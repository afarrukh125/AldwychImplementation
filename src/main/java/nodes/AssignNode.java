package nodes;

import visitor.customised.CustomVisitor;

public class AssignNode extends TreeNode {

    private final TreeNode left;
    private final TreeNode right;

    public AssignNode(TreeNode left, TreeNode right) {
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
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
