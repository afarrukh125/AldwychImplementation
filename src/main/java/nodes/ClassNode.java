package nodes;

import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassNode extends TreeNode {
    List<ProcedureNode> procedureNodeList;
    List<SequentialProcedureNode> sequentialProcedureNodeList;

    public ClassNode() {
        procedureNodeList = new ArrayList<>();
        sequentialProcedureNodeList = new ArrayList<>();
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

    public void addProcedureNode(ProcedureNode procedureNode) {
        procedureNodeList.add(procedureNode);
    }

    public void addSequentialProcedureNode(SequentialProcedureNode sequentialProcedureNode) {
        sequentialProcedureNodeList.add(sequentialProcedureNode);
    }

    public List<SequentialProcedureNode> getSequentialProcedureNodes() {
        return Collections.unmodifiableList(sequentialProcedureNodeList);
    }

    public List<ProcedureNode> getProcedures() {
        return Collections.unmodifiableList(procedureNodeList);
    }

}
