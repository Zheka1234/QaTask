package homework3.utilities;

import com.miskevich.homework3.utilities.Iterator;
import com.miskevich.homework3.utilities.MyStack;
import com.miskevich.homework3.utilities.StackADT;
import homework3.listener.MyListenerTestNgTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

@Listeners(MyListenerTestNgTest.class)
public class StackTest {

    private StackADT<String> stack;

    @BeforeMethod
    public void setUp() {
        stack = new MyStack<>();
    }

    @Test(expectedExceptions = NullPointerException.class, dataProvider = "nullValues")
    public void testMyStackPushNull(String value) {
        stack.push(value);
    }

    @DataProvider(name = "nullValues")
    public Object[][] provideNullValues() {
        return new Object[][]{{null}};
    }

    @Test(dataProvider = "pushValues")
    public void testMyStackPush(String value) {
        stack.push(value);
        assertTrue(stack.contains(value));
    }

    @DataProvider(name = "pushValues")
    public Object[][] providePushValues() {
        return new Object[][]{{"First"}, {"Second"}, {"Third"}};
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void testPopFromEmptyMyStack() {
        stack.pop();
    }

    @Test(dataProvider = "popValues")
    public void testMyStackPop(String[] expected) {
        for (String value : expected) {
            stack.push(value);
        }
        assertEquals(stack.pop(), expected[expected.length - 1]);
    }

    @DataProvider(name = "popValues")
    public Object[][] providePopValues() {
        return new Object[][]{{new String[]{"First", "Second", "Third"}},
                {new String[]{"First", "Second"}},
                {new String[]{"First"}}};
    }

    @Test
    public void testMyStackPopCompareStacks() {

        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.pop();

        String[] expected = {"Second", "First"};

        assertArrayEquals(stack.toArray(), expected);
        ;
    }


    @Test(expectedExceptions = EmptyStackException.class)
    public void testPeekFromEmptyMyStack() {
        stack.peek();
    }

    @Test
    public void testMyStackPeek() {
        stack.push("First");
        stack.push("Second");

        stack.push("Third");
        assertEquals(stack.peek(), "Third");
    }

    @Test
    public void testMyStackPeekCompareStacks() {
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.peek();

        String[] expected = {"Third", "Second", "First"};

        assertArrayEquals(stack.toArray(), expected);
    }

    @Test
    public void testMyStackClear() {
        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.clear();

        assertTrue(stack.isEmpty());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testMyStackToArrayWithNullIntoParameter() {
        stack.toArray(null);
    }

    @Test
    public void testMyStackToArrayWithArrayIntoParameter() {

        String[] array = {"First", "Second", "Third"};
        String[] expected = {"First", "Second", "Third"};

        assertArrayEquals(stack.toArray(array), expected);
    }


    @Test(expectedExceptions = NullPointerException.class)
    public void testMyStackContainsNull() {
        stack.contains(null);

    }


    @Test
    public void testMyStackSearchNegative() {
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        assertEquals(stack.search(null), -1);
    }

    @Test
    public void testEmptyMyStackSearch() {

        assertEquals(stack.search("First"), -1);
    }

    @Test
    public void testMyStackSearchPositive() {
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(stack.search("Third"), 1);
        softAssert.assertEquals(stack.search("Second"), 2);
        softAssert.assertEquals(stack.search("First"), 3);
        softAssert.assertAll();
    }

    @Test
    public void testMyStackEqualsPositive() {

        StackADT<String> stack1 = new MyStack<>();
        stack1.push("First");
        stack1.push("Second");
        stack1.push("Third");

        StackADT<String> stack2 = new MyStack<>();
        stack2.push("First");
        stack2.push("Second");
        stack2.push("Third");
        assertTrue(stack1.equals(stack2));
    }

    @Test
    public void testMyStackEqualsDifferentValues() {
        StackADT<String> stack1 = new MyStack<>();
        stack1.push("First");
        stack1.push("Second");
        stack1.push("Third");

        StackADT<String> stack2 = new MyStack<>();
        stack2.push("First");
        stack2.push("Second");
        stack2.push("Fourth");

        assertFalse(stack1.equals(stack2));
    }

    @Test
    public void testMyStackEqualsDifferentLength() {
        StackADT<String> stack1 = new MyStack<>();
        stack1.push("first");
        stack1.push("Second");
        stack1.push("Third");

        StackADT<String> stack2 = new MyStack<>();
        stack2.push("First");
        stack2.push("Second");

        assertFalse(stack1.equals(stack2));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void testMyStackIteratorNextWithEmptyMyStack() {
        Iterator<String> iterator = stack.iterator();
        iterator.next();
    }

    @AfterMethod
    public void tearDown() {
        stack.clear();
    }
}
