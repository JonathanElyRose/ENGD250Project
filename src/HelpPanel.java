import javax.swing.GroupLayout;
import javax.swing.JLabel;

/*
 * @author Emmi Schwitters.
 */

public class HelpPanel extends ParentPanel {

	public HelpPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setupComponents() {
		// TODO Auto-generated method stub
		JLabel helpTitle = new JLabel("HELP");
		
		addComponent("helpTitle", helpTitle);

	}

	@Override
	public void setupLayout() {
		// TODO Auto-generated method stub
		getLayout().setAutoCreateGaps(true);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
				getLayout().createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(getLayout().createSequentialGroup()
							.addComponent(returnComponent("helpTitle")))
		);
		
		getLayout().setVerticalGroup(
				getLayout().createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(getLayout().createSequentialGroup()
						.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(returnComponent("helpTitle"))))
		);

	}

	@Override
	public void setupListeners() {
		// TODO Auto-generated method stub

	}

}
