package homework3.utilities;

import com.miskevich.homework3.exceptionsss.EmptyQueueException;
import com.miskevich.homework3.utilities.Iterator;
import com.miskevich.homework3.utilities.MyQueue;
import com.miskevich.homework3.utilities.QueueADT;
import homework3.listener.MyListenerTestNgTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.AssertJUnit.assertArrayEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

@Listeners(MyListenerTestNgTest.class)
public class QueueTest {

    private QueueADT<String> queue;

    @BeforeMethod
    public void setup() {
        queue = new MyQueue<>();
    }

    @Test
    public void testNewQueueIsEmpty() {

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testNewQueueSizeEqualsZero() {

        assertEquals(queue.size(), 0);
    }

    @Test
    public void testNewQueueIsNotEmpty() {

        queue.enqueue("First");

        assertFalse(queue.isEmpty());
    }

    @Test
    public void testNewQueueSizeEqualsOne() {

        queue.enqueue("First");

        assertEquals(queue.size(), 1);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testEnqueueNull() {

        queue.enqueue(null);

    }


    @Test
    public void testDequeObject() {

        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        assertEquals(queue.dequeue(), "First");
    }

    @Test
    public void testDequeOneObjectSizeMinusOne() {

        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        queue.dequeue();

        assertEquals(queue.size(), 2);
    }

    @Test(expectedExceptions = EmptyQueueException.class)
    public void testDequeFromEmptyMyQueue() {

        queue.dequeue();
    }

    @Test
    public void testQueueAfterDequeueMethodAndEqualsMethod() {

        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");
        queue.dequeue();

        QueueADT<String> expected = new MyQueue<>();
        expected.enqueue("Second");
        expected.enqueue("Third");

        assertTrue(queue.equals(expected));
    }

    @Test
    public void testPeek() {

        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        assertEquals(queue.peek(), "First");
    }

    @Test(expectedExceptions = EmptyQueueException.class)
    public void testPeekFromEmptyMyQueue() {

        queue.peek();
    }

    @Test
    public void testDequeueAll() {

        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        queue.dequeueAll();

        assertTrue(queue.isEmpty());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testNextElementFromIteratorWhenMyQueueIsEmpty() {

        Iterator<String> iterator = queue.iterator();
        iterator.next();
    }

    @Test
    public void testNoEqualsMyQueuesBySize() {
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        QueueADT<String> queue2 = new MyQueue<>();
        queue2.enqueue("First");
        queue2.enqueue("Second");

        assertFalse(queue.equals(queue2));
    }

    @Test
    public void testNoEqualsMyQueuesByElements() {
        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        QueueADT<String> queue2 = new MyQueue<>();
        queue2.enqueue("First");
        queue2.enqueue("Second");
        queue2.enqueue("Fourth");

        assertFalse(queue.equals(queue2));
    }

    @Test
    public void testToArray() {

        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        String[] expected = {"First", "Second", "Third"};

        assertArrayEquals(queue.toArray(), expected);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testToArrayWithHolderAsNull() {

        queue.toArray(null);
    }

    @AfterMethod
    public void cleanup() {
        queue = null;
    }


}
