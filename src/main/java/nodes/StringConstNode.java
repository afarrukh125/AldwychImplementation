package nodes;

import visitor.customised.CustomVisitor;

public class StringConstNode extends SingleValueNode<String> {
    public StringConstNode(String value) {
        super(value);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
