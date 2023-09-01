package homework3.utilities;

import com.miskevich.homework3.utilities.Iterator;
import com.miskevich.homework3.utilities.ListADT;
import com.miskevich.homework3.utilities.MyArrayList;
import homework3.listener.MyListenerTestNgTest;
import org.testng.Assert;
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
public class ArrayListTest {

    private ListADT<String> list;

    @BeforeMethod
    public void setUp() {

        list = new MyArrayList<>();
    }

    @Test
    public void testArrayListGet() {

        list.add("First");
        list.add("Second");
        list.add("Third");

        assertEquals(list.get(1), "Second");
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testArrayListGetMoreThanIndexValue() {

        list.add("First");
        list.add("Second");
        list.add("Third");
        list.get(3);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testArrayListGetWithNegativeValue() {

        list.add("First");
        list.add("Second");
        list.add("Third");
        list.get(-1);
    }

    @Test
    public void testArrayListMethodClear() {

        list.add("First");
        list.add("second");
        list.add("Third");
        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    public void testArrayListWithCapacity() {

        list = new MyArrayList<>(1);
        list.add("First");
        list.add("Second");
        list.add("Third");

        assertEquals(list.size(), 3);
    }

    @Test
    public void testArrayListAddToIndex() {

        list.add("Second");
        list.add("Third");
        list.add(0, "First");

        assertEquals(list.size(), 3);
    }

    @Test
    public void testArrayListAddToIndexAndGetThisElementInTheSpecifiedLocation() {

        list.add("Second");
        list.add("Third");
        list.add(0, "First");

        assertEquals(list.get(0), "First");
    }

    @Test
    public void testArrayListAddToIndexWithCapacity() {

        list = new MyArrayList<>(3);
        list.add("Second");
        list.add("Third");
        list.add(0, "First");

        assertEquals(list.size(), 3);
    }


    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testAddElementToNoExistIndex() {

        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add(4, "Fifth");
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void testAddElementToNegativeIndex() {

        list.add("First");
        list.add("Second");
        list.add("Third");
        list.add(-1, "Zero");
    }

    @Test
    public void testMyArrayListAddAll() {
        ListADT<String> listToAdd = new MyArrayList<>(3);
        listToAdd.add("Fourth");
        listToAdd.add("Fifth");
        listToAdd.add("Sixth");

        ListADT<String> list = new MyArrayList<>(3);
        list.add("First");
        list.add("Second");
        list.add("Third");

        list.addAll(listToAdd);

        ListADT<String> checkList = new MyArrayList<>();
        checkList.add("First");
        checkList.add("Second");
        checkList.add("Third");
        checkList.add("Fourth");
        checkList.add("Fifth");
        checkList.add("Sixth");

        Assert.assertEquals(list.toArray(), checkList.toArray());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testArrayListAddAllIfOneOfListsIsNull() {
        ListADT<String> listToAdd = null;


        list = new MyArrayList<>(3);
        list.add("First");
        list.add("Second");
        list.add("Third");

        list.addAll(listToAdd);
    }

    @Test
    public void testRemoveElement() {

        list.add("First");
        list.add("Second");
        list.add("Third");

        list.remove("First");

        ListADT<String> checkList = new MyArrayList<>();
        checkList.add("Second");
        checkList.add("Third");

        assertEquals(list.toArray(), checkList.toArray());
    }

    @Test
    public void testRemoveElementByIndex() {

        list.add("First");
        list.add("Second");
        list.add("Third");

        list.remove(0);

        ListADT<String> checkList = new MyArrayList<>();
        checkList.add("Second");
        checkList.add("Third");

        assertEquals(list.toArray(), checkList.toArray());
    }

    @Test
    public void testMethodRemoveIfElementIsNull() {

        list.add("First");
        list.add("Second");
        list.add("Third");
        list.remove(null);

        assertEquals(list.size(), 3);
    }

    @Test
    public void testMethodRemoveIfElementIsNotInList() {

        list.add("First");
        list.add("Second");
        list.add("Third");
        list.remove("Fourth");

        assertEquals(list.size(), 3);
    }

    @Test
    public void testSetElement() {

        list.add("Fourth");
        list.add("Second");
        list.add("Third");

        list.set(0, "First");

        ListADT<String> checkList = new MyArrayList<>();
        checkList.add("First");
        checkList.add("Second");
        checkList.add("Third");

        assertEquals(list.toArray(), checkList.toArray());
    }

    @Test
    public void testContains() {

        list.add("First");
        list.add("Second");
        list.add("Third");

        assertTrue(list.contains("First"));
    }

    @Test
    public void testContainsNull() {

        list.add("First");
        list.add("Second");
        list.add("Third");

        assertFalse(list.contains(null));
    }

    @Test
    public void testDoNotContainsElement() {

        list.add("First");
        list.add("Second");
        list.add("Third");

        assertFalse(list.contains("Fourth"));
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testToArrayWithNullInParameter() {

        list.toArray(null);
    }

    @Test
    public void testToArrayWithArrayInParameter() {

        String[] array = {"first", "Second", "Third"};

        assertArrayEquals(list.toArray(array), array);

    }

    @Test
    public void testIterator() {

        list.add("First");
        list.add("Second");
        list.add("Third");

        ListADT<String> checkList = new MyArrayList<>();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            checkList.add(iterator.next());
        }

        assertEquals(list.toArray(), checkList.toArray());

    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testIteratorMethodNextIfNextElementDontExist() {

        Iterator<String> iterator = list.iterator();
        iterator.next();

    }

    @AfterMethod
    public void tearDown() {
        list.clear();
    }


}