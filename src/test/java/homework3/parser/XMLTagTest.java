package homework3.parser;

import com.miskevich.homework3.parser.XMLTag;
import com.miskevich.homework3.utilities.ListADT;
import com.miskevich.homework3.utilities.MyArrayList;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class XMLTagTest {

    private XMLTag xmlTag;

    @BeforeMethod
    public void setup() {

        xmlTag = new XMLTag("test");
    }


    @Test(groups = "parser", dataProvider = "tagNames")
    public void testGetName(String tagName) {
        xmlTag.setName(tagName);
        assertEquals(xmlTag.getName(), tagName);
    }

    @Test(groups = "parser", dataProvider = "tagProperties")
    public void testTagPropertySetName(String propertyName, String propertyValue) {
        XMLTag.TagProperty property = new XMLTag.TagProperty(propertyName, propertyValue);
        property.setName("New" + propertyName);
        assertEquals(property.getName(), "New" + propertyName);
    }

    @Test(groups = "parser", dataProvider = "tagProperties")
    public void testTagPropertySetValue(String propertyName, String propertyValue) {
        XMLTag.TagProperty property = new XMLTag.TagProperty(propertyName, propertyValue);
        property.setValue("New" + propertyValue);
        assertEquals(property.getValue(), "New" + propertyValue);
    }

    @Test(groups = "parser")
    public void testGetEmptyArrayListAsProperties() {
        XMLTag tag = new XMLTag("Tag");
        ListADT<XMLTag.TagProperty> properties = tag.getProperties();
        assertTrue(properties.isEmpty());
    }

    @Test(groups = "parser", dataProvider = "tagPropertiesList")
    public void testSetAndGetProperties(ListADT<XMLTag.TagProperty> propertyListADT) {
        XMLTag tag = new XMLTag("Tag");
        tag.setProperties(propertyListADT);
        assertEquals(tag.getProperties(), propertyListADT);
    }

    @Test(groups = "parser")
    public void testGetEmptyArrayListAsNestedTags() {
        ListADT<XMLTag> nestedTags = xmlTag.getNestedTags();
        assertTrue(nestedTags.isEmpty());
    }

    @Test(groups = "parser", dataProvider = "nestedTagsList")
    public void testSetNestedTags(ListADT<XMLTag> nestedTags) {
        xmlTag.setNestedTags(nestedTags);
        assertEquals(xmlTag.getNestedTags(), nestedTags);
    }

    @Test(groups = "parser")
    public void testGetText() {
        xmlTag.setText("sample text");
        assertEquals(xmlTag.getText(), "sample text");
    }

    @Test(groups = "parser")
    public void testSetText() {
        XMLTag tag = new XMLTag("Tag");
        tag.setText("Text");
        assertEquals(tag.getText(), "Text");
    }

    @DataProvider(name = "tagNames")
    public Object[][] provideTagNames() {
        return new Object[][]{
                {"newName1"},
                {"newName2"},
                {"newName3"}
        };
    }

    @DataProvider(name = "tagProperties")
    public Object[][] provideTagProperties() {
        return new Object[][]{
                {"Property1", "Value1"},
                {"Property2", "Value2"},
                {"Property3", "Value3"}
        };
    }

    @DataProvider(name = "tagPropertiesList")
    public Object[][] provideTagPropertiesList() {

        ListADT<XMLTag.TagProperty> propertyList1 = new MyArrayList<>();
        propertyList1.add(new XMLTag.TagProperty("Name1", "Value1"));
        propertyList1.add(new XMLTag.TagProperty("Name2", "Value2"));

        ListADT<XMLTag.TagProperty> propertyList2 = new MyArrayList<>();
        propertyList2.add(new XMLTag.TagProperty("Name3", "Value3"));
        propertyList2.add(new XMLTag.TagProperty("Name4", "Value4"));
        return new Object[][]{
                {propertyList1},
                {propertyList2}
        };
    }

    @DataProvider(name = "nestedTagsList")
    public Object[][] provideNestedTagsList() {

        ListADT<XMLTag> nestedTags1 = new MyArrayList<>();
        nestedTags1.add(new XMLTag("nested1"));
        nestedTags1.add(new XMLTag("nested2"));

        ListADT<XMLTag> nestedTags2 = new MyArrayList<>();
        nestedTags2.add(new XMLTag("nested3"));
        nestedTags2.add(new XMLTag("nested4"));

        return new Object[][]{
                {nestedTags1},
                {nestedTags2}
        };
    }

    @AfterMethod
    public void cleanup() {
    }
}