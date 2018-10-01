package demo;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

public class SpecialNumberEntityTest {

    @Test
    public void testingPrivateConstructors() {
        Constructor<?>[] arrayOfConstructors = SpecialNumberEntity.class.getDeclaredConstructors();
        for (Constructor constructor : arrayOfConstructors) {
            assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        }

    }


}