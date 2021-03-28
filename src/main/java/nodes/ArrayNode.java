package nodes;

import visitor.customised.CustomVisitor;

import java.util.List;

public class ArrayNode extends ExpressionNode {

    private List<ExpressionNode> exprs;

    public ArrayNode() {

    }

    // TODO decide attributes
    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
