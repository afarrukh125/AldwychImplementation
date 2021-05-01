package nodes;

import visitor.CustomVisitor;

public class DivNode extends BinOpNode {
    public DivNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
