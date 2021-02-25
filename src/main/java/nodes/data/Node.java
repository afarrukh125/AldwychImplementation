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
}
