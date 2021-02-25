package nodes;

import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeadingNode extends TreeNode {

    private final String name;
    private final ReaderContainerNode readers;
    private final WriterContainerNode writers;

    public HeadingNode(String name, ReaderContainerNode readers, WriterContainerNode writers) {
        this.name = name;
        this.readers = readers;
        this.writers = writers;
    }

    public String getName() {
        return name;
    }

    public ReaderContainerNode getReaders() {
        return readers;
    }

    public WriterContainerNode getWriters() {
        return writers;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }

    @Override
    public String toString() {
        return "HeadingNode{" +
                "name='" + name + '\'' +
                '}';
    }
}
