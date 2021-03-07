package nodes.data;

import visitor.customised.CustomVisitor;

public class IdentifierNode extends Node<String> {
    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

    public IdentifierNode(String value) {
        super(value);
    }

}
