# Aldwych Interpreter

Please view these instructions in a markdown reader that supports GitHub markdown.

## Folder descriptions

* `bin` Contains JAR files required to run Aldwych code
* `lib` Contains dependencies to be used and marked as a library root in an IDE
* `src` Contains all source code for this project. The lexer and parser can be found under the `\src\main\java\visitor\generated` directory. Test cases can be found under `\src\test\java\tests`.
* `testsuite` Contains all the test cases used for reference during the development of the interpreter.

## Running Aldwych code
The `bin` folder has all the files required in order to run the build created at the time of submission. Java 8 JRE is required to do this. The necessary ANTLR JAR dependencies are included within the `bin` directory. These are required in order for the `AldwychConcurrency.jar` file to run properly.

The general format to run Aldwych code is:

`java -jar AldwychConcurrency.jar <Aldwych_File_Path>`

The bin folder also contains all test cases from the test suite, just in case. For example, in order to run the `ArrayCount.ald` in the test suite, we enter:

`java -jar AldwychConcurrency.jar testsuite/ArrayCount.ald`

This should print `3`. Note that the absolute file path can also be provided here.

## Development setup

The following instructions are for use if work is to be continued on this project, or if the test suite is to be used.

### Setting up with an IDE

This step may vary greatly depending on which IDE is used. Quite simply, the `lib` folder needs to be added as a library root and the `src/main/java` folder needs to be marked as a sources root. If test cases are required to be run, the `src/test/java` folder needs to be marked as a test sources root. It will certainly be useful to find relevant ANTLR plugins for your IDE. The project was developed using [Jetbrains IntelliJ IDEA](https://www.jetbrains.com/idea/), which has a popular ANTLR plugin to view parse trees from within the IDE for any given input.

**IMPORTANT**: Ensure your IDE ignores the `bin` folder.

### Updating the lexer and parser

Updating the lexer and parser for this project is something that has been quite cumbersome due to the package declaration in the generated Java files. I found it particularly useful to drag the `.g4` files out of the folder through the IDE, then run the commands to compile them into the necessary `.java` files and then drag all the files included the newly generated ones back in to the `generated` folder via the IDE. The IDE itself manages the package declarations, removing compiler errors. If there is an easier way to do this, do tell.

It would be good to look at how to setup ANTLR and add it to a class path. A tutorial to setup the environment variables for Windows can be found [here](https://levlaz.org/setting-up-antlr4-on-windows/). This essentially aims to reduce the amount of writing needed to be done to generate the files from the lexer and parser. The `.bat` files I have used and added to my classpath on my Windows machine are included in the `bin` directory if needed.

Setting up ANTLR class paths, however, is not necessary and will not be required for the rest of the instructions. The JAR files in the `bin` folder can be used directly if required.

Given that the `AldwychLexer.g4` and `AldwychParser.g4` files are in the same folder as the ANTLR jar files, the following command compiles both the lexer and parser:

`java org.antlr.v4.Tool Ald*.g4 -visitor`

This generates the visitors and all necessary classes from the `.g4` files. **The generated Java files will not have any package declarations by default, so use the drag method above, or otherwise to make that correct**.

### Generating the parse tree diagrams

If you wish to generate a graphical view of how the lexer and parser handle some input, this can be done easily, after running the command above to generate the visitors and listeners from ANTLR.

* `javac *.java` (This can lead to the directory becoming quite messy so use `rm *.class` to clean up as required)
* `java org.antlr.v4.gui.TestRig Aldwych aldwychClass -gui`

The command line should then pause and allow you to write or paste in any Aldwych code. Press `Ctrl+Z` and `Enter` once the input has been passed. After this, a generated parse tree should show up, unless there were errors while parsing.
