package helpers;

import java.util.Stack;

import static helpers.DataTable.Entry;

/**
 * Keeps track of variable values for simple values in the current scope and can enter and exit scopes
 */
public class ValueTable<K, V> {
    private final Stack<Entry<K, V>> table;

    public ValueTable() {
        table = new Stack<>();
    }

    public void addVariable(K identifier, V value) {
        Entry<K, V> entry = table.peek();
        entry.addMapping(identifier, value);
    }

    public void enterScope() {
        table.add(new Entry<>());
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
    public V findInScope(K identifier) {
        for (int i = table.size() - 1; i >= 0; i--) {
            Entry<K, V> tableEntry = table.get(i);
            Object value = tableEntry.getValue(identifier);
            if (value != null)
                return tableEntry.getValue(identifier);
        }
        return null;
    }

    public Entry<K, V> getCurrentScope() {
        return table.peek();
    }

}
