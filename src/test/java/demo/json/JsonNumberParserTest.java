package demo.json;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class JsonNumberParserTest extends demo.JsonTest {

    @Test(expected = IllegalArgumentException.class)
    public void testForIOExceptionRandomFileName()  {
        Random randomGenerator = new Random();
        String fileNameBasedOnRandom = String.valueOf(randomGenerator.nextInt());
        new JsonNumberParser(fileNameBasedOnRandom);

    }

    @Test
    public void testForEmptyFile() {
        assertEquals("tempFile should be 0", 0, new JsonNumberParser(emptyTempFilePathString).getSpecialNumberEntities().size());
    }

    @Test
    public void testWithTestData() {
        assertEquals(9, new JsonNumberParser(testFile).getSpecialNumberEntities().size());

    }

    @Test(expected = com.google.gson.JsonSyntaxException.class)
    public void testWithUnparseableData() {
        new JsonNumberParser(unparsableTempFilePathString);

    }
}