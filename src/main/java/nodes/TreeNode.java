package nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNode {
    private final List<TreeNode> children;

    public TreeNode() {
        children = new ArrayList<>();
    }

    public boolean addChild(TreeNode node) {
        return children.add(node);
    }

    public List<TreeNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public String toString() {
        return "\n" + getClass().getSimpleName() +
                "{children=" + children +
                '}';
    }
}
