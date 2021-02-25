package nodes;

import visitor.customised.CustomVisitor;

public class EqNode extends BinOpNode {
    public EqNode(TreeNode left, TreeNode right) {
        super(left, right);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
