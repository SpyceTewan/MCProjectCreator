package at.tewan.mcpc.project.module;

import at.tewan.mcpc.language.mcfunction.MCFunctionIcons;
import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.SourcePathsBuilder;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.*;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.ModifiableModelsProvider;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import org.jdom.JDOMException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.jps.model.java.JavaResourceRootType;
import org.jetbrains.jps.model.java.JavaSourceRootType;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MCProjectModuleBuilder extends ModuleBuilder implements SourcePathsBuilder {

	private static final String MINECRAFT_NAMESPACE = "minecraft";

	private List<Pair<String, String>> sourcePaths;

	@Override
	public void setupRootModel(@NotNull ModifiableRootModel modifiableRootModel) throws ConfigurationException {

		final ContentEntry contentEntry = doAddContentEntry(modifiableRootModel);
		if(contentEntry == null) return;

		final File dataFile = new File(getContentEntryPath(), "data");
		final File resourcesFile = new File(getContentEntryPath(), "resources");
		dataFile.mkdirs();
		resourcesFile.mkdirs();

		final VirtualFile dataRoot = LocalFileSystem.getInstance().refreshAndFindFileByIoFile(dataFile);
		final VirtualFile resourcesRoot = LocalFileSystem.getInstance().refreshAndFindFileByIoFile(resourcesFile);

		if(dataRoot == null || resourcesRoot == null) return;

		contentEntry.addSourceFolder(dataRoot, JavaSourceRootType.SOURCE);
		contentEntry.addSourceFolder(resourcesRoot, JavaResourceRootType.RESOURCE);
	}

	@Override
	public ModuleType<?> getModuleType() {
		return MCProjectModuleType.getInstance();
	}

	@Nullable
	@Override
	public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
		return new MCProjectModuleWizardStep();
	}

	@Override
	public String getGroupName() {
		return MCProjectModuleType.getInstance().getName();
	}

	@Override
	public Icon getNodeIcon() {
		return MCFunctionIcons.FILE;
	}

	@Nls(capitalization = Nls.Capitalization.Sentence)
	@Override
	public String getDescription() {
		return MCProjectModuleType.getInstance().getDescription();
	}

	@Nls(capitalization = Nls.Capitalization.Title)
	@Override
	public String getPresentableName() {
		return getGroupName();
	}

	@Override
	public int getWeight() {
		return 100;
	}

	@Override
	public boolean isTemplateBased() {
		return true;
	}

	@Override
	public List<Pair<String, String>> getSourcePaths() {
		if(sourcePaths == null)
			sourcePaths = new ArrayList<>();

		return sourcePaths;
	}

	@Override
	public void setSourcePaths(List<Pair<String, String>> newSourcePaths) {
		sourcePaths = newSourcePaths;
	}

	@Override
	public void addSourcePath(Pair<String, String> sourcePathInfo) {
		if(sourcePaths == null) {
			sourcePaths = new ArrayList<>();
		}

		sourcePaths.add(sourcePathInfo);
	}
}
