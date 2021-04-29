package tests;

import helpers.ExecuteUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class GenericTest {

    private final Set<String> expectedValues;
    private final String fileName;

    public GenericTest(String fileName, String... expectedResults) {
        expectedValues = new HashSet<>(Arrays.asList(expectedResults));
        this.fileName = fileName;
    }

    public GenericTest(String fileName, int... expectedResults) {
        this.fileName = fileName;
        expectedValues = new HashSet<>();
        for(int x : expectedResults)
            expectedValues.add(Integer.toString(x));
    }

    @Test
    public final void performTest() throws IOException {
        Set<Object> retrievedResults = new HashSet<>();

        int attempts = 0;
        while(!retrievedResults.equals(expectedValues) && attempts < 1000) {
            Object result = ExecuteUtils.runAndReturn("testsuite/" + fileName);
            retrievedResults.add(result);
            attempts++;
        }
        assert retrievedResults.equals(expectedValues);
    }
}
