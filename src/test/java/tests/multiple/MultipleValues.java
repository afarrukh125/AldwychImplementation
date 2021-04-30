package tests.multiple;

import helpers.ResultWrapper;
import tests.MultipleReturnValueGenericTest;

// To be used when we have multiple return values for a given main method body, in which case
// the final result is a result wrapper
public class MultipleValues extends MultipleReturnValueGenericTest {
    public MultipleValues() {
        super("MultipleReturnValues.ald");
        ResultWrapper wrapper1 = new ResultWrapper().addValue("d").addValue("g");
        ResultWrapper wrapper2= new ResultWrapper().addValue("b").addValue("f");

        this.expectedValues.add(wrapper1);
        this.expectedValues.add(wrapper2);
    }
}
