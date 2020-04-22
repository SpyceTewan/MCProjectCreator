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
	public static final TextAttributesKey TARGET_SELECTOR = TextAttributesKey.createTextAttributesKey("MCFUNCTION_TARGET_SELECTOR", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
	public static final TextAttributesKey TARGET_BRACKETS = TextAttributesKey.createTextAttributesKey("MCFUNCTION_TARGET_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
	public static final TextAttributesKey RESOURCE_NAMESPACE = TextAttributesKey.createTextAttributesKey("MCFUNCTION_RESOURCE_NAMESPACE", DefaultLanguageHighlighterColors.INSTANCE_METHOD);
	public static final TextAttributesKey RESOURCE_SEPARATOR = TextAttributesKey.createTextAttributesKey("MCFUNCTION_RESOURCE_SEPARATOR", DefaultLanguageHighlighterColors.COMMA);
	public static final TextAttributesKey SNBT_PRIMITIVE = TextAttributesKey.createTextAttributesKey("MCFUNCTION_SNBT_PRIMITIVE", DefaultLanguageHighlighterColors.NUMBER);
	public static final TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey("MCFUNCTION_STRING", DefaultLanguageHighlighterColors.STRING);


	public static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHAR};
	public static final TextAttributesKey[] COMMAND_NAME_KEYS = new TextAttributesKey[]{COMMAND_NAME};
	public static final TextAttributesKey[] LITERAL_KEYS = new TextAttributesKey[]{LITERAL};
	public static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
	public static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
	public static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
	public static final TextAttributesKey[] TARGET_SELECTOR_KEYS = new TextAttributesKey[]{TARGET_SELECTOR};
	public static final TextAttributesKey[] TARGET_BRACKETS_KEYS = new TextAttributesKey[]{TARGET_BRACKETS};
	public static final TextAttributesKey[] RESOURCE_SEPARATOR_KEYS = new TextAttributesKey[]{RESOURCE_SEPARATOR};
	public static final TextAttributesKey[] SNBT_PRIMITIVE_KEYS = new TextAttributesKey[]{SNBT_PRIMITIVE};
	public static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};

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
		} else if(tokenType.equals(MCFunctionTypes.TARGET_BODY_START) || tokenType.equals(MCFunctionTypes.TARGET_BODY_END)) {
			return TARGET_BRACKETS_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.RES_SEPARATOR)) {
			return RESOURCE_SEPARATOR_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.STRING)) {
			return STRING_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.SNBT_VAL_BYTE) |
				tokenType.equals(MCFunctionTypes.SNBT_VAL_SHORT) |
				tokenType.equals(MCFunctionTypes.SNBT_VAL_INT) |
				tokenType.equals(MCFunctionTypes.SNBT_VAL_LONG) |
				tokenType.equals(MCFunctionTypes.SNBT_VAL_FLOAT) |
				tokenType.equals(MCFunctionTypes.SNBT_VAL_DOUBLE) ) {
			return SNBT_PRIMITIVE_KEYS;
		} else {
			return EMPTY_KEYS;
		}
	}
}
