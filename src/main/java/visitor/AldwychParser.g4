parser grammar AldwychParser;

options { tokenVocab = AldwychLexer; }

aldwychClass
    : (declaration)* mainprocedure (declaration)* EOF;

declaration
    : heading CURLY_OPEN body CURLY_CLOSE                                   # ProcedureNode
    | ID EQUALS expr SEMICOLON                                              # DeclarationNode
    ;

mainprocedure
    : heading CURLY_OPEN finalrule SEMICOLON CURLY_CLOSE                    # MainProcedureNode
    ;

heading
    : name formals;

name
    : HASH ID;

formals
    : readers ARROW writers;

readers
    : ID
    | PARENT_OPEN PARENT_CLOSE
    | PARENT_OPEN (ID COMMA)* ID PARENT_CLOSE;

writers
    : ID
    | PARENT_OPEN PARENT_CLOSE
    | PARENT_OPEN (ID COMMA)* ID PARENT_CLOSE;

body
    : ruleset+ finalrule
    ;

ruleset
    : (regularrule SEMICOLON)+ COLON
    ;

regularrule
    : ask (COMMA ask)* PRED_SEPARATOR tell (COMMA tell)*;

ask
    : expr                                                                  # AskNode
    ;

tell
    : expr                                                                  # TellNode
    ;

finalrule
    : PRED_SEPARATOR tell (COMMA tell)*
    ;

expr
    : ID EQUALS ID PARENT_OPEN (expr (COMMA expr)*) PARENT_CLOSE            # StructureEqNode
    | ID PARENT_OPEN ( expr (COMMA expr)*)? PARENT_CLOSE (ARROW ID)?        # DispatchNode
    | <assoc=right> expr (MULT_OPERATOR | DIV_OPERATOR) expr                # DivMultNode
    | <assoc=right> expr (MINUS_OPERATOR | PLUS_OPERATOR) expr              # MinusPlusNode
    | expr LESS_EQ expr                                                     # LEqNode
    | expr LESS expr                                                        # LtNode
    | expr EQUALS expr                                                      # EqNode
    | expr GREATER_EQ expr                                                  # GEqNode
    | expr GREATER_THAN expr                                                # GTNode
    | expr NOT_EQUAL expr                                                   # NEqNode
    | ID                                                                    # IdentifierNode
    | INTEGER                                                               # IntegerNode
    | STRING_CONST                                                          # StringConstNode
    | TRUE                                                                  # True
    | FALSE                                                                 # False
    ;