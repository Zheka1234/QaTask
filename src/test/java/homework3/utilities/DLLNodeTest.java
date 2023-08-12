package homework3.utilities;

import com.miskevich.homework3.utilities.MyDLLNode;
import homework3.listener.MyListenerTestNgTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

@Listeners(MyListenerTestNgTest.class)
public class DLLNodeTest {

    private MyDLLNode<String> node;

    @BeforeMethod
    public void setUp() {
        node = null;
    }

    @Test
    public void testConstructorWithAllParameters() {

        node = new MyDLLNode<>("Node",
                new MyDLLNode<>("Eugene"),
                new MyDLLNode<>("Miskevich"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(node.getValue(), "Node");
        softAssert.assertEquals(node.getPrev().getValue(), "Eugene");
        softAssert.assertEquals(node.getNext().getValue(), "Miskevich");
        softAssert.assertAll();
    }

    @Test
    public void testSetPrev() {

        node = new MyDLLNode<>("Node");
        node.setPrev(new MyDLLNode<>("Eugene"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(node.getValue(), "Node");
        softAssert.assertEquals(node.getPrev().getValue(), "Eugene");
        softAssert.assertEquals(node.getNext(), null);

        softAssert.assertAll();
    }

    @Test
    public void testSetNext() {

        node = new MyDLLNode<>("Node");
        node.setNext(new MyDLLNode<>("Miskevich"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(node.getValue(), "Node");
        softAssert.assertEquals(node.getPrev(), null);
        softAssert.assertEquals(node.getNext().getValue(), "Miskevich");

        softAssert.assertAll();
    }

    @Test
    public void testSetValue() {

        node = new MyDLLNode<>("Node");
        node.setValue("ExpectedValue");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(node.getValue(), "ExpectedValue");
        softAssert.assertEquals(node.getPrev(), null);
        softAssert.assertEquals(node.getNext(), null);

        softAssert.assertAll();
    }

    @Test
    public void testEqualsMyDLLNodes() {
        MyDLLNode<String> firstNode = new MyDLLNode<>("Node");
        MyDLLNode<String> secondNode = new MyDLLNode<>("Node");
        assertTrue(firstNode.equals(secondNode));
    }

    @Test(description = "bug")
    public void testEqualsDifferentMyDLLNodesByPrevAndNextFields() {
        MyDLLNode<String> firstNode = new MyDLLNode<>("Node",
                new MyDLLNode<>("Eugene"),
                new MyDLLNode<>("Miskevich"));
        MyDLLNode<String> secondNode = new MyDLLNode<>("Node");

        assertFalse(firstNode.equals(secondNode));
    }

    @DataProvider(name = "dataProvider")
    public static Object[][] dataMethod() {
        return new Object[][]{
                {"first"},
                {"second"},
                {"third"},};
    }

    @Test(dataProvider = "dataProvider")
    public void testValueMatch(String value) {
        MyDLLNode<String> node = new MyDLLNode<>(value);
        assertTrue(node.valueMatch(value));
    }

    @DataProvider(name = "provider")
    public static Object[][] getValue() {
        return new Object[][]{
                {"Fourth"}, {"Fifth"}, {"Sixth"}};
    }

    @Test(dataProvider = "provider")
    public void testValueMatchWithOtherValue(String value) {
        MyDLLNode<String> node = new MyDLLNode<>(value);
        assertFalse(node.valueMatch("Other Value"));
    }

    @AfterMethod
    public void tearDown() {
        node = null;
    }
}

