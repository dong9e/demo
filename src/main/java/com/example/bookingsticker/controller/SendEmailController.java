package com.example.bookingsticker.controller;

import com.example.bookingsticker.service.ISendMailService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;

@RestController
@CrossOrigin("*")
@RequestMapping("/email")
public class SendEmailController {

    @Autowired
    private ISendMailService sendMailService;

    @PostMapping
    public ResponseEntity<?> senMail(@RequestParam String to) {
        sendMailService.sendEmail(to);

        return new ResponseEntity<>("send successfully", HttpStatus.OK);
    }

    @PostMapping("/pdf")
    public ResponseEntity<?> senMail1(@RequestParam String to) throws MessagingException, DocumentException, FileNotFoundException {
        sendMailService.sendEmailPDF(to);

        return new ResponseEntity<>("send successfully", HttpStatus.OK);
    }

    @GetMapping("/hello")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String firstPage() {
        return "Hello World";
    }

}
