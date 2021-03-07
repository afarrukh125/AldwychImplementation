package nodes;

import visitor.customised.CustomVisitor;

public class SequentialProcedureNode extends Subroutine {

    private final HeadingNode headingNode;
    private final SequentialBodyNode body;

    public SequentialProcedureNode(HeadingNode headingNode, SequentialBodyNode body) {
        this.headingNode = headingNode;
        this.body = body;
    }

    @Override
    public HeadingNode getHeadingNode() {
        return headingNode;
    }

    public SequentialBodyNode getSequentialBody() {
        return body;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
