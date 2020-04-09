import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
	private JFrame frame = new JFrame();	
	
	public MainFrame() {		
		frame.setTitle("RotoScope");
		
		HomePanel homePanel = new HomePanel();
		
		ProjectsPanel projectsPanel = new ProjectsPanel();
		
		NewProjectPanel newProjectPanel = new NewProjectPanel();
		
		frame.add(newProjectPanel);
		
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}