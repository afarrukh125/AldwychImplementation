package nodes;

import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BodyNode extends TreeNode {

    List<RegularRuleNode> regularRules;
    FinalRuleNode finalRule;

    public BodyNode() {
        this.regularRules = new ArrayList<>();
    }

    public void addRegularRule(RegularRuleNode regularRuleNode) {
        regularRules.add(regularRuleNode);
    }

    public void setFinalRule(FinalRuleNode finalRule) {
        this.finalRule = finalRule;
    }

    public List<RegularRuleNode> getRegularRules() {
        return Collections.unmodifiableList(regularRules);
    }

    public FinalRuleNode getFinalRule() {
        return finalRule;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

}
