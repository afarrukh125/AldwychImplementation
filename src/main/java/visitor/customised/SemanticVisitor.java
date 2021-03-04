package visitor.customised;

import helpers.HeadingStringData;
import helpers.Mode;
import nodes.*;
import nodes.data.*;

import java.util.*;
import java.util.stream.Collectors;

public class SemanticVisitor implements CustomVisitor<Void, Object> {

    private List<String> errors;

    public SemanticVisitor() {
        super();
        errors = new ArrayList<>();
    }

    @Override
    public Void visit(ClassNode classNode, Object data) {

        for(ProcedureNode procedureNode : classNode.getProcedures())
            visit(procedureNode, data);

        return null;
    }

    /**
     *
     * @param ruleNode The rule node
     * @param data The data for this particular instance will be data about the {@link helpers.HeadingStringData} so we can
     *             verify the readers and writers are being used properly within the rule if they are identifiers
     * @return {@link Void void}
     */
    @Override
    public Void visit(RegularRuleNode ruleNode, Object data) {
        HeadingStringData headingStringData = (HeadingStringData) data;
        Set<String> readers = headingStringData.getReaders();
        Set<String> writers = headingStringData.getWriters();
        String procedureName = headingStringData.getProcedureName();

        for(AskNode askNode : ruleNode.getAsks()) {
            if(askNode.getExpressionNode() instanceof BinOpNode) {
                BinOpNode binOpNode = (BinOpNode) askNode.getExpressionNode();
                checkAndReportBinOpNode(procedureName, binOpNode, readers, Mode.READ);
            }
        }

        for(TellNode tellNode : ruleNode.getTells()) {
            if(tellNode.getExpressionNode() instanceof BinOpNode) {
                BinOpNode binOpNode = (BinOpNode) tellNode.getExpressionNode();
                checkAndReportBinOpNode(procedureName, binOpNode, writers, Mode.WRITE);
            }
        }

        return null;
    }

    /**
     * Checks all the {@link IdentifierNode}s for validity in their usage
     * @param procedureName The name of the procedure
     * @param binOpNode The {@link BinOpNode} to check
     * @param variables The possible {@link IdentifierNode}s we are looking for to compare to from the procedure heading
     * @param mode The {@link helpers.Mode} to check for
     */
    private void checkAndReportBinOpNode(String procedureName, BinOpNode binOpNode, Collection<String> variables, Mode mode) {
        if(binOpNode.getLeft() instanceof IdentifierNode) {
            IdentifierNode leftNode = ((IdentifierNode) binOpNode.getLeft());
            if(!variables.contains(leftNode.getNodeValue()))
                this.addError(leftNode.getNodeValue() + " does not have " + mode.getMode() + " access in procedure " + procedureName);
        }

        if(binOpNode.getRight() instanceof IdentifierNode) {
            IdentifierNode rightNode = ((IdentifierNode) binOpNode.getRight());
            if(!variables.contains(rightNode.getNodeValue()))
                this.addError(rightNode.getNodeValue() + " does not have " + mode.getMode() + " access in procedure " + procedureName);
        }
    }

    @Override
    public Void visit(FinalRuleNode finalRuleNode, Object data) {
        return null;
    }

    @Override
    public Void visit(AskNode askNode, Object data) {
        return null;
    }

    @Override
    public Void visit(BodyNode bodyNode, Object data) {
        return null;
    }

    @Override
    public Void visit(DispatchNode dispatchNode, Object data) {
        return null;
    }

    @Override
    public Void visit(DivNode divNode, Object data) {
        return null;
    }

    @Override
    public Void visit(EqNode eqNode, Object data) {
        return null;
    }

    @Override
    public Void visit(GEqNode gEqNode, Object data) {
        return null;
    }

    @Override
    public Void visit(GTNode gtNode, Object data) {
        return null;
    }

    @Override
    public Void visit(HeadingNode headingNode, Object data) {
        return null;
    }

    @Override
    public Void visit(LEqNode lEqNode, Object data) {
        return null;
    }

    @Override
    public Void visit(LTNode ltNode, Object data) {
        return null;
    }

    @Override
    public Void visit(MulNode mulNode, Object data) {
        return null;
    }

    @Override
    public Void visit(PlusNode plusNode, Object data) {
        return null;
    }

    @Override
    public Void visit(ProcedureNode procedureNode, Object data) {

        // Index the readers and writers into sets so we can look up easier when validating readers and writers
        Set<String> readersAsStrings =  procedureNode.getHeadingNode().getReaders().getReaderNodes()
                .stream()
                .map(ReaderNode::getName)
                .collect(Collectors.toSet());

        Set<String> writersAsStrings = procedureNode.getHeadingNode().getWriters().getWriterNodes()
                .stream()
                .map(WriterNode::getName)
                .collect(Collectors.toSet());

        HeadingStringData headingStringData =
                new HeadingStringData(procedureNode.getHeadingNode().getName(), readersAsStrings, writersAsStrings);

        for(RegularRuleNode regularRuleNode : procedureNode.getBody().getRegularRules())
            visit(regularRuleNode, headingStringData);

        visit(procedureNode.getBody().getFinalRule(), headingStringData);
        return null;
    }

    @Override
    public Void visit(ReaderContainerNode readerContainerNode, Object data) {
        return null;
    }

    @Override
    public Void visit(WriterContainerNode writerContainerNode, Object data) {
        return null;
    }

    @Override
    public Void visit(ReaderNode readerNode, Object data) {
        return null;
    }

    @Override
    public Void visit(ExpressionNode expressionNode, Object data) {
        return null;
    }

    @Override
    public Void visit(SubNode subNode, Object data) {
        return null;
    }

    @Override
    public Void visit(TellNode tellNode, Object data) {
        return null;
    }

    @Override
    public Void visit(WriterNode writerNode, Object data) {
        return null;
    }

    @Override
    public Void visit(BooleanNode booleanNode, Object data) {
        return null;
    }

    @Override
    public Void visit(IdentifierNode identifierNode, Object data) {
        return null;
    }

    @Override
    public Void visit(IntegerNode integerNode, Object data) {
        return null;
    }

    @Override
    public Void visit(StringConstNode stringConstNode, Object data) {
        return null;
    }

    private void addError(String message) {
        errors.add(message);
    }

    public List<String> getErrors() {
        return errors;
    }
}
