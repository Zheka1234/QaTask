package homework3.parser;

import com.miskevich.homework3.parser.XMLParser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ValidXMLParserTest {
    private XMLParser parser;

    @BeforeMethod
    public void setUp() {
        parser = null;
    }


    @DataProvider(name = "xmlFilePaths")
    public Object[][] provideXmlFilePaths() {
        return new Object[][]{
                {"src/test/java/homework3/filesxml/valid/simple.xml"},
                {"src/test/java/homework3/filesxml/valid/declaration.xml"},
                {"src/test/java/homework3/filesxml/valid/atribute.xml"},
                {"src/test/java/homework3/filesxml/valid/closed_tag.xml"},
                {"src/test/java/homework3/filesxml/valid/comment_lines.xml"},
                {"src/test/java/homework3/filesxml/valid/carshop.xml"},
                {"src/test/java/homework3/filesxml/valid/valid_parametrs.xml"},
                {"src/test/java/homework3/filesxml/valid/difficult_file.xml"},
                {"src/test/java/homework3/filesxml/valid/valid_special_characters.xml"},

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