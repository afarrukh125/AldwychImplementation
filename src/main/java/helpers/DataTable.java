package helpers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface DataTable<K, V> {

    public void addVariable(K identifier, V value);

    public void enterScope();

    public void exitScope();

    public V findInScope(K identifier);

    public Entry<K, V> getCurrentScope();

    class Entry<K, V> {
        private final Map<K, V> entry;

        public Entry() {
            entry = new ConcurrentHashMap<>();
        }

        public void addMapping(K identifier, V value) {
            entry.put(identifier, value);
        }

        public V getValue(K identifier) {
            return entry.get(identifier);
        }
    }

}
