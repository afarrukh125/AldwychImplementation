package helpers.rules;

import helpers.ValueTable;

class RegularRule extends Rule {
    protected final Ask ask;

    RegularRule(Ask ask, Tell tell) {
        super(tell);
        this.ask = ask;
    }

    public Ask getAsk() {
        return ask;
    }

    @Override
    public String toString() {
        return "RegularRule{" +
                "ask=" + ask +
                ", tell=" + tell +
                '}';
    }

    @Override
    public RuleData execute(ValueTable valueTable) {
        Object askLeft = valueTable.findInScope(ask.getLeft());
        Object askRight = valueTable.findInScope(ask.getRight().toString());

        Object tellValue = valueTable.findInScope(tell.getLeft());

        if (askLeft.equals(askRight)) {
            Object previousValue = valueTable.findInScope(tell.getLeft());
            valueTable.addVariable(tell.getLeft(), tellValue);
            return new RuleData(this, previousValue);
        }
        return null;
    }
}
