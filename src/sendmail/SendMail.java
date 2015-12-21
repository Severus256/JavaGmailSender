
package sendmail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Severus256
 */
public class SendMail {

    /**
     * TLS method
     *
     * @param args
     */
    public static void main(String[] args) {
        final String username = "severus256@gmail.com";
        final String password = "vfnhbwf1";
        Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("****@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("***@****.**"));
            message.setSubject("from SendMailApp");
            message.setText("TEST");
            Transport.send(message);
            System.out.println("DONE");
        } catch (MessagingException e) {
            throw new RuntimeException(e);

        }

    }

}
