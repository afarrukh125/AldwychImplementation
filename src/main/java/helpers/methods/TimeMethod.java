package helpers.methods;

import java.util.List;

public class TimeMethod extends DefaultProcedure {
    public TimeMethod() {
        super("time");
    }

    @Override
    public Object handle(List<Object> params) {
        return Long.toString(System.currentTimeMillis());
    }
}
