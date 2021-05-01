package nodes;

import visitor.CustomVisitor;

// Arrays in Aldwych essentially get parsed to structures
public class ExtractableArrayNode extends ExpressionNode {

    private final String head, tail;

    public ExtractableArrayNode(String head, String tail) {
        this.head = head;
        this.tail = tail;
    }

    public String getHead() {
        return head;
    }

    /**
     * Returns the identifier that refers to the structure that holds the tail of this list
     */
    public String getTail() {
        return tail;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
