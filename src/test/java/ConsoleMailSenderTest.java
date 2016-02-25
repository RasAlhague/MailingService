import dao.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.mailsender.ConsoleMailSender;
import services.mailsender.Mail;
import services.mailsender.MailSendResult;
import services.mailsender.MailSender;

public class ConsoleMailSenderTest {

    @Test
    public void sendTest() throws Exception {
        Mail mail = new Mail("subj", "body");
        User user = new User("testuser", true);
        MailSender mailSender = new ConsoleMailSender(mail, user);
        MailSendResult result = mailSender.call();

        Assert.assertTrue(result.getOk());
    }
}
