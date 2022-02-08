package kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class App {

    private HashMap<String, User> users = new HashMap<>();

    public App() { }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public List<String> getUserTimeline(String userId) {
        User user = users.get(userId);
        if (user != null) {
            return user.viewTimeline();
        }
        else {
            System.out.println("User [" + userId + "] not found");
            return new ArrayList<String>();
        }
    }
}
