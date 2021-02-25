package nodes.data;

import nodes.TreeNode;

public abstract class Node<T> extends TreeNode {
    private final T nodeValue;

    public Node(T value) {
        nodeValue = value;
    }

    public T getNodeValue() {
        return nodeValue;
    }
}
