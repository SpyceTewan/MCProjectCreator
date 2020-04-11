package at.tewan.mcpc.sdk;

import at.tewan.mcpc.sdk.model.manifest.Manifest;
import com.google.gson.Gson;
import com.intellij.openapi.projectRoots.*;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PdkType extends SdkType {

	public static final String MANIFEST_FILE_NAME = "manifest.json";
	public static final String MINECRAFT = "minecraft";
	public static final String REGISTRIES_FILE_NAME = "registries.json";
	public static final String BLOCKS_FILE_NAME = "blocks.json";
	public static final String COMMANDS_FILE_NAME = "commands.json";

	public PdkType() {
		super("MC_PDK");
	}

	@Nullable
	@Override
	public String suggestHomePath() {
		return System.getProperty("user.home" + "mc_pdk");
	}

	@Override
	public boolean isValidSdkHome(String path) {
		return getManifest(path).isFile();
	}

	@NotNull
	@Override
	public String suggestSdkName(@Nullable String currentSdkName, String sdkHome) {
		return "Minecraft";
	}

	@Nullable
	@Override
	public AdditionalDataConfigurable createAdditionalDataConfigurable(@NotNull SdkModel sdkModel, @NotNull SdkModificator sdkModificator) {
		return null;
	}

	@NotNull
	@Override
	public String getPresentableName() {
		return "Minecraft PDK";
	}

	@Override
	public void saveAdditionalData(@NotNull SdkAdditionalData additionalData, @NotNull Element additional) {

	}

	@Override
	public Icon getIcon() {
		return PdkIcons.PDK;
	}

	@NotNull
	@Override
	public Icon getIconForAddAction() {
		return PdkIcons.PDK_ADD;
	}

	@Nullable
	@Override
	public String getVersionString(String sdkHome) {

		final File manifestFile = getManifest(sdkHome);

		try (FileReader reader = new FileReader(manifestFile)) {
			Gson gson = new Gson();
			Manifest manifest = gson.fromJson(reader, Manifest.class);

			return manifest.version.label;

		} catch (IOException e) {
			return null;
		}

	}

	private File getManifest(String sdkHome) {
		return new File(sdkHome, MANIFEST_FILE_NAME);
	}

	private File getNamespaceContent(String sdkHome, String namespace) {
		return new File(sdkHome, namespace);
	}

	private File getBlocks(String sdkHome, String namespace) {
		return new File(getNamespaceContent(sdkHome, namespace), BLOCKS_FILE_NAME);
	}

	private File getRegistries(String sdkHome, String namespace) {
		return new File(getNamespaceContent(sdkHome, namespace), REGISTRIES_FILE_NAME);
	}

	private File getCommands(String sdkHome, String namespace) {
		return new File(getNamespaceContent(sdkHome, namespace), COMMANDS_FILE_NAME);
	}

	/**
	 * @param sdkHome The home of the pdk
	 * @return Returns all the namespaces in the pdk (All subdirectories)
	 */
	private File[] getNamespaces(String sdkHome) {
		return new File(sdkHome).listFiles(File::isDirectory);
	}

	private File getMinecraftContent(String sdkHome) {
		return getNamespaceContent(sdkHome, MINECRAFT);
	}

	private File getMinecraftBlocks(String sdkHome) {
		return getBlocks(sdkHome, MINECRAFT);
	}

	private File getMinecraftRegistries(String sdkHome) {
		return getRegistries(sdkHome, MINECRAFT);

	}
	private File getMinecraftCommands(String sdkHome) {
		return getCommands(sdkHome, MINECRAFT);
	}

}
