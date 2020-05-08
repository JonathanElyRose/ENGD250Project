import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Timer;
import javax.swing.AbstractButton;
import javax.swing.JButton;
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
	Timer timer;

	public ToolbarPanel(MainFrame frame, EditorPanel editorPanel) {
		super(frame);
		this.editorPanel = editorPanel;
		this.fps = 1;
		this.running = false;
		this.timer = new Timer(1000 / fps, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fps = Integer.parseInt(((JTextField) returnComponent("fs")).getText());
				timer.setDelay(1000 / fps);
				editorPanel.advanceImage();
				getFrame().repaint();
				getFrame().pack();
			}
			
		});
	}

	@Override
	public void setupComponents() {
		
		JButton play = new JButton("Play/Pause");
		JLabel fsLabel = new JLabel("Frames/Second");
		JTextField fs = new JTextField("1", 2);
		JButton selectPhoto = new JButton("Select Photos");
		JButton importPhoto = new JButton("Import Photos");
		JButton exportVideo = new JButton("Export Animation");
		JButton editor = new JButton("Edit Photos");
		
		addComponent("play", play);
		addComponent("fsLabel", fsLabel);
		addComponent("fs", fs);
		addComponent("selectPhoto", selectPhoto);
		addComponent("importPhoto", importPhoto);
		addComponent("exportVideo", exportVideo);
		addComponent("editor", editor);

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
						.addComponent(returnComponent("fs")))
					.addComponent(returnComponent("selectPhoto"))
					.addComponent(returnComponent("importPhoto"))
					.addComponent(returnComponent("exportVideo"))
					.addComponent(returnComponent("editor")))
		);
		
		getLayout().setVerticalGroup(
			getLayout().createSequentialGroup()
				.addComponent(returnComponent("fsLabel"))
				.addGroup(getLayout().createParallelGroup()
					.addComponent(returnComponent("play"))		
					.addComponent(returnComponent("fs"))
					.addComponent(returnComponent("selectPhoto"))
					.addComponent(returnComponent("importPhoto"))
					.addComponent(returnComponent("exportVideo"))
					.addComponent(returnComponent("editor")))
		);

	}

	@Override
	public void setupListeners() {
		((AbstractButton) returnComponent("selectPhoto")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				SelectDialog dialog = new SelectDialog();
				String[] images = dialog.getSelectedImages();
				getFrame().getProjectManager().addImages(images, editorPanel.getProject(), (System.getProperty("user.dir") + "/" + editorPanel.getProject().getFilePath()), "existing file");
				editorPanel.loadProject();
			}
		});
		((AbstractButton) returnComponent("play")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				playerToggle();
			}
		});
		((AbstractButton) returnComponent("importPhoto")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				ImportDialog dialog = new ImportDialog();
				File[] images = dialog.getSelectedImages();
				
				int numOfImages = 0;
				if(editorPanel.getProject().getImagesMap().size() > 0) {
					numOfImages = editorPanel.getProject().getImagesMap().size();
				}
				for(int i = 0; i < images.length; i++) {
					editorPanel.getProject().addImage(i + numOfImages, System.getProperty("user.dir") + "/src/data/images/" + images[i].getName());
				}
				editorPanel.loadProject();
			}
		});
	}
	
	public void playerToggle() {
		this.running = !this.running;
		if(running) {
			
			this.timer.start();
		}
		else {
			this.timer.stop();
		}
	}
}
