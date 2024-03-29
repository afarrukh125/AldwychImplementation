package nodes;

import visitor.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReaderContainerNode extends TreeNode {

    private final List<ReaderNode> readerNodes;

    public ReaderContainerNode() {
        readerNodes = new ArrayList<>();
    }

    public void addReader(ReaderNode node) {
        readerNodes.add(node);
    }

    public List<ReaderNode> getReaderNodes() {
        return Collections.unmodifiableList(readerNodes);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
