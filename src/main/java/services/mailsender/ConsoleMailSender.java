package services.mailsender;

/**
 * Strategy for console impl
 */
public class ConsoleMailSender implements MailSender {
    private Mail mailToSend;

    public ConsoleMailSender(Mail mailToSend) {
        this.mailToSend = mailToSend;
    }

    public MailSendResult send(Mail mail) throws InterruptedException {
        System.out.println(mail);
        Thread.sleep(1000);

        return new MailSendResult(true);
    }

    @Override
    public MailSendResult call() throws Exception {
        return send(mailToSend);
    }
}
