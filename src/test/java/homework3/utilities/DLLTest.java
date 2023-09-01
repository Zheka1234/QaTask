package homework3.utilities;

import com.miskevich.homework3.utilities.Iterator;
import com.miskevich.homework3.utilities.ListADT;
import com.miskevich.homework3.utilities.MyDLL;
import homework3.listener.MyListenerTestNgTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

@Listeners(MyListenerTestNgTest.class)
public class DLLTest {

    private ListADT<String> list;

    @BeforeMethod
    public void setUp() {

        list = new MyDLL<>();
    }

    @Test
    public void testIsEmpty() {

        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {

        list.add("first");
        assertFalse(list.isEmpty());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testToArrayNullInParameter() {
        list.toArray(null);
    }

    @Test
    public void testToArrayWithArrayInParameter() {
        String[] expected = {"first", "second", "third"};
        assertArrayEquals(list.toArray(expected), expected);
    }

    @Test
    public void testContains() {

        list.add("first");
        list.add("second");
        list.add("third");

        assertTrue(list.contains("third"));
    }

    @Test
    public void testDontContains() {

        list.add("first");
        list.add("second");
        list.add("third");

        assertFalse(list.contains("fourth"));
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testDontContainsNull() {
        list.add("first");
        list.add("second");
        list.add("third");
        list.contains(null);
    }

    @Test
    public void testIterator() {
        list.add("first");
        list.add("second");
        list.add("third");

        ListADT<String> expected = new MyDLL<>();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            expected.add(iterator.next());
        }
        assertArrayEquals(list.toArray(), expected.toArray());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testIteratorIfIsNotNext() {
        Iterator<String> iterator = list.iterator();
        iterator.next();
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testAddNull() {
        list.add(null);
    }

    @Test
    public void testAddAll() {
        ListADT<String> toAdd = new MyDLL<>();
        toAdd.add("first");
        toAdd.add("second");
        toAdd.add("third");
        list.addAll(toAdd);

        assertArrayEquals(list.toArray(), toAdd.toArray());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testAddAllNull() {

        list.addAll(null);
    }

    @Test
    public void testAddAllEmpty() {

        assertTrue(list.addAll(new MyDLL<String>()));
    }

    @Test(description = "bug")
    public void testRemoveByElementGetArrayWithoutTheElement() {

        list.add("first");
        list.add("second");
        list.add("Third");

        list.remove("first");

        String[] expected = {"second", "Third"};

        assertArrayEquals(list.toArray(), expected);
    }

    @Test
    public void testRemoveByElementGetActualSize() {

        list.add("first");
        list.add("second");
        list.add("third");

        list.remove("first");

        assertEquals(list.size(), 3);
    }

    @Test
    public void testRemoveByIndex() {

        list.add("first");
        list.add("second");
        list.add("third");

        list.remove(0);

        String[] expected = {"second", "third"};

        assertArrayEquals(list.toArray(), expected);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testRemoveByNegativeIndex() {
        list.remove(-1);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testRemoveByIndexFromEmptyList() {

        list.remove(1);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testRemoveNull() {

        list.add("first");
        list.add("second");
        list.add("third");

        list.remove(null);
    }

    @Test
    public void testClear() {

        list.add("first");
        list.add("second");
        list.add("third");

        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    public void testAddByIndex() {

        list.add("first");
        list.add("third");
        list.add(1, "second");

        String[] expected = {"first", "second", "third"};

        assertArrayEquals(list.toArray(), expected);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testAddByIndexNull() {

        list.add("first");
        list.add("third");
        list.add(1, null);
    }

    @Test(description = "bug")
    public void testAddByZeroIndex() {

        list.add("Second");
        list.add("Third");
        list.add(0, "First");

        String[] expected = {"First", "Second", "Third"};

        assertArrayEquals(list.toArray(), expected);
    }

    @Test(description = "bug", expectedExceptions = IndexOutOfBoundsException.class)
    public void testAddByNegativeIndex() {
        list.add(-1, "First");
    }

    @Test
    public void testGet() {

        list.add("First");
        list.add("Second");
        list.add("Third");

        assertEquals(list.get(0), "First");
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testGetByNegativeIndex() {

        list.add("First");
        list.add("Second");
        list.add("Third");

        list.get(-1);
    }

    @Test
    public void testSet() {

        list.add("Fourth");
        list.add("Second");
        list.add("Third");

        list.set(0, "First");

        String[] expected = {"First", "Second", "Third"};

        assertArrayEquals(list.toArray(), expected);
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testSetNull() {

        list.add("Firth");
        list.add("Second");
        list.add("Third");

        list.set(0, null);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testSetNegativeIndex() {

        list.add("First");
        list.add("Second");
        list.add("Third");

        list.set(-1, "Zero");
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testSetNoExistIndex() {
        list.add("First");
        list.add("Second");
        list.add("Third");

        list.set(3, "Fourth");
    }

    @AfterMethod
    public void tearDown() {
        list = null;
    }
}
