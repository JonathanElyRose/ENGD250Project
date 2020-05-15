import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JScrollPane;

public class HelpPanel extends ParentPanel {

	public HelpPanel(MainFrame frame) {
		super(frame);
		
	}

	@Override
	public void setupComponents() {
		InnerHelpPanel innerHelpPanel = new InnerHelpPanel(this.getFrame());
		
		JScrollPane scrollPane = new JScrollPane(innerHelpPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setPreferredSize(new Dimension(1250, 600));
		
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

	@Override
	public void setupListeners() {
		
	}

}
