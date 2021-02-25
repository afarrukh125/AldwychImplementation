package nodes.data;

import visitor.customised.CustomVisitor;

public class BooleanNode extends Node<Boolean> {
    public BooleanNode(Boolean value) {
        super(value);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
