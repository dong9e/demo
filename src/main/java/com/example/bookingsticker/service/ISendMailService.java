package com.example.bookingsticker.service;

import com.itextpdf.text.DocumentException;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;

public interface ISendMailService {
    void sendEmail(String to);
    void sendEmailPDF(String to) throws MessagingException, DocumentException, FileNotFoundException;
}
