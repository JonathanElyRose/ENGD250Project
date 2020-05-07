import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * This panel provides a viewing and editing window for the images in a project.
 * 
 * @author Emmi Schwitters, Jonathan Ely
 */

public class EditorPanel extends ParentPanel {
	private static final long serialVersionUID = 1L;
	private Project project = null;
	private int scaledWidth;
	private int numOfImages;
	private int currentImage;

	public EditorPanel(MainFrame frame) {
		super(frame);
	}

	@Override
	public void setupComponents() {
		this.scaledWidth = 720;
		
		ToolbarPanel toolPanel = new ToolbarPanel(this.getFrame());
		
		JButton previous = new JButton("<");
		JButton next = new JButton(">");
		JLabel picture = getImageAsLabel("logoPlaceholder.png");
		
		addComponent("toolPanel", toolPanel);
		addComponent("previous", previous);
		addComponent("next", next);
		addComponent("picture", picture);
	}
	
	/**
	 * Creates a BufferedImage, scales it, and reads it into a JLabel. Returns the JLabel if successful, otherwise returns null
	 * 
	 * @return JLabel - JLabel with ImageIcon
	 */
	public JLabel getImageAsLabel(String path) {
		BufferedImage image;
		try {
			image = ImageIO.read(new File(path));
			java.awt.Image imageScaled;
			//int heightScaled = (int) (((float) image.getWidth() / (float) scaledWidth) * (float) image.getHeight());
			imageScaled = image.getScaledInstance(this.scaledWidth, 480, 2);
			return new JLabel(new ImageIcon(imageScaled));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Sets the picture in the center of the EditorPanel to a new image
	 * 
	 * @param picture - JLabel with the image to be displayed
	 */
	public void setPicture(JLabel picture) {
		getLayout().replace(returnComponent("picture"), picture);
		addComponent("picture", picture);
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
		((AbstractButton) returnComponent("next")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				if(currentImage + 1 < numOfImages) {
					currentImage++;
					setPicture(getImageAsLabel(project.getImagePath(currentImage)));
					
				}
				else if(currentImage + 1 == numOfImages) {
					currentImage = 0;
					setPicture(getImageAsLabel(project.getImagePath(currentImage)));
				}
			}
		});
		((AbstractButton) returnComponent("previous")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				if(currentImage > 0) {
					currentImage--;
					setPicture(getImageAsLabel(project.getImagePath(currentImage)));
					
				}
				else if(currentImage == 0) {
					currentImage = numOfImages - 1;
					setPicture(getImageAsLabel(project.getImagePath(currentImage)));
				}
			}
		});
	}

	/**
	 * A getter for the project being viewed in the editor panel
	 * 
	 * @return Project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * A setter method for the project being viewed in the editor panel
	 * 
	 * @param project - Project instance of EditorPanel
	 * 
	 */
	public void setProject(Project project) {
		this.project = project;
		loadProject();
	}
	
	/**
	 * A method for loading images and other project-related information into the EditorPanel at the opening of a project
	 */
	public void loadProject() {
		this.currentImage = 0;
		setPicture(getImageAsLabel(project.getImagePath(currentImage)));
		this.numOfImages = project.getImagesMap().keySet().size();
	}
}
