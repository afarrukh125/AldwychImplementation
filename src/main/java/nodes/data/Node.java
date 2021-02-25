package nodes.data;

import helpers.Constants;
import nodes.TreeNode;

public abstract class Node<T> extends TreeNode {
    private final T nodeValue;

    public Node(T value) {
        nodeValue = value;
    }

    public T getNodeValue() {
        return nodeValue;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeValue=" + nodeValue +
                '}';
    }

    @Override
    protected String toStringRec(int depth) {
        String result = super.toStringRec(depth);
        StringBuilder sb = new StringBuilder(result);
        for (int i = 0; i < depth * Constants.INDENT_LENGTH; i++)
            sb.append(" ");
        sb.append(getNodeValue());
        sb.append("\n");
        return sb.toString();
    }
}
