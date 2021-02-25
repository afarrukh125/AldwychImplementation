package nodes;

import java.util.ArrayList;
import java.util.List;

public class ProcedureNode extends TreeNode {

    private final String procedureName;

    public ProcedureNode(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getProcedureName() {
        return procedureName;
    }
}
