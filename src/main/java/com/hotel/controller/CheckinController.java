package com.hotel.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.CheckinEntity;
import com.hotel.exception.NotFoundException;
import com.hotel.previsao.CheckinPrevisao;
import com.hotel.previsao.Diaria;
import com.hotel.repository.CheckinRepository;

@RestController
@RequestMapping("/checkin")
public class CheckinController {

	@Autowired
	private CheckinRepository repository;

	@PostMapping
	public Long save(@RequestBody CheckinEntity input) {
		repository.save(input);
		return input.getId();
	}

	@RequestMapping(value = "/{checkinId}", method = RequestMethod.GET)
	public CheckinEntity findById(@PathVariable @NotNull @DecimalMin("0") Long checkinId) {
		return repository.findById(checkinId).orElseThrow(() -> new NotFoundException("Checkin não encontrado!"));
	}

	@RequestMapping(value = "/{checkinId}", method = RequestMethod.DELETE)
	public void deleteCheckin(@PathVariable @NotNull @DecimalMin("0") Long checkinId) {
		repository.deleteById(checkinId);
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public Iterable<CheckinEntity> getCheckin() {
		return repository.findAll();
	}

	@GetMapping("/findAllInHotel")
	public List<CheckinPrevisao> findAllInHotel() {
		return getValor(repository.findByDataSaidaAfter(new Date()));
	}

	@GetMapping("/findAllOutHotel")
	public List<CheckinPrevisao> findAllOuHotel() {
		return getValor(repository.findByDataSaidaBefore(new Date()));
	}

	private List<CheckinPrevisao> getValor(List<CheckinEntity> findByDataSaidaAfter) {
		List<CheckinPrevisao> listaPrevisao = new ArrayList<>();
		findByDataSaidaAfter.stream()
				.forEach(check -> listaPrevisao.add(new CheckinPrevisao(check, Diaria.getValor(check))));
		return listaPrevisao;
	}

}
