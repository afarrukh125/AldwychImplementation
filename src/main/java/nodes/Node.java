package nodes;

public abstract class Node<T> {
    private final T nodeValue;

    public Node(T value) {
        nodeValue = value;
    }

    public T getNodeValue() {
        return nodeValue;
    }
}
