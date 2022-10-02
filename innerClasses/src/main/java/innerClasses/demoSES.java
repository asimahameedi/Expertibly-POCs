package innerClasses;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class demoSES {
	//amazon ses
//	static final String FROM = "glorious_hameedi@hotmail.com";
//	static final String FROMNAME = "Asima Glorious";
//	static final String SMTP_USERNAME = "AKIATZFGHYNPLX52PDM5";
//	static final String SMTP_PASSWORD = "BEZWG/Fe9uyekTOdRJr+1Tf2e7ihuVx4JIpZewmqPYOb";
//	static final String TO = "hameediasima@gmail.com";
//	
//	static final String HOST = "email-smtp.us-east-1.amazonaws.com";
//	static final int PORT=587;
//	static final String SUBJECT="test SES smtp interface access";
//	
//	static final String BODY="test SES smtp interface access";
	//
	static final String FROM = "support@expertibly.com";
	static final String FROMNAME = "Expertibly support";
	static final String SMTP_USERNAME = "AKIATZFGHYNPLX52PDM5";
	static final String SMTP_PASSWORD = "BEZWG/Fe9uyekTOdRJr+1Tf2e7ihuVx4JIpZewmqPYOb";
	static final String TO = "asima.rehman@yahoo.com";
	
	static final String HOST = "email-smtp.us-east-1.amazonaws.com";
	static final int PORT=587;
	static final String SUBJECT="test SES smtp interface access";
	
	static final String BODY="test SES smtp interface access";
	
	//bluehost
//	static final String FROM = "support@ourexpertfinder.com";
//	static final String FROMNAME = "Asima Glorious";
//	static final String SMTP_USERNAME = "support@ourexpertfinder.com";
//	static final String SMTP_PASSWORD = "v2lzIi6}0R)J";
//	static final String TO = "hameediasima@gmail.com";
//	
//	static final String HOST = "mail.ourexpertfinder.com";
//	static final int PORT=465;
//	static final String SUBJECT="test SES smtp interface access";
//	
//	static final String BODY="test SES smtp interface access";
	//gridsend
//	static final String FROM = "support@ourexpertfinder.com";
//	static final String FROMNAME = "Asima Glorious";
//	static final String SMTP_USERNAME = "apikey";
//	static final String SMTP_PASSWORD = "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";
//	static final String TO = "hameediasima@gmail.com";
//	
//	static final String HOST = "smtp.sendgrid.net";
//	static final int PORT=587;
//	static final String SUBJECT="test SES smtp interface access";
//	
//	static final String BODY="test SES smtp interface access";
	
public static void main(String args[]) throws Exception{
	
	Properties props = System.getProperties();
	props.put("mail.transport.protocol", "smtp");
	props.put("mail.smtp.port", PORT);
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.auth", "true");
	
	Session session = Session.getDefaultInstance(props);
	MimeMessage msg = new MimeMessage(session);
	msg.setFrom(new InternetAddress(FROM,FROMNAME));
	msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
	msg.setSubject(SUBJECT);
	msg.setContent(BODY,"text/html");
	
	Transport transport = session.getTransport();
	try
	{
		System.out.println("Sending ...");
		
		transport.connect(HOST, SMTP_USERNAME,SMTP_PASSWORD );
		System.out.println("connected successfully");
		transport.sendMessage(msg, msg.getAllRecipients());
		System.out.println("Email sent successfully");
	}
	catch (Exception ex)
	{
		System.out.println("email not sent ...");
		System.out.println("Error message is ..." +ex.getMessage());
		System.out.println("Error message is ..." +ex.getStackTrace());
	} finally
	{
		transport.close();
	}
	
}//main
}
