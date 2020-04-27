import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * This panel provides a viewing and editing window for the images in a project.
 * 
 * @author Emmi Schwitters
 */

public class EditorPanel extends ParentPanel {
	private static final long serialVersionUID = 1L;

	public EditorPanel(MainFrame frame) {
		super(frame);
	}

	@Override
	public void setupComponents() {
		ToolbarPanel toolPanel = new ToolbarPanel(this.getFrame());
		
		JButton previous = new JButton("<");
		JButton next = new JButton(">");
		JLabel picture = setupImage();
		
		addComponent("toolPanel", toolPanel);
		addComponent("previous", previous);
		addComponent("next", next);
		addComponent("picture", picture);
	}
	
	/**
	 * Creates a BufferedImage and reads it into a JLabel. Returns the JLabel if successful, otherwise returns null
	 * 
	 * @return JLabel - JLabel with ImageIcon
	 */
	public JLabel setupImage() {
		BufferedImage image;
		try {
			image = ImageIO.read(new File("logoPlaceholder.png"));
			return new JLabel(new ImageIcon(image));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setupLayout() {
		getLayout().setAutoCreateGaps(false);
		getLayout().setAutoCreateContainerGaps(false);
		
		getLayout().setVerticalGroup(
				getLayout().createSequentialGroup()
					.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(returnComponent("previous"))
						.addComponent(returnComponent("picture"))
						.addComponent(returnComponent("next")))
					.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(returnComponent("toolPanel")))
		);
		
		getLayout().setHorizontalGroup(
			getLayout().createSequentialGroup()
				.addComponent(returnComponent("previous"))
				.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
					.addComponent(returnComponent("picture"))
					.addComponent(returnComponent("toolPanel")))
				.addComponent(returnComponent("next"))
		);
		

	}

	@Override
	public void setupListeners() {
	}

}
