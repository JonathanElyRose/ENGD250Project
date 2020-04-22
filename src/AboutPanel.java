import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
/*
 * @author Emmi Schwitters, Liz Stutz.
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
		JTextArea area = new JTextArea();

		
		area.setText("As Engineering Design Students at Rose-Hulman Institute of Technology in Terre Haute, Indiana, we were "
				+ "challenged to create a computer application \ndesigned for use by a culture different from our own.  Our team "
				+ "selected Hong Kong as our cultural focus on our \nanimation app, due to its’ incredible diversity.  This product "
				+ "will allow users to create entertaining animation \nsequences using a combination of traditional hand-drawn skills "
				+ "along with a modern app that allows them to bring their stories to life.");

		addComponent("aboutTitle", aboutTitle);
		addComponent("area", area);
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
							.addComponent(returnComponent("area")))
		);
		
		getLayout().setVerticalGroup(
				getLayout().createSequentialGroup()
								.addComponent(returnComponent("aboutTitle"))
								.addComponent(returnComponent("area"))
		);

	}

	@Override
	public void setupListeners() {
		// TODO Auto-generated method stub

	}

}
