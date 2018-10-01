package demo;

import java.util.List;

public interface IntegerFinder {

    /**
     * Checks if valueToFind is contained in the list
     *
     * @param valueToFind
     * @param list
     * @return true if valueToFind exist in the list
     * false if not
     */
    boolean doesListContain(int valueToFind, List<SpecialNumberEntity> list);

    /**
     * Read a list of SpecialNumberEntity from a file
     * In the file the list is as a JSON  object
     *
     * @param filePathStr
     * @return a list of SpecialNumberEntity objects read from the file.
     */
    List readListFromFile(String filePathStr);

}

