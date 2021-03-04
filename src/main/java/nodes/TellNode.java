package nodes;

import helpers.rules.RuleComponent;
import nodes.data.ExpressionNode;
import visitor.customised.CustomVisitor;

public class TellNode extends TreeNode implements RuleComponent {
    private final ExpressionNode expressionNode;

    public TellNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
