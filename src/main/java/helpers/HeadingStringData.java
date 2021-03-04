package helpers;

import java.util.Collections;
import java.util.Set;

public class HeadingStringData {

    private final String procedureName;

    private final Set<String> readers;
    private final Set<String> writers;

    public HeadingStringData(String procedureName, Set<String> readers, Set<String> writers) {
        this.readers = readers;
        this.writers = writers;
        this.procedureName = procedureName;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public Set<String> getReaders() {
        return Collections.unmodifiableSet(readers);
    }

    public Set<String> getWriters() {
        return Collections.unmodifiableSet(writers);
    }
}
