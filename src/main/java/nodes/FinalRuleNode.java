package nodes;

import visitor.CustomVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinalRuleNode extends TreeNode {

    private final List<TellNode> tells;

    public FinalRuleNode() {
        this.tells = new ArrayList<>();
    }

    public void addTell(TellNode tellNode) {
        tells.add(tellNode);
    }

    public List<TellNode> getTells() {
        return Collections.unmodifiableList(tells);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
