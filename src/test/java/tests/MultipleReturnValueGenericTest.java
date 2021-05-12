package tests;

import helpers.ProgramRunner;
import helpers.ResultWrapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static tests.GenericTest.obtainCompleteFileName;

// For test cases where we return multiple values and test the result
public abstract class MultipleReturnValueGenericTest {

    protected final Set<ResultWrapper> expectedValues;
    private final String fileName;

    public MultipleReturnValueGenericTest(String fileName, ResultWrapper... expectedResults) {
        expectedValues = new HashSet<>(Arrays.asList(expectedResults));
        this.fileName = obtainCompleteFileName(fileName);
    }

    @Test
    public final void performTest() throws IOException {
        Set<ResultWrapper> retrievedResults = new HashSet<>();

        int attempts = 0;
        while (!retrievedResults.equals(expectedValues) && attempts < 1000) {
            ResultWrapper result = (ResultWrapper) ProgramRunner.runAndReturnProgram("testsuite/" + fileName);
            retrievedResults.add(result);
            attempts++;
        }
        assert retrievedResults.equals(expectedValues);
    }
}
