package nodes;

public class IdentifierNode extends Node<String> {
    private final Node nodeValue;

    public IdentifierNode(String value, Node nodeValue) {
        super(value);
        this.nodeValue = nodeValue;
    }
}
