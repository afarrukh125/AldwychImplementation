package helpers.methods;

import java.util.List;

public abstract class DefaultProcedure {

    protected String name;

    public DefaultProcedure(String name) {
        this.name = name;
    }

    public abstract Object handle(List<String> params);

    public String getName() {
        return name;
    }
}
