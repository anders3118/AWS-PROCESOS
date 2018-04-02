/**
 * 
 */
package com.provider.compumundo.smtp;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.provider.compumundo.generatePriceQuotationFile.CreateExcel;

/**
 * @author Felipe
 *
 */
public class SendPriceQuoteEmail {
	
	private final String username = "pujarqesp@gmail.com";
	private final String password = "Testing.14";
	
	public void sendEmail() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		// check the authentication
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("pujarqesp@gmail.com"));

			// recipients email address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(CreateExcel.clientEmail));

			// add the Subject of email
			message.setSubject("Cotizacion CompuMundo");

			Multipart multipart = new MimeMultipart();

			// add the body message
			BodyPart bodyPart = new MimeBodyPart();
			bodyPart.setText("Buenas tardes, \n \nConforme a su petición, adjuntamos la cotización solicitada. \n  \nGracias");
			multipart.addBodyPart(bodyPart);

			// attach the file
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			try {
				mimeBodyPart.attachFile(new File("src/main/resources/CotizacionCompuMundo.xlsx"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			multipart.addBodyPart(mimeBodyPart);
			message.setContent(multipart);

			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();

		}
	}
}
