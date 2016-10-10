package com.vmware.team7.mail.web;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.team7.mail.domain.Mail;

@RestController
@RequestMapping("/api/mails")
public class MailService {

	private static Logger logger = LoggerFactory.getLogger(MailService.class);

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mail post(@RequestBody final Mail mail) throws Exception {
		logger.info(mail.toString());

		final SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail.getFrom());
		message.setTo(mail.getTo());
		if (mail.getCc() != null) {
			message.setCc(mail.getCc());
		}
		message.setSubject(mail.getSubject());
		String body = mail.getBody();
		if (mail.getBodyFormat().equalsIgnoreCase("base64")) {
			body = new String(Base64.getDecoder().decode(body));
		}
		message.setText(mail.getBody());
		mailSender.send(message);
		return mail;
	}
}
