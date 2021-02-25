package helpers.rules;


/**
 * A data object that is concerned with the rule that was executed, and
 * information about the execution of this rule
 */
public class RuleData {
    private Rule rule;
    private Object previousValue; // The value before applying the rule

    public RuleData(Rule rule, Object previousValue) {
        this.rule = rule;
        this.previousValue = previousValue;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Object getPreviousValue() {
        return previousValue;
    }

    public void setPreviousValue(Object previousValue) {
        this.previousValue = previousValue;
    }

    @Override
    public String toString() {
        return "Rule=" + rule;
    }
}
