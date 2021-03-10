package nodes;

import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BodyNode extends TreeNode {

    private final List<RuleSetNode> rulesets;
    private FinalRuleNode finalRule;

    public BodyNode() {
        this.rulesets = new ArrayList<>();
    }

    public void addRuleSet(RuleSetNode ruleSetNode) {
        rulesets.add(ruleSetNode);
    }

    public List<RuleSetNode> getRulesets() {
        return Collections.unmodifiableList(rulesets);
    }

    public FinalRuleNode getFinalRule() {
        return finalRule;
    }

    public void setFinalRule(FinalRuleNode finalRule) {
        this.finalRule = finalRule;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

}
