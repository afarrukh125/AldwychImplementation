package nodes;

import visitor.customised.CustomVisitor;

public class PlusNode extends BinOpNode {
    public PlusNode(TreeNode left, TreeNode right) {
        super(left, right);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
