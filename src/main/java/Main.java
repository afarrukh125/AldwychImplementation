import nodes.TreeNode;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitor.AldLexer;
import visitor.AldParser;
import visitor.AldTreeBuilder;
import visitor.customised.ExecutionVisitor;
import visitor.customised.SemanticVisitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Please provide some file names as command line arguments, separated by space if multiple needed");
            System.exit(0);
        }
        List<String> fileNames = new ArrayList<>();

        Collections.addAll(fileNames, args);

        runAll(fileNames);
    }

    private static void runAll(List<String> fileNames) throws IOException {
        for (String fileName : fileNames) {
            AldLexer lexer = new AldLexer(new ANTLRFileStream(fileName));
            AldParser parser = new AldParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.aldwychClass();

            // Frontend layer
            TreeNode result = new AldTreeBuilder().visit(tree);

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

            // Executing the code
            ExecutionVisitor executionVisitor = new ExecutionVisitor();
            result.accept(executionVisitor, null);

        }
    }
}
