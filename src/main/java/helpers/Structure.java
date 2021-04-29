package helpers;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Structure {
    private final String varName;
    private final String structureName;
    private final List<Object> values;

    public Structure(String structureName, String varName, List<Object> values) {
        this.varName = varName;
        this.values = values;
        this.structureName = structureName;
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public String toString() {
        return "Structure{" +
                "varName='" + varName + '\'' +
                ", structureName='" + structureName + '\'' +
                ", values=" + values +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Structure structure = (Structure) o;
        boolean res1= structureName.equals(structure.structureName);
        boolean res2=values.equals(structure.values);
        return  res1 &&res2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(structureName, values);
    }

    public String getStructureName() {
        return structureName;
    }

    public List<Object> getValues() {
        return Collections.unmodifiableList(values);
    }
}
