package tests.simple;

import tests.GenericTest;

public class TestSimpleAssignment extends GenericTest {

    private static final String ASSIGNMENT_FILE = "SimpleAssignment.ald";

    public TestSimpleAssignment() {
        super(ASSIGNMENT_FILE, "b", "d");
    }
}
