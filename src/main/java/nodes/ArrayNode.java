package nodes;

import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayNode extends ExpressionNode {

    private final List<StructureNode> internalStructureNodes;

    public ArrayNode() {
        internalStructureNodes = new ArrayList<>();
    }

    public void addStructure(StructureNode structureNode) {
        internalStructureNodes.add(structureNode);
    }

    public List<StructureNode> getInternalStructureNodes() {
        return Collections.unmodifiableList(internalStructureNodes);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
