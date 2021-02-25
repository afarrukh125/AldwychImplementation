package nodes;

import visitor.customised.CustomVisitor;

public class DispatchNode extends TreeNode {
    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

}
