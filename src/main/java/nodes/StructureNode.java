package nodes;

import visitor.customised.CustomVisitor;

import java.util.Collections;
import java.util.List;

public class StructureNode extends ExpressionNode {
    private final String varName;
    private final String structureName;
    private final List<ExpressionNode> values;

    public StructureNode(String varName, String structureName, List<ExpressionNode> values) {
        this.varName = varName;
        this.structureName = structureName;
        this.values = values;
    }

    public String getVarName() {
        return varName;
    }

    public String getStructureName() {
        return structureName;
    }

    public List<ExpressionNode> getValues() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
