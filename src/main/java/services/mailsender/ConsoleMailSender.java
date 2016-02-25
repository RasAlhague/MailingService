package services.mailsender;

import dao.User;

/**
 * Strategy for console impl
 */
public class ConsoleMailSender implements MailSender {
    private Mail mailToSend;
    private User to;

    public ConsoleMailSender(Mail mailToSend, User to) {
        this.mailToSend = mailToSend;
        this.to = to;
    }

    public MailSendResult send(Mail mail, User to) throws InterruptedException {
        System.out.println("Sending mail:" + mail + "to user:" + to);
        Thread.sleep(500);

        return new MailSendResult(true, mail, to);
    }

    @Override
    public MailSendResult call() throws Exception {
        return send(mailToSend, to);
    }
}
