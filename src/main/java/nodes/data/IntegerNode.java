package nodes.data;

public class IntegerNode extends Node<Integer> {
    public IntegerNode(Integer value) {
        super(value);
    }

    public IntegerNode(String value) {
        super(Integer.parseInt(value));
    }
}
