package homework3.parser;

import com.miskevich.homework3.parser.XMLParser;
import com.miskevich.homework3.parser.XMLTag;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class XMLParserTest {
    private XMLParser parser;

    @BeforeMethod
    public void setUp() {
        parser = new XMLParser("src/test/java/homework3/filesxml/carshop.xml");
    }

    @Test(expectedExceptions = FileNotFoundException.class, groups = "parser")
    public void testXMLParserWithoutTrueFileRoot() {
        new XMLParser("");
    }

    @Test(groups = "parser")
    public void testTrueSimpleXmlFile() {
        parser = new XMLParser("src/test/java/homework3/filesxml/simple.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test(groups = "parser")
    public void testSelfClosedTag() {
        parser = new XMLParser("src/test/java/homework3/filesxml/closed_tag.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test(groups = "parser")
    public void testTagWithAtribute() {
        parser = new XMLParser("src/test/java/homework3/filesxml/atribute.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test(groups = "parser")
    public void testCommentLines() {
        parser = new XMLParser("src/test/java/homework3/filesxml/comment_lines.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test(groups = "parser")
    public void testDifficultFile() {
        parser = new XMLParser("src/test/java/homework3/filesxml/difficult_file.xml");
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @Test(groups = "parser")
    public void testWithoutDeclarationFile() {
        parser = new XMLParser("src/test/java/homework3/filesxml/declaration.xml");
        parser.parseDocument();
        assertFalse(parser.getErrors().isEmpty());
    }

    @Test(groups = "parser")
    public void testGetNameFromRoot() {
        parser = new XMLParser("src/test/java/homework3/filesxml/simple.xml");
        parser.parseDocument();
        String xmlTagName;
        try {
            Field field = parser.getClass().getDeclaredField("root");
            field.setAccessible(true);
            XMLTag xmlTag = (XMLTag) field.get(parser);
            xmlTagName = xmlTag.getName();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        assertEquals(xmlTagName, "carshop");
    }

    @DataProvider(name = "xmlFilePaths")
    public Object[][] provideXmlFilePaths() {
        return new Object[][]{
                {"src/test/java/homework3/filesxml/simple.xml"},
                {"src/test/java/homework3/filesxml/closed_tag.xml"},
                {"src/test/java/homework3/filesxml/atribute.xml"},
                {"src/test/java/homework3/filesxml/comment_lines.xml"},
                {"src/test/java/homework3/filesxml/difficult_file.xml"},
                {"src/test/java/homework3/filesxml/declaration.xml"}
        };
    }

    @Test(dataProvider = "xmlFilePaths", groups = "parser")
    public void testParseDocument(String xmlFilePath) {
        parser = new XMLParser(xmlFilePath);
        parser.parseDocument();
        assertTrue(parser.getErrors().isEmpty());
    }

    @AfterMethod
    public void tearDown() {
        parser = null;
    }
}




