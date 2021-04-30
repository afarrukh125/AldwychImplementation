package helpers;

import java.util.*;

// This class aims to make it easier to return multiple values to multiple writers
public class ResultWrapper {
    private final List<Object> results;

    public ResultWrapper() {
        results = new ArrayList<>();
    }

    public ResultWrapper addValue(Object value) {
        results.add(value);
        return this;
    }

    public List<Object> getResults() {
        return Collections.unmodifiableList(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultWrapper that = (ResultWrapper) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "ResultWrapper{" +
                "results=" + results +
                '}';
    }
}
