package nodes;

import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SequentialBodyNode extends TreeNode {

    private final List<ExpressionNode> expressionNodeList;

    public SequentialBodyNode() {
        expressionNodeList = new ArrayList<>();
    }

    public void addExpression(ExpressionNode expressionNode) {
        expressionNodeList.add(expressionNode);
    }

    public List<ExpressionNode> getExpressions() {
        return Collections.unmodifiableList(expressionNodeList);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
