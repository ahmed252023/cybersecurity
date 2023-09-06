package tn.itbs.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.itbs.sb.services.EmailService;
@RequestMapping("/api")
@RestController

public class EmailController {
	private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/get_email/{domain}")
    public List<String> getEmailAddresses(@PathVariable String domain) {
        return emailService.getEmailAddresses(domain);
    }
}
