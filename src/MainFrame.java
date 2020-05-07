import javax.swing.*;

/**
 * MainFrame not only provides itself as a JFrame to hold any panels in this program, but also keeps various helper, getter, and
 * setter methods available for any class that needs them. Most of the program is in some way dependent upon this class. It keeps
 * an instance of every Panel available for displaying once the associated method is called.
 * 
 * @author Jonathan Ely, Emmi Schwitters.
 */

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private ProjectManager projectManager;
	
	private HomePanel homePanel;
	private ProjectsPanel projectsPanel;
	private NewProjectPanel newProjectPanel;
	private NavigationPanel navigationPanel;
	private HelpPanel helpPanel;
	private AboutPanel aboutPanel;
	private EditorPanel editorPanel;
	
	private JPanel outerPanel = new JPanel();
	private JPanel currentPanel = new JPanel();
	
	public MainFrame(ProjectManager projectManager) {
		this.projectManager = projectManager;
		
		homePanel = new HomePanel(this);
		projectsPanel = new ProjectsPanel(this);
		newProjectPanel = new NewProjectPanel(this);
		navigationPanel = new NavigationPanel(this);
		helpPanel = new HelpPanel(this);
		aboutPanel = new AboutPanel(this);
		editorPanel = new EditorPanel(this);
		
		this.setTitle("RotoScope");
		
		configurePanels();
		
		this.add(outerPanel);
		
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * A getter method for the ProjectManager, allowing Panels to create Projects and .proj files.
	 * 
	 * @return projectManager - A ProjectManager instance shared by all panels.
	 */
	public ProjectManager getProjectManager() {
		return this.projectManager;
	}
	
	/**
	 * Splits the frame into a section for the navigation bar, and a lower half to hold the currently viewed panel. Sets the
	 * HomePanel as the default panel at startup
	 */
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
	
	/**
	 * Changes displayed panel to HomePanel
	 */
	public void showHomePanel() {
		currentPanel.remove(0);
		currentPanel.add(homePanel);
		this.pack();
		this.repaint();
	}
	
	/**
	 * Changes displayed panel to ProjectsPanel. Creates a new instance to update the panel in case any projects have been made since the last showing.
	 */
	public void showProjectsPanel() {
		projectsPanel = new ProjectsPanel(this);
		currentPanel.remove(0);
		currentPanel.add(projectsPanel);
		this.pack();
		this.repaint();
	}
	
	/**
	 * Changes displayed panel to NewProjectPanel
	 */
	public void showNewProjectPanel() {
		currentPanel.remove(0);
		currentPanel.add(newProjectPanel);
		this.pack();
		this.repaint();
	}
	
	/**
	 * Displays the JFileChooser for the ImportDialog, allowing users to select files
	 */
	public void showImportDialog() {
		new ImportDialog();
	}
	
	/**
	 * Not yet implemented
	 */
	public void showSelectPhotosPanel() {
		//TODO: Add SelectPhotosPanel class
		this.pack();
		this.repaint();
	}
	
	/**
	 * Changes displayed panel to HelpPanel
	 */
	public void showHelpPanel() {
		currentPanel.removeAll();
		currentPanel.add(helpPanel);
		this.pack();
		this.repaint();
	}
	
	/**
	 * Changes displayed panel to AboutPanel
	 */
	public void showAboutPanel() {
		currentPanel.removeAll();
		currentPanel.add(aboutPanel);
		this.pack();
		this.repaint();
	}
	
	/**
	 * Changes displayed panel to EditorPanel
	 */
	public void showEditorPanel(Project project) {
		editorPanel.setProject(project);
		currentPanel.removeAll();
		currentPanel.add(editorPanel);
		this.pack();
		this.repaint();
	}
}