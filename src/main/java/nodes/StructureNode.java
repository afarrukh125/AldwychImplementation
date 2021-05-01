package nodes;

import visitor.CustomVisitor;

import java.util.Collections;
import java.util.List;

public class StructureNode extends ExpressionNode {
    private String varName;
    private final String structureName;
    private final List<ExpressionNode> expressions;

    public static final String DEFAULT_STRUCTURE_VAR_NAME = "empty";

    public StructureNode(String varName, String structureName, List<ExpressionNode> expressions) {
        this.varName = varName;
        this.structureName = structureName;
        this.expressions = expressions;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String newName) {varName = newName;}

    public String getStructureName() {
        return structureName;
    }

    public List<ExpressionNode> getExpressions() {
        return Collections.unmodifiableList(expressions);
    }

    @Override
    public String toString() {
        return "StructureNode{" +
                "varName='" + varName + '\'' +
                ", structureName='" + structureName + '\'' +
                ", expressions=" + expressions +
                '}';
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
