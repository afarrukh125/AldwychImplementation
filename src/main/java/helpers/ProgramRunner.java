package helpers;

import nodes.TreeNode;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitor.ExecutionVisitor;
import visitor.SemanticVisitor;
import visitor.TreeBuilder;
import visitor.generated.AldwychLexer;
import visitor.generated.AldwychParser;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ProgramRunner {

    private static final int SEMANTIC_ERROR_CODE = -1;

    public static Object runAndReturnProgram(String programFileName) throws IOException {
        ParseTree tree = obtainParseTree(programFileName);
        TreeNode programRootNode = obtainCustomisedTreeFromParseTree(tree);
        performSemanticAnalysis(programRootNode);
        return obtainProgramOutput(programRootNode);
    }

    private static ParseTree obtainParseTree(String programName) throws IOException {
        AldwychLexer lexer = new AldwychLexer(new ANTLRFileStream(programName));
        AldwychParser parser = new AldwychParser(new CommonTokenStream(lexer));
        return parser.aldwychClass();
    }

    private static TreeNode obtainCustomisedTreeFromParseTree(ParseTree parseTree) {
        TreeBuilder treeBuilder = new TreeBuilder();
        TreeNode resultingTree = treeBuilder.visit(parseTree);
        return resultingTree;
    }

    private static void performSemanticAnalysis(TreeNode programRootNode) {
        List<String> semanticErrors = obtainSemanticErrors(programRootNode);

        boolean semanticallyCorrect = checkForSemanticCorrectness(semanticErrors);
        if (!semanticallyCorrect)
            printErrorsAndExit(semanticErrors);
    }

    private static List<String> obtainSemanticErrors(TreeNode programRootNode) {
        SemanticVisitor visitor = new SemanticVisitor();
        programRootNode.accept(visitor, null);
        List<String> semanticErrors = visitor.getErrors();
        return Collections.unmodifiableList(semanticErrors);
    }

    private static boolean checkForSemanticCorrectness(List<String> semanticErrors) {
        return semanticErrors.isEmpty();
    }

    private static void printErrorsAndExit(List<String> semanticErrors) {
        System.err.println("Failed to run program: ");
        for (String error : semanticErrors)
            System.err.println("    " + error);
        System.err.println("\nExecution failed with " + semanticErrors.size() + " errors.");
        System.exit(SEMANTIC_ERROR_CODE);
    }

    private static Object obtainProgramOutput(TreeNode programRootNode) {
        ExecutionVisitor executionVisitor = new ExecutionVisitor();
        Object output = programRootNode.accept(executionVisitor, null);
        return output;
    }
}
