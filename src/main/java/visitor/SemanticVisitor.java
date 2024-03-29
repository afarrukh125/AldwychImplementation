package visitor;

import helpers.HeadingStringData;
import helpers.Mode;
import nodes.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SemanticVisitor implements CustomVisitor<Object, Object> {
    private final List<String> errors;

    public SemanticVisitor() {
        super();
        errors = new ArrayList<>();
    }

    @Override
    public Object visit(DoubleEqualsNode doubleEqualsNode, Object data) {
        visit(doubleEqualsNode.getLeft(), data);
        visit(doubleEqualsNode.getRight(), data);
        return null;
    }

    @Override
    public Object visit(AssignNode assignNode, Object data) {
        Object identifierName = visit(assignNode.getLeft(), data);
        if(identifierName instanceof String) {
            String stringIdentifier = (String) identifierName;
            if(stringIdentifier.startsWith(TreeBuilder.HIDDEN_VAR_PREFIX))
                addError("Identifiers may not start with reserved name " + TreeBuilder.HIDDEN_VAR_PREFIX);
        }
        visit(assignNode.getRight(), data);
        return null;
    }

    @Override
    public Object visit(ClassNode classNode, Object data) {

        visit(classNode.getMainProcedureNode(), data);
        if (classNode.getMainProcedureNode() == null || !classNode.getMainProcedureNode().getHeadingNode().getName().equals("main"))
            addError("No entry point procedure found. Please include exactly one, and call it 'main'");

        for (ProcedureNode procedureNode : classNode.getProcedures())
            visit(procedureNode, data);

        return null;
    }

    @Override
    public Object visit(RegularRuleNode ruleNode, Object data) {

        for (AskNode askNode : ruleNode.getAsks())
            visit(askNode, data);

        for (TellNode tellNode : ruleNode.getTells())
            visit(tellNode, data);

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
    }

    @Override
    public Object visit(FinalRuleNode finalRuleNode, Object data) {
        for(TellNode tellNode : finalRuleNode.getTells())
            visit(tellNode, data);
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
        // TODO analyse parameters for semantic analysis if type checking is added in future
        return null;
    }

    @Override
    public Object visit(DivNode divNode, Object data) {
        visit(divNode.getLeft(), data);
        visit(divNode.getRight(), data);
        return null;
    }

    @Override
    public Object visit(EqNode eqNode, Object data) {
        visit(eqNode.getLeft(), data);
        visit(eqNode.getRight(), data);
        return null;
    }

    @Override
    public Object visit(GEqNode gEqNode, Object data) {
        visit(gEqNode.getLeft(), data);
        visit(gEqNode.getRight(), data);
        return null;
    }

    @Override
    public Object visit(GTNode gtNode, Object data) {
        visit(gtNode.getLeft(), data);
        visit(gtNode.getRight(), data);
        return null;
    }

    @Override
    public Object visit(HeadingNode headingNode, Object data) {
        visit(headingNode.getReaders(), data);
        visit(headingNode.getWriters(), data);
        return null;
    }

    @Override
    public Object visit(LEqNode lEqNode, Object data) {
        visit(lEqNode.getLeft(), data);
        visit(lEqNode.getRight(), data);
        return null;
    }

    @Override
    public Object visit(NEqNode nEqNode, Object data) {
        visit(nEqNode.getLeft(), data);
        visit(nEqNode.getRight(), data);
        return null;
    }

    @Override
    public Object visit(LTNode ltNode, Object data) {
        visit(ltNode.getLeft(), data);
        visit(ltNode.getRight(), data);
        return null;
    }

    @Override
    public Object visit(MulNode mulNode, Object data) {
        visit(mulNode.getLeft(), data);
        visit(mulNode.getRight(), data);
        return null;
    }

    @Override
    public Object visit(PlusNode plusNode, Object data) {
        visit(plusNode.getLeft(), data);
        visit(plusNode.getRight(), data);
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
        for(ReaderNode rn : readerContainerNode.getReaderNodes())
            visit(rn, data);
        return null;
    }

    @Override
    public Object visit(WriterContainerNode writerContainerNode, Object data) {
        for(WriterNode wn : writerContainerNode.getWriterNodes())
            visit(wn, data);
        return null;
    }

    @Override
    public Object visit(ReaderNode readerNode, Object data) {
        return readerNode.getName();
    }

    @Override
    public Object visit(ExpressionNode expressionNode, Object data) {
        return expressionNode.accept(this, data);
    }

    @Override
    public Object visit(SubNode subNode, Object data) {
        visit(subNode.getLeft(), data);
        visit(subNode.getRight(), data);
        return null;
    }

    @Override
    public Object visit(TellNode tellNode, Object data) {
        visit(tellNode.getExpressionNode(), data);
        return null;
    }

    @Override
    public Object visit(WriterNode writerNode, Object data) {
        return writerNode.getName();
    }

    @Override
    public Object visit(IdentifierNode identifierNode, Object data) {
        return identifierNode.getNodeValue();
    }

    @Override
    public Object visit(IntegerNode integerNode, Object data) {
        return integerNode;
    }

    @Override
    public Object visit(MainProcedureNode mainProcedureNode, Object data) {
        visit(mainProcedureNode.getFinalRuleNode(), data);
        return null;
    }

    @Override
    public Object visit(StringConstNode stringConstNode, Object data) {
        String value = stringConstNode.getNodeValue();
        if(value.startsWith(TreeBuilder.HIDDEN_VAR_PREFIX))
            addError("String constant may not start with reserved value " + TreeBuilder.HIDDEN_VAR_PREFIX);
        return value;
    }

    @Override
    public Object visit(StructureNode structureNode, Object data) {
        // TODO implement
        return null;
    }

    @Override
    public Object visit(ExtractableArrayNode extractableArrayNode, Object data) {
        // TODO implement
        return null;
    }

    private void addError(String message) {
        errors.add(message);
    }

    public List<String> getErrors() {
        return errors;
    }
}
