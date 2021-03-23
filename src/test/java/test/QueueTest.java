package test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {

    private Queue<String> queue;

    @Nested
    @DisplayName("when new")
    public class WhenNew {
        @BeforeEach
        void setUp() {
            queue = new LinkedList<String>();
        }

        @DisplayName("when offer, size must be 1")
        @Test
        void offerNewData() {
            queue.offer("Fakhri");
            Assertions.assertEquals(1, queue.size());
        }

        @DisplayName("when offer 2 data, size must be 2")
        @Test
        void offerMoreData() {
            queue.offer("Fakhri");
            queue.offer("Chaerul");
            Assertions.assertEquals(2, queue.size());
        }
    }

}
