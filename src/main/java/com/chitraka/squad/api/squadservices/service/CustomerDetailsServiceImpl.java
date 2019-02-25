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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitraka.squad.api.squadservices.controller.FileController;
import com.chitraka.squad.api.squadservices.entity.CustomerDetailsEntity;
import com.chitraka.squad.api.squadservices.model.CustomerDetailsDTO;
import com.chitraka.squad.api.squadservices.repository.CustomerDetailsRepository;
import com.chitraka.squad.api.squadservices.util.ApplicationConstants;

import ch.qos.logback.core.status.Status;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService{
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerDetailsServiceImpl.class);
	
	@Autowired
	private CustomerDetailsRepository customerDetailsRepository;
	
	@Override
	public String sendEmailandSaveCustDetails(CustomerDetailsDTO custDetailsDTO) throws AddressException, MessagingException, IOException {
		String message;
		try {
			 message = sendEmail(custDetailsDTO);
			logger.info("Success sending email");
		} catch(Exception e) {
			logger.info("Error sending email" + e);
			return ApplicationConstants.ERROR;
		}
		return message;
	}
	
	// To send email 
	private String sendEmail(CustomerDetailsDTO custDetailsDTO) throws AddressException, MessagingException, IOException {
		String message;
		try {
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
			   msg.setSubject("Message from Chitraka Customer");
			   msg.setSentDate(new Date());

			   MimeBodyPart messageBodyPart = new MimeBodyPart();
			   messageBodyPart.setContent(buildMessage(custDetailsDTO), "text/html");

			   Multipart multipart = new MimeMultipart();
			   multipart.addBodyPart(messageBodyPart);
			   msg.setContent(multipart);
			   Transport.send(msg);   
			   message = saveUserDetails(custDetailsDTO);
		} catch(Exception e) {
			return ApplicationConstants.ERROR;
		}
		return message;
	}
	

	// To save customer details
	private String saveUserDetails(CustomerDetailsDTO custDetailsDTO) {
		try {
			CustomerDetailsEntity entity = new CustomerDetailsEntity();
			 entity.setGroupId(1L);
			 entity.setFirstName(custDetailsDTO.getFirstName());
			 entity.setLastName(custDetailsDTO.getLastName());
			 entity.setPhone(custDetailsDTO.getPhone());
			 entity.setEmail(custDetailsDTO.getEmail());
			 entity.setMessage(custDetailsDTO.getMessage());
			 entity.setCreateDate(new Date());
			 entity.setModifiedDate(new Date());
			 customerDetailsRepository.save(entity);
		} catch(Exception e) {
			return ApplicationConstants.ERROR;
		}
		return ApplicationConstants.SUCCESS;
	}
	
	private String buildMessage(CustomerDetailsDTO custDetailsDTO) {
		String message = "Name : " + custDetailsDTO.getFirstName() + " " + custDetailsDTO.getLastName() +'\n'+
				"Phone : " + custDetailsDTO.getPhone() + '\n'+ "Email : " + custDetailsDTO.getEmail() + '\n'
				+ "Message : " + custDetailsDTO.getMessage();
		return message;
	}
	
	

}
