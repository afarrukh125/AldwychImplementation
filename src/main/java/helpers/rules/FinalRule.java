package helpers.rules;


import helpers.ValueTable;

// The rule at the end of each procedure that will be executed unconditionally given the other rules were not
class FinalRule extends Rule {
    FinalRule(Tell tell) {
        super(tell);
    }

    @Override
    public RuleData execute(ValueTable valueTable) {
        Object tellValue = valueTable.findInScope(tell.getRight().toString());
        Object previousTellValue = valueTable.findInScope(tell.getLeft());
        valueTable.addVariable(tell.getLeft(), tellValue);
        return new RuleData(this, previousTellValue);
    }

    @Override
    public String toString() {
        return "FinalRule{" +
                "tell=" + tell +
                '}';
    }
}
