package MovieOn.db.requests;

public interface EmailSender {
    void send(String to, String email);
}
