import java.io.IOException;

/*
 * @author Jonathan Ely.
 */

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
            	launchProjectManager();
            	launchGUI();
            }
            private void launchFileManager() throws IOException {
        		new FileManager();
        	}
            private void launchProjectManager() {
            	new ProjectManager();
            }
            private void launchGUI() {
            	new MainFrame();
            }
            
        });
	}
}
