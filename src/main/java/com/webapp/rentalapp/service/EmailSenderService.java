package com.webapp.rentalapp.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	@Autowired
	private JavaMailSender mailSender;
		
	public void sendMailWithAttachment(String toEmail, String subject, String body, String attachment) throws MessagingException{
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("jordan.harri1@gmail.com");
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(body);
		
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		helper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		mailSender.send(mimeMessage);
		
		System.out.println("Invoice sent successfully");
	}
}
