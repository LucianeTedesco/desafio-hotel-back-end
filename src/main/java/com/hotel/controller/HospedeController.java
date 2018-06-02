package com.hotel.controller;

import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.HospedeEntity;
import com.hotel.repository.HospedeRepository;

@RestController
@RequestMapping("/hospede")
public class HospedeController {

	@Autowired
	private HospedeRepository repository;

	@PostMapping
	public Long save(@RequestBody HospedeEntity input) {
		repository.save(input);
		return input.getId();
	}

	@RequestMapping(value = "/{hospedeId}", method = RequestMethod.GET)
	public HospedeEntity getHospede(@PathVariable @NotNull @DecimalMin("0") Long hospedeId) {
		return repository.findById(hospedeId).orElseThrow(() -> new RuntimeException("Hóspede não encontrado!"));
	}

	@RequestMapping(value = "/{hospedeId}", method = RequestMethod.DELETE)
	public void deleteHospede(@PathVariable @NotNull @DecimalMin("0") Long hospedeId) {
		repository.deleteById(hospedeId);
	}

	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public Iterable<HospedeEntity> getHospede() {
		return repository.findAll();
	}

	@GetMapping("/findHospede")
	public List<HospedeEntity> find(@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "documento", required = false) String documento,
			@RequestParam(value = "telefone", required = false) String telefone) {
		if (nome != null) {
			return repository.findByNomeContaining(nome);
		}
		if (documento != null) {
			return repository.findByDocumentoContaining(documento);
		}
		if (telefone != null) {
			return repository.findByTelefoneContaining(telefone);
		}
		return Collections.emptyList();
	}

}
