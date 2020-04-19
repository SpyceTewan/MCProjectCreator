package at.tewan.mcpc.language.mcfunction.highlighter;

import at.tewan.mcpc.language.mcfunction.MCFunctionLexerAdapter;
import at.tewan.mcpc.language.mcfunction.psi.MCFunctionTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class MCFunctionSyntaxHighlighter extends SyntaxHighlighterBase {

	public static final TextAttributesKey COMMAND_NAME = TextAttributesKey.createTextAttributesKey("MCFUNCTION_COMMAND_NAME", DefaultLanguageHighlighterColors.KEYWORD);
	public static final TextAttributesKey LITERAL = TextAttributesKey.createTextAttributesKey("MCFUNCTION_LITERAL", DefaultLanguageHighlighterColors.PARAMETER);
	public static final TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey("MCFUNCTION_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
	public static final TextAttributesKey BAD_CHAR = TextAttributesKey.createTextAttributesKey("MCFUNCTION_BAD_CHAR", HighlighterColors.BAD_CHARACTER);
	public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey("MCFUNCTION_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
	public static final TextAttributesKey TARGET_SELECTOR = TextAttributesKey.createTextAttributesKey("MCFUNCTION_TARGET_SELECTOR", DefaultLanguageHighlighterColors.IDENTIFIER);
	public static final TextAttributesKey RESOURCE_SEPARATOR = TextAttributesKey.createTextAttributesKey("MCFUNCTION_RESOURCE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);

	public static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHAR};
	public static final TextAttributesKey[] COMMAND_NAME_KEYS = new TextAttributesKey[]{COMMAND_NAME};
	public static final TextAttributesKey[] LITERAL_KEYS = new TextAttributesKey[]{LITERAL};
	public static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
	public static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
	public static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
	public static final TextAttributesKey[] TARGET_SELECTOR_KEYS = new TextAttributesKey[]{TARGET_SELECTOR};
	public static final TextAttributesKey[] RESOURCE_SEPARATOR_KEYS = new TextAttributesKey[]{RESOURCE_SEPARATOR};

	@NotNull
	@Override
	public Lexer getHighlightingLexer() {
		return new MCFunctionLexerAdapter();
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
		if(tokenType.equals(MCFunctionTypes.COMMENT)) {
			return COMMENT_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.LITERAL)) {
			return LITERAL_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.NUMBER)) {
			return NUMBER_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.COMMAND_NAME)) {
			return COMMAND_NAME_KEYS;
		} else if(tokenType.equals(TokenType.BAD_CHARACTER)) {
			return BAD_CHAR_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.TARGET_SELECTOR)) {
			return TARGET_SELECTOR_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.RES_SEPARATOR)) {
			return RESOURCE_SEPARATOR_KEYS;
		} else {
			return EMPTY_KEYS;
		}
	}
}
