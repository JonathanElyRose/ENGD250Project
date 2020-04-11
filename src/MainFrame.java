/*
 * @author Jonathan Ely.
 */

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
	private JFrame frame = new JFrame();	
	
	public MainFrame() {		
		frame.setTitle("RotoScope");
		
		HomePanel homePanel = new HomePanel(frame);
		
		ProjectsPanel projectsPanel = new ProjectsPanel(frame);
		
		NewProjectPanel newProjectPanel = new NewProjectPanel(frame);
		
		NavigationPanel navigationPanel = new NavigationPanel(frame);
		
		frame.add(navigationPanel);
		
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}