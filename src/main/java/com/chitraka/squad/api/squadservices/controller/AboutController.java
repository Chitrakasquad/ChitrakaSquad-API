package com.chitraka.squad.api.squadservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitraka.squad.api.squadservices.entity.AboutEntity;
import com.chitraka.squad.api.squadservices.model.AboutDTO;
import com.chitraka.squad.api.squadservices.service.AboutTextServiceImpl;
import com.chitraka.squad.api.squadservices.util.ApplicationConstants;

@RestController
@RequestMapping({ApplicationConstants.ABOUT})
public class AboutController {
	
	@Autowired
	private AboutTextServiceImpl aboutTextServiceImpl;
	
    @PostMapping(path = "/writetext")
	public String writeText(@RequestBody AboutDTO aboutDTO) {
    	String text = aboutTextServiceImpl.writeText(aboutDTO);
		return text;
	}
    
    @PutMapping(path = "/updatetext/{id}")
    public String updateText(@RequestBody AboutDTO aboutDTO) {
    	String text = aboutTextServiceImpl.updateText(aboutDTO);
    	return text;
    }
	 
	@GetMapping(path = "/readtext")
	public AboutEntity readText() {
		AboutEntity aboutEntity = aboutTextServiceImpl.readText();
    	return aboutEntity;
	}

	
}
