//this is Liz
public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	launchGUI();
            }
        });
	}
	
	private static void launchGUI() {
		new MainFrame();
	}
}
