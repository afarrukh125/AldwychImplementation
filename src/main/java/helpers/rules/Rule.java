package helpers.rules;

import helpers.ValueTable;

public abstract class Rule {
    protected final Tell tell;

    Rule(Tell tell) {
        this.tell = tell;
    }

    public Tell getTell() {
        return tell;
    }

    public abstract RuleData execute(ValueTable valueTable);
}
