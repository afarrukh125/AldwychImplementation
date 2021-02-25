package nodes;

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
}
