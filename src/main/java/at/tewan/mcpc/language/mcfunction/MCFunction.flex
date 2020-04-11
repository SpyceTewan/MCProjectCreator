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
TARGET_ATTR_KEY = [a-z_]
TARGET_ATTR_EQU = =
TARGET_ATTR_SEPARATOR = ,

%state WAIT_COMMAND_ARG
%state WAIT_COMMAND_ARG_SEPARATOR
%state WAIT_TARGET_BODY

%%
<YYINITIAL> {
	{COMMAND_LITERAL}                                       { yybegin(WAIT_COMMAND_ARG_SEPARATOR); return MCFunctionTypes.COMMAND_NAME; }
	({EOL} | {WHITE_SPACE})+							    { return MCFunctionTypes.WHITE_SPACE; }
    ^{LINE_COMMENT}											{ return MCFunctionTypes.COMMENT; }
}
<WAIT_COMMAND_ARG_SEPARATOR> {
    {SPACE}+                                                { yybegin(WAIT_COMMAND_ARG); return MCFunctionTypes.SPACE; }
    {SPACE}*{EOL}                                           { yybegin(YYINITIAL); return MCFunctionTypes.COMMAND_END; }
}
<WAIT_COMMAND_ARG> {
    {EOL}           									    { yybegin(YYINITIAL); return MCFunctionTypes.COMMAND_END; }
    {COMMAND_LITERAL}										{ yybegin(WAIT_COMMAND_ARG_SEPARATOR); return MCFunctionTypes.COMMAND_ARGUMENT; }
    {TARGET_SELECTOR}                                       { yybegin(WAIT_TARGET_BODY); return MCFunctionTypes.TARGET_SELECTOR; }
}

//<WAITING_LINE> {LINE_COMMENT}                               { return MCFunctionTypes.COMMENT; }

//<WAITING_LINE> {COMMAND_ARGUMENT}                           { yybegin(WAITING_ARG_SEPARATOR); return MCFunctionTypes.COMMAND_NAME; }
//
//<WAITING_ARG> {COMMAND_ARGUMENT}                            { yybegin(WAITING_ARG_SEPARATOR); return MCFunctionTypes.COMMAND_ARGUMENT; }
//<WAITING_ARG> {TARGET_SELECTOR}                             { yybegin(WAITING_TARGET_START); return MCFunctionTypes.TARGET_SELECTOR; }
//<WAITING_ARG_SEPARATOR> {SPACE}                             { yybegin(WAITING_ARG); return TokenType.WHITE_SPACE; }
//<WAITING_TARGET_START> {TARGET_BODY_START}                  { yybegin(WAITING_TARGET_ATT); return MCFunctionTypes.TARGET_BODY_START; }
//<WAITING_TARGET_START> {SPACE}                              { yybegin(WAITING_ARG); return MCFunctionTypes.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }