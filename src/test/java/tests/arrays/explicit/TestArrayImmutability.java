package tests.arrays.explicit;

import tests.ArrayTest;

public class TestArrayImmutability extends ArrayTest {

    public TestArrayImmutability() {
        super("ArrayImmutability", new ArrayStructureBuilder<Integer>()
                .addArray(2, 15, 5, 6, 7, 8, 28, 24, 21)
                .build());
    }
}
