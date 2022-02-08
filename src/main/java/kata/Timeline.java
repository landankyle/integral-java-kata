package kata;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Timeline {

    TreeMap<LocalDateTime, String> messages = new TreeMap<>();

    public void addMessage(String message, LocalDateTime timestamp) {

        this.messages.put(timestamp, message);
    }

    public List<String> getMessages() {

        ArrayList<String> messageList = new ArrayList<>();

        this.messages.forEach((timestamp, message) -> {

            messageList.add(message + getTimestampDiff(timestamp));
        });

        return messageList;
    }

    private String getTimestampDiff(LocalDateTime timestamp1) {

        Long difference = ChronoUnit.SECONDS.between(timestamp1, LocalDateTime.now());

        if (difference == 0) {
            return "";
        }
        else {
            return " (" + difference + " seconds ago)";
        }

        //TO-DO: add conditions here to determine difference in min or days, etc.
    }

}
