package com.Faculty;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail {
    public void mail(String to , String ID , String userpass){
        
	    String subject = "Password Sent";
	    String message = "Respected Sir/Ma'am,"+"\n"+"Your Login ID :  "+ID + "\n"+"Your Password:   "+userpass;

	    String from = "iiit.bbsr.1234@gmail.com";
	    final String password = "IIITBHok123";
	    try
	    {
                                    try {
                                        Properties props = new Properties();
                                        props.put("mail.smtp.host", "smtp.gmail.com");
                                        props.put("mail.smtp.socketFactory.port", "465");
                                        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                                        props.put("mail.smtp.auth", "true");
                                        props.put("mail.smtp.port", "465");

                                        Authenticator auth = new Authenticator() {
                                            public PasswordAuthentication getPasswordAuthentication() {
                                                return new PasswordAuthentication(from, password);
                                            }
                                        };
                                        Session session = Session.getInstance(props, auth);

                                        MimeMessage msg = new MimeMessage(session);
                                        msg.setFrom(new InternetAddress(from));
                                        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                                        msg.setSubject(subject);
                                        msg.setText(message);

                                        Transport.send(msg);
                                        System.out.println("Message delivered successfully , Check your mail ...........:)");
                                    }
                                    catch (MessagingException e)
	             {
	                   e.printStackTrace();
	              }
                           }catch(Exception e){
                               System.out.println("Exception occured while sending email.....:)");
                           }
    }  
}
