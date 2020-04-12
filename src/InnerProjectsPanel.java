/*
 * @author Jonathan Ely.
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.GroupLayout.*;
import java.lang.Math;

public class InnerProjectsPanel extends ParentPanel {
	private int gridX;
	private int numProjects;
	
	public InnerProjectsPanel(MainFrame frame) {
		super(frame);
	}

	

	@Override
	public void setupComponents() {
		numProjects = 23;
		gridX = 4;
		for(int i = 0; i < numProjects; i++) {
			setupLogo(i);
		}
		
	}
	
	public void setupLogo(int i) {
		BufferedImage logoImage;
		try {
			logoImage = ImageIO.read(new File("logoPlaceholder.png"));
			java.awt.Image logoImageScaled;
			logoImageScaled = logoImage.getScaledInstance(logoImage.getWidth() * (getPanelScale() / 25), logoImage.getHeight() * (getPanelScale() / 25), 2);
			JLabel image = new JLabel(new ImageIcon(logoImageScaled));
			addComponent(Integer.toString(i), image);
		} 
		catch (IOException e) {
			e.printStackTrace();
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
	
	public int getPanelWidth() {
		return (gridX * 200) + (gridX * 20);
	}



	@Override
	public void setupListeners() {
		// TODO Auto-generated method stub
		
	}

}
