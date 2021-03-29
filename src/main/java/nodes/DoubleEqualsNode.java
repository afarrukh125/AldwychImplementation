package nodes;

import visitor.customised.CustomVisitor;

public class DoubleEqualsNode extends BinOpNode {
    public DoubleEqualsNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
