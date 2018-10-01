package demo;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TechTestNumberFinderTest extends JsonTest {

    @Test
    public void testPhysicalTestFileWithSearchFor100(){
        TechTestFindNumber finder = new TechTestFindNumber();
        List<SpecialNumberEntity> customNumberEntities = finder.readListFromFile(this.testFile);
        assertTrue(finder.doesListContain(100, customNumberEntities));
    }

    @Test
    public void testReadDataAndDontFindValue() {
        TechTestFindNumber finder = new TechTestFindNumber();
        List<SpecialNumberEntity> customNumberEntities = finder.readListFromFile(this.testFile);
        assertFalse(finder.doesListContain(101, customNumberEntities));
    }

}
