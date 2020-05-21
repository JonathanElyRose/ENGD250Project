import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This panel goes inside an instance of EditorPanel, and provides options to edit a Project, including tools for the frame rate,
 * order of images, and the import of images.
 * 
 * @author Emmi Schwitters
 */

public class ToolbarPanel extends ParentPanel {
	private static final long serialVersionUID = 1L;
	private EditorPanel editorPanel;
	private int fps;
	private boolean running;
	private Timer timer;
	private ImageIcon playIcon;
	private ImageIcon pause;

	public ToolbarPanel(MainFrame frame, EditorPanel editorPanel) {
		super(frame);
		this.editorPanel = editorPanel;
		this.fps = 1;
		this.running = false;
		this.timer = new Timer(1000 / fps, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(verifyFPS()) {
					fps = Integer.parseInt(((JTextField) returnComponent("fs")).getText());
					timer.setDelay(1000 / fps);
					editorPanel.advanceImage(1);
					getFrame().repaint();
					getFrame().pack();
				}
				else {
					playerToggle();
				}
				
			}
			
		});
		
	}

	@Override
	public void setupComponents() {
		
		playIcon = new ImageIcon("play.png");
		pause = new ImageIcon("pause.png");
		
		java.awt.Image img1 = playIcon.getImage();
		java.awt.Image img2 = pause.getImage();
		
		int iconSize = 20;
		Image newimg1 = img1.getScaledInstance(iconSize, iconSize, java.awt.Image.SCALE_SMOOTH ) ;
		Image newimg2 = img2.getScaledInstance(iconSize, iconSize, java.awt.Image.SCALE_SMOOTH ) ;
		
		playIcon = new ImageIcon( newimg1 );
		pause = new ImageIcon( newimg2 );
		
		JLabel fpsErrorMessages = new JLabel("");
		RotoButton play = new RotoButton(playIcon);
		play.setText("Play");
		JLabel fsLabel = new JLabel("Frames/Second");
		JTextField fs = new JTextField("1", 2);
		RotoButton selectPhoto = new RotoButton("Select Photos");
		RotoButton importPhoto = new RotoButton("Import Photos");
		RotoButton exportVideo = new RotoButton("Export Animation");
		

		
		addComponent("fpsErrorMessages", fpsErrorMessages);
		addComponent("play", play);
		addComponent("fsLabel", fsLabel);
		addComponent("fs", fs);
		addComponent("selectPhoto", selectPhoto);
		addComponent("importPhoto", importPhoto);
		addComponent("exportVideo", exportVideo);
		
		

	}

	@Override
	public void setupLayout() {
		getLayout().setAutoCreateGaps(false);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
			getLayout().createParallelGroup()
				.addGroup(getLayout().createSequentialGroup()
					.addComponent(returnComponent("play"))
						.addGroup(getLayout().createParallelGroup()
						.addComponent(returnComponent("fsLabel"))
						.addComponent(returnComponent("fs"))
						.addComponent(returnComponent("fpsErrorMessages")))
					.addComponent(returnComponent("selectPhoto"))
					.addComponent(returnComponent("importPhoto"))
					.addComponent(returnComponent("exportVideo")))
		);
		
		getLayout().setVerticalGroup(
			getLayout().createSequentialGroup()
				.addComponent(returnComponent("fsLabel"))
				.addGroup(getLayout().createParallelGroup()
					.addComponent(returnComponent("play"))		
					.addComponent(returnComponent("fs"))
					.addComponent(returnComponent("selectPhoto"))
					.addComponent(returnComponent("importPhoto"))
					.addComponent(returnComponent("exportVideo")))
				.addComponent(returnComponent("fpsErrorMessages"))
		);

	}

	@Override
	public void setupListeners() {
		((AbstractButton) returnComponent("selectPhoto")).addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectDialog dialog = new SelectDialog();
				String[] images = dialog.getSelectedImages();
				getFrame().getProjectManager().addImages(images, editorPanel.getProject(), (System.getProperty("user.dir") + "/" + editorPanel.getProject().getFilePath()), "existing file");
				editorPanel.loadProject();
			}
		});
		((AbstractButton) returnComponent("play")).addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				playerToggle();
			}
		});
		((AbstractButton) returnComponent("importPhoto")).addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ImportDialog dialog = new ImportDialog();
				String[] images = dialog.getSelectedImages();
				
				int numOfImages = 0;
				if(editorPanel.getProject().getImagesMap().size() > 0) {
					numOfImages = editorPanel.getProject().getImagesMap().size();
				}
				for(int i = 0; i < images.length; i++) {
					editorPanel.getProject().addImage(i + numOfImages, System.getProperty("user.dir") + "/src/data/images/" + images[i]);
				}
				editorPanel.loadProject();
			}
		});
		((AbstractButton) returnComponent("exportVideo")).addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				if(verifyFPS()) {
					getFrame().getVideoManager().makeProgressBar();
					getFrame().getVideoManager().exportVideo(editorPanel.getProject(), Integer.parseInt(((JTextField) returnComponent("fs")).getText()));
				}
			}
		});
	}
	
	public void playerToggle() {
		this.running = !this.running;
		if(running) {
			((RotoButton) returnComponent("play")).setText("Pause");
			((RotoButton) returnComponent("play")).setIcon(pause);
			this.timer.start();
		}
		else {
			((RotoButton) returnComponent("play")).setText("Play");
			((RotoButton) returnComponent("play")).setIcon(playIcon);
			this.timer.stop();
		}
	}
	
	public boolean verifyFPS() {
		String input = ((JTextField) returnComponent("fs")).getText();
		if(input.length() == 0) {
			((JLabel) returnComponent("fpsErrorMessages")).setText("Error: FPS must be a whole number");
			return false;
		}
		boolean output = true;
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) < 48 || input.charAt(i) > 57) {
				output = false;
				((JLabel) returnComponent("fpsErrorMessages")).setText("Error: FPS must be a whole number");
			}
		}
		return output;
	}
}
