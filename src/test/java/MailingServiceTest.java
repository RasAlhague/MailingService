import dao.User;
import dao.UserStorage;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.MailingService;
import services.mailsender.*;

import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("user " + i + " UNmarked");
            user.setMarked(false);

            users.add(user);
        }

        when(userStorage.getMarked()).thenReturn(users);
        mailingService = new ParallelMailingService(userStorage, threadPoolSize);
    }

    @Test
    public void notifyMarkedUsersTest() throws Exception {
        mailingService.notifyMarkedUsersWith();

        verify(userStorage).getMarked();
    }
}
