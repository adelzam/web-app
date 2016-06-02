package com.springapp.mvc.sender;

import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Ann on 02.06.2016.
 */
public class SimpleMailManager {
    private final String COMPANY_GMAIL = "airline.tickets.course.su@gmail.com";
    private final String COMPANY_PASSWORD = "1.airline.tickets.2";
    private String user_name;
    private Properties props;

    public SimpleMailManager(String username) {
        this.user_name = username;
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }

    private Session getSession() {
        return Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(COMPANY_GMAIL, COMPANY_PASSWORD);
                    }
                });
    }

    public void sendQ(String text) {
        try {
            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(user_name));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(COMPANY_GMAIL));
            message.setSubject("Контактная форма");
            message.setText(text);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendC() {
        try {
            Message message = new MimeMessage(getSession());
            message.setFrom(new InternetAddress(COMPANY_GMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user_name));
            message.setSubject("Подтверждение регистрации");
            message.setText("Вы прошли успешную регистрацию на сайте Airline tickets\n" +
                    "Ваш логин : " + user_name);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
