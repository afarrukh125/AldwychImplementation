package nodes;

public class HeadingNode extends TreeNode {

    private final String name;

    public HeadingNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "HeadingNode{" +
                "name='" + name + '\'' +
                '}';
    }
}
