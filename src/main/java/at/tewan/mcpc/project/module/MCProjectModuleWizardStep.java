package at.tewan.mcpc.project.module;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;

import javax.swing.*;

public class MCProjectModuleWizardStep extends ModuleWizardStep {

	final JPanel rootPanel;
	final JLabel label;

	public MCProjectModuleWizardStep() {
		rootPanel = new JPanel();
		label = new JLabel();
		label.setText("MCProject using Minecraft Datapacks and Resourcepacks");
		rootPanel.add(label);
	}

	@Override
	public JComponent getComponent() {
		return rootPanel;
	}

	@Override
	public void updateDataModel() {

	}
}
