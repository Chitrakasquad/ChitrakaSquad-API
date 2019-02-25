package com.chitraka.squad.api.squadservices.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chitraka.squad.api.squadservices.model.CustomerDetailsDTO;
import com.chitraka.squad.api.squadservices.service.CustomerDetailsServiceImpl;
import com.chitraka.squad.api.squadservices.util.ApplicationConstants;

@RestController
@RequestMapping({ApplicationConstants.CUSTOMER_DETAILS})
public class CustomerDetailsController {
	
	@Autowired
	private CustomerDetailsServiceImpl custDetailsService;
	 
	 @PostMapping(path = "/sendemail/custdetails")
	 public String sendEmailandUserDetails(@RequestBody CustomerDetailsDTO customerDetailsDTO) throws AddressException, MessagingException, IOException  {
		 String message = custDetailsService.sendEmailandSaveCustDetails(customerDetailsDTO);
		 return message;
	 }

}
