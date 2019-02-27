package com.chitraka.squad.api.squadservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitraka.squad.api.squadservices.entity.ImageRetrievalEntity;
import com.chitraka.squad.api.squadservices.model.ImageRetrievalDTO;
import com.chitraka.squad.api.squadservices.service.ImageRetrievalServiceImpl;
import com.chitraka.squad.api.squadservices.util.ApplicationConstants;

@RestController
@RequestMapping({ApplicationConstants.IMAGE_DETAILS})
public class ImageRetrievalController {

	@Autowired
	private ImageRetrievalServiceImpl imageRetrievalServiceImpl;
	
    @PostMapping(path = "/loadimage")
	public String loadImageDetails(@RequestBody ImageRetrievalDTO imageRetrievalDTO) {
    	String text = imageRetrievalServiceImpl.loadImageDetails(imageRetrievalDTO);
		return text;
	}
    // TODO upadte image
    /*@PutMapping(path = "/updateimage/{id}")
    public String updateImageDetails(@PathVariable("id") Long id, @RequestBody ImageRetrievalDTO imageRetrievalDTO) {
    	String text = imageRetrievalServiceImpl.updateImageDetails(imageRetrievalDTO);
    	return text;
    }*/
	 
	@GetMapping(path = "/getimage")
	public List<ImageRetrievalEntity> getImageDetails() {
		List<ImageRetrievalEntity> imageRetrievalEntity = imageRetrievalServiceImpl.getImageDetails();
    	return imageRetrievalEntity;
	}
}
