import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This panel provides options for creating a new project and importing photos.
 * 
 * @author Jonathan Ely and Emmi Schwitters.
 */

public class HomePanel extends ParentPanel{
	private static final long serialVersionUID = 1L;

	public HomePanel(MainFrame frame) {
		super(frame);
	}

	public void setupComponents() {
		JButton newProject = new JButton("New Project");
		JButton importPhotos = new JButton("Import Photos");
		
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
