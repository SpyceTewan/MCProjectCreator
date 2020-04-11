package at.tewan.mcpc.language.mcfunction;

import at.tewan.mcpc.language.mcfunction.psi.MCFunctionTypes;
import com.intellij.psi.tree.IElementType;
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

ANYTHING = [\w\t]*

EOL = \R
WHITE_SPACE = [\ \t\f]
SPACE = [ ]+
LINE_COMMENT = #[^\r\n]*
COMMAND_LITERAL = [a-z]+
TARGET_SELECTOR = @.
TARGET_BODY_START = \[
TARGET_BODY_END = \]
TARGET_ATTR_KEY = [a-z_]+
TARGET_ATTR_EQU = =
TARGET_ATTR_SEPARATOR = ,

%state WAIT_COMMAND_ARG
%state WAIT_COMMAND_ARG_SEPARATOR
%state WAIT_TARGET_BODY
%state WAIT_TARGET_KEY
%state WAIT_TARGET_EQU
%state WAIT_TARGET_END

%%
<YYINITIAL> {
	{COMMAND_LITERAL}                                       { yybegin(WAIT_COMMAND_ARG_SEPARATOR); return MCFunctionTypes.COMMAND_NAME; }
	({EOL} | {WHITE_SPACE})+                                { return MCFunctionTypes.WHITE_SPACE; }
	^{LINE_COMMENT}                                         { return MCFunctionTypes.COMMENT; }
}
<WAIT_COMMAND_ARG_SEPARATOR> {
    {SPACE}+                                                { yybegin(WAIT_COMMAND_ARG); return MCFunctionTypes.SPACE; }
    {SPACE}*{EOL}                                           { yybegin(YYINITIAL); return MCFunctionTypes.COMMAND_END; }
}
<WAIT_COMMAND_ARG> {
    {EOL}           									    { yybegin(YYINITIAL); return MCFunctionTypes.COMMAND_END; }
    {COMMAND_LITERAL}										{ yybegin(WAIT_COMMAND_ARG_SEPARATOR); return MCFunctionTypes.COMMAND_LITERAL; }
    {TARGET_SELECTOR}                                       { yybegin(WAIT_TARGET_BODY); return MCFunctionTypes.TARGET_SELECTOR; }
}
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
[^]                                                         { return TokenType.BAD_CHARACTER; }