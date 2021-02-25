parser grammar AldParser;

options { tokenVocab = AldLexer; }

aldwychClass
    : (declaration)+ EOF;

declaration
    : heading CURLY_OPEN body CURLY_CLOSE                               # ProcedureNode
    | ID EQUALS expr SEMICOLON                                          # DeclarationNode
    ;

heading
    : name variables;

name
    : HASH ID;

variables
    : reader ARROW writer;

reader
    : ID
    | PARENT_OPEN (ID COMMA)* ID PARENT_CLOSE;

writer
    : ID
    | PARENT_OPEN (ID COMMA)* ID PARENT_CLOSE;

body
    : (regularrule SEMICOLON COLON?)*  COLON finalrule;

regularrule
    : ask PRED_SEPARATOR tell;

ask
    : expr (COMMA expr)*                                            # AskNode
    ;

tell
    : expr (COMMA expr)*                                            # TellNode
    ;

finalrule
    : PRED_SEPARATOR tell;

expr
    : ID                                                            # IdentifierNode
    | INTEGER                                                       # IntegerNode
    | STRING_CONST                                                  # StringConstNode
    | TRUE                                                          # True
    | FALSE                                                         # False
    | <assoc=right> expr (MULT_OPERATOR | DIV_OPERATOR) expr        # DivMultNode
    | <assoc=right> expr (MINUS_OPERATOR | PLUS_OPERATOR) expr      # MinusPlusNode
    | expr LESS_EQ expr                                             # LEqNode
    | expr LESS expr                                                # LtNode
    | expr EQUALS expr                                              # EqNode
    | expr GREATER_EQ expr                                          # GEqNode
    | expr GREATER_THAN expr                                        # GTNode

    ;