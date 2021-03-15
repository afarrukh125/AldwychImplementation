package nodes;

import helpers.RuleComponent;
import visitor.customised.CustomVisitor;

public class AskNode extends TreeNode implements RuleComponent {

    private final ExpressionNode expressionNode;

    public AskNode(ExpressionNode expressionNode) {
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
