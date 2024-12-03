package com.yash.JavaMail.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("mailService")
public class IJavaMailServiceImpl implements IJavaMailService{

    @Autowired
    private JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String fromMail;
    @Override
    public String javaMail(String[] email) throws Exception {
        String msg="Hello Receiver please find attachment, This is test Mail";

        String send= sendMail(msg,email);
        return msg + send;
    }

    private String sendMail(String msg, String[] toEmails)throws Exception {
        MimeMessage message=sender.createMimeMessage();  //empty email message
        MimeMessageHelper helper=new MimeMessageHelper(message, true);
        helper.setFrom(fromMail);
        helper.setCc(toEmails);
        helper.setSubject("Hello This is testMail Subject");
        helper.setSentDate(new Date());
        helper.setText(msg);
        helper.addAttachment("yash.jpg", new ClassPathResource("yash.jpg"));  //place yash.jpg file src/main/resource folder
        sender.send(message);
        return "mail sent ";
    }

}
