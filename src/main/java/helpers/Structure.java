package helpers;

import java.util.Collections;
import java.util.List;

public class Structure {
    private final String varName;
    private final String structureName;
    private final List<String> values;

    public Structure(String structureName, String varName, List<String> values) {
        this.varName = varName;
        this.values = values;
        this.structureName = structureName;
    }

    public String getVarName() {
        return varName;
    }

    public String getStructureName() {
        return structureName;
    }

    public List<String> getValues() {
        return Collections.unmodifiableList(values);
    }
}
