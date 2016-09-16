package coplan.messaging;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by afcoplan on 9/16/16.
 */
public class Sender {

    private static final String smtpHost = "smtp.gmail.com";
    private static final int smtpPort = 587;

    public static void send(final String phoneNumber, final String carrierExtension, final int numMessages, final int delay, final String messageText, final String gmailUsername, final String gmailPassword){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = null;

                try {
                    message = new MimeMessage(assembleSession(gmailUsername, gmailPassword));

                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(phoneNumber + carrierExtension));

                    message.setText(messageText);
                }catch(Exception e){
                    e.printStackTrace();
                    System.out.println("Error building message!");
                    System.exit(-1);
                }

                System.out.println("Message built successfully.");

                try{
                    Transport.send(message);
                    System.out.println("Message sent successfully.");
                }catch(Exception e){
                    if(e.getClass().equals(javax.mail.AuthenticationFailedException.class)){
                        System.out.println("Invalid gmail username and/or password!");
                        System.exit(-1);
                    }else{
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    private static Session assembleSession(final String gmailUsername, final String gmailPassword){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(gmailUsername, gmailPassword);
            }
        });

        return session;
    }
}
