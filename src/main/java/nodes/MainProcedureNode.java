package nodes;

import visitor.CustomVisitor;

public class MainProcedureNode extends Subroutine {

    private final HeadingNode headingNode;
    private final FinalRuleNode finalRuleNode;

    public MainProcedureNode(HeadingNode headingNode, FinalRuleNode finalRuleNode) {
        this.headingNode = headingNode;
        this.finalRuleNode = finalRuleNode;
    }

    @Override
    public HeadingNode getHeadingNode() {
        return headingNode;
    }

    public FinalRuleNode getFinalRuleNode() {
        return finalRuleNode;
    }

    @Override
    public <T, D> T accept(CustomVisitor<T, D> v, D data) {
        return v.visit(this, data);
    }
}
