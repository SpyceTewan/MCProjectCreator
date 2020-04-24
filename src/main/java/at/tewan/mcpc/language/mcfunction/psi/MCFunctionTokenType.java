package at.tewan.mcpc.language.mcfunction.psi;

import at.tewan.mcpc.language.mcfunction.MCFunctionLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class MCFunctionTokenType extends IElementType {

	public MCFunctionTokenType(@NotNull String debugName) {
		super(debugName, MCFunctionLanguage.INSTANCE);
	}

	@Override
	public String toString() {
		return "MCFunctionTokenType." + super.toString();
	}
}
