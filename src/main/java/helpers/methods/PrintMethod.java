package helpers.methods;

import java.util.List;

public class PrintMethod extends DefaultProcedure {
    private static final int PARAM_SIZE = 1;

    public PrintMethod() {
        super("print");
    }

    @Override
    public Object handle(List<String> params) {
        if (params.size() != PARAM_SIZE)
            throw new IllegalArgumentException("Print takes one argument");
        System.out.println(params.get(0));
        return params.get(0);
    }
}
