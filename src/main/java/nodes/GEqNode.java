package nodes;

import visitor.CustomVisitor;

public class GEqNode extends BinOpNode {
    public GEqNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
