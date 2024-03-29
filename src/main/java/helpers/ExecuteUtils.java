package helpers;

import nodes.TreeNode;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitor.TreeBuilder;
import visitor.ExecutionVisitor;
import visitor.SemanticVisitor;
import visitor.generated.AldwychLexer;
import visitor.generated.AldwychParser;

import java.io.IOException;
import java.util.List;

public class ExecuteUtils {

    /**
     * Runs a program with given file name and returns the output of the last expression in the sequential method of that program
     *
     * @param fileName The file name
     * @return A string representing the output of that program
     * @throws IOException File related issues, e.g. file not found
     */
    public static Object runAndReturn(String fileName) throws IOException {
        AldwychLexer lexer = new AldwychLexer(new ANTLRFileStream(fileName));
        AldwychParser parser = new AldwychParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.aldwychClass();

        // Frontend layer
        TreeNode result = new TreeBuilder().visit(tree);

        // Semantic layer
        SemanticVisitor visitor = new SemanticVisitor();
        result.accept(visitor, null);

        List<String> semanticErrors = visitor.getErrors();
        if (!semanticErrors.isEmpty()) {
            System.err.println("Failed to run program: ");
            for (String s : semanticErrors)
                System.err.println("    " + s);
            System.err.println("\nExecution failed with " + semanticErrors.size() + " errors.");
            System.exit(-1);
        }

        ExecutionVisitor executionVisitor = new ExecutionVisitor();
        Object output = result.accept(executionVisitor, null);

        return output;
    }
}
