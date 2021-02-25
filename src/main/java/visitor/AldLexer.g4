lexer grammar AldLexer;

// StringBuilder in case we need to do some post-processing
@lexer::members {
    StringBuilder buffer;
}

fragment DIGIT: '0'..'9';
fragment LOWERCASE: 'a'..'z';
fragment UPPERCASE: 'A'..'Z';
fragment LETTER: (LOWERCASE|UPPERCASE);
fragment WORD: (LETTER)+;

/* Fragments */
fragment A :('a'|'A');
fragment B :('b'|'B');
fragment C :('c'|'C');
fragment D :('d'|'D');
fragment E :('e'|'E');
fragment F :('f'|'F');
fragment G :('g'|'G');
fragment H :('h'|'H');
fragment I :('i'|'I');
fragment J :('j'|'J');
fragment K :('k'|'K');
fragment L :('l'|'L');
fragment M :('m'|'M');
fragment N :('n'|'N');
fragment O :('o'|'O');
fragment P :('p'|'P');
fragment Q :('q'|'Q');
fragment R :('r'|'R');
fragment S :('s'|'S');
fragment T :('t'|'T');
fragment U :('u'|'U');
fragment V :('v'|'V');
fragment W :('w'|'W');
fragment X :('x'|'X');
fragment Y :('y'|'Y');
fragment Z :('z'|'Z');

// Symbols

SEMICOLON                   : ';';
COLON                       : ':';

CURLY_OPEN                  : '{' ;
CURLY_CLOSE                 : '}' ;
PARENT_OPEN                 : '(' ;
PARENT_CLOSE                : ')' ;

ARROW                       : '->';
PRED_SEPARATOR              : '||';
HASH                        : '#';
EQUALS                      : '=';
GREATER_THAN                : '>';
GREATER_EQ                  : '>=';
LESS_EQ                     : '<=';
LESS                        : '<';
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

mode STRING_MODE;
    STRING_TEXT             : ~[\\\n\r\u0000"]+ { buffer.append(getText()); } -> more; // Not any escape chars, or double comma, then just append
    STRING_END              : '"' { setText(buffer.toString()); } -> type(STRING_CONST), popMode; // Get out of string mode if double quote encountered