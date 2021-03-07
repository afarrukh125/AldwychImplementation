package nodes;

import nodes.data.ExpressionNode;
import visitor.customised.CustomVisitor;

public class GTNode extends BinOpNode {
    public GTNode(ExpressionNode left, ExpressionNode right) {
        super(left, right);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
