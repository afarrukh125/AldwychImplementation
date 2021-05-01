package nodes;

import visitor.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClassNode extends TreeNode {
    private final List<ProcedureNode> procedureNodeList;
    private final MainProcedureNode mainProcedureNode;

    public ClassNode(MainProcedureNode mainProcedureNode) {
        procedureNodeList = new ArrayList<>();
        this.mainProcedureNode = mainProcedureNode;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

    public void addProcedureNode(ProcedureNode procedureNode) {
        procedureNodeList.add(procedureNode);
    }

    public MainProcedureNode getMainProcedureNode() {
        return mainProcedureNode;
    }

    public List<ProcedureNode> getProcedures() {
        return Collections.unmodifiableList(procedureNodeList);
    }

}
