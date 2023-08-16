package homework3.parser;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import com.miskevich.homework3.parser.XMLParser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static org.testng.Assert.assertThrows;

public class InvalidXmlParserTest {
    private XMLParser parser;

    @BeforeMethod
    public void setUp() {
        parser = null;
    }

    @AfterMethod
    public void tearDown() {
        parser = null;
    }

    @DataProvider(name = "invalidFiles")
    public Object[][] invalidFilesProvider() {
        return new Object[][]{
                {"src/test/java/homework3/filesxml/invalid_file_missing_root_tag.xml", Exception.class},
                {"src/test/java/homework3/filesxml/invalid_file_missing_closing_tag.xml", Exception.class},
                {"src/test/java/homework3/filesxml/invalid_file_unexpected_closing_tag.xml", Exception.class},
                {"src/test/java/homework3/filesxml/invalid_file_missing_closing_bracket.xml", Exception.class},
                {"src/test/java/homework3/filesxml/invalid_file_missing_instruction_closing_tag.xml", ArrayIndexOutOfBoundsException.class},
        };
    }

    @Test(dataProvider = "invalidFiles")
    public void testInvalidFiles(String filePath, Class<? extends Exception> expectedException) {
        parser = new XMLParser(filePath);
        assertThrows(expectedException, parser::parseDocument);

    }



    @Test(expectedExceptions = NullPointerException.class)
    public void testInvalidFile_nullFileName() throws FileNotFoundException {
        parser = new XMLParser(null);
        parser.parseDocument();

    }
}