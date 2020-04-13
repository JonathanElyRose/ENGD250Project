/*
 * @author Jonathan Ely, Emmi Schwitters.
 */

import javax.swing.*;

public class MainFrame extends JFrame {
	private HomePanel homePanel = new HomePanel(this);
	private ProjectsPanel projectsPanel = new ProjectsPanel(this);
	private NewProjectPanel newProjectPanel = new NewProjectPanel(this);
	private NavigationPanel navigationPanel = new NavigationPanel(this);
	private HelpPanel helpPanel = new HelpPanel(this);
	private AboutPanel aboutPanel = new AboutPanel(this);
	
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
		this.repaint();
	}
	
	public void showProjectsPanel() {
		currentPanel.remove(0);
		currentPanel.add(projectsPanel);
		this.pack();
		this.repaint();
	}
	
	public void showNewProjectPanel() {
		currentPanel.remove(0);
		currentPanel.add(newProjectPanel);
		this.pack();
		this.repaint();
	}
	public void showImportDialog() {
		new ImportDialog();
		this.pack();
		this.repaint();
	}
	public void showSelectPhotosPanel() {
		//TODO: Add SelectPhotosPanel class
		this.pack();
		this.repaint();
	}
	public void showHelpPanel() {
		currentPanel.removeAll();
		currentPanel.add(helpPanel);
		this.pack();
		this.repaint();
	}
	public void showAboutPanel() {
		currentPanel.removeAll();
		currentPanel.add(aboutPanel);
		this.pack();
		this.repaint();
	}
}