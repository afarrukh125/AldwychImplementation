package nodes.data;

import nodes.TreeNode;
import visitor.customised.CustomVisitor;

public class ExpressionNode extends TreeNode {
    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
