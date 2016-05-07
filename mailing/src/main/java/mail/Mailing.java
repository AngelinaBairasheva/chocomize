package mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class Mailing {
    private final String company_mail = "chockomize.shop@gmail.com";
    private final String password = "chocomizeshop";
    private final String company_name = "Chocomize Shop";

    private boolean status = false;

    public boolean isStatus() {
        return status;
    }

    public Mailing( ) {
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public boolean sendMail(String toEmail, String text) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(company_mail, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(company_mail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            message.setSubject(company_name);
            message.setContent(text, "text/plain; charset=US-ASCII");
            Transport.send(message);

            return status = true;
        } catch (MessagingException e) {
            return status = false;
        }
    }
}