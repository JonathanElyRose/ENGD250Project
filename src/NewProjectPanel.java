import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.time.*;
import java.util.HashMap;

/**
 * A JPanel to create a new .proj file and Project instance. The GUI supports a space for a project name to be entered, with input validation to
 * avoid special characters. An error will appear on the screen if the input is invalid. It also supports the creation of ImportDialogs for the
 * purposes of importing and selecting photos.
 * 
 * @author Jonathan Ely, Emmi Schwitters.
 */
public class NewProjectPanel extends ParentPanel {
	private static final long serialVersionUID = 1L;
	private HashMap<Integer, String> importedImages = new HashMap<Integer, String>();
	
	public NewProjectPanel(MainFrame frame) {
		super(frame);
	}

	@Override
	public void setupComponents() {
		JLabel nameFieldLabel = new JLabel("New Project Name: ");
		JLabel nameFieldErrorMessages = new JLabel("");
		JTextField nameField = new JTextField();
		JButton selectImages = new JButton("Select Existing Images...");
		JButton importImages = new JButton("Import Images...");
		JButton cancel = new JButton("Cancel");
		JButton finish = new JButton("Finish!");
		
		
		addComponent("nameFieldLabel", nameFieldLabel);
		addComponent("nameFieldError", nameFieldErrorMessages);
		addComponent("nameField", nameField);
		addComponent("selectImages", selectImages);
		addComponent("importImages", importImages);
		addComponent("cancel", cancel);
		addComponent("finish", finish);
		
		selectImages.setBackground(Color.white);
		importImages.setBackground(Color.white);
		cancel.setBackground(Color.white);
		finish.setBackground(Color.white);
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
						.addComponent(returnComponent("finish")))		
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
						.addComponent(returnComponent("finish"))))	
		);
	}

	@Override
	public void setupListeners() {
		((AbstractButton) returnComponent("finish")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				if(checkNameValid()) {
					Project project = new Project();
					project.setName(((JTextField) returnComponent("nameField")).getText());
					LocalDate time = LocalDate.now();
					project.setDate(time.toString());
					if(importedImages.keySet().size() > 0) {
						project.setThumbnailPath(importedImages.get(0));
						project.setImagesMap(importedImages);
					}
					
					if(!getFrame().getProjectManager().makeProjectFile(project).equals("exists")) {
						getFrame().getProjectManager().addProject(project);
						getFrame().showEditorPanel(project);
					}
					else {
						((JLabel) returnComponent("nameFieldError")).setText("This project already exists! Choose another name.");
					}
				}
			}
		});
		((AbstractButton) returnComponent("importImages")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				ImportDialog dialog = new ImportDialog();
				String[] images = dialog.getSelectedImages();
				
				int numOfImages = 0;
				if(importedImages.size() > 0) {
					numOfImages = importedImages.size();
				}
				for(int i = 0; i < images.length; i++) {
					importedImages.put(i + numOfImages, System.getProperty("user.dir") + "/src/data/images/" + images[i]);
				}
			}
		});
		((AbstractButton) returnComponent("selectImages")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				SelectDialog dialog = new SelectDialog();
				String[] images = dialog.getSelectedImages();
				if(images != null) {
					int numOfImages = 0;
					if(importedImages.size() > 0) {
						numOfImages = importedImages.size();
					}
					for(int i = 0; i < images.length; i++) {
						importedImages.put(i + numOfImages, images[i]);
					}
				}
			}
		});
		
	}
	
	/**
	 * Checks the text written into the JTextField and validates it against conditions. If the text field is valid, the method returns true,
	 * otherwise it returns false and displays an error.
	 * 
	 * @return boolean
	 */
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
