package com.example.bookingsticker.service.impl;

import com.example.bookingsticker.service.ISendMailService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfChunk;
import com.itextpdf.text.pdf.PdfEncodings;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class SendMailService implements ISendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("DEMO");
        message.setText("Trả sớm nhe, ko là xiên đó");

        javaMailSender.send(message);
    }

    @Override
    public void sendEmailPDF(String to) throws MessagingException, DocumentException, FileNotFoundException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject("THÔNG BÁO");
        helper.setText("Mời bạn đọc thông báo đính kèm.");

        String str = "C:\\Users\\dongnv\\Downloads\\a\\LongTDD_Rocket41_PE\\src\\BookingSticker\\src\\main\\resources\\file\\";

        String name = new SimpleDateFormat("yyyyMMdd hhmmss").format(new Date())+".pdf";

        Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, new  FileOutputStream(str+name));
        document.open();
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 16, BaseColor.BLACK);

        Chunk chunk = new Chunk("Xin chào, bạn gì đó hay dỗi ơi! Iu con páo tên Hèng^^", font);
        document.add(chunk);
        document.close();


        FileSystemResource fileSystemResource = new FileSystemResource(str+name);
        helper.addAttachment("Thongbao.pdf", fileSystemResource);


        javaMailSender.send(message);
    }

}
