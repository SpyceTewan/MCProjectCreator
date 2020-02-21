package at.tewan.mcpc.language;

import com.intellij.lexer.FlexAdapter;

public class MCFunctionLexerAdapter extends FlexAdapter {

	public MCFunctionLexerAdapter() {
		super(new MCFunctionLexer(null));
	}
}
