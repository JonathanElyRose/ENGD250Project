/*
 * @author Jonathan Ely.
 */

import java.io.IOException;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	try {
					launchFileManager();
				} catch (IOException e) {
					System.out.println("Fatal Error in Main: launchFileManager failed in startup. Program unable to continue");
				}
            	launchGUI(launchProjectManager());
            }
            private void launchFileManager() throws IOException {
        		new FileManager();
        	}
            private ProjectManager launchProjectManager() {
            	ProjectManager projectManager = new ProjectManager();
            	return projectManager;
            }
            private void launchGUI(ProjectManager projectManager) {
            	new MainFrame(projectManager);
            }
            
        });
	}
}
