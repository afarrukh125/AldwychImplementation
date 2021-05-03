package tests.arrays.explicit;

import helpers.Structure;
import tests.ArrayTest;

import java.util.Set;

public class TestArrayReapply extends ArrayTest {
    public TestArrayReapply() {
        super("ArrayReapply", new ArrayStructureBuilder<Integer>()
                .addArray(2, 15, 5, 6, 7, 8, 28, 24, 21)
                .apply(x -> x*x)
                .apply(x -> x*x)
                .build());
    }
}
