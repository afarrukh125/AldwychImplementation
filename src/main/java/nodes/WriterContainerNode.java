package nodes;

import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriterContainerNode extends TreeNode{

    List<WriterNode> writers;

    public WriterContainerNode() {
        super();
        writers = new ArrayList<>();
    }

    public void addWriter(WriterNode writer) {
        writers.add(writer);
    }

    public List<WriterNode> getWriterNodes() {
        return Collections.unmodifiableList(writers);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
