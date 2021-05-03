package tests.arrays.explicit;

import tests.ArrayTest;

public class TestRemoveLessThan extends ArrayTest {
    public TestRemoveLessThan() {
        super("ArrayRemoveLessThan.ald", new ArrayStructureBuilder<Integer>()
                .addArray(2, 15, 5, 6, 7, 8, 28, 24, 21)
                .filter(x -> x>=6)
                .build());
    }
}
