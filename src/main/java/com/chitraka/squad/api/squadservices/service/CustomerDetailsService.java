package com.chitraka.squad.api.squadservices.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.chitraka.squad.api.squadservices.model.CustomerDetailsDTO;

public interface CustomerDetailsService {
	
	public String sendEmailandSaveCustDetails(CustomerDetailsDTO custDetailsDTO) throws AddressException, MessagingException, IOException;

}
