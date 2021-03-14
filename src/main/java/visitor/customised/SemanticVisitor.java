package visitor.customised;

import helpers.Flag;
import helpers.HeadingStringData;
import helpers.Mode;
import helpers.ValueTable;
import nodes.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SemanticVisitor implements CustomVisitor<Object, Object> {

    private final List<String> errors;
    private final ValueTable valueTable;

    public SemanticVisitor() {
        super();
        errors = new ArrayList<>();
        valueTable = new ValueTable();
    }

    @Override
    public Object visit(ClassNode classNode, Object data) {

        for (SequentialProcedureNode sequentialProcedureNode : classNode.getSequentialProcedureNodes())
            visit(sequentialProcedureNode, data);

        for (ProcedureNode procedureNode : classNode.getProcedures())
            visit(procedureNode, data);

        return null;
    }

    /**
     * @param ruleNode The rule node
     * @param data     The data for this particular instance will be data about the {@link helpers.HeadingStringData} so we can
     *                 verify the readers and writers are being used properly within the rule if they are identifiers
     * @return {@link Object Object}
     */
    @Override
    public Object visit(RegularRuleNode ruleNode, Object data) {
        HeadingStringData headingStringData = (HeadingStringData) data;
        Set<String> readers = headingStringData.getReaders();

        String procedureName = headingStringData.getProcedureName();

        for (AskNode askNode : ruleNode.getAsks()) {
            if (askNode.getExpressionNode() instanceof BinOpNode) {
                BinOpNode binOpNode = (BinOpNode) askNode.getExpressionNode();
                checkAndReportBinOpNode(procedureName, binOpNode, readers, Mode.READ);
            }
        }

        // No need to check for variables existing in tells; we can create new variables on the fly to store the result of calls
        // See SimpleMult.ald as an example

        return null;
    }

    /**
     * Checks all the {@link IdentifierNode}s for validity in their usage
     *
     * @param procedureName The name of the procedure
     * @param binOpNode     The {@link BinOpNode} to check
     * @param variables     The possible {@link IdentifierNode}s we are looking for to compare to from the procedure heading
     * @param mode          The {@link helpers.Mode} to check for
     */
    private void checkAndReportBinOpNode(String procedureName, BinOpNode binOpNode, Collection<String> variables, Mode mode) {
        if (binOpNode.getLeft() instanceof IdentifierNode) {
            IdentifierNode leftNode = ((IdentifierNode) binOpNode.getLeft());
            if (!variables.contains(leftNode.getNodeValue()))
                this.addError(leftNode.getNodeValue() + " does not have " + mode.getMode() + " access in procedure " + procedureName);
        }

//        if (binOpNode.getRight() instanceof IdentifierNode) {
//            IdentifierNode rightNode = ((IdentifierNode) binOpNode.getRight());
//            if (!variables.contains(rightNode.getNodeValue()))
//                this.addError(rightNode.getNodeValue() + " does not have " + mode.getMode() + " access in procedure " + procedureName);
//        }
    }

    @Override
    public Object visit(FinalRuleNode finalRuleNode, Object data) {
        HeadingStringData headingStringData = (HeadingStringData) data;
        Set<String> writers = headingStringData.getWriters();
        String procedureName = headingStringData.getProcedureName();

        for (TellNode tellNode : finalRuleNode.getTells()) {
            if (tellNode.getExpressionNode() instanceof BinOpNode) {
                BinOpNode binOpNode = (BinOpNode) tellNode.getExpressionNode();
                checkAndReportBinOpNode(procedureName, binOpNode, writers, Mode.WRITE);
            }
        }

        return null;
    }

    @Override
    public Object visit(RuleSetNode ruleSetNode, Object data) {
        for (RegularRuleNode regularRuleNode : ruleSetNode.getRegularRules())
            visit(regularRuleNode, data);
        return null;
    }

    @Override
    public Object visit(AskNode askNode, Object data) {
        return visit(askNode.getExpressionNode(), data);
    }

    @Override
    public Object visit(BodyNode bodyNode, Object data) {
        for (RuleSetNode ruleSetNode : bodyNode.getRulesets())
            visit(ruleSetNode, data);
        visit(bodyNode.getFinalRule(), data);
        return null;
    }

    @Override
    public Object visit(DispatchNode dispatchNode, Object data) {
        // TODO analyse parameters for semantic analysis
        return null;
    }

    @Override
    public Object visit(DivNode divNode, Object data) {
        return null;
    }

    @Override
    public Object visit(EqNode eqNode, Object data) {
        return null;
    }

    @Override
    public Object visit(GEqNode gEqNode, Object data) {
        return null;
    }

    @Override
    public Object visit(GTNode gtNode, Object data) {
        return null;
    }

    @Override
    public Object visit(HeadingNode headingNode, Object data) {
        return null;
    }

    @Override
    public Object visit(LEqNode lEqNode, Object data) {
        return null;
    }

    @Override
    public Object visit(LTNode ltNode, Object data) {
        return null;
    }

    @Override
    public Object visit(MulNode mulNode, Object data) {
        return null;
    }

    @Override
    public Object visit(PlusNode plusNode, Object data) {
        return null;
    }

    @Override
    public Object visit(ProcedureNode procedureNode, Object data) {

        // Index the readers and writers into sets so we can look up easier when validating readers and writers
        Set<String> readersAsStrings = procedureNode.getHeadingNode().getReaders().getReaderNodes()
                .stream()
                .map(ReaderNode::getName)
                .collect(Collectors.toSet());

        Set<String> writersAsStrings = procedureNode.getHeadingNode().getWriters().getWriterNodes()
                .stream()
                .map(WriterNode::getName)
                .collect(Collectors.toSet());

        HeadingStringData headingStringData =
                new HeadingStringData(procedureNode.getHeadingNode().getName(), readersAsStrings, writersAsStrings);

        visit(procedureNode.getBody(), headingStringData);
        return null;
    }

    @Override
    public Object visit(ReaderContainerNode readerContainerNode, Object data) {
        return null;
    }

    @Override
    public Object visit(WriterContainerNode writerContainerNode, Object data) {
        return null;
    }

    @Override
    public Object visit(ReaderNode readerNode, Object data) {
        return null;
    }

    @Override
    public Object visit(ExpressionNode expressionNode, Object data) {
        expressionNode.accept(this, data);
        return null;
    }

    @Override
    public Object visit(SubNode subNode, Object data) {
        return null;
    }

    @Override
    public Object visit(TellNode tellNode, Object data) {
        visit(tellNode.getExpressionNode(), data);
        return null;
    }

    @Override
    public Object visit(WriterNode writerNode, Object data) {
        return null;
    }

    @Override
    public Object visit(BooleanNode booleanNode, Object data) {
        return null;
    }

    @Override
    public Object visit(IdentifierNode identifierNode, Object data) {
        return null;
    }

    @Override
    public Object visit(IntegerNode integerNode, Object data) {
        return null;
    }

    @Override
    public Object visit(StringConstNode stringConstNode, Object data) {
        return null;
    }

    @Override
    public Object visit(SequentialProcedureNode sequentialProcedureNode, Object data) {
        visit(sequentialProcedureNode.getSequentialBody(), data);
        return null;
    }

    @Override
    public Object visit(SequentialBodyNode sequentialBodyNode, Object data) {
        data = Flag.ASSIGN;
        for (ExpressionNode expr : sequentialBodyNode.getExpressions())
            visit(expr, data);
        return null;
    }

    private void addError(String message) {
        errors.add(message);
    }

    public List<String> getErrors() {
        return errors;
    }
}
