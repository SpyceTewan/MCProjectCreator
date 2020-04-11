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
import com.intellij.openapi.roots.impl.ModuleRootManagerImpl;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.io.FileUtil;
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
	public void setupRootModel(@NotNull ModifiableRootModel rootModel) throws ConfigurationException {

		final ContentEntry contentEntry = doAddContentEntry(rootModel);
		if(contentEntry == null) return;

		final VirtualFile dataRoot = getSourceRoot(getContentEntryPath(), "data");
		final VirtualFile resourcesRoot = getSourceRoot(getContentEntryPath(), "resources");

		if(dataRoot == null || resourcesRoot == null) return;

		contentEntry.addSourceFolder(dataRoot, JavaSourceRootType.SOURCE);
		contentEntry.addSourceFolder(resourcesRoot, JavaResourceRootType.RESOURCE);

		setupMinecraftModule(rootModel);
	}

	private VirtualFile getSourceRoot(String contentEntryPath, String name) {
		final File file = new File(contentEntryPath, name);
		file.mkdirs();
		return LocalFileSystem.getInstance().refreshAndFindFileByIoFile(file);
	}

	private void setupMinecraftModule(ModifiableRootModel rootModel) {
		final String parentContentEntry = new File(getContentEntryPath()).getParent();
		final File minecraftModulePath = new File(parentContentEntry, MINECRAFT_NAMESPACE + File.separator + MINECRAFT_NAMESPACE + ".iml");
		FileUtil.createIfDoesntExist(minecraftModulePath);
		Module minecraftModule = ModuleManager.getInstance(rootModel.getProject()).newModule(minecraftModulePath.toString(), MCProjectModuleType.getInstance().getId());

		ModifiableRootModel minecraftRootModel = ModuleRootManagerImpl.getInstance(minecraftModule).getModifiableModel();
		ContentEntry minecraftContentEntry = doAddContentEntry(minecraftRootModel);
		minecraftContentEntry.addSourceFolder(getSourceRoot(parentContentEntry, "data"), JavaSourceRootType.SOURCE);

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
