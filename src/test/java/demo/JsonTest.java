package demo;

import org.junit.Before;

import javax.naming.Reference;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JsonTest {

    private static final StringBuilder TEST_JSON_BAD_STUFF = new StringBuilder()
            .append("[\n")
            .append("  {\n")
            .append("    \"number\":\"\"\n")
            .append("  },\n")
            .append("  {\n")
            .append("    \"number\":\"45\"\n")
            .append("  },\n")
            .append("  {\n")
            .append("    \"number\":null\n")
            .append("  },\n")
            .append("  {\n")
            .append("    \"number\":\"45\"\n")
            .append("  },\n")
            .append("  {\n")
            .append("    \"number\":\"s\"\n")
            .append("  },\n")
            .append("  {\n")
            .append("    \"number\":\"-3\"\n")
            .append("  },\n")
            .append("  {\n")
            .append("    \"number\":\"12\"\n")
            .append("  },\n")
            .append("  {\n    \"number\":\"100\"\n")
            .append("  },\n")
            .append("  {\n")
            .append("    \"number\":\"3\"\n")
            .append("  },\n")
            .append("  {\n")
            .append("    \"numer\":\"qwewqewqe\"\n")
            .append("  },\n")
            .append("  {\n")
            .append("    ")
            .append("  ,\n")
            .append("]\n");

    protected String testFile;
    protected String emptyTempFilePathString;
    protected String unparsableTempFilePathString;


    @Before
    public void setUp() throws Exception {
        emptyTempFilePathString = createAndWriteToTempFile("test12345677890", new StringBuilder());
        unparsableTempFilePathString = createAndWriteToTempFile("unparsableData", TEST_JSON_BAD_STUFF);
        Path testFilePath = Paths.get(getClass().getClassLoader()
                .getResource("testData.json").toURI());
        testFile = testFilePath.toFile().getAbsolutePath();

    }

    private String createAndWriteToTempFile(String fileName, StringBuilder testJson) throws IOException {
        Path tempFilePath = Files.createTempFile(fileName, "json");
        File tempFile = tempFilePath.toFile();
        tempFile.deleteOnExit();

        Files.write(tempFilePath, testJson.toString().getBytes(StandardCharsets.UTF_8));

        return tempFile.getAbsolutePath();
    }
}
