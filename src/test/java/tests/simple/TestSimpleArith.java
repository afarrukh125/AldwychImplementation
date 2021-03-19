package tests.simple;

import tests.GenericTest;

public class TestSimpleArith extends GenericTest {

    private static final String ARITH_FILE = "SimpleArith.ald";

    public TestSimpleArith() {
        super(ARITH_FILE, "8", "13", "15");
    }
}
