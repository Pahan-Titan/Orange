package ua.kurs.kp;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class EmailHandler implements Serializable {
 
    private static String username = "orange.one.plus@gmail.com";
    private static String password = "123456789O";
	
	static void EmailHandler(String emailTo, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getDefaultInstance(props,
        		new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        Message msg = new MimeMessage(session);
        try {
			msg.setFrom(new InternetAddress(username, "Orange+"));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
                emailTo, "Dear customer"));
			msg.setSubject(subject);
			msg.setText(body);
			Transport.send(msg);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    }
}