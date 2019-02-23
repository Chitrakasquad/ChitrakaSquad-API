package com.chitraka.squad.api.squadservices.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	 @ GetMapping(path = "/sendmail")
	   public String sendEmail() throws AddressException, MessagingException, IOException {
		  custDetailsService.sendmail();
	      return ApplicationConstants.EMAIL_SUCCESS;
	   }
	 	
	 @GetMapping(path = "/savecustomer")
	 @ResponseBody
		public String saveUserDetails() {                    // @RequestBody CustomerDetailsDTO userDetailsDTO
		 CustomerDetailsDTO custDetailsDTO = new CustomerDetailsDTO();
		 String message = custDetailsService.saveUserDetails(custDetailsDTO);   
		 return message;
		}

}
