package nodes;

import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassNode extends TreeNode {
    List<ProcedureNode> procedureNodeList;
    SequentialProcedureNode sequentialProcedureNode;

    public ClassNode(SequentialProcedureNode sequentialProcedureNode) {
        procedureNodeList = new ArrayList<>();
        this.sequentialProcedureNode = sequentialProcedureNode;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

    public void addProcedureNode(ProcedureNode procedureNode) {
        procedureNodeList.add(procedureNode);
    }

    public SequentialProcedureNode getSequentialProcedureNode() {
        return sequentialProcedureNode;
    }

    public List<ProcedureNode> getProcedures() {
        return Collections.unmodifiableList(procedureNodeList);
    }

}
