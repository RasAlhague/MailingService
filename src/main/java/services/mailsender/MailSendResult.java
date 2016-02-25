package services.mailsender;

import dao.User;

public class MailSendResult {
    private Boolean isOk;
    private Mail mail;
    private User to;

    public MailSendResult(Boolean isOk, Mail mail, User to) {
        this.isOk = isOk;
        this.mail = mail;
        this.to = to;
    }

    public Boolean getOk() {
        return isOk;
    }

    public Mail getMail() {
        return mail;
    }

    public User getUser() {
        return to;
    }
}
