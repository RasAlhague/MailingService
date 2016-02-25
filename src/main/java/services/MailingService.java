package services;

import services.mailsender.Mail;

public interface MailingService {
    void notifyMarkedUsersWith(Mail mail);
}
