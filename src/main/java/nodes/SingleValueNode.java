package nodes;

public abstract class SingleValueNode<T> extends ExpressionNode {
    private final T nodeValue;

    public SingleValueNode(T value) {
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
