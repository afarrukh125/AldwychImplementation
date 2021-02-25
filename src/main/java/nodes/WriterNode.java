package nodes;

import visitor.customised.CustomVisitor;

public class WriterNode extends TreeNode {
    private String name;

    public WriterNode(String name) {
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
