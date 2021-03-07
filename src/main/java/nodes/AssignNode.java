package nodes;

import nodes.data.ExpressionNode;
import visitor.customised.CustomVisitor;

public class AssignNode extends ExpressionNode {

    private final ExpressionNode left;
    private final ExpressionNode right;

    public AssignNode(ExpressionNode left, ExpressionNode right) {
        this.left = left;
        this.right = right;
    }

    public ExpressionNode getLeft() {
        return left;
    }

    public ExpressionNode getRight() {
        return right;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
