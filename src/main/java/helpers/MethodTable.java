package helpers;

import nodes.Subroutine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodTable {
    private final Map<String, Subroutine> methodTable;
    private final DefaultProcedureHandler handler;

    public MethodTable() {
        methodTable = new HashMap<>();
        handler = new DefaultProcedureHandler();
    }

    public void addMethod(String methodName, Subroutine node) {
        methodTable.put(methodName, node);
    }

    public Subroutine getMethodByName(String name) {
        return methodTable.get(name);
    }

    /**
     * The method table can handle calls to some default methods
     *
     * @param methodName The name of the method
     * @return Whether this method can be handled
     */
    public boolean canHandle(String methodName) {
        return handler.canHandle(methodName);
    }

    public Object handleDefaultMethod(String methodName, List<Object> params) {
        return handler.handleProcedure(methodName, params);
    }
}
