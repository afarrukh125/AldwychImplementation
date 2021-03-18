package helpers;

import nodes.WriterNode;

import java.security.spec.ECField;
import java.util.*;

public class ExecutionEnvironment {
    private  Set<Flag> flags;
    private  ValueTable<String, Object> valueTable;
    private  ValueTable<String, Structure> structureTable;
    private MethodTable methodTable;

    private List<WriterNode> writerNodes;

    public ExecutionEnvironment() {
        flags = new HashSet<>();
        valueTable = new ValueTable<>();
        structureTable = new ValueTable<>();
        writerNodes = new ArrayList<>();
        methodTable = new MethodTable();
    }

    public List<WriterNode> getWriterNodes() {
        return Collections.unmodifiableList(writerNodes);
    }

    public void addWriters(Collection<WriterNode> writerNodes) {
        this.writerNodes.addAll(writerNodes);
    }

    public void clearFlags() {
        flags.clear();
    }

    public void addFlag(Flag flag) {
        flags.add(flag);
    }

    public Set<Flag> getFlags() {
        return flags;
    }

    public ValueTable<String, Object> getValueTable() {
        return valueTable;
    }

    public ValueTable<String, Structure> getStructureTable() {
        return structureTable;
    }

    public MethodTable getMethodTable() {
        return methodTable;
    }

    public ExecutionEnvironment copy() {
        ExecutionEnvironment env = new ExecutionEnvironment();
        env.flags = new HashSet<>(this.flags);
        env.methodTable = this.methodTable.copy();
        env.structureTable = this.structureTable.copy();
        env.valueTable = this.valueTable.copy();
        env.writerNodes = new ArrayList<>(this.writerNodes);

        return env;
    }
}
