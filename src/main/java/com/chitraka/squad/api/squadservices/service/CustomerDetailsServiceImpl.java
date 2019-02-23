package com.chitraka.squad.api.squadservices.service;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitraka.squad.api.squadservices.entity.CustomerDetailsEntity;
import com.chitraka.squad.api.squadservices.model.CustomerDetailsDTO;
import com.chitraka.squad.api.squadservices.repository.CustomerDetailsRepository;
import com.chitraka.squad.api.squadservices.util.ApplicationConstants;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService{
	
	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;
	
	@Override
	public void sendmail() throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("chitraka.squad@gmail.com", "Avengers09");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("crreddysgt@gmail.com", false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("chitraka.squad@gmail.com"));
		   msg.setSubject("Chitraka app email test");
		   msg.setContent("Nithin email two", "text/html");
		   msg.setSentDate(new Date());

		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setText("Hello");
		   messageBodyPart.setContent("Testing", "text/html");

		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		   msg.setContent(multipart);
		   Transport.send(msg);   
		}
	

	@Override
	public String saveUserDetails(CustomerDetailsDTO userDetailsDTO) {
		CustomerDetailsEntity entity = new CustomerDetailsEntity();
		/* entity.setGroupId(1L);
		 entity.setFirstName(userDetailsDTO.getFirstName());
		 entity.setLastName(userDetailsDTO.getLastName());
		 entity.setPhone(userDetailsDTO.getPhone());
		 entity.setEmail(userDetailsDTO.getEmail());
		 entity.setMessage(userDetailsDTO.getMessage());
		 entity.setCreateDate(new Date());
		 entity.setModifiedDate(new Date());*/
		
		 entity.setGroupId(1L);
		 entity.setFirstName("nithin");
		 entity.setLastName("chiliveru");
		 entity.setPhone(23L);
		 entity.setEmail("c@GMAIL.COM");
		 entity.setMessage("hELLO");
		 entity.setCreateDate(new Date());
		 entity.setModifiedDate(new Date());
		
		 customerDetailsRepository.save(entity);
		return ApplicationConstants.UPDATE_SUCCESS;
	}

}
