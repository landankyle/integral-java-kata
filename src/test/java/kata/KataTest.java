package kata;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KataTest {
    @Test
    void testSomeKataMethod() {
        Kata subjectUnderTest = new Kata();
        assertEquals("hello, world!", subjectUnderTest.someKataMethod());
    }

    @Test
    void testPublishing() {
        App app = new App();
        User alice = new User("Alice", "1");
        app.addUser(alice);

        LocalDateTime msgTimestamp = LocalDateTime.now();
        alice.publishTimelineMessage("I love the weather today.", msgTimestamp);

        List<String> timelineMessages = app.getUserTimeline(alice.getId());
        assertEquals("I love the weather today.", timelineMessages.get(0));
    }

    @Test
    void testViewTimeline() {
        App app = new App();
        User alice = new User("Alice", "1");
        User bob = new User("Bob", "2");
        app.addUser(alice);
        app.addUser(bob);

        LocalDateTime msgTimestamp1 = LocalDateTime.now().minusMinutes(1);
        LocalDateTime msgTimestamp2 = LocalDateTime.now().minusMinutes(2);
        bob.publishTimelineMessage("Darn! We lost!", msgTimestamp1);
        bob.publishTimelineMessage("Good game though.", msgTimestamp2);

        List<String> timelineMessages = app.getUserTimeline(bob.getId());
        assertEquals("Good game though. (120 seconds ago)", timelineMessages.get(0));
        assertEquals("Darn! We lost! (60 seconds ago)", timelineMessages.get(1));
    }
}
