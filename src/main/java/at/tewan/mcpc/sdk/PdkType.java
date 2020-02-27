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
		return new File(sdkHome, "manifest.json");
	}
}
