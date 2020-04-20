import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JFrame;
/*
 * @author Emmi Schwitters, Liz Stutz.
 */

public class HelpPanel extends ParentPanel {

	private static final long serialVersionUID = 1L;
	
	public HelpPanel(MainFrame frame) {
		super(frame);
		
		
		
		
		// TODO Auto-generated constructor stub
		
	}
	
	

	@Override
	public void setupComponents() {
		// TODO Auto-generated method stub
		JLabel helpTitle = new JLabel("HELP");
		JTextField field = new JTextField();
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		JTextField field3 = new JTextField();
		JTextField field4 = new JTextField();
		JTextField field5 = new JTextField();
		JTextField field6 = new JTextField();
		JTextField field7 = new JTextField();
		JTextField field8 = new JTextField();
	
		
		field.setText("How do I create a new project?");
		field1.setText("To create a new project, go to the home page and select “New Project”.  A window will then pop up asking you"
				+ " to name your project and import images to be used in the project.");
		field2.setText("How do I find my ongoing projects?");
		field3.setText("If you go to the menu bar at the top of the application, you will find a page labeled “Projects”.  Click on"
				+ " this and you will be taken to a page that lists all of your projects.  If you want to find a project you have "
				+ "been working on recently, they can be found at the top of the Home page.");
		field4.setText("How do I import photos?");
		field5.setText("There are a few different ways to upload images.  One way is to go to the Home page and click on the button "
				+ "on the bottom right labeled “Import Photos”.  This will take you to your computer’s files and allow you to "
				+ "select which photos you want to upload.  ");
		field6.setText("Another way to import photos is when you first create a new project.  After asking you to name the project,"
				+ " there is a button that is labeled “Import Images”, which will also take you to your computer’s files and allow"
				+ " you to select the images you want to use.");
		field7.setText("A third and final way is to select the “Import Images” button in the project editor.");
		field8.setText("How do I save my projects?");
		
		
		field.setEditable(false);
		field1.setEditable(false);
		field2.setEditable(false);
		field3.setEditable(false);
		field4.setEditable(false);
		field5.setEditable(false);
		field6.setEditable(false);
		field7.setEditable(false);
		field8.setEditable(false);
	
		
		addComponent("helpTitle", helpTitle);
		addComponent("field", field);
		addComponent("field1", field1);
		addComponent("field2", field2);
		addComponent("field3", field3);
		addComponent("field4", field4);
		addComponent("field5", field5);
		addComponent("field6", field6);
		addComponent("field7", field7);
		addComponent("field8", field8);
	}

	@Override
	public void setupLayout() {
		// TODO Auto-generated method stub
		getLayout().setAutoCreateGaps(true);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
				getLayout().createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(getLayout().createParallelGroup()
							.addComponent(returnComponent("helpTitle"))
							.addComponent(returnComponent("field"))
							.addComponent(returnComponent("field1"))
							.addComponent(returnComponent("field2"))
							.addComponent(returnComponent("field3"))
							.addComponent(returnComponent("field4"))
							.addComponent(returnComponent("field5"))
							.addComponent(returnComponent("field6"))
							.addComponent(returnComponent("field7"))
							.addComponent(returnComponent("field8")))
		);
		
		getLayout().setVerticalGroup(
				getLayout().createSequentialGroup()
								.addComponent(returnComponent("helpTitle"))
								.addComponent(returnComponent("field"))
								.addComponent(returnComponent("field1"))
								.addComponent(returnComponent("field2"))
								.addComponent(returnComponent("field3"))
								.addComponent(returnComponent("field4"))
								.addComponent(returnComponent("field5"))
								.addComponent(returnComponent("field6"))
								.addComponent(returnComponent("field7"))
								.addComponent(returnComponent("field8"))
		);

	}
	
	

	@Override
	public void setupListeners() {
		// TODO Auto-generated method stub

	}

}
