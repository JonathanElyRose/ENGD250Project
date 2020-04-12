/*
 * @author Jonathan Ely.
 */

import javax.swing.*;

public class MainFrame extends JFrame {
	private JFrame frame = new JFrame();
	
	private HomePanel homePanel = new HomePanel(frame);
	private ProjectsPanel projectsPanel = new ProjectsPanel(frame);
	private NewProjectPanel newProjectPanel = new NewProjectPanel(frame);
	private NavigationPanel navigationPanel = new NavigationPanel(frame);
	
	private JPanel outerPanel = new JPanel();
	private JPanel currentPanel = new JPanel();
	
	public MainFrame() {		
		frame.setTitle("RotoScope");
		
		configurePanels();
		
		frame.add(outerPanel);
		
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void configurePanels() {
		GroupLayout layout = new GroupLayout(outerPanel);
		outerPanel.setLayout(layout);
		
		outerPanel.add(navigationPanel);
		outerPanel.add(currentPanel);
		
		layout.setAutoCreateGaps(false);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.CENTER)
					.addComponent(navigationPanel)
					.addComponent(currentPanel)
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(navigationPanel)
				.addComponent(currentPanel)
		);
		
		currentPanel.add(homePanel);
	}
	
	public void showHomePanel() {
		currentPanel.removeAll();
		currentPanel.add(homePanel);
	}
	
	public void showProjectsPanel() {
		currentPanel.removeAll();
		currentPanel.add(projectsPanel);
	}
}