import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;



/**
 * A panel for displaying buttons to switch between frequently used and important pages of the program. Always displayed at the top
 * of the MainFrame
 * 
 * @author Jonathan Ely, Emmi Schwitters, and Liz Stutz.
 */

public class NavigationPanel extends ParentPanel {
	private static final long serialVersionUID = 1L;

	public NavigationPanel(MainFrame frame) {
		super(frame);
	}

	@Override
	public void setupComponents() {
				
		ImageIcon icon1 = new ImageIcon("home logo.png");
		ImageIcon icon2 = new ImageIcon("projects logo.png");
		ImageIcon icon3 = new ImageIcon("Question.png");
		ImageIcon icon4 = new ImageIcon("about  logo.png");
	
		java.awt.Image img1 = icon1.getImage();
		java.awt.Image img2 = icon2.getImage();
		java.awt.Image img3 = icon3.getImage();
		java.awt.Image img4 = icon4.getImage();

		int iconSize = 20;
		Image newimg1 = img1.getScaledInstance(iconSize, iconSize, java.awt.Image.SCALE_SMOOTH ) ;
		Image newimg2 = img2.getScaledInstance( iconSize, iconSize, java.awt.Image.SCALE_SMOOTH ) ; 
		Image newimg3 = img3.getScaledInstance( iconSize, iconSize, java.awt.Image.SCALE_SMOOTH ) ; 
		Image newimg4 = img4.getScaledInstance(iconSize, iconSize, java.awt.Image.SCALE_SMOOTH ) ; 
		
		icon1 = new ImageIcon( newimg1 );
		icon2 = new ImageIcon( newimg2 );
		icon3 = new ImageIcon( newimg3 );
		icon4 = new ImageIcon( newimg4 );
		
		JButton menu1 = new JButton(icon1);
		JButton menu2 = new JButton(icon2);
		JButton menu3 = new JButton(icon3);
		JButton menu4 = new JButton(icon4);
		
	
		
		menu1.setText("Home");
		menu2.setText("Projects");
		menu3.setText("Help");
		menu4.setText("About");
		
		
		int panelScale = getPanelScale();
		
		menu1.setMinimumSize(new Dimension(5 * panelScale, 3 * panelScale));
		menu2.setMinimumSize(new Dimension(5 * panelScale, 3 * panelScale));
		menu3.setMinimumSize(new Dimension(5 * panelScale, 3 * panelScale));
		menu4.setMinimumSize(new Dimension(5 * panelScale, 3 * panelScale));
		
		setupLogo();
		addComponent("menu1", menu1);
		addComponent("menu2", menu2);
		addComponent("menu3", menu3);
		addComponent("menu4", menu4);
		
		menu1.setBackground(Color.white);
		menu2.setBackground(Color.white);
		menu3.setBackground(Color.white);
		menu4.setBackground(Color.white);

	}
	
	/**
	 * Reads BufferedImage from a file into a JLabel, and adds the JLabel to the componentMap. Throws an error if unsuccessful
	 */
	public void setupLogo() {
		BufferedImage logoImage;
		try {
			logoImage = ImageIO.read(new File("Final_Logo.png"));
			java.awt.Image logoImageScaled;
			logoImageScaled = logoImage.getScaledInstance(250, 150, 2);
			addComponent("logo", new JLabel(new ImageIcon(logoImageScaled)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setupLayout() {
		getLayout().setAutoCreateGaps(false);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
			getLayout().createParallelGroup()
				.addGroup(getLayout().createSequentialGroup()
					.addComponent(returnComponent("logo"))
					.addComponent(returnComponent("menu1"))
					.addComponent(returnComponent("menu2"))
					.addComponent(returnComponent("menu3"))
					.addComponent(returnComponent("menu4")))
		);
		
		getLayout().setVerticalGroup(
			getLayout().createSequentialGroup()
				.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(returnComponent("logo"))
					.addComponent(returnComponent("menu1"))
					.addComponent(returnComponent("menu2"))
					.addComponent(returnComponent("menu3"))
					.addComponent(returnComponent("menu4")))
		);
	}

	@Override
	public void setupListeners() {
		((AbstractButton) returnComponent("menu1")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				getFrame().showHomePanel();
			}
		});
		((AbstractButton) returnComponent("menu2")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				getFrame().showProjectsPanel();
			}
		});
		((AbstractButton) returnComponent("menu3")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				//TODO: Add in HelpPanel once created
				getFrame().showHelpPanel();
			}
		});
		((AbstractButton) returnComponent("menu4")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				//TODO: Add in AboutPanel once created
				getFrame().showAboutPanel();
			}
		});
	}

}

