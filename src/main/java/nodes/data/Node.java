package nodes.data;

public abstract class Node<T> extends ExpressionNode {
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
