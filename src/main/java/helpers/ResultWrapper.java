package helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This class aims to make it easier to return multiple values to multiple writers
public class ResultWrapper {
    private final List<Object> results;

    public ResultWrapper() {
        results = new ArrayList<>();
    }

    public void addValue(Object value) {
        results.add(value);
    }

    public List<Object> getResults() {
        return Collections.unmodifiableList(results);
    }
}
