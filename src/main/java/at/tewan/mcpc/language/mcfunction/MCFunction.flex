package at.tewan.mcpc.language.mcfunction;

import at.tewan.mcpc.language.mcfunction.psi.MCFunctionTypes;
import com.intellij.json.JsonElementType;import com.intellij.json.JsonElementTypes;import com.intellij.psi.impl.source.tree.JavaElementType;import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.intellij.lexer.FlexLexer;

%%

%class MCFunctionLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

%{
	// This is the code to push and pop on the stack of the current snbt object depth.
	// If a compound ends on the top layer, the snbt block ends and the command arg is complete
	int snbtDepth = 0;

	private void pushSnbtDepth() {
		snbtDepth++;
	}

	private void popSnbtDepth() {
  	    snbtDepth--;
	}

	private boolean isSnbtTopLayer() {
		return snbtDepth <= 0;
	}
%}

ANYTHING = [\w\t]*

EOL = \R
WHITE_SPACE = [\ \t\f]
SPACE = [ ]+
LINE_COMMENT = #[^\r\n]*
LITERAL = [0-9a-z_\-]+
NUMBER = [0-9]+(.[0-9]+)?
STRING = \"(\\.|[^\"\\\R])*\"
RES_ID_NAME = [0-9a-z_\-/.]+
RES_SEPARATOR = :
TARGET_SELECTOR = @.
TARGET_BODY_START = \[
TARGET_BODY_END = \]
TARGET_ATTR_KEY = [a-z_]+
TARGET_ATTR_EQU = =
TARGET_ATTR_SEPARATOR = ,
SNBT_COMP_START = \{
SNBT_COMP_END = }
SNBT_ARR_START = \[
SNBT_ARR_END = \]
SNBT_KEY = [a-zA-Z ]+
SNBT_SEPARATOR = :
SNBT_PARM_SEPARATOR = ,
SNBT_VAL_BYTE = -?[0-9]+b
SNBT_VAL_SHORT = -?[0-9]+s
SNBT_VAL_INT = -?[0-9]+
SNBT_VAL_LONG = -?[0-9]+l
SNBT_VAL_FLOAT = -?[0-9]+\.[0-9]+f
SNBT_VAL_DOUBLE = -?[0-9]+\.[0-9]+d

%state WAIT_COMMAND_ARG
%state WAIT_COMMAND_ARG_SEPARATOR
%state WAIT_LITERAL_SEPARATOR
%state WAIT_TARGET_BODY
%state WAIT_TARGET_KEY
%state WAIT_TARGET_EQU
%state WAIT_TARGET_END
%state WAIT_RES_ID
%state WAIT_AFTER_SNBT_BLOCK
%state WAIT_SNBT_COMP
%state WAIT_SNBT_OBJ
%state WAIT_SNBT_COMP_CONTENT
%state WAIT_SNBT_COMP_KEY
%state WAIT_SNBT_COMP_VAL
%state WAIT_SNBT_COMP_SEP
%state WAIT_SNBT_COMP_AFTERVAL
%state WAIT_SNBT_ARR_VAL
%state WAIT_SNBT_ARR_SEP

%%
<YYINITIAL> {
	{LITERAL}                                               { yybegin(WAIT_COMMAND_ARG_SEPARATOR); return MCFunctionTypes.COMMAND_NAME; }
	({EOL} | {WHITE_SPACE})+                                { return MCFunctionTypes.WHITE_SPACE; }
	^{LINE_COMMENT}                                         { return MCFunctionTypes.COMMENT; }
}
<WAIT_LITERAL_SEPARATOR> {
	{RES_SEPARATOR}											{ yybegin(WAIT_RES_ID); return MCFunctionTypes.RES_SEPARATOR; }
}
<WAIT_LITERAL_SEPARATOR, WAIT_COMMAND_ARG_SEPARATOR, WAIT_AFTER_SNBT_BLOCK> {
    {SPACE}+                                                { yybegin(WAIT_COMMAND_ARG); return MCFunctionTypes.SPACE; }
	{SPACE}*{EOL}                                           { yybegin(YYINITIAL); return MCFunctionTypes.COMMAND_END; }
}
<WAIT_COMMAND_ARG> {
    {EOL}           									    { yybegin(YYINITIAL); return MCFunctionTypes.COMMAND_END; }
    {NUMBER}												{ yybegin(WAIT_COMMAND_ARG_SEPARATOR); return MCFunctionTypes.NUMBER; }
	{LITERAL}										        { yybegin(WAIT_LITERAL_SEPARATOR); return MCFunctionTypes.LITERAL; }
    {TARGET_SELECTOR}                                       { yybegin(WAIT_TARGET_BODY); return MCFunctionTypes.TARGET_SELECTOR; }
}

// ===============================================
// SNBT
// ===============================================

<WAIT_COMMAND_ARG, WAIT_SNBT_COMP, WAIT_SNBT_COMP_VAL> {
	{SNBT_COMP_START}										{ yybegin(WAIT_SNBT_COMP_CONTENT); pushSnbtDepth(); return MCFunctionTypes.SNBT_COMP_START; }
}

// End of composite
<WAIT_SNBT_COMP_AFTERVAL, WAIT_SNBT_COMP_CONTENT> {
{SNBT_COMP_END}	{   popSnbtDepth();
					if(isSnbtTopLayer()) {
						yybegin(WAIT_AFTER_SNBT_BLOCK);
					}
					return MCFunctionTypes.SNBT_COMP_END;
				}
{SNBT_PARM_SEPARATOR}										{ yybegin(WAIT_SNBT_COMP_KEY); return MCFunctionTypes.SNBT_PARM_SEPARATOR; }
}

// Start of compound keyvalue pair
<WAIT_SNBT_COMP_KEY, WAIT_SNBT_COMP_CONTENT> {
	{SNBT_KEY}												{ yybegin(WAIT_SNBT_COMP_SEP); return MCFunctionTypes.SNBT_KEY; }
	{STRING}												{ yybegin(WAIT_SNBT_COMP_SEP); return MCFunctionTypes.STRING; }
}

// Separator between key and value in compound keyvalue pair
<WAIT_SNBT_COMP_SEP> {
	{SNBT_SEPARATOR}										{ yybegin(WAIT_SNBT_COMP_VAL); return MCFunctionTypes.SNBT_SEPARATOR; }
}

// compound keyvalue value
<WAIT_SNBT_COMP_VAL> {
	{SNBT_VAL_BYTE}											{ yybegin(WAIT_SNBT_COMP_AFTERVAL); return MCFunctionTypes.SNBT_VAL_BYTE; }
	{SNBT_VAL_SHORT}										{ yybegin(WAIT_SNBT_COMP_AFTERVAL); return MCFunctionTypes.SNBT_VAL_SHORT; }
	{SNBT_VAL_INT}											{ yybegin(WAIT_SNBT_COMP_AFTERVAL); return MCFunctionTypes.SNBT_VAL_INT; }
	{SNBT_VAL_LONG}											{ yybegin(WAIT_SNBT_COMP_AFTERVAL); return MCFunctionTypes.SNBT_VAL_LONG; }
	{SNBT_VAL_FLOAT}										{ yybegin(WAIT_SNBT_COMP_AFTERVAL); return MCFunctionTypes.SNBT_VAL_FLOAT; }
	{SNBT_VAL_DOUBLE}										{ yybegin(WAIT_SNBT_COMP_AFTERVAL); return MCFunctionTypes.SNBT_VAL_DOUBLE; }
	{STRING}												{ yybegin(WAIT_SNBT_COMP_AFTERVAL); return MCFunctionTypes.STRING; }
//	{SNBT_ARR_START}										{ yybegin(WAIT_SNBT_VALUE); return MCFunctionTypes.SNBT_ARR_START; }
}
/*
<WAIT_SNBT_ARR_VAL> {
	{SNBT_VAL_BYTE}											{ yybegin(WAIT_SNBT_AFTER_VAL); return MCFunctionTypes.SNBT_VAL_BYTE; }
	{SNBT_VAL_SHORT}										{ yybegin(WAIT_SNBT_AFTER_VAL); return MCFunctionTypes.SNBT_VAL_SHORT; }
	{SNBT_VAL_INT}											{ yybegin(WAIT_SNBT_AFTER_VAL); return MCFunctionTypes.SNBT_VAL_INT; }
	{SNBT_VAL_LONG}											{ yybegin(WAIT_SNBT_AFTER_VAL); return MCFunctionTypes.SNBT_VAL_LONG; }
	{SNBT_VAL_FLOAT}										{ yybegin(WAIT_SNBT_AFTER_VAL); return MCFunctionTypes.SNBT_VAL_FLOAT; }
	{SNBT_VAL_DOUBLE}										{ yybegin(WAIT_SNBT_AFTER_VAL); return MCFunctionTypes.SNBT_VAL_DOUBLE; }
	{SNBT_ARR_START}										{ yybegin(WAIT_SNBT_VALUE); return MCFunctionTypes.SNBT_ARR_START; }
	{SNBT_ARR_END}											{ yybegin(WAIT_SNBT_AFTER_VAL); return MCFunctionTypes.SNBT_ARR_END; }
}

<WAIT_SNBT_ARR_VAL> {
	{SNBT_PARM_SEPARATOR}{SPACE}*							{ yybegin(WAIT_SNBT_KEY); return MCFunctionTypes.SNBT_PARM_SEPARATOR; }

	{SNBT_ARR_END}											{ return MCFunctionTypes.SNBT_ARR_END; }
}
*/
// ===============================================
// TARGET SELECTORS
// ===============================================

<WAIT_TARGET_BODY> {
    {SPACE}+                                                { yybegin(WAIT_COMMAND_ARG); return MCFunctionTypes.SPACE; }
    {SPACE}*{EOL}                                           { yybegin(YYINITIAL); return MCFunctionTypes.COMMAND_END; }
    {TARGET_BODY_START}                                     { yybegin(WAIT_TARGET_KEY); return MCFunctionTypes.TARGET_BODY_START; }
}
<WAIT_TARGET_KEY> {
    {SPACE}+                                                { return MCFunctionTypes.SPACE; }
    {TARGET_ATTR_KEY}                                       { yybegin(WAIT_TARGET_EQU); return MCFunctionTypes.TARGET_ATTR_KEY; }
}
<WAIT_TARGET_EQU> {
	{SPACE}+                                                { return MCFunctionTypes.SPACE; }
	{TARGET_ATTR_EQU}										{ yybegin(WAIT_TARGET_END); return MCFunctionTypes.TARGET_ATTR_EQU; }
}
<WAIT_TARGET_END> {
	{TARGET_BODY_END}										{ yybegin(WAIT_COMMAND_ARG_SEPARATOR); return MCFunctionTypes.TARGET_BODY_END; }
	//{TARGET_ATTR_SEPARATOR}									{ yybegin(WAIT_TARGET_KEY); return MCFunctionTypes.TARGET}
}

// ===============================================
// RESOURCE IDS
// ===============================================

<WAIT_RES_ID> {
	{RES_ID_NAME}											{ yybegin(WAIT_COMMAND_ARG_SEPARATOR); return MCFunctionTypes.RES_ID_NAME; }
}

[^]                                                         { return TokenType.BAD_CHARACTER; }