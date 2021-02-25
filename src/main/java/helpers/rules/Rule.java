package helpers.rules;

import helpers.SymbolTable;

public abstract class Rule {
    protected final Tell tell;

    Rule(Tell tell) {
        this.tell = tell;
    }

    public Tell getTell() {
        return tell;
    }

    public abstract RuleData execute(SymbolTable symbolTable);
}
