package helpers.rules;


import helpers.SymbolTable;

// The rule at the end of each procedure that will be executed unconditionally given the other rules were not
class FinalRule extends Rule {
    FinalRule(Tell tell) {
        super(tell);
    }

    @Override
    public RuleData execute(SymbolTable symbolTable) {
        Object tellValue = symbolTable.findInScope(tell.getRight().toString());
        Object previousTellValue = symbolTable.findInScope(tell.getLeft());
        symbolTable.addVariable(tell.getLeft(), tellValue);
        return new RuleData(this, previousTellValue);
    }

    @Override
    public String toString() {
        return "FinalRule{" +
                "tell=" + tell +
                '}';
    }
}
