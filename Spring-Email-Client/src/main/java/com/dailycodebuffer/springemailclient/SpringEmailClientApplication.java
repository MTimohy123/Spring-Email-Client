package com.dailycodebuffer.springemailclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailClientApplication {

	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {

//		service.sendSimpleEmail("201737926@keyaka.ul.ac.za",
//					"This is the email Body",
//						"This is the Email subject");
		service.sendEmailWithAttachment("201737926@keyaka.ul.ac.za",
				"This is email with attachment...",
				"This email has attachment",
				"C:\\Users\\201737926\\Pictures\\Screenshots\\Screenshot (30).png");
	}

}
