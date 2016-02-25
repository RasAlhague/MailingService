package services.mailsender;

import dao.User;
import dao.UserStorage;
import services.MailingService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelMailingService implements MailingService {
    private UserStorage userStorage;
    private ExecutorService executor;

    public ParallelMailingService(UserStorage userStorage, int threadPoolSize) {
        this.userStorage = userStorage;
        this.executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    @Override
    public void notifyMarkedUsersWith(Mail mail) {
        List<User> markedUsers = userStorage.getMarked();
    }
}
