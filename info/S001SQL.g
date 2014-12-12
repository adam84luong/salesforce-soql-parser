grammar S001SQL;

options
{
  language = Java;
  output = AST;
  backtrack=true;
}

@lexer::header {
package test.antlr.parser;
}

@parser::header {
package test.antlr.parser;
}

fragment A_ :	'a' | 'A';
fragment B_ :	'b' | 'B';
fragment C_ :	'c' | 'C';
fragment D_ :	'd' | 'D';
fragment E_ :	'e' | 'E';
fragment F_ :	'f' | 'F';
fragment G_ :	'g' | 'G';
fragment H_ :	'h' | 'H';
fragment I_ :	'i' | 'I';
fragment J_ :	'j' | 'J';
fragment K_ :	'k' | 'K';
fragment L_ :	'l' | 'L';
fragment M_ :	'm' | 'M';
fragment N_ :	'n' | 'N';
fragment O_ :	'o' | 'O';
fragment P_ :	'p' | 'P';
fragment Q_ :	'q' | 'Q';
fragment R_ :	'r' | 'R';
fragment S_ :	's' | 'S';
fragment T_ :	't' | 'T';
fragment U_ :	'u' | 'U';
fragment V_ :	'v' | 'V';
fragment W_ :	'w' | 'W';
fragment X_ :	'x' | 'X';
fragment Y_ :	'y' | 'Y';
fragment Z_ :	'z' | 'Z';

ADDDATE				: A_ D_ D_ D_ A_ T_ E_  ;
ALL				: A_ L_ L_  ;
ANY				: A_ N_ Y_ ;
AS_SYM				: A_ S_  ;
ASC				: A_ S_ C_  ;
AVG				: A_ V_ G_;
BETWEEN				: B_ E_ T_ W_ E_ E_ N_  ;
BINARY				: B_ I_ N_ A_ R_ Y_  ;
BY_SYM				: B_ Y_ ;
CASE_SYM			: C_ A_ S_ E_  ;
CAST_SYM			: C_ A_ S_ T_  ;
CHAR				: C_ H_ A_ R_  ;
CONVERT_TZ			: C_ O_ N_ V_ E_ R_ T_ '_' T_ Z_  ;
COUNT				: C_ O_ U_ N_ T_  ;
COUNT_DISTINCT		: C_ O_ U_ N_ T_ '_' D_ I_ S_ T_ I_ N_ C_ T_ ;
CROSS				: C_ R_ O_ S_ S_  ;
DATE_SYM			: D_ A_ T_ E_  ;
DATETIME			: D_ A_ T_ E_ T_ I_ M_ E_  ;
DAY_SYM				: D_ A_ Y_  ;
DAY_HOUR			: D_ A_ Y_  '_' H_ O_ U_ R_  ;
DAY_MICROSECOND			: D_ A_ Y_  '_' M_ I_ C_ R_ O_ S_ E_ C_ O_ N_ D_  ;
DAY_MINUTE			: D_ A_ Y_  '_' M_ I_ N_ U_ T_ E_  ;
DAY_SECOND			: D_ A_ Y_  '_' S_ E_ C_ O_ N_ D_  ;
DECIMAL_SYM			: D_ E_ C_ I_ M_ A_ L_  ;
DESC				: D_ E_ S_ C_  ;
DISTINCT			: D_ I_ S_ T_ I_ N_ C_ T_ ;
DISTINCTROW			: D_ I_ S_ T_ I_ N_ C_ T_ R_ O_ W_ ;
ELSE_SYM			: E_ L_ S_ E_  ;
END_SYM				: E_ N_ D_ ;
ESCAPE_SYM			: E_ S_ C_ A_ P_ E_  ;
FALSE_SYM			: F_ A_ L_ S_ E_ ;
EXISTS				: E_ X_ I_ S_ T_ S_ ;
EXTRACT				: E_ X_ T_ R_ A_ C_ T_  ;
FOR_SYM				: F_ O_ R_  ;
FROM				: F_ R_ O_ M_  ;
FROM_DAYS			: F_ R_ O_ M_ '_' D_ A_ Y_ S_  ;
FROM_UNIXTIME			: F_ R_ O_ M_ '_' U_ N_ I_ X_ T_ I_ M_ E_  ;
GROUP_SYM			: G_ R_ O_ U_ P_  ;
GET_FORMAT			: G_ E_ T_ '_' F_ O_ R_ M_ A_ T_  ;
HAVING				: H_ A_ V_ I_ N_ G_  ;
HIGH_PRIORITY			: H_ I_ G_ H_  '_' P_ R_ I_ O_ R_ I_ T_ Y_  ;
HOUR				: H_ O_ U_ R_  ;
HOUR_MICROSECOND		: H_ O_ U_ R_  '_' M_ I_ C_ R_ O_ S_ E_ C_ O_ N_ D_  ;
HOUR_MINUTE			: H_ O_ U_ R_  '_' M_ I_ N_ U_ T_ E_  ;
HOUR_SECOND			: H_ O_ U_ R_  '_' S_ E_ C_ O_ N_ D_  ;
IN_SYM				: I_ N_  ;
INNER_SYM			: I_ N_ N_ E_ R_  ;
INTEGER_SYM			: I_ N_ T_ E_ G_ E_ R_  ;
INTERVAL_SYM			: I_ N_ T_ E_ R_ V_ A_ L_  ;
IS_SYM				: I_ S_  ;
JOIN_SYM			: J_ O_ I_ N_  ;
LAST_DAY			: L_ A_ S_ T_ '_' D_ A_ Y_  ;
LEFT				: L_ E_ F_ T_  ;
LIKE_SYM			: L_ I_ K_ E_  ;
LIMIT				: L_ I_ M_ I_ T_  ;
LOCK				: L_ O_ C_ K_ ;
MAKEDATE			: M_ A_ K_ E_ D_ A_ T_ E_  ;
MAKETIME			: M_ A_ K_ E_ T_ I_ M_ E_  ;
MAX_SYM				: M_ A_ X_  ;
MICROSECOND			: M_ I_ C_ R_ O_ S_ E_ C_ O_ N_ D_  ;
MODE_SYM			: M_ O_ D_ E_  ;
MINUTE_MICROSECOND		: M_ I_ N_ U_ T_ E_  '_' M_ I_ C_ R_ O_ S_ E_ C_ O_ N_ D_  ;
MINUTE_SECOND			: M_ I_ N_ U_ T_ E_  '_' S_ E_ C_ O_ N_ D_  ;
MONTH				: M_ O_ N_ T_ H_  ;
NATURAL				: N_ A_ T_ U_ R_ A_ L_  ;
MINUTE				: M_ I_ N_ U_ T_ E_  ;
NOT_SYM				: (N_ O_ T_) | ('!') ;
NOW				: (N_ O_ W_) | (L_ O_ C_ A_ L_ T_ I_ M_ E_) | (L_ O_ C_ A_ L_ T_ I_ M_ E_ S_ T_ A_ M_ P_) | (C_ U_ R_ R_ E_ N_ T_ '_' T_ I_ M_ E_ S_ T_ A_ M_ P_);
NULL_SYM			: N_ U_ L_ L_  ;
MIN_SYM				: M_ I_ N_  ;
MONTHNAME			: M_ O_ N_ T_ H_ N_ A_ M_ E_  ;
OUTER				: O_ U_ T_ E_ R_  ;
ON				: O_ N_  ;
ORDER_SYM			: O_ R_ D_ E_ R_  ;
OFFSET_SYM			: O_ F_ F_ S_ E_ T_  ;
OJ_SYM				: O_ J_  ;
PERIOD_ADD			: P_ E_ R_ I_ O_ D_ '_' A_ D_ D_  ;
PERIOD_DIFF			: P_ E_ R_ I_ O_ D_ '_' D_ I_ F_ F_  ;

RIGHT				: R_ I_ G_ H_ T_  ;
ROW_SYM				: R_ O_ W_  ;
TIME_SYM			: T_ I_ M_ E_  ;
STRAIGHT_JOIN			: S_ T_ R_ A_ I_ G_ H_ T_  '_' J_ O_ I_ N_  ;
SECOND				: S_ E_ C_ O_ N_ D_  ;
QUARTER				: Q_ U_ A_ R_ T_ E_ R_  ;
SHARE_SYM			: S_ H_ A_ R_ E_  ;
TRUE_SYM			: T_ R_ U_ E_ ;
SQL_NO_CACHE_SYM		: S_ Q_ L_  '_' N_ O_  '_' C_ A_ C_ H_ E_  ;
SHARED_SYM			: S_ H_ A_ R_ E_ D_  ;
SUM				: S_ U_ M_  ;
SOUNDS_SYM			: S_ O_ U_ N_ D_ S_  ;
SECOND_MICROSECOND		: S_ E_ C_ O_ N_ D_  '_' M_ I_ C_ R_ O_ S_ E_ C_ O_ N_ D_  ;
SQL_CACHE_SYM			: S_ Q_ L_  '_' C_ A_ C_ H_ E_  ;
SQL_SMALL_RESULT		: S_ Q_ L_  '_' S_ M_ A_ L_ L_  '_' R_ E_ S_ U_ L_ T_  ;
REGEXP				: (R_ E_ G_ E_ X_ P_) | (R_ L_ I_ K_ E_);
ROLLUP_SYM			: R_ O_ L_ L_ U_ P_  ;
SELECT				: S_ E_ L_ E_ C_ T_ ;
SIGNED_SYM			: S_ I_ G_ N_ E_ D_  ;
SQL_BIG_RESULT			: S_ Q_ L_  '_' B_ I_ G_  '_' R_ E_ S_ U_ L_ T_  ;
SQL_CALC_FOUND_ROWS		: S_ Q_ L_  '_' C_ A_ L_ C_  '_' F_ O_ U_ N_ D_  '_' R_ O_ W_ S_  ;
SQL_BUFFER_RESULT		: S_ Q_ L_  '_' B_ U_ F_ F_ E_ R_  '_' R_ E_ S_ U_ L_ T_  ;
THEN_SYM			: T_ H_ E_ N_  ;

UNION_SYM			: U_ N_ I_ O_ N_  ;
UNSIGNED_SYM			: U_ N_ S_ I_ G_ N_ E_ D_  ;
UPDATE				: U_ P_ D_ A_ T_ E_ ;
USING_SYM			: U_ S_ I_ N_ G_ 	;
WEEK				: W_ E_ E_ K_  ;
WHEN_SYM			: W_ H_ E_ N_ 	;
WHERE				: W_ H_ E_ R_ E_  ;
WITH				: W_ I_ T_ H_  ;
XOR				: X_ O_ R_  ;
YEAR				: Y_ E_ A_ R_  ;
YEAR_MONTH			: Y_ E_ A_ R_  '_' M_ O_ N_ T_ H_  ;

// basic token definition ------------------------------------------------------------

DIVIDE	: (  D_ I_ V_ ) | '/' ;
MOD_SYM	: (  M_ O_ D_ ) | '%' ;
OR_SYM	: (  O_ R_ ) | '||';
AND_SYM	: (  A_ N_ D_ ) | '&&';

ARROW	: '=>' ;
EQ_SYM	: '=' | '<=>' ;
NOT_EQ	: '<>' | '!=' | '~='| '^=';
LET	: '<=' ;
GET	: '>=' ;
SET_VAR	: ':=' ;
SHIFT_LEFT	: '<<' ;
SHIFT_RIGHT	: '>>' ;
ALL_FIELDS	: '.*' ;

SEMI	: ';' ; 
COLON	: ':' ;
DOT	: '.' ;
COMMA	: ',' ;
ASTERISK: '*' ;
RPAREN	: ')' ;
LPAREN	: '(' ;
RBRACK	: ']' ;
LBRACK	: '[' ;
PLUS	: '+' ;
MINUS	: '-' ;
NEGATION: '~' ;
VERTBAR	: '|' ;
BITAND	: '&' ;
POWER_OP: '^' ;
GTH	: '>' ;
LTH	: '<' ;



INTEGER_NUM		: ('0'..'9')+ ;

fragment HEX_DIGIT_FRAGMENT: ( 'a'..'f' | 'A'..'F' | '0'..'9' ) ;
HEX_DIGIT:
	(  '0x'     (HEX_DIGIT_FRAGMENT)+  )
	|
	(  'X' '\'' (HEX_DIGIT_FRAGMENT)+ '\''  ) 
;

BIT_NUM:
	(  '0b'    ('0'|'1')+  )
	|
	(  B_ '\'' ('0'|'1')+ '\''  ) 
;

REAL_NUMBER:
	(  INTEGER_NUM DOT INTEGER_NUM | INTEGER_NUM DOT | DOT INTEGER_NUM | INTEGER_NUM  )
	(  ('E'|'e') ( PLUS | MINUS )? INTEGER_NUM  )? 
;

TEXT_STRING:
	( N_ | ('_' U_ T_ F_ '8') )?
	(
		(  '\'' ( ('\\' '\\') | ('\\' '\'') | ~('\'') )* '\''  )
		|
		(  '\"' ( ('\\' '\\') | ('\\' '\"') | ~('\"') )* '\"'  ) 
	)
;

ID:	
	( 'A'..'Z' | 'a'..'z' | '_' | '$') ( 'A'..'Z' | 'a'..'z' | '_' | '$' | '0'..'9' )*
;

WHITE_SPACE	: ( ' '|'\r'|'\t'|'\n' ) {$channel=HIDDEN;} ;

// basic type definition -----------------------------------------------------------------------
relational_op: 
	EQ_SYM | LTH | GTH | NOT_EQ | LET | GET  ;

cast_data_type:	
	BINARY (INTEGER_NUM)? 
	| CHAR (INTEGER_NUM)? 
	| DATE_SYM
	| DATETIME 
	| DECIMAL_SYM ( INTEGER_NUM (COMMA INTEGER_NUM)? )?
	| SIGNED_SYM (INTEGER_SYM)?
	| TIME_SYM
	| UNSIGNED_SYM (INTEGER_SYM)?
;

interval_unit:
	  SECOND
	| MINUTE
	| HOUR
	| DAY_SYM
	| WEEK
	| MONTH
	| QUARTER
	| YEAR
	| SECOND_MICROSECOND
	| MINUTE_MICROSECOND
	| MINUTE_SECOND
	| HOUR_MICROSECOND
	| HOUR_SECOND
	| HOUR_MINUTE
	| DAY_MICROSECOND
	| DAY_SECOND
	| DAY_MINUTE
	| DAY_HOUR
	| YEAR_MONTH
;

// basic const data definition ---------------------------------------------------------------
string_literal:		TEXT_STRING ;
number_literal:		(PLUS | MINUS)? (INTEGER_NUM | REAL_NUMBER) ;
hex_literal:		HEX_DIGIT;
boolean_literal:	TRUE_SYM | FALSE_SYM ;
bit_literal:		BIT_NUM;

// http://dev.mysql.com/doc/refman/5.6/en/literals.html
literal_value:
        ( string_literal | number_literal | hex_literal | boolean_literal | bit_literal | NULL_SYM ) ;

// function defintion ------  http://dev.mysql.com/doc/refman/5.6/en/func-op-summary-ref.html  ----------
functionList:
	time_functions
;

time_functions:
	  ADDDATE
;

group_functions:
	AVG | COUNT | COUNT_DISTINCT | MAX_SYM | MIN_SYM | SUM
;

// identifiers ---  http://dev.mysql.com/doc/refman/5.6/en/identifiers.html --------------
table_name			: ID ;
column_name			: ID ;
alias				: ( AS_SYM )? ID ;

// expression statement -------  http://dev.mysql.com/doc/refman/5.6/en/expressions.html  -------------
expression:	exp_factor1 ( OR_SYM exp_factor1 )* ;
exp_factor1:	exp_factor2 ( XOR exp_factor2 )* ;
exp_factor2:	exp_factor3 ( AND_SYM exp_factor3 )* ;
exp_factor3:	(NOT_SYM)? exp_factor4 ;
exp_factor4:	bool_primary ( IS_SYM (NOT_SYM)? (boolean_literal|NULL_SYM) )? ;
bool_primary:
	  ( predicate relational_op predicate ) 
	| ( predicate relational_op ( ALL | ANY )? subquery )
	| ( NOT_SYM? EXISTS subquery )
	| predicate 
;
predicate:
	  ( bit_expr (NOT_SYM)? IN_SYM (subquery | expression_list) )
	| ( bit_expr (NOT_SYM)? BETWEEN bit_expr AND_SYM predicate ) 
	| ( bit_expr SOUNDS_SYM LIKE_SYM bit_expr ) 
	| ( bit_expr (NOT_SYM)? LIKE_SYM simple_expr (ESCAPE_SYM simple_expr)? )
	| ( bit_expr (NOT_SYM)? REGEXP bit_expr ) 
	| ( bit_expr )  
;
bit_expr:
	factor1 ( VERTBAR factor1 )? ;
factor1:
	factor2 ( BITAND factor2 )? ;
factor2:
	factor3 ( (SHIFT_LEFT|SHIFT_RIGHT) factor3 )? ;
factor3:
	factor4 ( (PLUS|MINUS) factor4 )? ;
factor4:
	factor5 ( (ASTERISK|DIVIDE|MOD_SYM|POWER_OP) factor5 )? ;
factor5:
	factor6 ( (PLUS|MINUS) interval_expr )? ;
factor6:
	(PLUS | MINUS | NEGATION | BINARY) simple_expr
	| simple_expr ;
simple_expr:
	literal_value 
	| column_spec
	| function_call
	//| param_marker
	| expression_list
	| (ROW_SYM expression_list)
	| subquery
	| EXISTS subquery
	//| {identifier expression}
	| case_when_statement
	| interval_expr
;


function_call:
	  (  functionList ( LPAREN (expression (COMMA expression)*)? RPAREN ) ?  )
	| (  CAST_SYM LPAREN expression AS_SYM cast_data_type RPAREN  )
	| (  group_functions LPAREN ( ASTERISK | ALL | DISTINCT )? bit_expr RPAREN  )
;

case_when_statement:
        case_when_statement1 | case_when_statement2
;
case_when_statement1:
        CASE_SYM
        ( WHEN_SYM expression THEN_SYM bit_expr )+
        ( ELSE_SYM bit_expr )?
        END_SYM
;
case_when_statement2:
        CASE_SYM bit_expr
        ( WHEN_SYM bit_expr THEN_SYM bit_expr )+
        ( ELSE_SYM bit_expr )?
        END_SYM
;

column_spec:
	( table_name DOT )? column_name ;

expression_list:
	LPAREN expression ( COMMA expression )* RPAREN ;

interval_expr:
	INTERVAL_SYM expression interval_unit
;

// JOIN Syntax ----------  http://dev.mysql.com/doc/refman/5.6/en/join.html  ---------------
table_references:
        table_reference ( COMMA table_reference )*
;
table_reference:
	table_factor1 | table_atom
;
table_factor1:
	table_factor2 (  (INNER_SYM | CROSS)? JOIN_SYM table_atom (join_condition)?  )?
;
table_factor2:
	table_factor3 (  STRAIGHT_JOIN table_atom (ON expression)?  )?
;
table_factor3:
	table_factor4 (  (LEFT|RIGHT) (OUTER)? JOIN_SYM table_factor4 join_condition  )?
;
table_factor4:
	table_atom (  NATURAL ( (LEFT|RIGHT) (OUTER)? )? JOIN_SYM table_atom )?
;
table_atom:
	  ( table_spec (alias)? )
	| ( subquery alias )
	| ( LPAREN table_references RPAREN )
	| ( OJ_SYM table_reference LEFT OUTER JOIN_SYM table_reference ON expression )
;
join_condition:
	  (ON expression) | (USING_SYM column_list)
;

// select ------  http://dev.mysql.com/doc/refman/5.6/en/select.html  -------------------------------
select_statement:
        select_expression ( (UNION_SYM (ALL)?) select_expression )* 
;

select_expression:
	SELECT 
	
	( ALL | DISTINCT | DISTINCTROW )? 
	(HIGH_PRIORITY)?
	(STRAIGHT_JOIN)?
	(SQL_SMALL_RESULT)? (SQL_BIG_RESULT)? (SQL_BUFFER_RESULT)?
	(SQL_CACHE_SYM | SQL_NO_CACHE_SYM)? (SQL_CALC_FOUND_ROWS)?

	select_list
	
	( 
		FROM table_references 
		( where_clause )? 
		( groupby_clause )?
		( having_clause )?
	) ?
	
	( orderby_clause )?
	( limit_clause )?
	( ( FOR_SYM UPDATE) | (LOCK IN_SYM SHARE_SYM MODE_SYM) )? 
;

where_clause:
	WHERE expression
;

groupby_clause:
	GROUP_SYM BY_SYM groupby_item (COMMA groupby_item)* (WITH ROLLUP_SYM)?
;
groupby_item:	column_spec | INTEGER_NUM | bit_expr ;

having_clause:
	HAVING expression
;

orderby_clause:
	ORDER_SYM BY_SYM orderby_item (COMMA orderby_item)*
;
orderby_item:	groupby_item (ASC | DESC)? ;

limit_clause:
	LIMIT ((offset COMMA)? row_count) | (row_count OFFSET_SYM offset)
;
offset:		INTEGER_NUM ;
row_count:	INTEGER_NUM ;

select_list:
	( ( displayed_column ( COMMA displayed_column )*)
	| ASTERISK ) 
;

column_list:
	LPAREN column_spec (COMMA column_spec)* RPAREN
;

subquery:
	LPAREN select_statement RPAREN
;

table_spec:
	table_name
;

displayed_column :
	( table_spec DOT ASTERISK )
	|
	( column_spec (alias)? )
	| 
	( bit_expr (alias)? )
;