package nodes;

import nodes.data.ExpressionNode;
import visitor.customised.CustomVisitor;

public class DispatchNode extends ExpressionNode {
    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

}
