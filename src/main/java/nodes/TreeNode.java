package nodes;

import helpers.Constants;
import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class TreeNode {
    protected final List<TreeNode> children;

    public TreeNode() {
        children = new ArrayList<>();
    }

    public void addChild(TreeNode node) {
        children.add(node);
    }

    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

    public List<TreeNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public String toString() {
        return toStringRec(1);
    }

    protected String toStringRec(int depth) {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("\n");

        for (TreeNode childNode : children) {
            for (int i = 0; i < depth * Constants.INDENT_LENGTH; i++)
                sb.append(" ");
            sb.append(childNode.toStringRec(depth + 1));
        }
        return sb.toString();
    }
}
