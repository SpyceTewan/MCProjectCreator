package at.tewan.mcpc.language.mcfunction;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MCFunctionFileType extends LanguageFileType {

	public static final MCFunctionFileType INSTANCE = new MCFunctionFileType();

	private MCFunctionFileType() {
		super(MCFunctionLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public String getName() {
		return "MC Function";
	}

	@NotNull
	@Override
	public String getDescription() {
		return "Minecraft command file for datapacks";
	}

	@NotNull
	@Override
	public String getDefaultExtension() {
		return "mcfunction";
	}

	@Nullable
	@Override
	public Icon getIcon() {
		return MCFunctionIcons.FILE;
	}
}
