/*package xvr.mail;

import javax.mail.*;
import java.util.Properties;

class EmailAuth extends Authenticator {
    private String login;
    private String password;

    public EmailAuth(final String login, final String password) {
        this.login = login;
        this.password = password;

    }

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(login, password);
    }
}

public class MailMain {
/*
Сервер входящей почты IMAP-сервер — imap.mail.ru
 POP3-сервер — pop.mail.ru;
 Сервер исходящей почты (SMTP-сервер) — smtp.mail.ru;
 Имя пользователя — это полное название вашего почтового ящика, включая логин, значок «@» собачки и домен (например, vash_pomoshnik@mail.ru);
 Пароль — текущий пароль, который вы используете для входа в почтовый ящик;
 Порт — IMAP — 143 (при использовании шифрования STARTTLS)
    и 993 (при использовании шифрования SSL/TLS)
 POP3 — 110 (без шифрования) и 995 (с шифрованием)
 SMTP — 25, 587 или 2525 (без шифрования) и 465 (с шифрованием) .

 */
/*
    public static void main(String[] args) throws Exception {
        String username = "testtesttest-1980@mail.ru";
        String password = "rbylpflpf1980rbylpflpf";
        String hostSmtp = "smtp.mail.ru";
        String imapPort = "993";
        String pop3host = "pop.mail.ru";
        String imapHost = "imap.mail.ru";


        Properties properties = new Properties();
        properties.put("mail.debug", "true");
        properties.put("mail.imap.ssl.enable", "true");
        properties.put("mail.store.protocol", "imaps");
        properties.put("mail.imap.port", imapPort);

        Authenticator authenticator = new EmailAuth(username,
                password);
        Session session = Session.getDefaultInstance(properties, authenticator);
        Store store = session.getStore();
        store.connect(imapHost, username, password);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        System.out.println("Number of messages: " + String.valueOf(inbox.getMessageCount()));
        System.out.println();
        Message message = inbox.getMessage(inbox.getMessageCount());

        System.out.println("next multipart");
        //TO DO Multipart Null
        Multipart multipart = (Multipart) message.getContent();

        if (multipart == null) {
            System.out.println("mult null");
            System.exit(0);
        }

        for (int i = 0; i < multipart.getCount(); i++) {
            BodyPart bodyPart = multipart.getBodyPart(i);
            if (bodyPart.getFileName() == null) {
                System.out.println(" " + i + " " + bodyPart.getContent());
            } else {
                System.out.println(" " + i + " " + bodyPart.getFileName());
            }
        }
        //BodyPart bodyPart = multipart.getBodyPart(1);

        //System.out.println(bodyPart.getContent());

    }

}
*/