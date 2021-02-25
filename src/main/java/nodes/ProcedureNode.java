package nodes;

import visitor.customised.CustomVisitor;

public class ProcedureNode extends TreeNode {

    private final HeadingNode headingNode;
    private final BodyNode body;

    public ProcedureNode(HeadingNode headingNode, BodyNode bodyNode) {
        this.headingNode = headingNode;
        this.body = bodyNode;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return null;
    }

    public HeadingNode getHeadingNode() {
        return headingNode;
    }

    public BodyNode getBody() {
        return body;
    }
}
