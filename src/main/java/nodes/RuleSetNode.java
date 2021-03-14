package nodes;

import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RuleSetNode extends TreeNode {

    private final List<RegularRuleNode> regularRules;

    public RuleSetNode() {
        regularRules = new ArrayList<>();
    }

    public void addRegularRule(RegularRuleNode regularRuleNode) {
        regularRules.add(regularRuleNode);
    }

    public List<RegularRuleNode> getRegularRules() {
        // TODO decide if we want to return unmodifiable version or not
        return regularRules;
    }


    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
