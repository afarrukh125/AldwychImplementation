package nodes;

import visitor.CustomVisitor;

import java.util.Collections;
import java.util.List;

public class DispatchNode extends ExpressionNode {
    private final String name;
    private final List<ExpressionNode> params;
    private final List<String> writers;

    public DispatchNode(String name, List<ExpressionNode> params, List<String> writers) {
        this.name = name;
        this.params = params;
        this.writers = writers;
    }

    public String getName() {
        return name;
    }

    public List<String> getWriters() {
        return writers;
    }

    public List<ExpressionNode> getParams() {
        return Collections.unmodifiableList(params);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

}
