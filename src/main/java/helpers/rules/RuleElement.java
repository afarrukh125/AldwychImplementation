package helpers.rules;

public abstract class RuleElement {

    protected String left;
    protected Object right;

    public RuleElement(String left, Object right) {
        this.left = left;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public Object getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "RuleElement{" +
                "left='" + left + '\'' +
                ", right=" + right +
                '}';
    }
}
