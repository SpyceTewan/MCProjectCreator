package at.tewan.mcpc.language.mcfunction;

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

	public static final TextAttributesKey COMMAND_NAME = TextAttributesKey.createTextAttributesKey("MCFUNCTION_NAME", DefaultLanguageHighlighterColors.CONSTANT);
	public static final TextAttributesKey COMMAND_ARG = TextAttributesKey.createTextAttributesKey("MCFUNCTION_COMMAND_ARG", DefaultLanguageHighlighterColors.KEYWORD);
	public static final TextAttributesKey BAD_CHAR = TextAttributesKey.createTextAttributesKey("MCFUNCTION_BAD_CHAR", HighlighterColors.BAD_CHARACTER);
	public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey("MCFUNCTION_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);

	public static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHAR};
	public static final TextAttributesKey[] COMMAND_NAME_KEYS = new TextAttributesKey[]{COMMAND_NAME};
	public static final TextAttributesKey[] COMMAND_ARG_KEYS = new TextAttributesKey[]{COMMAND_ARG};
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
		if(tokenType.equals(MCFunctionTypes.COMMENT)) {
			return COMMENT_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.COMMAND_ARGUMENT)) {
			return COMMAND_ARG_KEYS;
		} else if(tokenType.equals(MCFunctionTypes.COMMAND_NAME)) {
			return COMMAND_NAME_KEYS;
		} else if(tokenType.equals(TokenType.BAD_CHARACTER)) {
			return BAD_CHAR_KEYS;
		} else {
			return EMPTY_KEYS;
		}
	}
}
