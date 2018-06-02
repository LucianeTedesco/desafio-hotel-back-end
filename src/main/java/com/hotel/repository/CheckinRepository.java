package com.hotel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hotel.entity.CheckinEntity;

public interface CheckinRepository extends CrudRepository<CheckinEntity, Long> {

	List<CheckinEntity> findByDataSaidaAfter(Date dataAtual);
	
	List<CheckinEntity> findByDataSaidaBefore(Date dataAtual);
	
}
