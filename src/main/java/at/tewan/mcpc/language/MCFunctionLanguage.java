package at.tewan.mcpc.language;

import com.intellij.lang.Language;

public class MCFunctionLanguage extends Language {

	public static final MCFunctionLanguage INSTANCE = new MCFunctionLanguage();

	private MCFunctionLanguage() {
		super("mcfunction");
	}
}
