/*
 * @author Jonathan Ely.
 */

import javax.swing.*;

public class MainFrame extends JFrame {
	private HomePanel homePanel = new HomePanel(this);
	private ProjectsPanel projectsPanel = new ProjectsPanel(this);
	private NewProjectPanel newProjectPanel = new NewProjectPanel(this);
	private NavigationPanel navigationPanel = new NavigationPanel(this);
	
	private JPanel outerPanel = new JPanel();
	private JPanel currentPanel = new JPanel();
	
	public MainFrame() {		
		this.setTitle("RotoScope");
		
		configurePanels();
		
		this.add(outerPanel);
		
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
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
		currentPanel.remove(0);
		currentPanel.add(homePanel);
		this.pack();
	}
	
	public void showProjectsPanel() {
		currentPanel.remove(0);
		currentPanel.add(projectsPanel);
		this.pack();
	}
	
	public void showNewProjectPanel() {
		currentPanel.remove(0);
		currentPanel.add(newProjectPanel);
		this.pack();
	}
	public void showImportPhotosPanel() {
		currentPanel.remove(0);
		//TODO: Add ImportPhotosPanel class
		this.pack();
	}
	public void showSelectPhotosPanel() {
		currentPanel.remove(0);
		//TODO: Add SelectPhotosPanel class
		this.pack();
	}
	public void showHelpPanel() {
		currentPanel.remove(0);
		//TODO: Add HelpPanel class
		this.pack();
	}
	public void showAboutPanel() {
		currentPanel.remove(0);
		//TODO: Add AboutPanel class
		this.pack();
	}
}