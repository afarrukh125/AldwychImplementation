package nodes;

import visitor.customised.CustomVisitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RegularRuleNode extends TreeNode {

    private final List<AskNode> asks;
    private final List<TellNode> tells;

    public RegularRuleNode() {
        asks = new ArrayList<>();
        tells = new ArrayList<>();
    }

    public void addAsk(AskNode askNode) {
        asks.add(askNode);
    }

    public void addTell(TellNode tellNode) {
        tells.add(tellNode);
    }

    public List<AskNode> getAsks() {
        return Collections.unmodifiableList(asks);
    }

    public List<TellNode> getTells() {
        return Collections.unmodifiableList(tells);
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
