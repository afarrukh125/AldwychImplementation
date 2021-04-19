package nodes;

import java.util.Collections;
import java.util.List;

public class EmptyStructureNode extends StructureNode {

    public EmptyStructureNode() {
        super("", StructureNode.DEFAULT_STRUCTURE_VAR_NAME, java.util.Collections.emptyList());
    }
}
