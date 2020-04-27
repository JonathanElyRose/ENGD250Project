import javax.swing.GroupLayout;
import javax.swing.JButton;

/**
 * This panel goes inside an instance of EditorPanel, and provides options to edit a Project, including tools for the frame rate,
 * order of images, and the import of images.
 * 
 * @author Emmi Schwitters
 */

public class ToolbarPanel extends ParentPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolbarPanel(MainFrame frame) {
		super(frame);
	}

	@Override
	public void setupComponents() {
		JButton play = new JButton("Play/Pause");
		JButton fs = new JButton("Frames/Second");
		JButton importPhoto = new JButton("Import Photos");
		JButton exportVideo = new JButton("Export Animation");
		JButton editor = new JButton("Edit Photos");
		
		addComponent("play", play);
		addComponent("fs", fs);
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
					.addComponent(returnComponent("fs"))
					.addComponent(returnComponent("importPhoto"))
					.addComponent(returnComponent("exportVideo"))
					.addComponent(returnComponent("editor")))
		);
		
		getLayout().setVerticalGroup(
			getLayout().createSequentialGroup()
				.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(returnComponent("play"))
					.addComponent(returnComponent("fs"))
					.addComponent(returnComponent("importPhoto"))
					.addComponent(returnComponent("exportVideo"))
					.addComponent(returnComponent("editor")))
		);

	}

	@Override
	public void setupListeners() {
	}

}
