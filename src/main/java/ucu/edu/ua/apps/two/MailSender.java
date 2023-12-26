package ucu.edu.ua.apps.two;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.resource.Emailv31;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class MailSender {
    public static void sendMail(MailInfo mailInfo, String apiKey, String apiSecretKey) throws MailjetException {
        MailjetClient mailjetClient;
        MailjetRequest mailjetRequest;
        MailjetResponse mailjetResponse;

        ClientOptions clientOptions = ClientOptions.builder().apiKey(apiKey).apiSecretKey(apiSecretKey).build();
        mailjetClient = new MailjetClient(clientOptions);

        mailjetRequest = new MailjetRequest(Emailv31.resource)
                .property("Email", mailInfo.getClient().getMail())
                .property("From", mailInfo.getClient().getName())
                .property("Subject", mailInfo.getMailCode())
                .property("Age", mailInfo.getClient().getAge())
                .property("ID", mailInfo.getClient().getId());

        mailjetResponse = mailjetClient.post(mailjetRequest);
        System.out.println(mailjetResponse.getStatus());
    }
}
