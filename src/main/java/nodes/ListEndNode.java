package nodes;

import visitor.CustomVisitor;

import static nodes.StructureNode.DEFAULT_STRUCTURE_VAR_NAME;

public class ListEndNode extends ExpressionNode {

    public static final String NODE_NAME = "empty";

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
        return DEFAULT_STRUCTURE_VAR_NAME;
    }
}
