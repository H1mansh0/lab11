package ucu.edu.ua.apps.task2;

import com.mailjet.client.errors.MailjetException;

import java.util.ArrayList;
import java.util.List;

public class MailBox {
    private final List<MailInfo> mailInfos;
    private final String apiKey;
    private final String apiSecretKey;

    public MailBox(String apiKey, String apiSecretKey) {
        this.mailInfos = new ArrayList<>();
        this.apiKey = apiKey;
        this.apiSecretKey = apiSecretKey;
    }

    public void addMailInfo(MailInfo mailInfo) {
        mailInfos.add(mailInfo);
    }

    public void sendAll() throws MailjetException {
        for (MailInfo mailInfo : mailInfos) {
            MailSender.sendMail(mailInfo, apiKey, apiSecretKey);
        }
    }
}
