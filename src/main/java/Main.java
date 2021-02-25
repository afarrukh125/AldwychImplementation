import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import visitor.RuleBuildVisitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.err.println("Please provide some file names as command line arguments, separated by space if multiple needed");
            System.exit(0);
        }
        List<String> fileNames = new ArrayList<>();

        Collections.addAll(fileNames, args);

        runAll(fileNames);
    }

    private static void runAll(List<String> fileNames) throws IOException {
        for(String fileName : fileNames) {
            System.out.println("Running " + fileName);
            AldwychLexer lexer = new AldwychLexer(new ANTLRFileStream(fileName));
            AldwychParser parser = new AldwychParser(new CommonTokenStream(lexer));
            ParseTree tree = parser.aldwychClass();
            new RuleBuildVisitor().visit(tree);
            System.out.println("Completed running " + fileName + "\n");
        }
    }
}
