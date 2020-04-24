package at.tewan.mcpc.project.module;

import at.tewan.mcpc.language.mcfunction.MCFunctionIcons;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.ModuleTypeManager;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MCProjectModuleType extends ModuleType<MCProjectModuleBuilder> {

	private static final String ID = "MCPC_MODULE_TYPE";

	public MCProjectModuleType() {
		super(ID);
	}

	public static MCProjectModuleType getInstance() {
		return (MCProjectModuleType) ModuleTypeManager.getInstance().findByID(ID);
	}

	@NotNull
	@Override
	public MCProjectModuleBuilder createModuleBuilder() {
		return new MCProjectModuleBuilder();
	}

	@Nls(capitalization = Nls.Capitalization.Title)
	@NotNull
	@Override
	public String getName() {
		return "MC-Project";
	}

	@Nls(capitalization = Nls.Capitalization.Sentence)
	@NotNull
	@Override
	public String getDescription() {
		return "Minecraft datapacks and resourcepacks";
	}

	@NotNull
	@Override
	public Icon getNodeIcon(boolean isOpened) {
		return MCFunctionIcons.FILE;
	}

	@NotNull
	@Override
	public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull MCProjectModuleBuilder moduleBuilder, @NotNull ModulesProvider modulesProvider) {
		return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider);
	}
}
