import javax.swing.GroupLayout;
import javax.swing.JLabel;

/*
 * @author Emmi Schwitters.
 */

public class AboutPanel extends ParentPanel {

	public AboutPanel(MainFrame frame) {
		super(frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setupComponents() {
		// TODO Auto-generated method stub
		JLabel title = new JLabel("ABOUT");
		
		addComponent("title", title);

	}

	@Override
	public void setupLayout() {
		// TODO Auto-generated method stub
		getLayout().setAutoCreateGaps(true);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
				getLayout().createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(getLayout().createSequentialGroup()
							.addComponent(returnComponent("title")))
		);
		
		getLayout().setVerticalGroup(
				getLayout().createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(getLayout().createSequentialGroup()
						.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(returnComponent("title"))))
		);

	}

	@Override
	public void setupListeners() {
		// TODO Auto-generated method stub

	}

}
