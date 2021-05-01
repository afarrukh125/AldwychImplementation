package nodes;

import visitor.CustomVisitor;

// Arrays in Aldwych essentially get parsed to structures
public class ExtractableArrayNode extends ExpressionNode {

    private final String varName;
    private final String head, tail;

    public ExtractableArrayNode(String varName, String head, String tail) {
        this.varName = varName;
        this.head = head;
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "ExtractableArrayNode{" +
                "varName='" + varName + '\'' +
                ", head='" + head + '\'' +
                ", tail='" + tail + '\'' +
                '}';
    }

    public String getVarName() {
        return varName;
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
