parser grammar AldParser;

options { tokenVocab = AldLexer; }

aldwychClass
    : (declaration)+ EOF;

declaration
    : heading CURLY_OPEN body CURLY_CLOSE                                   # ProcedureNode
    | heading CURLY_OPEN seqbody CURLY_CLOSE                                # SequentialProcedureNode
    | ID EQUALS expr SEMICOLON                                              # DeclarationNode
    ;

seqbody
    : (expr SEMICOLON)+
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
    : (regularrule SEMICOLON COLON?)*  COLON finalrule
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
    : ID PARENT_OPEN ( expr (COMMA expr)*)? PARENT_CLOSE (ARROW ID)?        # DispatchNode
    | <assoc=right> expr (MULT_OPERATOR | DIV_OPERATOR) expr                # DivMultNode
    | <assoc=right> expr (MINUS_OPERATOR | PLUS_OPERATOR) expr              # MinusPlusNode
    | expr LESS_EQ expr                                                     # LEqNode
    | expr LESS expr                                                        # LtNode
    | expr EQUALS expr                                                      # EqNode
    | expr GREATER_EQ expr                                                  # GEqNode
    | expr GREATER_THAN expr                                                # GTNode
    | ID                                                                    # IdentifierNode
    | INTEGER                                                               # IntegerNode
    | STRING_CONST                                                          # StringConstNode
    | TRUE                                                                  # True
    | FALSE                                                                 # False
    ;