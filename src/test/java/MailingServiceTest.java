import dao.User;
import dao.UserStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.MailingService;
import services.ParallelMailingService;
import services.mailsender.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MailingServiceTest {
    @Mock
    private UserStorage userStorage;

    private MailingService mailingService;

    private int threadPoolSize = 20;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            User user = new User();
            user.setName("user " + i + " marked");
            user.setMarked(true);

            users.add(user);
        }

        when(userStorage.getMarked()).thenReturn(users);
        mailingService = new ParallelMailingService(userStorage, threadPoolSize);
    }

    @Test
    public void notifyMarkedUsersTest() throws Exception {
        Mail mail = new Mail("subj", "body");

        List<Future<MailSendResult>> futureList = mailingService.notifyMarkedUsersWith(mail);

        verify(userStorage).getMarked();
        Assert.assertNotNull(futureList);

        for (Future<MailSendResult> mailSendResultFuture : futureList) {
            MailSendResult mailSendResult = mailSendResultFuture.get();
            Assert.assertTrue(mailSendResult.getOk());
            Assert.assertTrue(mailSendResult.getUser().getMarked());
        }
    }
}
