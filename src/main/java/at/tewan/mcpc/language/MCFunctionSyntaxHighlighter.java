package at.tewan.mcpc.language;

import at.tewan.mcpc.language.psi.MCFunctionTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class MCFunctionSyntaxHighlighter extends SyntaxHighlighterBase {

	public static final TextAttributesKey SEPARATOR = TextAttributesKey.createTextAttributesKey("MCFUNCTION_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
	public static final TextAttributesKey KEY = TextAttributesKey.createTextAttributesKey("MCFUNCTION_KEY", DefaultLanguageHighlighterColors.KEYWORD);
	public static final TextAttributesKey VALUE = TextAttributesKey.createTextAttributesKey("MCFUNCTION_VALUE", DefaultLanguageHighlighterColors.STRING );
	public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey("MCFUNCTION_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
	public static final TextAttributesKey BAD_CHAR = TextAttributesKey.createTextAttributesKey("MCFUNCTION_BAD_CHAR", HighlighterColors.BAD_CHARACTER);

	public static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHAR};
	public static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
	public static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
	public static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
	public static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
	public static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

	@NotNull
	@Override
	public Lexer getHighlightingLexer() {
		return new MCFunctionLexerAdapter();
	}

	@NotNull
	@Override
	public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
		if(tokenType.equals(MCFunctionTypes.SEPARATOR)) {
			return SEPARATOR_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.COMMENT)) {
			return COMMENT_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.KEY)) {
			return KEY_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.VALUE)) {
			return VALUE_KEYS;
		} else if(tokenType.equals(TokenType.BAD_CHARACTER)) {
			return BAD_CHAR_KEYS;
		} else {
			return EMPTY_KEYS;
		}
	}
}
