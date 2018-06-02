package com.hotel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hotel.entity.HospedeEntity;

public interface HospedeRepository extends CrudRepository<HospedeEntity, Long> {

	List<HospedeEntity> findByNomeContaining(String nome);

	List<HospedeEntity> findByDocumentoContaining(String documento);
	
	List<HospedeEntity> findByTelefoneContaining(String telefone);

}
