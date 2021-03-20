package nodes;

import visitor.customised.CustomVisitor;

import java.util.Collections;
import java.util.List;

public class StructureNode extends ExpressionNode {
    private final String varName;
    private final String structureName;
    private final List<ExpressionNode> expressions;

    public StructureNode(String varName, String structureName, List<ExpressionNode> expressions) {
        this.varName = varName;
        this.structureName = structureName;
        this.expressions = expressions;
    }

    public String getVarName() {
        return varName;
    }

    public String getStructureName() {
        return structureName;
    }

    public List<ExpressionNode> getExpressions() {
        return Collections.unmodifiableList(expressions);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
