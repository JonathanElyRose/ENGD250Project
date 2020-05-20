import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



/**
 * A panel for displaying buttons to switch between frequently used and important pages of the program. Always displayed at the top
 * of the MainFrame
 * 
 * @author Jonathan Ely, Emmi Schwitters, and Liz Stutz.
 */

public class NavigationPanel extends ParentPanel {
	private static final long serialVersionUID = 1L;
	private int something = 0;

	public NavigationPanel(MainFrame frame) {
		super(frame);
	}

	@Override
	public void setupComponents() {
				
		ImageIcon icon1 = new ImageIcon("home logo.png");
		ImageIcon icon2 = new ImageIcon("projects logo.png");
		ImageIcon icon3 = new ImageIcon("Question.png");
		ImageIcon icon4 = new ImageIcon("about  logo.png");
		
		JLabel motto = new JLabel("Bring your imagination to life!");
		motto.setHorizontalAlignment(SwingConstants.CENTER);
		motto.setBackground(Color.white);
		motto.setMinimumSize(new Dimension(250, 10));
		motto.setOpaque(true);
	
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
		
		RotoButton menu1 = new RotoButton(icon1);
		RotoButton menu2 = new RotoButton(icon2);
		RotoButton menu3 = new RotoButton(icon3);
		RotoButton menu4 = new RotoButton(icon4);
		
	
		
		menu1.setText("Home");
		menu2.setText("Projects");
		menu3.setText("Help");
		menu4.setText("About");
		
		menu1.setFont(new Font("Arial", Font.PLAIN, 20));
		menu2.setFont(new Font("Arial", Font.PLAIN, 20));
		menu3.setFont(new Font("Arial", Font.PLAIN, 20));
		menu4.setFont(new Font("Arial", Font.PLAIN, 20));
		
		int panelScale = getPanelScale();
		

		menu1.setMinimumSize(new Dimension(5 * panelScale, 3 * panelScale));
		menu2.setMinimumSize(new Dimension(5 * panelScale, 3 * panelScale));
		menu3.setMinimumSize(new Dimension(5 * panelScale, 3 * panelScale));
		menu4.setMinimumSize(new Dimension(5 * panelScale, 3 * panelScale));
		
	
		

		menu1.setMinimumSize(new Dimension(5 * panelScale, 166));
		menu2.setMinimumSize(new Dimension(5 * panelScale, 166));
		menu3.setMinimumSize(new Dimension(5 * panelScale, 166));
		menu4.setMinimumSize(new Dimension(5 * panelScale, 166));

		setupLogo();
		addComponent("menu1", menu1);
		addComponent("menu2", menu2);
		addComponent("menu3", menu3);
		addComponent("menu4", menu4);
		addComponent("motto", motto);
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
					.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
							.addComponent(returnComponent("logo"))
							.addComponent(returnComponent("motto")))
					.addComponent(returnComponent("menu1"))
					.addComponent(returnComponent("menu2"))
					.addComponent(returnComponent("menu3"))
					.addComponent(returnComponent("menu4")))
		);
		
		getLayout().setVerticalGroup(
			getLayout().createSequentialGroup()
				.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addGroup(getLayout().createSequentialGroup()
							.addComponent(returnComponent("logo"))
							.addComponent(returnComponent("motto")))
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
				getFrame().showHelpPanel();
			}
		});
		((AbstractButton) returnComponent("menu4")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				getFrame().showAboutPanel();
			}
		});
		((JLabel) returnComponent("motto")).addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent evt) {
				String array[] = {"Image makes video machine go brrr!", "OOGA BOOGA OOGA BOOGA", "The back end is just frozen rubber bands.", "CSSE_Career == Money && !Friends"};
				((JLabel) returnComponent("motto")).setText(array[something]);
				if(something == array.length - 1) {
					something = 0;
				}
				else {
					something++;
				}
			}
			public void mouseExited(MouseEvent evt) {
				((JLabel) returnComponent("motto")).setText("Bring your imagination to life!");
			}
		});
	}

}

