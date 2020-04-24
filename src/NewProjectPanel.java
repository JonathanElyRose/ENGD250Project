/*
 * @author Jonathan Ely.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import java.time.*;
import java.util.HashMap;

public class NewProjectPanel extends ParentPanel {
	private HashMap<String, String> importedImages = new HashMap<String, String>();
	
	public NewProjectPanel(MainFrame frame) {
		super(frame);
	}

	@Override
	public void setupComponents() {
		JLabel nameFieldLabel = new JLabel("New Project Name: ");
		JLabel nameFieldErrorMessages = new JLabel("");
		JTextField nameField = new JTextField();
		JButton selectImages = new JButton("Select Images...");
		JButton importImages = new JButton("Import Images...");
		JButton cancel = new JButton("Cancel");
		JButton createProject = new JButton("Finish!");
		
		
		addComponent("nameFieldLabel", nameFieldLabel);
		addComponent("nameFieldError", nameFieldErrorMessages);
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
						.addGroup(getLayout().createParallelGroup()
								.addComponent(returnComponent("nameField"))
								.addComponent(returnComponent("nameFieldError"))))
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
					.addComponent(returnComponent("nameFieldError"))
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

	@Override
	public void setupListeners() {
		((AbstractButton) returnComponent("createProject")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				if(checkNameValid()) {
					Project project = new Project();
					project.setName(((JTextField) returnComponent("nameField")).getText());
					LocalDate time = LocalDate.now();
					project.setDate(time.toString());
					if(importedImages.keySet().size() > 0) {
						project.setThumbnailPath(importedImages.get("1"));
						project.setImagesMap(importedImages);
					}
					
					getFrame().getProjectManager().makeProjectFile(project);
					
					getFrame().showEditorPanel();
				}
			}
		});
		((AbstractButton) returnComponent("importImages")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				ImportDialog dialog = new ImportDialog();
				File[] images = dialog.getSelectedImages();
				String[] paths = new String[images.length - 1];
				for(int i = 1; i <= images.length; i++) {
					paths[i] = images[i].getPath();
					importedImages.put(Integer.toString(i), paths[i]);
				}
			}
		});
		
	}
	
	public boolean checkNameValid() {
		((JLabel) returnComponent("nameFieldError")).setText("");
		String fieldValue = ((JTextField) returnComponent("nameField")).getText();
		String[] naughtyCharacters = {"!","#","$","%","&","'",",",",","*","+","-",".","/",":",";","<","=",">","?","@","[","]","^","`","{","|","}","~"};
		for(String naughtyBoi : naughtyCharacters) {
			if(fieldValue.contains(naughtyBoi)) {
				((JLabel) returnComponent("nameFieldError")).setText("Error: File name cannot contain special characters such as '" + naughtyBoi + "'");
				return false;
			}
		}
		return true;
	}

}
