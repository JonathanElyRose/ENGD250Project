import java.awt.Color;
import java.awt.Font;
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
import javax.swing.GroupLayout.*;
import java.lang.Math;

/**
 * This panel is located inside ProjectsPanel, and aligns the projects into a grid of select dimensions.
 * 
 * @author Jonathan Ely, Emmi Schwitters.
 */

public class InnerProjectsPanel extends ParentPanel {
	private static final long serialVersionUID = 1L;
	
	private int gridX;
	private int numProjects;
	
	public InnerProjectsPanel(MainFrame frame) {
		super(frame);
	}	

	@Override
	public void setupComponents() {
		numProjects = this.getFrame().getProjectManager().getNumOfProjects();
		gridX = 4;
		
		int i = 0;
		for(Project project : this.getFrame().getProjectManager().getProjectMap().values()) {
			RotoButton button = new RotoButton(setupThumbnail(project.getThumbnailPath()));
			
			if(project.getName().length() > 8) {
				button.setText(project.getName().substring(0, 14) + "...");
			}
			else {
				button.setText(project.getName());
			}
			button.setFont(new Font("Arial", Font.PLAIN, 20));
			button.setHorizontalTextPosition(JButton.CENTER);
			button.setVerticalTextPosition(JButton.BOTTOM);
			addComponent(Integer.toString(i), button);
			i++;
			
			button.setBackground(Color.gray);
		}
		
	}
	
	/**
	 * Creates a BufferedImage and reads it into a JLabel. Adds the JLabel to the componentMap if successful, otherwise throws an
	 * error
	 * 
	 * @return JLabel - JLabel with ImageIcon
	 */
	public ImageIcon setupThumbnail(String path) {
		BufferedImage thumbnailImage;
		try {
			if(path == null) {
				thumbnailImage = ImageIO.read(new File("Final_Logo.png"));
			}
			else {
				thumbnailImage = ImageIO.read(new File(path));
			}
			java.awt.Image thumbnailImageScaled;
			thumbnailImageScaled = thumbnailImage.getScaledInstance(200, 100, 2);
			return new ImageIcon(thumbnailImageScaled);
		} 
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void setupLayout() {	
		getLayout().setAutoCreateGaps(true);
		getLayout().setAutoCreateContainerGaps(true);
		
		ParallelGroup horizontalGroup = getLayout().createParallelGroup(GroupLayout.Alignment.LEADING);
		ParallelGroup verticalGroup = getLayout().createParallelGroup(GroupLayout.Alignment.LEADING);
		
		for(int i = 0; i < numProjects; i += gridX) {
			SequentialGroup newRow = getLayout().createSequentialGroup();
			for(int j = i; j < (i + gridX); j++) {
				if(returnComponent(Integer.toString(j)) != null)
					newRow.addComponent(returnComponent(Integer.toString(j)));
				}
			horizontalGroup.addGroup(newRow);
		}
		
		double decimalGridY = (double) numProjects / (double) gridX;
		int gridY = (int) Math.ceil(decimalGridY);
		
		for(int i = 0; i < gridX; i++) {
			SequentialGroup newColumn = getLayout().createSequentialGroup();
			for(int j = i; j < i + (gridX * gridY); j += gridX) {
				if(returnComponent(Integer.toString(j)) != null) {
					newColumn.addComponent(returnComponent(Integer.toString(j)));
				}
			}
			verticalGroup.addGroup(newColumn);
		}
		
		getLayout().setHorizontalGroup(horizontalGroup);
		getLayout().setVerticalGroup(verticalGroup);
	}
	
	/**
	 * Returns width of panel. Meant for scaling purposes.
	 * 
	 * @return
	 */
	public int getPanelWidth() {
		return (gridX * 200) + (gridX * 20);
	}

	@Override
	public void setupListeners() {
		int i = 0;
		for(Project project : this.getFrame().getProjectManager().getProjectMap().values()) {
			((AbstractButton) returnComponent(Integer.toString(i))).addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) {
					getFrame().showEditorPanel(project);
				}
			});
			i++;
		}
	}

}
