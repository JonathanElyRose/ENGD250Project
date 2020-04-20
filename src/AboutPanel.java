import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
		JLabel aboutTitle = new JLabel("ABOUT");
		JTextField field = new JTextField();
		JTextField field1 = new JTextField();
		JTextField field2 = new JTextField();
		
		field.setText("As Engineering Design Students at Rose-Hulman Institute of Technology in Terre Haute, Indiana, we were"
				+ " challenged to create a computer application designed for use by a culture different from our own.  Our team ");
		field1.setText("selected Hong Kong as our cultural focus on our animation app, due to its’ incredible diversity.  This product "
				+ "will allow users to create entertaining animation sequences using a combination of traditional hand-drawn skills");
		field2.setText(" along with a modern app that allows them to bring their stories to life.");
		
		addComponent("aboutTitle", aboutTitle);
		addComponent("field", field);
		addComponent("field1", field1);
		addComponent("field2", field2);
	}

	@Override
	public void setupLayout() {
		// TODO Auto-generated method stub
		getLayout().setAutoCreateGaps(true);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
				getLayout().createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(getLayout().createParallelGroup()
							.addComponent(returnComponent("aboutTitle"))
							.addComponent(returnComponent("field"))
							.addComponent(returnComponent("field1"))
							.addComponent(returnComponent("field2")))
		);
		
		getLayout().setVerticalGroup(
				getLayout().createSequentialGroup()
								.addComponent(returnComponent("aboutTitle"))
								.addComponent(returnComponent("field"))
								.addComponent(returnComponent("field1"))
								.addComponent(returnComponent("field2"))
		);

	}

	@Override
	public void setupListeners() {
		// TODO Auto-generated method stub

	}

}
