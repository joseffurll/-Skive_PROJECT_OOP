package javaapplication14;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
public class EmailSender {

    public static void main(String[] args) {
        String from = "skivequizplatform@gmail.com";
        String password = "ctio ropg ynjf cjlo";
        String to = "abuhanjoseff@gmail.com";
        String subject = "TEST EMAIL";
        String body = "SEND SEND SEND OTP";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587"); 


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}