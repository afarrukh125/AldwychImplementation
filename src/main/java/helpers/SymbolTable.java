package helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Behaves like a scope and type checker aspect, while also maintaining the value of variables
 * in a given scope
 */
public class SymbolTable {
    private final Stack<Entry> table;

    public SymbolTable() {
        table = new Stack<>();
    }

    public void addVariable(String identifier, Object value) {
        Entry entry = table.peek();
        entry.addIdentifier(identifier, value);
    }

    public void enterScope() {
        table.add(new Entry());
    }

    public void exitScope() {
        table.pop();
    }

    /**
     * Finds the value of the identifier in the nearest scope
     *
     * @param identifier The identifier to look for
     * @return The value of the identifier if found, null otherwise TODO find a better way to handle not-found values
     */
    public Object findInScope(String identifier) {
        for (Entry tableEntry : table) {
            Object value = tableEntry.getValue(identifier);
            if (value != null)
                return tableEntry.getValue(identifier);
        }
        return null;
    }

    public Entry getCurrentScope() {
        return table.peek();
    }

    public static class Entry {
        private final Map<String, Object> entry;

        public Entry() {
            entry = new HashMap<>();
        }

        public void addIdentifier(String identifier, Object value) {
            entry.put(identifier, value);
        }

        public Object getValue(String identifier) {
            return entry.get(identifier);
        }
    }
}
