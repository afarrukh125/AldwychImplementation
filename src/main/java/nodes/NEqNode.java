package nodes;

import visitor.CustomVisitor;

public class NEqNode extends BinOpNode {

    public NEqNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
