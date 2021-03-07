package nodes;

import nodes.data.ExpressionNode;
import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SequentialProcedureNode extends TreeNode {

    private final HeadingNode headingNode;
    private final SequentialBodyNode body;

    public SequentialProcedureNode(HeadingNode headingNode, SequentialBodyNode body) {
        this.headingNode = headingNode;
        this.body = body;
    }

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
