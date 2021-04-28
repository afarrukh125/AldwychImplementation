package nodes;

import visitor.customised.CustomVisitor;

public class ListEndNode extends ExpressionNode {

    private static ListEndNode instance;

    private ListEndNode() { }

    public static ListEndNode getInstance() {
        if(instance == null)
            instance = new ListEndNode();
        return instance;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

    @Override
    public String toString() {
        return "listEnd";
    }
}
