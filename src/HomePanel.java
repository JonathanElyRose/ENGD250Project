import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Image;

/**
 * This panel provides options for creating a new project and importing photos.
 * 
 * @author Jonathan Ely, Emmi Schwitters, and Liz Stutz.
 */

public class HomePanel extends ParentPanel{
	private static final long serialVersionUID = 1L;

	public HomePanel(MainFrame frame) {
		super(frame);
	}

	public void setupComponents() {

		ImageIcon icon1 = new ImageIcon("new project logo.png");
		ImageIcon icon2 = new ImageIcon("add image logo.png");
		
		java.awt.Image img1 = icon1.getImage();
		java.awt.Image img2 = icon2.getImage();
		
		int iconSize = 20;
		Image newimg1 = img1.getScaledInstance(iconSize, iconSize, java.awt.Image.SCALE_SMOOTH ) ;
		Image newimg2 = img2.getScaledInstance( iconSize, iconSize, java.awt.Image.SCALE_SMOOTH ) ; 
		
		icon1 = new ImageIcon( newimg1 );
		icon2 = new ImageIcon( newimg2 );
		
		RotoButton newProject = new RotoButton(icon1);
		RotoButton importPhotos = new RotoButton(icon2);
		
		newProject.setText("New Project");
		importPhotos.setText("Import Photos");

		newProject.setFont(new Font("Arial", Font.PLAIN, 20));
		importPhotos.setFont(new Font("Arial", Font.PLAIN, 20));
		
		int panelScale = getPanelScale();
		newProject.setMinimumSize(new Dimension(10 * panelScale, 4 * panelScale));
		importPhotos.setMinimumSize(new Dimension(10 * panelScale, 4 * panelScale));
		
		addComponent("newProject", newProject);
		addComponent("importPhotos", importPhotos);
		
		newProject.setBackground(Color.white);
		importPhotos.setBackground(Color.white);
	}
	
	public void setupLayout() {
		getLayout().setAutoCreateGaps(false);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
			getLayout().createParallelGroup()
				.addGroup(getLayout().createSequentialGroup()
					.addComponent(returnComponent("newProject"))
					.addComponent(returnComponent("importPhotos")))
		);
		
		getLayout().setVerticalGroup(
				getLayout().createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(returnComponent("newProject"))
					.addComponent(returnComponent("importPhotos"))
		);
	}

	@Override
	public void setupListeners() {
		((AbstractButton) returnComponent("newProject")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				getFrame().showNewProjectPanel();
			}
		});
		((AbstractButton) returnComponent("importPhotos")).addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				getFrame().showImportDialog();
			}
		});
	}
}
