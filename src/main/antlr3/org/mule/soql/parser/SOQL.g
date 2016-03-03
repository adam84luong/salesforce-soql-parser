grammar SOQL;

options
{
  language = Java;
  output = AST;
  ASTLabelType = CommonTree;
  backtrack = true;
}

tokens {
    ALIAS;
    FIELD_SPEC;
    FUNCTION_CALL_SPEC;
    SUBQUERY;
    OBJECT_REFERENCE_PREFIX;
    TYPEOF_WHEN_THEN_CLAUSE_LIST;
    FUNCTION_PARAMETERS_LIST;
    FIELD_CONDITION;
    SET_CONDITION;
    LIKE_CONDITION;
    PARENTHESIZED_CONDITION;
    SET_VALUE_LIST;
    ORDER_BY_SPEC;
}

@lexer::header {
package org.mule.soql.parser;
}

@parser::header {
package org.mule.soql.parser;
}

@rulecatch {
    catch (RecognitionException e) {
        throw e;
    }
}

@parser::members {
	protected Object recoverFromMismatchedToken(IntStream input,int ttype, BitSet follow) throws RecognitionException {
        MismatchedTokenException ex = new MismatchedTokenException(ttype, input);
		throw new org.mule.soql.exception.SOQLParsingException("Invalid token at " + ex.line + ":" + ex.charPositionInLine);
	}
	
	protected void mismatch(IntStream input, int ttype, BitSet follow) throws RecognitionException {
        throw new MismatchedTokenException(ttype, input);
    }

    public Object recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow) throws RecognitionException {
        throw e;
    }

    public void reportError(RecognitionException e) {
        throw new org.mule.soql.exception.SOQLParsingException(e);
    }

    public void recover(RecognitionException e) {
        throw new org.mule.soql.exception.SOQLParsingException(e);
    }
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


/*------------------------------------------------------------------------------------------------------------------------*/
/*-------------------------------------------------------- LEXERS --------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------------------------*/


WHITE_SPACE	       : ( ' '|'\r'|'\t'|'\n' ) {$channel=HIDDEN;} ;

/********** STRINGS **********/

STRING_VALUE       : ( '\'' (
					    ('\\' '\\')
					  | ('\\' N_)
					  | ('\\' R_)
					  | ('\\' T_)
					  | ('\\' B_)
					  | ('\\' F_)
					  | ('\\' '"')
					  | ('\\' '\'')
					  | ~('\''|'\\')
			         )* '\'' ) ;
LIKE_STRING_VALUE  : ( '\'' (
					    ('\\' '\\')
					  | ('\\' '%')
					  | ('\\' '_')
					  | ('\\' N_)
					  | ('\\' R_)
					  | ('\\' T_)
					  | ('\\' B_)
					  | ('\\' F_)
					  | ('\\' '"')
					  | ('\\' '\'')
					  | ~('\''|'\\')
			         )* '\'' ) ;			   

/********** RESERVED KEYWORDS **********/

AND                 : A_ N_ D_ ;
AS   				: A_ S_ ;
ASC                 : A_ S_ C_ ;
BY  				: B_ Y_ ;
DESC                : D_ E_ S_ C_ ;
EXCLUDES            : E_ X_ C_ L_ U_ D_ E_ S_ ;
FALSE               : F_ A_ L_ S_ E_ ;
FIRST               : F_ I_ R_ S_ T_ ;
FROM				: F_ R_ O_ M_ ;
GROUP        		: G_ R_ O_ U_ P_ ;
HAVING              : H_ A_ V_ I_ N_ G_ ;
IN                  : I_ N_ ;
INCLUDES            : I_ N_ C_ L_ U_ D_ E_ S_ ;
LAST                : L_ A_ S_ T_ ;
LIKE                : L_ I_ K_ E_ ;
LIMIT				: L_ I_ M_ I_ T_ ;
NOT                 : N_ O_ T_ ;
NULL     			: N_ U_ L_ L_ ;
NULLS               : N_ U_ L_ L_ S_ ;
OR                  : O_ R_ ;
SELECT				: S_ E_ L_ E_ C_ T_ ;
TRUE                : T_ R_ U_ E_ ;
USING   			: U_ S_ I_ N_ G_ ;
WHERE				: W_ H_ E_ R_ E_ ;
WITH                : W_ I_ T_ H_ ;

/********** NON RESERVED KEYWORDS **********/

ABOVE               : A_ B_ O_ V_ E_ ;
ABOVE_OR_BELOW      : A_ B_ O_ V_ E_ '_' O_ R_ '_' B_ E_ L_ O_ W_ ;
AT                  : A_ T_ ;
BELOW               : B_ E_ L_ O_ W_ ;
CATEGORY            : C_ A_ T_ E_ G_ O_ R_ Y_ ;
CUBE                : C_ U_ B_ E_ ;
DATA                : D_ A_ T_ A_ ;
ELSE                : E_ L_ S_ E_ ;
END                 : E_ N_ D_ ;
OFFSET              : O_ F_ F_ S_ E_ T_ ;
ORDER   			: O_ R_ D_ E_ R_ ;
ROLLUP              : R_ O_ L_ L_ U_ P_ ;
SCOPE               : S_ C_ O_ P_ E_ ;
THEN                : T_ H_ E_ N_ ;
TYPEOF              : T_ Y_ P_ E_ O_ F_ ;
WHEN                : W_ H_ E_ N_ ;

/********** DATE FUNCTIONS **********/

CALENDAR_MONTH      : C_ A_ L_ E_ N_ D_ A_ R_ '_' M_ O_ N_ T_ H_ ;
CALENDAR_QUARTER    : C_ A_ L_ E_ N_ D_ A_ R_ '_' Q_ U_ A_ R_ T_ E_ R_ ;
CALENDAR_YEAR       : C_ A_ L_ E_ N_ D_ A_ R_ '_' Y_ E_ A_ R_ ;
DAY_IN_MONTH        : D_ A_ Y_ '_' I_ N_ '_' M_ O_ N_ T_ H_ ;
DAY_IN_WEEK         : D_ A_ Y_ '_' I_ N_ '_' W_ E_ E_ K_ ;
DAY_IN_YEAR         : D_ A_ Y_ '_' I_ N_ '_' Y_ E_ A_ R_ ;
DAY_ONLY            : D_ A_ Y_ '_' O_ N_ L_ Y_ ;
FISCAL_MONTH        : F_ I_ S_ C_ A_ L_ '_' M_ O_ N_ T_ H_ ;
FISCAL_QUARTER      : F_ I_ S_ C_ A_ L_ '_' Q_ U_ A_ R_ T_ E_ R_ ;
FISCAL_YEAR         : F_ I_ S_ C_ A_ L_ '_' Y_ E_ A_ R_ ;
HOUR_IN_DAY         : H_ O_ U_ R_ '_' I_ N_ '_' D_ A_ Y_ ;
WEEK_IN_MONTH       : W_ E_ E_ K_ '_' I_ N_ '_' M_ O_ N_ T_ H_ ;
WEEK_IN_YEAR        : W_ E_ E_ K_ '_' I_ N_ '_' Y_ E_ A_ R_ ;

/********** AGGREGATE FUNCTIONS **********/

AVG                 : A_ V_ G_ ;
COUNT               : C_ O_ U_ N_ T_ ;
COUNT_DISTINCT      : C_ O_ U_ N_ T_ '_' D_ I_ S_ T_ I_ N_ C_ T_ ;
MIN                 : M_ I_ N_ ;
MAX                 : M_ A_ X_ ;
SUM                 : S_ U_ M_ ;

/********** OTHER FUNCTIONS **********/

TO_LABEL		    : T_ O_ L_ A_ B_ E_ L_ ;
CONVERT_TIME_ZONE   : C_ O_ N_ V_ E_ R_ T_ T_ I_ M_ E_ Z_ O_ N_ E_ ;
GROUPING            : G_ R_ O_ U_ P_ I_ N_ G_ ;
CONVERT_CURRENCY    : C_ O_ N_ V_ E_ R_ T_ C_ U_ R_ R_ E_ N_ C_ Y_ ;

/********** DATE LITERALS **********/

YESTERDAY           : Y_ E_ S_ T_ E_ R_ D_ A_ Y_ ;
TODAY               : T_ O_ D_ A_ Y_ ;
TOMORROW            : T_ O_ M_ O_ R_ R_ O_ W_ ;
LAST_WEEK           : L_ A_ S_ T_ '_' W_ E_ E_ K_ ;
THIS_WEEK           : T_ H_ I_ S_ '_' W_ E_ E_ K_ ;
NEXT_WEEK           : N_ E_ X_ T_ '_' W_ E_ E_ K_ ;
LAST_MONTH          : L_ A_ S_ T_ '_' M_ O_ N_ T_ H_ ;
THIS_MONTH          : T_ H_ I_ S_ '_' M_ O_ N_ T_ H_ ;
NEXT_MONTH          : N_ E_ X_ T_ '_' M_ O_ N_ T_ H_ ;
LAST_90_DAYS        : L_ A_ S_ T_ '_' '9' '0' '_' D_ A_ Y_ S_ ;
NEXT_90_DAYS        : N_ E_ X_ T_ '_' '9' '0' '_' D_ A_ Y_ S_ ;
THIS_QUARTER        : T_ H_ I_ S_ '_' Q_ U_ A_ R_ T_ E_ R_ ;
LAST_QUARTER        : L_ A_ S_ T_ '_' Q_ U_ A_ R_ T_ E_ R_ ;
NEXT_QUARTER        : N_ E_ X_ T_ '_' Q_ U_ A_ R_ T_ E_ R_ ;
THIS_YEAR           : T_ H_ I_ S_ '_' Y_ E_ A_ R_ ;
LAST_YEAR           : L_ A_ S_ T_ '_' Y_ E_ A_ R_ ;
NEXT_YEAR           : N_ E_ X_ T_ '_' Y_ E_ A_ R_ ;
THIS_FISCAL_QUARTER : T_ H_ I_ S_ '_' F_ I_ S_ C_ A_ L_ '_' Q_ U_ A_ R_ T_ E_ R_ ;
LAST_FISCAL_QUARTER : L_ A_ S_ T_ '_' F_ I_ S_ C_ A_ L_ '_' Q_ U_ A_ R_ T_ E_ R_ ;
NEXT_FISCAL_QUARTER : N_ E_ X_ T_ '_' F_ I_ S_ C_ A_ L_ '_' Q_ U_ A_ R_ T_ E_ R_ ;
THIS_FISCAL_YEAR    : T_ H_ I_ S_ '_' F_ I_ S_ C_ A_ L_ '_' Y_ E_ A_ R_ ;
LAST_FISCAL_YEAR    : L_ A_ S_ T_ '_' F_ I_ S_ C_ A_ L_ '_' Y_ E_ A_ R_ ;
NEXT_FISCAL_YEAR    : N_ E_ X_ T_ '_' F_ I_ S_ C_ A_ L_ '_' Y_ E_ A_ R_ ;

/********** DATE N LITERALS **********/

NEXT_N_DAYS             : N_ E_ X_ T_ '_' N_ '_' D_ A_ Y_ S_ ;
LAST_N_DAYS             : L_ A_ S_ T_ '_' N_ '_' D_ A_ Y_ S_ ;
NEXT_N_WEEKS            : N_ E_ X_ T_ '_' N_ '_' W_ E_ E_ K_ S_ ;
LAST_N_WEEKS            : L_ A_ S_ T_ '_' N_ '_' W_ E_ E_ K_ S_ ;
NEXT_N_MONTHS           : N_ E_ X_ T_ '_' N_ '_' M_ O_ N_ T_ H_ S_ ;
LAST_N_MONTHS           : L_ A_ S_ T_ '_' N_ '_' M_ O_ N_ T_ H_ S_ ;
NEXT_N_QUARTERS         : N_ E_ X_ T_ '_' N_ '_' Q_ U_ A_ R_ T_ E_ R_ S_ ;
LAST_N_QUARTERS         : L_ A_ S_ T_ '_' N_ '_' Q_ U_ A_ R_ T_ E_ R_ S_ ;
NEXT_N_YEARS            : N_ E_ X_ T_ '_' N_ '_' Y_ E_ A_ R_ S_ ;
LAST_N_YEARS            : L_ A_ S_ T_ '_' N_ '_' Y_ E_ A_ R_ S_ ;
NEXT_N_FISCALQUARTERS   : N_ E_ X_ T_ '_' N_ '_' F_ I_ S_ C_ A_ L_ '_' Q_ U_ A_ R_ T_ E_ R_ S_ ;
LAST_N_FISCALQUARTERS   : L_ A_ S_ T_ '_' N_ '_' F_ I_ S_ C_ A_ L_ '_' Q_ U_ A_ R_ T_ E_ R_ S_ ;
NEXT_N_FISCALYEARS      : N_ E_ X_ T_ '_' N_ '_' F_ I_ S_ C_ A_ L_ '_' Y_ E_ A_ R_ S_ ;
LAST_N_FISCALYEARS      : L_ A_ S_ T_ '_' N_ '_' F_ I_ S_ C_ A_ L_ '_' Y_ E_ A_ R_ S_ ;
N_DAYS_AGO              : N_ '_' D_ A_ Y_ S_ '_' A_ G_ O_ ;

/********** OPERATIONS **********/

EQ_SYM	    : '=' ;
NOT_EQ	    : '<>' | '!=' ;
LET	        : '<=' ;
GET	        : '>=' ;
GTH	        : '>' ;
LTH	        : '<' ;

/********** SYMBOLS **********/

DOT	        : '.' ;
COLON	    : ':' ;
SEMICOLON	: ';' ;
COMMA	    : ',' ;
ASTERISK    : '*' ;
RPAREN	    : ')' ;
LPAREN	    : '(' ;
PLUS	    : '+' ;
MINUS	    : '-' ;

/********** IDENTIFIERS **********/

ID: ( 'A'..'Z' | 'a'..'z' | '_' | '$') ( 'A'..'Z' | 'a'..'z' | '_' | '$' | '0'..'9' )* ;

/********** NUMBERS AND DATES **********/

DATE               : ('0'..'9') ('0'..'9') ('0'..'9') ('0'..'9') MINUS ('0'..'1') ('0'..'9') MINUS ('0'..'3') ('0'..'9') ;
DATETIME           : DATE T_ ('0'..'2') ('0'..'9') COLON ('0'..'5') ('0'..'9') COLON ('0'..'5') ('0'..'9') ( DOT ('0'..'9')+ )? (Z_ | (PLUS | MINUS) ('0'..'2') ('0'..'9') COLON? ('0'..'5') ('0'..'9') );
UNSIGNED_INTEGER   : ('0'..'9')+ ;
REAL_NUMBER:
	( PLUS | MINUS )? ( UNSIGNED_INTEGER DOT UNSIGNED_INTEGER | UNSIGNED_INTEGER DOT | DOT UNSIGNED_INTEGER ) ;
SIGNED_INTEGER     : (PLUS | MINUS) UNSIGNED_INTEGER ;


/*------------------------------------------------------------------------------------------------------------------------*/
/*-------------------------------------------------------- RULES ---------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------------------------*/


/********** KEYWORDS **********/

keywords_alias_allowed :
	  ABOVE
	| ABOVE_OR_BELOW
	| AT
	| BELOW
	| CATEGORY
	| CUBE
	| DATA
	| OFFSET
	| ROLLUP
	| ORDER
	| SCOPE
;

keywords_name_allowed :
	  keywords_alias_allowed
	| GROUP
;

/********** NAMES **********/

name                      : ID | keywords_name_allowed ;
object_name	              : name ;
typeof_name               : name ;
field_name		          : name ;
filter_scope_name         : name ;
data_category_group_name  : name ;
data_category_name        : name ;

alias_name                : ID | keywords_alias_allowed ;

alias			          : alias_ -> ^(ALIAS<Alias> alias_) ;
alias_			          : ( AS )? alias_name ;

/********** LITERALS **********/

literal:
	date_formula_literal | date_formula_n_literal | datetime_literal | date_literal | integer_literal | real_literal | string_literal | boolean_literal | null_literal ;

date_formula_literal:
	  YESTERDAY
	| TODAY
	| TOMORROW
	| LAST_WEEK
	| THIS_WEEK
	| NEXT_WEEK
	| LAST_MONTH
	| THIS_MONTH
	| NEXT_MONTH
	| LAST_90_DAYS
	| NEXT_90_DAYS
	| THIS_QUARTER
	| LAST_QUARTER
	| NEXT_QUARTER
	| THIS_YEAR
	| LAST_YEAR
	| NEXT_YEAR
	| THIS_FISCAL_QUARTER
	| LAST_FISCAL_QUARTER
	| NEXT_FISCAL_QUARTER
	| THIS_FISCAL_YEAR
	| LAST_FISCAL_YEAR
	| NEXT_FISCAL_YEAR
;

date_formula_n_literal_name:
   	  NEXT_N_DAYS
   	| LAST_N_DAYS
   	| NEXT_N_WEEKS
   	| LAST_N_WEEKS
   	| NEXT_N_MONTHS
   	| LAST_N_MONTHS
   	| NEXT_N_QUARTERS
   	| LAST_N_QUARTERS
   	| NEXT_N_YEARS
   	| LAST_N_YEARS
   	| NEXT_N_FISCALQUARTERS
   	| LAST_N_FISCALQUARTERS
   	| NEXT_N_FISCALYEARS
   	| LAST_N_FISCALYEARS
	| N_DAYS_AGO
;

date_formula_n_literal: date_formula_n_literal_name COLON UNSIGNED_INTEGER ;
datetime_literal: DATETIME ;
date_literal: DATE ;
integer_literal: SIGNED_INTEGER | UNSIGNED_INTEGER ;
real_literal: REAL_NUMBER ;
string_literal: STRING_VALUE ;
boolean_literal: TRUE | FALSE ;
null_literal: NULL ;

/********** FUNCTIONS **********/

function_name:
	function_date | function_aggregate | function_other ;

function_date:
      CALENDAR_MONTH
    | CALENDAR_QUARTER
    | CALENDAR_YEAR
    | DAY_IN_MONTH
    | DAY_IN_WEEK
    | DAY_IN_YEAR
    | DAY_ONLY
    | FISCAL_MONTH
    | FISCAL_QUARTER
    | FISCAL_YEAR
    | HOUR_IN_DAY
    | WEEK_IN_MONTH
    | WEEK_IN_YEAR
;

function_aggregate:
      AVG
    | COUNT
    | COUNT_DISTINCT
    | MIN
    | MAX
    | SUM
;

function_other:
	  TO_LABEL
	| CONVERT_TIME_ZONE
	| CONVERT_CURRENCY
;

/************************************* SELECT QUERY *************************************/

select_expression:
	query EOF! ;

query:
	select_clause from_clause ( using_clause )? ( where_clause )? ( with_clause )? ( groupby_clause ( having_clause )? )? ( orderby_clause )? ( limit_clause )? ( offset_clause )? ;

select_clause:
    SELECT^ select_reference ( COMMA! select_reference )* ;

from_clause:
    FROM^ object_reference ( COMMA! object_reference )* ;

using_clause:
	USING^ SCOPE! filter_scope_name ;

where_clause:
	WHERE^ condition ;

groupby_clause:
	GROUP^ BY! ( group_by_rollup_clause | group_by_cube_clause | group_by_plain_clause ) ;

having_clause:
	HAVING^ condition ;

orderby_clause:
	ORDER^ BY! order_by_list ;

limit_clause:
	LIMIT^ UNSIGNED_INTEGER ;
	
offset_clause:
	OFFSET^ UNSIGNED_INTEGER ;

/************************************ SELECT SUBQUERY ***********************************/

subquery:
    subquery_ -> ^(SUBQUERY<SubQuery> subquery_) ;

subquery_:
    ( LPAREN! ( subquery_select_clause from_clause ( using_clause )? ( where_clause )? ( with_clause )? ( orderby_clause )? ( limit_clause )? ( offset_clause )? ) RPAREN! ) ;

subquery_select_clause:
    SELECT^ subquery_select_reference ( COMMA! subquery_select_reference )* ;

/************************************** SELECT_LIST *************************************/

select_reference:
	  field_spec
	| function_call_spec
	| subquery
	| typeof_spec ;

subquery_select_reference:
	  field_spec
	| function_call_spec ;

field_spec:
    field_spec_ -> ^(FIELD_SPEC<FieldSpec> field_spec_) ;

field_spec_:
	( object_reference_prefix )? field_name ( alias )? ;

function_call_spec:
    function_call_spec_ -> ^(FUNCTION_CALL_SPEC<FunctionCallSpec> function_call_spec_) ;

function_call_spec_:
	function_call ( alias )? ;

/********** TYPEOF **********/

typeof_spec:
	TYPEOF^ typeof_name
		typeof_when_then_clause_list
		( typeof_else_clause )?
	END! ;

typeof_when_then_clause_list:
    typeof_when_then_clause_list_ -> ^(TYPEOF_WHEN_THEN_CLAUSE_LIST<TypeofWhenThenClauseList> typeof_when_then_clause_list_) ;

typeof_when_then_clause_list_:
    ( typeof_when_then_clause )+ ;

typeof_when_then_clause:
    WHEN^ object_name typeof_then_clause ;

typeof_then_clause:
    THEN^ field_spec_list ;

typeof_else_clause:
    ELSE^ field_spec_list ;

field_spec_list:
    field_spec ( COMMA! field_spec )* ;

/************************************** FROM_CLAUSE *************************************/

object_reference:
	( object_reference_prefix )? object_name ( alias )? ;

object_reference_prefix:
    object_reference_prefix_ -> ^(OBJECT_REFERENCE_PREFIX<ObjectReferencePrefix> object_reference_prefix_) ;

object_reference_prefix_:
    ( object_name DOT! )+ ;

/*************************************** CONDITIONS *************************************/

field_operator : EQ_SYM | NOT_EQ | LET | GET | GTH | LTH ;
set_operator   : IN | NOT IN | INCLUDES | EXCLUDES;

condition:
	condition1 ( ( OR^ | AND^ ) condition1 )* ;

condition1:
	( NOT^ )? ( simple_condition | parenthesized_condition ) ;

parenthesized_condition:
    parenthesized_condition_ -> ^(PARENTHESIZED_CONDITION parenthesized_condition_) ;

parenthesized_condition_:
	LPAREN! ( condition ) RPAREN! ;

simple_condition:
	field_condition | set_condition | like_condition ;

field_condition:
    field_condition_ -> ^(FIELD_CONDITION field_condition_) ;

field_condition_:
	condition_field field_operator literal ;

set_condition:
    set_condition_ -> ^(SET_CONDITION set_condition_) ;

set_condition_:
	condition_field set_operator ( subquery | set_values ) ;

like_condition:
    like_condition_ -> ^(LIKE_CONDITION like_condition_) ;

like_condition_:
	condition_field LIKE ( STRING_VALUE | LIKE_STRING_VALUE );

condition_field:
	field_spec | function_call ;

set_values:
	( LPAREN! ( set_value_list ) RPAREN! ) ;

set_value_list:
    set_value_list_ -> ^(SET_VALUE_LIST set_value_list_) ;

set_value_list_:
	literal ( COMMA! literal )* ;

/*************************************** FUNCTIONS **************************************/

function_call:
	function_name ( LPAREN! ( function_parameters_list )? RPAREN! ) ;

function_parameters_list:
    function_parameters_list_ -> ^(FUNCTION_PARAMETERS_LIST<FunctionParametersList> function_parameters_list_) ;

function_parameters_list_:
	function_parameter ( COMMA! function_parameter )* ;

function_parameter:
	field_spec | literal | function_call ;

/************************************** WITH CLAUSE *************************************/

with_clause:
	WITH ( with_clause_plain | with_clause_data_category ) ;
	
with_clause_plain:
	condition ;
	
with_clause_data_category:
	DATA CATEGORY data_category_spec_list ;
	
data_category_filtering_selector:
	AT | ABOVE | ABOVE_OR_BELOW | BELOW ;
	
data_category_spec_list:
	data_category_spec ( AND data_category_spec )* ;

data_category_spec:
	data_category_group_name data_category_filtering_selector ( data_category_name | LPAREN data_category_name ( COMMA data_category_name )* RPAREN ) ;

/************************************ GROUP BY CLAUSE ***********************************/

group_by_plain_clause:
	group_by_list ;

group_by_rollup_clause:
	ROLLUP^ ( LPAREN! ( group_by_list ) RPAREN! ) ;

group_by_cube_clause:
	CUBE^ ( LPAREN! ( group_by_list ) RPAREN! ) ;

group_by_list:
	group_by_spec ( COMMA! group_by_spec )* ;

group_by_spec:
	field_spec | function_call ;

/************************************ ORDER BY CLAUSE ***********************************/

order_by_list:
	order_by_spec ( COMMA! order_by_spec )* ;

order_by_spec:
    order_by_spec_ -> ^(ORDER_BY_SPEC order_by_spec_) ;

order_by_spec_:
	order_by_field ( order_by_direction_clause )? ( order_by_nulls_clause )? ;

order_by_direction_clause:
    ASC | DESC ;

order_by_nulls_clause:
    NULLS^ ( FIRST | LAST ) ;

order_by_field:
	field_spec | function_call ;
	