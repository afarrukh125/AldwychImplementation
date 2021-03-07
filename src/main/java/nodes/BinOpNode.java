package nodes;

import nodes.data.ExpressionNode;

public abstract class BinOpNode extends ExpressionNode {

    private final ExpressionNode left;
    private final ExpressionNode right;

    public BinOpNode(ExpressionNode left, ExpressionNode right) {
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
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
