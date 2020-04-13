/*
<<<<<<< HEAD
 * @author Emmi Schwitters.
=======
 * @author Jonathan Ely and Emmi Schwitters.
>>>>>>> branch 'master' of https://github.com/JonathanElyRose/ENGD250Project.git
 */

import java.awt.Dimension;
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

public class NavigationPanel extends ParentPanel {

	public NavigationPanel(MainFrame frame) {
		super(frame);
	}

	@Override
	public void setupComponents() {
		JButton menu1 = new JButton("Home");
		JButton menu2 = new JButton("Projects");
		JButton menu3 = new JButton("Help");
		JButton menu4 = new JButton("About");
		
		int panelScale = getPanelScale();
		
		menu1.setMinimumSize(new Dimension(4 * panelScale, 2 * panelScale));
		menu2.setMinimumSize(new Dimension(4 * panelScale, 2 * panelScale));
		menu3.setMinimumSize(new Dimension(4 * panelScale, 2 * panelScale));
		menu4.setMinimumSize(new Dimension(4 * panelScale, 2 * panelScale));
		
		setupLogo();
		addComponent("menu1", menu1);
		addComponent("menu2", menu2);
		addComponent("menu3", menu3);
		addComponent("menu4", menu4);

	}
	
	public void setupLogo() {
		BufferedImage logoImage;
		try {
			logoImage = ImageIO.read(new File("logoPlaceholder.png"));
			java.awt.Image logoImageScaled;
			logoImageScaled = logoImage.getScaledInstance(logoImage.getWidth() * (getPanelScale() / 25), logoImage.getHeight() * (getPanelScale() / 25), 2);
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

