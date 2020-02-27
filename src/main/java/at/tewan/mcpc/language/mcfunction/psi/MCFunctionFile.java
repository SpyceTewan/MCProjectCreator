package at.tewan.mcpc.language.mcfunction.psi;

import at.tewan.mcpc.language.mcfunction.MCFunctionFileType;
import at.tewan.mcpc.language.mcfunction.MCFunctionLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class MCFunctionFile extends PsiFileBase {

	public MCFunctionFile(@NotNull FileViewProvider viewProvider) {
		super(viewProvider, MCFunctionLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public FileType getFileType() {
		return MCFunctionFileType.INSTANCE;
	}

	@Override
	public String toString() {
		return "MCFunction File";
	}
}
