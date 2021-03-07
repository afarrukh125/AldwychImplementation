package nodes;

import visitor.customised.CustomVisitor;

public abstract class TreeNode {

    public TreeNode() {
    }

    public abstract <T, D> T accept(CustomVisitor<T, D> v, D data);
}
