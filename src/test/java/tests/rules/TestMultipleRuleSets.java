package tests.rules;

import tests.GenericTest;

public class TestMultipleRuleSets extends GenericTest {
    private static final String RULESETS_FILE = "MultipleRuleSets.ald";

    public TestMultipleRuleSets() {
        super(RULESETS_FILE, "12", "13");
    }
}
