package com.chitraka.squad.api.squadservices.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitraka.squad.api.squadservices.entity.ImageRetrievalEntity;
import com.chitraka.squad.api.squadservices.model.ImageRetrievalDTO;
import com.chitraka.squad.api.squadservices.repository.ImageRetrievalRepository;
import com.chitraka.squad.api.squadservices.util.ApplicationConstants;

@Service
public class ImageRetrievalServiceImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(ImageRetrievalServiceImpl.class);

	@Autowired
	private ImageRetrievalRepository imageRetrievalRepository;
	
	public String loadImageDetails(ImageRetrievalDTO imageRetrievalDTO) {
		try {
			ImageRetrievalEntity entity = new ImageRetrievalEntity();
			entity.setGroupId(1L);
			entity.setUrl(imageRetrievalDTO.getUrl());
			entity.setText(imageRetrievalDTO.getMessage());
			entity.setCreatedate(new Date());
			entity.setModifiedate(new Date());
			imageRetrievalRepository.save(entity);
			logger.info("Text written successfully");
		}catch(Exception e) {
			logger.info("Unable to write the text" + e);
			return ApplicationConstants.ERROR;
		}
		return ApplicationConstants.SUCCESS;
	}
	
	/*//
	public String updateImageDetails(ImageRetrievalDTO imageRetrievalDTO) {
		try {
			ImageRetrievalEntity entity = new ImageRetrievalEntity();
			entity.setId(1L);
			entity.setGroupId(1L);
			entity.setUrl(imageRetrievalDTO.getUrl());
			entity.setText(imageRetrievalDTO.getMessage());
			entity.setCreatedate(new Date());
			entity.setModifiedate(new Date());
			imageRetrievalRepository.save(entity);
			logger.info("Text updated successfully");
		}catch(Exception e) {
			logger.info("Successfully updated the image details" + e);
			return ApplicationConstants.ERROR;
		}
		return ApplicationConstants.SUCCESS;
	}*/
	
	public List<ImageRetrievalEntity> getImageDetails() {
		List<ImageRetrievalEntity> imageRetrievalEntity = imageRetrievalRepository.findAll();
		return imageRetrievalEntity;
	}

}
