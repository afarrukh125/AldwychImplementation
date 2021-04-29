package helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class aims to make it easier to return multiple values to multiple writers
public class Result {
    private final List<Object> values;

    public Result() {
        values = new ArrayList<>();
    }

    public void addValue(Object value) {
        values.add(value);
    }

    public List<Object> getValues() {
        return Collections.unmodifiableList(values);
    }
}
