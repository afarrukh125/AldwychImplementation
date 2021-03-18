import helpers.ExecuteUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class GenericTest {

    private final Set<String> resultSet;
    private final String fileName;

    public GenericTest(String fileName, String... expectedResults) {
        resultSet = new HashSet<>(Arrays.asList(expectedResults));
        this.fileName = fileName;
    }

    public GenericTest(String fileName, int... expectedResults) {
        this.fileName = fileName;
        resultSet = new HashSet<>();
        for(int x : expectedResults)
            resultSet.add(Integer.toString(x));
    }

    @Test
    public final void performTest() throws IOException {
        String result = ExecuteUtils.runAndReturn("testsuite/" + fileName);
        assert resultSet.contains(result);
    }
}
