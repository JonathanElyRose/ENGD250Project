import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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
				+ "If you go to the menu bar at the top of the application, you will find a page labeled “Projects”.  Click on this and you will be taken to a page that lists all of your projects.  If you want to find a \nproject you have been working on recently, they can be found at the top of the Home page.\n\n"
				+ "How do I import photos?\n\n"
				+ "There are a few different ways to upload images.  One way is to go to the Home page and click on the button on the bottom right labeled “Import Photos”.  This will take you to your computer’s\n files and allow you to select which photos you want to upload.  "
				+ "Another way to import photos is when you first create a new project.  After asking you to name the project, there is a button that \nis labeled “Import Images”, which will also take you to your computer’s files and allow you to select the images you want to use.  "
				+ "A third and final way is to select the “Import Images” button \nin the project editor.\n\n"
				+ "How do I save my projects?\n\n"
				+ "To save a project, go to the projects tab, select the project you want to save, and click the 'Export Animation.'\n\n"
				+ "");

		ImageIcon icon1 = new ImageIcon("Help part 1.png");
		ImageIcon icon2 = new ImageIcon("Help part 2.png");
		ImageIcon icon3 = new ImageIcon("Help part 3.png");
		
		java.awt.Image img1 = icon1.getImage();
		java.awt.Image img2 = icon2.getImage();
		java.awt.Image img3 = icon3.getImage();
		
		int iconSize1 = 1000;
		int iconSize2 =440;
		Image newimg1 = img1.getScaledInstance(iconSize1, iconSize2, java.awt.Image.SCALE_SMOOTH ) ;
		Image newimg2 = img2.getScaledInstance(iconSize1, iconSize2, java.awt.Image.SCALE_SMOOTH ) ;
		Image newimg3 = img3.getScaledInstance(iconSize1, iconSize2, java.awt.Image.SCALE_SMOOTH ) ;
		
		icon1 = new ImageIcon( newimg1 );
		icon2 = new ImageIcon( newimg2 );
		icon3 = new ImageIcon( newimg3 );
		JLabel label1 = new JLabel(icon1);
		JLabel label2 = new JLabel(icon2);
		JLabel label3 = new JLabel(icon3);
		
		addComponent("label1", label1);
		addComponent("label2", label2);
		addComponent("label3", label3);
	
	
		
	
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
							.addComponent(returnComponent("area"))
							
					.addGroup(getLayout().createSequentialGroup()
							.addComponent(returnComponent("label1"))
							.addComponent(returnComponent("label2"))
							.addComponent(returnComponent("label3")))		)
				);
		
		getLayout().setVerticalGroup(
				getLayout().createSequentialGroup()
								.addComponent(returnComponent("helpTitle"))		
								.addComponent(returnComponent("area"))
								.addComponent(returnComponent("label1"))
								.addComponent(returnComponent("label2"))
								.addComponent(returnComponent("label3"))
				.addGroup(getLayout().createParallelGroup()	
						)
		);

	}
	
	

	@Override
	public void setupListeners() {
	}

}
