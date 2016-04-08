package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mailing {
    //    private final String username = "digitalzonelaboratory@gmail.com";
//    private final String password = "digitalzone2014";
    private final String username = "chockomize.shop@gmail.com";
    private final String password = "chocomizeshop";

    private boolean status = false;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean sendMail(String fromEmail, String toEmail, String subject, String text) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
// multiple recipients           InternetAddress[] address = {new InternetAddress(to)};
//                               msg.setRecipients(Message.RecipientType.TO, address);
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);

            return status = true;
        } catch (MessagingException e) {
            return status = false;
        }
    }
}