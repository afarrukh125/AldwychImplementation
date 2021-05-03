package tests.arrays.explicit;

import tests.ArrayTest;

public class TestSquare extends ArrayTest {
    public TestSquare() {
        super("SquareAll", new ArrayStructureBuilder<Integer>()
                .addArray(2, 15, 5, 6, 7, 8, 28, 24, 21)
                .apply(x -> x * x)
                .build());
    }
}
