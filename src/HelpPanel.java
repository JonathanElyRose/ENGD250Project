import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * This panel answers basic questions about how to operate the program.
 * 
 * @author Emmi Schwitters, Liz Stutz.
 */

public class HelpPanel extends ParentPanel {

	private static final long serialVersionUID = 1L;
	
	public HelpPanel(MainFrame frame) {
		super(frame);
	}
	
	

	@Override
	public void setupComponents() {
		JLabel helpTitle = new JLabel("HELP");
		
		JTextArea area = new JTextArea();
		
		
		area.setText("How do I create a new project?\n\n To create a new project, go to the home page and select “New Project”.  A window will then pop up asking you to name your project and import images to be used in the project.\n\n"
				+ "How do I find my ongoing projects?\n\n"
				+ "If you go to the menu bar at the top of the application, you will find a page labeled “Projects”.  Click on this and you will be taken to a page that lists all of your projects.  If you want to find a\n project you have been working on recently,\n they can be found at the top of the Home page.\n\n"
				+ "How do I import photos?\n\n"
				+ "There are a few different ways to upload images.  One way is to go to the Home page and click on the button on the bottom right labeled “Import Photos”.  This will take you to your computer’s\n files and allow you to select which\n photos you want to upload."
				+ "Another way to import photos is when you first create a new project.  After asking you to name the project, there is a button that is labeled “Import Images”, which\n will also take you to your computer’s files and allow you to select the images you want to use.\n"
				+ "A third and final way is to select the “Import Images” button in the project editor.\n\n"
				+ "How do I save my projects?\n");
		
		
		
	
		
	
		area.setEditable(false);
		
		addComponent("helpTitle", helpTitle);
		addComponent("area", area);
	}

	@Override
	public void setupLayout() {
		getLayout().setAutoCreateGaps(true);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
				getLayout().createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(getLayout().createParallelGroup()
							.addComponent(returnComponent("helpTitle"))
							.addComponent(returnComponent("area")))
		);
		
		getLayout().setVerticalGroup(
				getLayout().createSequentialGroup()
								.addComponent(returnComponent("helpTitle"))		
								.addComponent(returnComponent("area"))
		);

	}
	
	

	@Override
	public void setupListeners() {
	}

}
