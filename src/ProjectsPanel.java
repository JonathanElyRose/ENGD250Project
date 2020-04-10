/*
 * @author Jonathan Ely.
 */

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class ProjectsPanel extends ParentPanel {

	public ProjectsPanel(JFrame frame) {
		super(frame);
	}

	@Override
	public void setupComponents() {
		InnerProjectsPanel innerPanel = new InnerProjectsPanel(this.getFrame());
		
		JScrollPane scrollPane = new JScrollPane(innerPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		setPreferredSize(new Dimension(innerPanel.getPanelWidth(), 600));		
		
		addComponent("scrollPane", scrollPane);
	}

	@Override
	public void setupLayout() {
		getLayout().setAutoCreateGaps(false);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
				getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
					.addComponent(returnComponent("scrollPane"))
		);
		getLayout().setVerticalGroup(
				getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
					.addComponent(returnComponent("scrollPane"))
		);
	}

}
