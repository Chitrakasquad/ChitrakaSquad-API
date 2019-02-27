package com.chitraka.squad.api.squadservices.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.chitraka.squad.api.squadservices.entity.ImageRetrievalEntity;

public interface ImageRetrievalRepository extends CrudRepository<ImageRetrievalEntity, Long> {
	
	@Override
    List<ImageRetrievalEntity> findAll();

}
