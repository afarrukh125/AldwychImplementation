package nodes.data;

import visitor.customised.CustomVisitor;

public class IntegerNode extends Node<Integer> {
    public IntegerNode(Integer value) {
        super(value);
    }

    public IntegerNode(String value) {
        super(Integer.parseInt(value));
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
