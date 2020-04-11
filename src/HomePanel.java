/*
 * @author Jonathan Ely.
 */

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
	public HomePanel(JFrame frame) {
		super(frame);
	}

	public void setupComponents() {
		JButton newProject = new JButton("New Project");
		JButton recentProjects = new JButton("Recent Projects");
		JButton importPhotos = new JButton("Import Photos");
		
		int panelScale = getPanelScale();
		
		recentProjects.setMinimumSize(new Dimension(20 * panelScale, 4 * panelScale));
		newProject.setMinimumSize(new Dimension(10 * panelScale, 4 * panelScale));
		importPhotos.setMinimumSize(new Dimension(10 * panelScale, 4 * panelScale));
		
		addComponent("newProject", newProject);
		addComponent("recentProjects", recentProjects);
		addComponent("importPhotos", importPhotos);
	}
	
	public void setupLayout() {
		getLayout().setAutoCreateGaps(false);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
			getLayout().createParallelGroup()
				.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(returnComponent("recentProjects")))
				.addGroup(getLayout().createSequentialGroup()
					.addComponent(returnComponent("newProject"))
					.addComponent(returnComponent("importPhotos")))
		);
		
		getLayout().setVerticalGroup(
			getLayout().createSequentialGroup()
				.addComponent(returnComponent("recentProjects"))
				.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(returnComponent("newProject"))
					.addComponent(returnComponent("importPhotos")))
		);
	}
}
