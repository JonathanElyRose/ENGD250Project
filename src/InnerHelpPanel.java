import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 * This panel is located inside HelpPanel and answers basic questions about how to operate the program.
 * 
 * @author Emmi Schwitters, Liz Stutz.
 */

public class InnerHelpPanel extends ParentPanel {

	private static final long serialVersionUID = 1L;
	
	public InnerHelpPanel(MainFrame frame) {
		super(frame);
	}
	
	

	@Override
	public void setupComponents() {
		JLabel helpTitle = new JLabel("HELP");
		
		JTextArea area1 = new JTextArea();
		JTextArea area2 = new JTextArea();
		JTextArea area3 = new JTextArea();
		JTextArea area4 = new JTextArea();
		
		area1.setText("How do I create a new project?\n\n To create a new project, go to the home page and select “New Project”.  A window will then pop up asking you to name your project and \nimport images to be used in the project.");
				area2.setText("How do I find my ongoing projects?\n\n"
				+ "If you go to the menu bar at the top of the application, you will find a page labeled “Projects”.  Click on this and you will be taken to a page \nthat lists all of your projects.  If you want to find a project you have been working on recently, they can be found at the top of the Home \npage.");
				area3.setText("How do I import photos?\n\n"
				+ "There are a few different ways to upload images.  One way is to go to the Home page and click on the button on the bottom right labeled \n“Import Photos”.  This will take you to your computer’s files and allow you to select which photos you want to upload.  "
				+ "Another way to \nimport photos is when you first create a new project.  After asking you to name the project, there is a button that is labeled “Import \nImages”, which will also take you to your computer’s files and allow you to select the images you want to use.  "
				+ "A third and final way is \nto select the “Import Images” button in the project editor.");
				area4.setText("How do I save my projects?\n\n"
				+ "To save a project, go to the projects tab, select the project you want to save, and click the 'Export Animation.'");

		area1.setFont(new Font("Arial", Font.PLAIN, 20));
		area2.setFont(new Font("Arial", Font.PLAIN, 20));
		area3.setFont(new Font("Arial", Font.PLAIN, 20));
		area4.setFont(new Font("Arial", Font.PLAIN, 20));
		helpTitle.setFont(new Font("Arial", Font.PLAIN, 20));
				
		ImageIcon icon1 = new ImageIcon("Help part 1.png");
		ImageIcon icon2 = new ImageIcon("Help part 2.png");
		ImageIcon icon3 = new ImageIcon("Help part 3.png");
		ImageIcon icon4 = new ImageIcon("Help part 4.png");
		ImageIcon icon5 = new ImageIcon("Help part 5.png");
		ImageIcon icon6 = new ImageIcon("Help part 6.png");
		
		java.awt.Image img1 = icon1.getImage();
		java.awt.Image img2 = icon2.getImage();
		java.awt.Image img3 = icon3.getImage();
		java.awt.Image img4 = icon4.getImage();
		java.awt.Image img5 = icon5.getImage();
		java.awt.Image img6 = icon6.getImage();
		
		int iconSize1 = 1000;
		int iconSize2 =440;
		Image newimg1 = img1.getScaledInstance(iconSize1, iconSize2, java.awt.Image.SCALE_SMOOTH ) ;
		Image newimg2 = img2.getScaledInstance(iconSize1, iconSize2, java.awt.Image.SCALE_SMOOTH ) ;
		Image newimg3 = img3.getScaledInstance(iconSize1, iconSize2, java.awt.Image.SCALE_SMOOTH ) ;
		Image newimg4 = img4.getScaledInstance(iconSize1, iconSize2, java.awt.Image.SCALE_SMOOTH ) ;
		Image newimg5 = img5.getScaledInstance(iconSize1, iconSize2, java.awt.Image.SCALE_SMOOTH ) ;
		Image newimg6 = img6.getScaledInstance(iconSize1, iconSize2, java.awt.Image.SCALE_SMOOTH ) ;
		
		icon1 = new ImageIcon( newimg1 );
		icon2 = new ImageIcon( newimg2 );
		icon3 = new ImageIcon( newimg3 );
		icon4 = new ImageIcon( newimg4 );
		icon5 = new ImageIcon( newimg5 );
		icon6 = new ImageIcon( newimg6 );
		
		JLabel label1 = new JLabel(icon1);
		JLabel label2 = new JLabel(icon2);
		JLabel label3 = new JLabel(icon3);
		JLabel label4 = new JLabel(icon4);
		JLabel label5 = new JLabel(icon5);
		JLabel label6 = new JLabel(icon6);
		
		addComponent("label1", label1);
		addComponent("label2", label2);
		addComponent("label3", label3);
		addComponent("label4", label4);
		addComponent("label5", label5);
		addComponent("label6", label6);
	
	
		
	
		area1.setEditable(false);
		area2.setEditable(false);
		area3.setEditable(false);
		area4.setEditable(false);
		
		addComponent("helpTitle", helpTitle);
		addComponent("area1", area1);
		addComponent("area2", area2);
		addComponent("area3", area3);
		addComponent("area4", area4);
	}

	@Override
	public void setupLayout() {
		getLayout().setAutoCreateGaps(true);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
				getLayout().createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(getLayout().createParallelGroup()
							.addComponent(returnComponent("helpTitle"))
							.addComponent(returnComponent("area1"))
							.addComponent(returnComponent("label1"))
							.addComponent(returnComponent("label4"))
							.addComponent(returnComponent("area2"))
							.addComponent(returnComponent("label3"))
							.addComponent(returnComponent("area3"))
							.addComponent(returnComponent("label2"))
							.addComponent(returnComponent("label5"))
							.addComponent(returnComponent("area4"))
							.addComponent(returnComponent("label6"))));
				
		
		getLayout().setVerticalGroup(
				getLayout().createSequentialGroup()
								.addComponent(returnComponent("helpTitle"))		
								.addComponent(returnComponent("helpTitle"))
								.addComponent(returnComponent("area1"))
								.addComponent(returnComponent("label1"))
								.addComponent(returnComponent("label4"))
								.addComponent(returnComponent("area2"))
								.addComponent(returnComponent("label3"))
								.addComponent(returnComponent("area3"))
								.addComponent(returnComponent("label2"))
								.addComponent(returnComponent("label5"))
								.addComponent(returnComponent("area4"))
								.addComponent(returnComponent("label6"))
				
		);

	}
	
	

	@Override
	public void setupListeners() {
	}

}
