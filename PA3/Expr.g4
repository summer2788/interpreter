grammar Expr;

// parser rules
prog: (decl_list expr | expr) (';' (decl_list expr | expr))* ';' NEWLINE?;

decl_list: decl+;

decl: 'def' ID var_list '=' expr 'endef' # functionDecl
    | 'def' ID '=' expr 'endef' # simpleFunctionDecl;

var_list: ID+ ;

expr: ID '()' # functionCallNoArg
    | ID '(' expr_list ')' # functionCall
    | expr op=('*'|'/') expr # infixExpr
    | expr op=('+'|'-') expr # infixExpr
    | 'let' ID '=' expr 'in' expr # letExpr
    | ID op='=' expr # assignExpr
    | num # numberExpr
    | '(' expr ')' # parensExpr
    | '~' '(' expr ')' # negationExpr
    | ID # idExpr;

expr_list: expr (',' expr)* ;

num : NUMBER ;

// lexer rules 
NUMBER : '-'? INT | '-'? REAL ;
INT: [0-9]+ ;
REAL: [0-9]+'.'[0-9]* ;
ID: [a-zA-Z0-9_\-]+; // Unifies FUNCTION_NAME, PARAMETER, and ID
NEWLINE: [\r\n]+ ;
WS: [ \t\r\n]+ -> skip ;
