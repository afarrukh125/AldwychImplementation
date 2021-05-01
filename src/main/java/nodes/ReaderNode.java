package nodes;

import visitor.CustomVisitor;

public class ReaderNode extends TreeNode {

    private final String name;

    public ReaderNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
