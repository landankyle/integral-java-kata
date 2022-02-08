package kata;

import java.time.LocalDateTime;
import java.util.List;

public class User {

    private String id;
    private String name;

    private Timeline timeline;

    public User(String name, String id) {
        this.id = id;
        this.name = name;
        this.timeline = new Timeline();
    }

    public void publishTimelineMessage(String message, LocalDateTime timestamp) {
        this.timeline.addMessage(message, timestamp);
    }

    public List<String> viewTimeline() {
        List<String> messages = this.timeline.getMessages();
        return messages;
    }

    public String getId() {
        return this.id;
    }
}
