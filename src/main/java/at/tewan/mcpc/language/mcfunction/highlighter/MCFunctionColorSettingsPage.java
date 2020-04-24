package at.tewan.mcpc.language.mcfunction.highlighter;

import at.tewan.mcpc.language.mcfunction.MCFunctionFileType;
import at.tewan.mcpc.language.mcfunction.MCFunctionIcons;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class MCFunctionColorSettingsPage implements ColorSettingsPage {

	private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
		new AttributesDescriptor("Target Selector", MCFunctionSyntaxHighlighter.TARGET_SELECTOR),
		new AttributesDescriptor("Number", MCFunctionSyntaxHighlighter.NUMBER)
	};

	@Nullable
	@Override
	public Icon getIcon() {
		return MCFunctionIcons.FILE;
	}

	@NotNull
	@Override
	public SyntaxHighlighter getHighlighter() {
		return new MCFunctionSyntaxHighlighter();
	}

	@NotNull
	@Override
	public String getDemoText() {
		return  "# This is an example mcfunction file\n"+
				"list\n"+
				"gamemode creative @a\n"+
				"execute as @e[type=pig,sort=nearest,limit=1] at @s if block ~ ~-1 ~ minecraft:grass run setblock ~ ~-1 ~ minecraft:course_dirt\n";
	}

	@Nullable
	@Override
	public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
		return null;
	}

	@NotNull
	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		return DESCRIPTORS;
	}

	@NotNull
	@Override
	public ColorDescriptor[] getColorDescriptors() {
		return ColorDescriptor.EMPTY_ARRAY;
	}

	@Nls(capitalization = Nls.Capitalization.Title)
	@NotNull
	@Override
	public String getDisplayName() {
		return MCFunctionFileType.INSTANCE.getDisplayName();
	}
}
