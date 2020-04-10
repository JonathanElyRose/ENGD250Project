/*
 * @author Jonathan Ely.
 */

import javax.swing.*;

public class NewProjectPanel extends ParentPanel {

	public NewProjectPanel(JFrame frame) {
		super(frame);
	}

	@Override
	public void setupComponents() {
		JLabel nameFieldLabel = new JLabel("New Project Name: ");
		JTextField nameField = new JTextField();
		JButton selectImages = new JButton("Select Images...");
		JButton importImages = new JButton("Import Images...");
		JButton cancel = new JButton("Cancel");
		JButton createProject = new JButton("Finish!");
		
		addComponent("nameFieldLabel", nameFieldLabel);
		addComponent("nameField", nameField);
		addComponent("selectImages", selectImages);
		addComponent("importImages", importImages);
		addComponent("cancel", cancel);
		addComponent("createProject", createProject);
	}

	@Override
	public void setupLayout() {
		getLayout().setAutoCreateGaps(true);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
			getLayout().createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(getLayout().createSequentialGroup()
						.addComponent(returnComponent("nameFieldLabel"))
						.addComponent(returnComponent("nameField")))
				.addComponent(returnComponent("importImages"))
				.addComponent(returnComponent("selectImages"))
				.addGroup(getLayout().createSequentialGroup()
						.addComponent(returnComponent("cancel"))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 300, 300)
						.addComponent(returnComponent("createProject")))		
		);
		
		getLayout().setVerticalGroup(
			getLayout().createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(getLayout().createSequentialGroup()
					.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
							.addComponent(returnComponent("nameFieldLabel"))
							.addComponent(returnComponent("nameField")))
					.addComponent(returnComponent("importImages"))
					.addComponent(returnComponent("selectImages"))
					.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(returnComponent("cancel"))
						.addComponent(returnComponent("createProject"))))	
		);
	}

}
