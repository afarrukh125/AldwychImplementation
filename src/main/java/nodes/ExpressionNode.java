package nodes;

import visitor.CustomVisitor;

public abstract class ExpressionNode extends TreeNode {
    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
