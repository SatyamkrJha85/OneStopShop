package com.one.stop.shop.helper;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class sEmail {

    public sEmail() {}

    public static void sendEmail(final String userName,final String password, String toAddress, String subject, String message) {
        
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        // Authenticator to authenticate the sender's username and password
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };

        try {
            Session session = Session.getInstance(properties, auth);

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(userName));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            msg.setSubject(subject);
            msg.setSentDate(new java.util.Date());
            msg.setText(message);

            Transport.send(msg);
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
