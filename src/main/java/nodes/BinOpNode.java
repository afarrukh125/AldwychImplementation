package nodes;

import helpers.Constants;

public class BinOpNode extends TreeNode {

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

    @Override
    protected String toStringRec(int depth) {
        String result = super.toStringRec(depth);
        StringBuilder sb = new StringBuilder(result);
        for (int i = 0; i < depth * Constants.INDENT_LENGTH; i++)
            sb.append(" ");
        sb.append(left.toStringRec(depth + 1));
        for (int i = 0; i < depth * Constants.INDENT_LENGTH; i++)
            sb.append(" ");
        sb.append(right.toStringRec(depth + 1));
        return sb.toString();
    }
}
