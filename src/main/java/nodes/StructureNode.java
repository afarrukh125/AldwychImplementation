package nodes;

import visitor.customised.CustomVisitor;

import java.util.Collections;
import java.util.List;

public class StructureNode extends ExpressionNode {
    private final String varName;
    private final String structureName;
    private final List<ExpressionNode> params;

    public StructureNode(String varName, String structureName, List<ExpressionNode> params) {
        this.varName = varName;
        this.structureName = structureName;
        this.params = params;
    }

    public String getVarName() {
        return varName;
    }

    public String getStructureName() {
        return structureName;
    }

    public List<ExpressionNode> getParams() {
        return Collections.unmodifiableList(params);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
