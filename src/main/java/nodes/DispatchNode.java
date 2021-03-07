package nodes;

import nodes.data.ExpressionNode;
import visitor.customised.CustomVisitor;

import java.util.Collections;
import java.util.List;

public class DispatchNode extends ExpressionNode {
    private final String name;
    private final List<ExpressionNode> params;
    private final String writer;

    public DispatchNode(String name, List<ExpressionNode> params, String writer) {
        this.name = name;
        this.params = params;
        this.writer = writer;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public List<ExpressionNode> getParams() {
        return Collections.unmodifiableList(params);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

}
