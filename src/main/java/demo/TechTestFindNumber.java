package demo;

import demo.json.JsonNumberParser;

import java.util.List;
import java.util.Objects;


public class TechTestFindNumber implements NumberFinder {

    static private final ComparatorWithRandomSleep FASTEST_COMPARATOR = new ComparatorWithRandomSleep();

    /**
     * Checks if valueToFind is contained in the list
     *
     * @param valueToFind
     * @param list
     * @return true if valueToFind exist in the list
     * false if not
     */
    public boolean doesListContain(int valueToFind, List<SpecialNumberEntity> list) {
        return list.parallelStream()
                .distinct()
                .filter(Objects::nonNull)
                .filter(customNumberEntity -> {
                    try {
                        if (FASTEST_COMPARATOR.compare(valueToFind, customNumberEntity) == 0) {
                            return true;
                        }
                    } catch (NumberFormatException numberFormatException) {
                        System.err.println("customNumberEntity with value " + customNumberEntity.getNumber() + " falied to parse");
                    }
                    return false;
                }).count() == 1;
    }

    /**
     * Read a list of SpecialNumberEntity from a file
     * In the file the list is as a JSON  object
     *
     * @param filePathStr
     * @return a list of SpecialNumberEntity objects read from the file.
     */
    public List<SpecialNumberEntity> readListFromFile(String filePathStr) {
        JsonNumberParser parser = new JsonNumberParser(filePathStr);
        return parser.getSpecialNumberEntities();
    }

}
