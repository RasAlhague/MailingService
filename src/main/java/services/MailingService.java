package services;

import services.mailsender.Mail;
import services.mailsender.MailSendResult;

import java.util.List;
import java.util.concurrent.Future;

public interface MailingService {
    List<Future<MailSendResult>> notifyMarkedUsersWith(Mail mail);
}
