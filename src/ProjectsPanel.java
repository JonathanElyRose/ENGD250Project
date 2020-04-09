import java.awt.Dimension;
import javax.swing.JScrollPane;

public class ProjectsPanel extends ParentPanel {

	@Override
	public void setupComponents() {
		InnerProjectsPanel innerPanel = new InnerProjectsPanel();
		
		JScrollPane scrollPane = new JScrollPane(innerPanel);
		setPreferredSize(new Dimension(innerPanel.getPanelWidth(), 600));		
		
		addComponent("scrollPane", scrollPane);
	}

	@Override
	public void setupLayout() {
		getLayout().setAutoCreateGaps(false);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
				getLayout().createParallelGroup()
					.addComponent(returnComponent("scrollPane"))
		);
		getLayout().setVerticalGroup(
				getLayout().createParallelGroup()
					.addComponent(returnComponent("scrollPane"))
		);
	}

}
