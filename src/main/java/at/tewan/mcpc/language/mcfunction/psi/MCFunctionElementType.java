package at.tewan.mcpc.language.mcfunction.psi;

import at.tewan.mcpc.language.mcfunction.MCFunctionLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public class MCFunctionElementType extends IElementType {

	public MCFunctionElementType(@NotNull String debugName) {
		super(debugName, MCFunctionLanguage.INSTANCE);
	}

}
