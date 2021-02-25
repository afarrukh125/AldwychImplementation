package nodes;

import helpers.Constants;
import nodes.data.ExpressionNode;

public abstract class BinOpNode extends ExpressionNode {

    private final TreeNode left;
    private final TreeNode right;

    public BinOpNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
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
