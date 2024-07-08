
import java.io.Serializable;

public class Message implements Serializable {
    private String fromwhich;
    private String towhich;
    private String textmessage;
    private Boolean isItBroadcast;

    public Message() {
    }

    public String getFrom() {
        return fromwhich;
    }

    public void setFrom(String from) {
        this.fromwhich = from;
    }

    public String getTo() {
        return towhich;
    }

    public void setTo(String to) {
        this.towhich = to;
    }

    public String getText() {
        return textmessage;
    }

    public void setText(String textmessage) {
        this.textmessage = textmessage;
    }

    public void setBroadcast(boolean broadcast) {
        this.isItBroadcast = broadcast;
    }

    public boolean isItBroadcast() {
        return isItBroadcast;
    }
}