package demo.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import demo.SpecialNumberEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.*;

public class JsonNumberParser {

    private static final Gson GSON_PARSER = new Gson();
    private static final Type CUSTOM_NUMBER_ENTITY_TYPE = new TypeToken<ArrayList<SpecialNumberEntity>>() {
    }.getType();
    private List specialNumberEntities = emptyList();

    private JsonNumberParser() {

    }

    public JsonNumberParser(final String filePath) {
        this();
        try (Reader numbersFileReader = new BufferedReader(new FileReader(filePath))) {
            try {
                this.specialNumberEntities = GSON_PARSER.fromJson(numbersFileReader, CUSTOM_NUMBER_ENTITY_TYPE);
                if (this.specialNumberEntities == null) {
                    this.specialNumberEntities = EMPTY_LIST;
                }
            } catch (Exception e) {
                System.err.println("Error parsing file " +filePath +"with " +e.getMessage());
                throw e;
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Error Accessing file [" + filePath + "]");
        }
    }

    public List getSpecialNumberEntities() {
        return this.specialNumberEntities;
    }
}
