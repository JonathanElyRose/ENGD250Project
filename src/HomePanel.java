/*
<<<<<<< HEAD
 * @author Jonathan Ely, Emmi Schwitters
=======
 * @author Jonathan Ely and Emmi Schwitters.
>>>>>>> branch 'master' of https://github.com/JonathanElyRose/ENGD250Project.git
 */

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//This class describes the layout of the home page and assigns ActionListeners to its buttons.
public class HomePanel extends ParentPanel{
	public HomePanel(MainFrame frame) {
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

	@Override
	public void setupListeners() {
		((AbstractButton) returnComponent("newProject")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				getFrame().showNewProjectPanel();
			}
		});
		((AbstractButton) returnComponent("recentProjects")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				getFrame().showProjectsPanel();
			}
		});
		((AbstractButton) returnComponent("importPhotos")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				getFrame().showImportPhotosPanel();
			}
		});
	}
}
