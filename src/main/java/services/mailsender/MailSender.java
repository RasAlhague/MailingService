package services.mailsender;

import java.util.concurrent.Callable;

public interface MailSender extends Callable<MailSendResult> {

}
