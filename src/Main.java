/**
 * Main is responsible for starting each component of the program in the right order, first launching the FileManager, then launching the
 * ProjectManager and passing it to the GUI launch.
 * 
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
            /**
             * Launches the FileManager, and throws an IOException if a fatal error occurs in runtime.
             * 
             * @throws IOException
             */
            private void launchFileManager() throws IOException {
        		new FileManager();
        	}
            /**
             * Launches the ProjectManager and returns the instance for use by launchGUI()
             * 
             * @return projectManager
             */
            private ProjectManager launchProjectManager() {
            	ProjectManager projectManager = new ProjectManager();
            	return projectManager;
            }
            /**
             * Initializes a MainFrame instance and passes an instance of ProjectManager to MainFrame. This makes it possible for the GUI panels
             * and frame to be created, and gives the JComponents of these panels the ability to make Project instances, and well as .proj files.
             * 
             * @param projectManager
             */
            private void launchGUI(ProjectManager projectManager) {
            	new MainFrame(projectManager);
            }
            
        });
	}
}
