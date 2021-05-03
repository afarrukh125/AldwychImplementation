package tests;

import helpers.ExecuteUtils;
import helpers.Structure;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static tests.GenericTest.obtainCompleteFileName;

// To be tested when a main procedure's last statement returns an array
public abstract class ArrayTest {

    private final String fileName;
    private final Set<Structure> arrays;

    public ArrayTest(String fileName, Set<Structure> arrays) {
        this.fileName = obtainCompleteFileName(fileName);
        this.arrays = arrays;
    }

    @Test
    public final void performTest() throws IOException {
        Set<Object> retrievedResults = new HashSet<>();

        int attempts = 0;
        while(!retrievedResults.equals(arrays) && attempts < 1000) {
            Object result = ExecuteUtils.runAndReturn("testsuite/" + fileName);
            retrievedResults.add(result);
            attempts++;
        }
        assert retrievedResults.equals(arrays);
    }

    // Helper class to allow array-based test cases by deferring
    // array instantiation logic to this class
    protected static final class ArrayStructureBuilder<T> {
        private final List<List<T>> storedValues;

        public ArrayStructureBuilder() {
            storedValues = new ArrayList<>();
        }

        @SafeVarargs
        public final ArrayStructureBuilder<T> addArray(T... values) {
            storedValues.add(Arrays.asList(values));
            return ArrayStructureBuilder.this;
        }

        // Converts an array to a structure, much like the method in the TreeBuilder class
        private static <T> Structure parseFromArray(List<T> arrayValues) {
            Structure last = new Structure(Structure.EMPTY_STRUCTURE_NAME, "", Collections.emptyList());

            for(int i = arrayValues.size() - 1; i>=0; i--)
                last = new Structure(Structure.LIST_STRUCTURE_NAME, "",
                        Arrays.asList(arrayValues.get(i).toString(), last));

            return last;
        }

        // Applies function to all previously added values
        public final ArrayStructureBuilder<T> apply(Function<T, ? extends T> function) {
            for(int i = 0; i<storedValues.size(); i++) {
                List<T> currentList = storedValues.get(i);
                storedValues.set(i, currentList.stream().map(function).collect(Collectors.toList()));
            }
            return ArrayStructureBuilder.this;
        }

        public final ArrayStructureBuilder<T> filter(Predicate<T> pred) {
            for(int i = 0; i<storedValues.size(); i++) {
                List<T> currentList = storedValues.get(i);
                storedValues.set(i, currentList.stream().filter(pred).collect(Collectors.toList()));
            }
            return ArrayStructureBuilder.this;
        }

        public Set<Structure> build() {
            Set<Structure> structures = new HashSet<>();
            for(List<T> structureValues : storedValues)
                structures.add(parseFromArray(structureValues));
            return Collections.unmodifiableSet(structures);
        }
    }

}
