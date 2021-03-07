package helpers;

import helpers.methods.DefaultProcedure;
import helpers.methods.PrintMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a class which is to handle calls to default methods like print in our program
 */
public class DefaultProcedureHandler {

    private final Map<String, DefaultProcedure> procedures;

    public DefaultProcedureHandler() {
        procedures = new HashMap<>();
        setup();
    }

    private void setup() {
        addProcedure(new PrintMethod());
    }

    private DefaultProcedureHandler addProcedure(DefaultProcedure procedure) {
        procedures.put(procedure.getName(), procedure);
        return this;
    }

    public boolean canHandle(String procedureName) {
        return procedures.containsKey(procedureName);
    }

    public Object handleProcedure(String procedureName, List<String> params) {
        return procedures.get(procedureName).handle(params);
    }


}
