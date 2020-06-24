package task6.bio;

public class Letter {

    private String address;
    private String subject;
    private String messageText;

    public String getAddress() {
        return address;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessaheText() {
        return messageText;
    }

    public Letter withAddress(String address) {
        this.address = address;
        return this;
    }

    public Letter withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Letter withText(String text) {
        this.messageText = text;
        return this;
    }

}
