lexer grammar AldwychLexer;

// StringBuilder in case we need to do some post-processing
@lexer::members {
    StringBuilder buffer;
}

fragment DIGIT: '0'..'9';
fragment LOWERCASE: 'a'..'z';
fragment UPPERCASE: 'A'..'Z';
fragment LETTER: (LOWERCASE|UPPERCASE);
fragment WORD: (LETTER)+;

// Symbols

SEMICOLON                   : ';';
COLON                       : ':';

CURLY_OPEN                  : '{' ;
CURLY_CLOSE                 : '}' ;
PARENT_OPEN                 : '(' ;
PARENT_CLOSE                : ')' ;
SQ_OPEN                     : '[' ;
SQ_CLOSE                    : ']' ;

RIGHT_ARROW                 : '->';
LEFT_ARROW                  : '<-';
PRED_SEPARATOR              : '||';
ARRAY_SEPARATOR             : '|';
HASH                        : '#';
EQUALS                      : '=';
GREATER_THAN                : '>';
GREATER_EQ                  : '>=';
LESS_EQ                     : '<=';
LESS_THAN                   : '<';
NOT_EQUAL                   : '!=';
COMMA                       : ',';

/* Arithmetic operations */
PLUS_OPERATOR               : '+';
MINUS_OPERATOR              : '-';
MULT_OPERATOR               : '*';
DIV_OPERATOR                : '/';

TRUE                        : 'true';
FALSE                       : 'false';

/* Integers, strings */
INTEGER                     : DIGIT+;
BOOLEAN                     : TRUE | FALSE;
STRING_CONST                : '"' { buffer = new StringBuilder(); } -> skip, pushMode(STRING_MODE);
WHITESPACE                  : [ \n\f\r\t\u000B]+ -> skip ;

/* Identifiers (variable declarations)*/
ID                          : LOWERCASE (LETTER|DIGIT|'_')*;
STRUCTURE_ID                : UPPERCASE (LETTER|DIGIT|'_')*; // Structures that have an output variable must be defined as starting with a capital letter

mode STRING_MODE;
    STRING_TEXT             : ~[\\\n\r\u0000"]+ { buffer.append(getText()); } -> more;
    STRING_END              : '"' { setText(buffer.toString()); } -> type(STRING_CONST), popMode;