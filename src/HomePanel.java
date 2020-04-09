import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.prism.Image;

//This class describes the layout of the home page and assigns ActionListeners to its buttons.
public class HomePanel extends ParentPanel{
	
	public void setupComponents() {
		JButton menu1 = new JButton("Menu 1");
		JButton menu2 = new JButton("Menu 2");
		JButton menu3 = new JButton("Menu 3");
		JButton menu4 = new JButton("Menu 4");
		JButton newProject = new JButton("New Project");
		JButton recentProjects = new JButton("Recent Projects");
		JButton importPhotos = new JButton("Import Photos");
		
		int panelScale = getPanelScale();
		
		menu1.setMinimumSize(new Dimension(4 * panelScale, 2 * panelScale));
		menu2.setMinimumSize(new Dimension(4 * panelScale, 2 * panelScale));
		menu3.setMinimumSize(new Dimension(4 * panelScale, 2 * panelScale));
		menu4.setMinimumSize(new Dimension(4 * panelScale, 2 * panelScale));
		recentProjects.setMinimumSize(new Dimension(20 * panelScale, 4 * panelScale));
		newProject.setMinimumSize(new Dimension(10 * panelScale, 4 * panelScale));
		importPhotos.setMinimumSize(new Dimension(10 * panelScale, 4 * panelScale));
		
		setupLogo();
		addComponent("menu1", menu1);
		addComponent("menu2", menu2);
		addComponent("menu3", menu3);
		addComponent("menu4", menu4);
		addComponent("newProject", newProject);
		addComponent("recentProjects", recentProjects);
		addComponent("importPhotos", importPhotos);
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
				.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(returnComponent("recentProjects")))
				.addGroup(getLayout().createSequentialGroup()
					.addComponent(returnComponent("newProject"))
					.addComponent(returnComponent("importPhotos")))
		);
		
		getLayout().setVerticalGroup(
			getLayout().createSequentialGroup()
				.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(returnComponent("logo"))
					.addComponent(returnComponent("menu1"))
					.addComponent(returnComponent("menu2"))
					.addComponent(returnComponent("menu3"))
					.addComponent(returnComponent("menu4")))
				.addComponent(returnComponent("recentProjects"))
				.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(returnComponent("newProject"))
					.addComponent(returnComponent("importPhotos")))
		);
	}
}
