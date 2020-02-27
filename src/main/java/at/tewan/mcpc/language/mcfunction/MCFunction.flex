package at.tewan.mcpc.language.mcfunction;

import at.tewan.mcpc.language.mcfunction.psi.MCFunctionTypes;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

%%

%class MCFunctionLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF = \R
WHITE_SPACE = [\ \n\t\f]
SPACE = [ ]+
LINE_COMMENT = #[^\r\n]*
COMMAND_ARGUMENT = [a-z]+
TARGET_SELECTOR = @.([[a-z= \.:,_0-9{}\"#!]*])?


%state WAITING_ARG
%state WAITING_ARG_SEPARATOR

%%

<YYINITIAL> ^{LINE_COMMENT}                                  { yybegin(YYINITIAL); return MCFunctionTypes.COMMENT; }

<YYINITIAL> ^[a-z]+                                         { yybegin(WAITING_ARG_SEPARATOR); return MCFunctionTypes.COMMAND_NAME; }

<WAITING_ARG> {COMMAND_ARGUMENT}                            { yybegin(WAITING_ARG_SEPARATOR); return MCFunctionTypes.COMMAND_ARGUMENT; }
<WAITING_ARG> {TARGET_SELECTOR}                             { yybegin(WAITING_ARG); return MCFunctionTypes.TARGET_SELECTOR; }
<WAITING_ARG_SEPARATOR> {SPACE}                             { yybegin(WAITING_ARG); return TokenType.WHITE_SPACE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }