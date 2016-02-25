package services;

import dao.User;
import dao.UserStorage;
import services.MailingService;
import services.mailsender.ConsoleMailSender;
import services.mailsender.Mail;
import services.mailsender.MailSendResult;
import services.mailsender.MailSender;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelMailingService implements MailingService {
    private UserStorage userStorage;
    private ExecutorService executor;

    public ParallelMailingService(UserStorage userStorage, int threadPoolSize) {
        this.userStorage = userStorage;
        this.executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    @Override
    public List<Future<MailSendResult>> notifyMarkedUsersWith(Mail mail) {
        List<User> markedUsers = userStorage.getMarked();
        List<Future<MailSendResult>> futureList = new ArrayList<>();
        markedUsers.forEach(user -> {
            MailSender mailSender = new ConsoleMailSender(mail, user);
            futureList.add(executor.submit(mailSender));
        });

        return futureList;
    }
}
