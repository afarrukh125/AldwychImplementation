package nodes;

import visitor.customised.CustomVisitor;

public class SubNode extends BinOpNode {
    public SubNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
