grammar Expr;


// parser rules
prog: (expr ';' NEWLINE?)*;

expr: expr op=('*'|'/') expr  # infixExpr
     | expr op=('+'|'-') expr  # infixExpr 
     | ID op='=' expr         # assignExpr
     | num                  # numberExpr
     | '(' expr ')'         # parensExpr
     | ID                   # idExpr 
     ;

num  : '-'? INT
     | '-'? REAL
     ;

// lexer rules
ID: [a-zA-Z]+ ;             // variable name
NEWLINE: [\r\n]+ ;
INT: [0-9]+ ;
REAL: [0-9]+'.'[0-9]* ;
WS: [ \t\r\n]+ -> skip ;
