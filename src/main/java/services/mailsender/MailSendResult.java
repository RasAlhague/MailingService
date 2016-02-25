package services.mailsender;

public class MailSendResult {
    private Boolean isOk;

    public MailSendResult(Boolean isOk) {
        this.isOk = isOk;
    }

    public Boolean getOk() {
        return isOk;
    }
}
