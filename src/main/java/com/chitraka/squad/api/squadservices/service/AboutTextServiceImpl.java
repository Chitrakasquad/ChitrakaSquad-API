package com.chitraka.squad.api.squadservices.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitraka.squad.api.squadservices.entity.AboutEntity;
import com.chitraka.squad.api.squadservices.model.AboutDTO;
import com.chitraka.squad.api.squadservices.repository.AboutRepository;
import com.chitraka.squad.api.squadservices.util.ApplicationConstants;

@Service
public class AboutTextServiceImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(AboutTextServiceImpl.class);
	
	@Autowired
	private AboutRepository aboutRepository;
	
	public String writeText(AboutDTO aboutDTO) {
		try {
			AboutEntity entity = new AboutEntity();
			entity.setGroupid(1L);
			entity.setMessage(aboutDTO.getMessage());
			entity.setCreatedate(new Date());
			entity.setModifiedate(new Date());
			aboutRepository.save(entity);
			logger.info("Text written successfully");
		}catch(Exception e) {
			logger.info("Unable to write the text" + e);
			return ApplicationConstants.ERROR;
		}
		return ApplicationConstants.SUCCESS;
	}
	
	public String updateText(AboutDTO aboutDTO, Long id) {
		try {
			AboutEntity entity = new AboutEntity();
			entity.setId(id);
			entity.setGroupid(1L);
			entity.setMessage(aboutDTO.getMessage());
			entity.setCreatedate(new Date());
			entity.setModifiedate(new Date());
			aboutRepository.save(entity);
			logger.info("Text updated successfully");
		}catch(Exception e) {
			logger.info("Unable to write the text" + e);
			return ApplicationConstants.ERROR;
		}
		return ApplicationConstants.SUCCESS;
	}
	
	public AboutEntity readText() {
		Optional<AboutEntity> aboutEntity = aboutRepository.findById(1L);
		return aboutEntity.get();
	}
	

}
