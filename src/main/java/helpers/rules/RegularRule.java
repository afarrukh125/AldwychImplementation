package helpers.rules;

import helpers.SymbolTable;
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
    public RuleData execute(SymbolTable symbolTable) {
        Object askLeft = symbolTable.findInScope(ask.getLeft());
        Object askRight = symbolTable.findInScope(ask.getRight().toString());

        Object tellValue = symbolTable.findInScope(tell.getLeft());

        if (askLeft.equals(askRight)) {
            Object previousValue = symbolTable.findInScope(tell.getLeft());
            symbolTable.addVariable(tell.getLeft(), tellValue);
            return new RuleData(this, previousValue);
        }
        return null;
    }
}
