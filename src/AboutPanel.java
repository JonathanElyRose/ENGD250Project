import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.ImageIcon;


/**
 * A JPanel which holds information about the project, the team's names, and images of the team.
 * 
 * @author Emmi Schwitters, Liz Stutz.
 */
public class AboutPanel extends ParentPanel {
	private static final long serialVersionUID = 1L;

	public AboutPanel(MainFrame frame) {
		super(frame);
	}
	
	@Override
	public void setupComponents() {
		JLabel aboutTitle = new JLabel("ABOUT");
		JTextArea area = new JTextArea();
		JFrame frame = new JFrame();
		
		ImageIcon icon1 = new ImageIcon("liz about.png");
		ImageIcon icon2 = new ImageIcon("emmi about.png");
		ImageIcon icon3 = new ImageIcon("jonny about1.png");
		
		java.awt.Image img1 = icon1.getImage();
		java.awt.Image img2 = icon2.getImage();
		java.awt.Image img3 = icon3.getImage();
		
		int iconSize1 = 220;
		int iconSize2 =190;
		Image newimg1 = img1.getScaledInstance(iconSize1, iconSize2, java.awt.Image.SCALE_SMOOTH ) ;
		Image newimg2 = img2.getScaledInstance(250, iconSize2, java.awt.Image.SCALE_SMOOTH ) ;
		Image newimg3 = img3.getScaledInstance(190, 220, java.awt.Image.SCALE_SMOOTH ) ;
		
		icon1 = new ImageIcon( newimg1 );
		icon2 = new ImageIcon( newimg2 );
		icon3 = new ImageIcon( newimg3 );
		JLabel label1 = new JLabel(icon1);
		JLabel label2 = new JLabel(icon2);
		JLabel label3 = new JLabel(icon3);
		
		area.setText("As Engineering Design Students at Rose-Hulman Institute of Technology in Terre Haute, Indiana, we were "
				+ "challenged to create a computer application \ndesigned for use by a culture different from our own.  Our team "
				+ "selected Hong Kong as our cultural focus on our animation app, due to its’ incredible \ndiversity.  This product "
				+ "will allow users to create entertaining animation sequences using a combination of traditional hand-drawn skills "
				+ "along with a \nmodern app that allows them to bring their stories to life.");

		addComponent("aboutTitle", aboutTitle);
		addComponent("area", area);
		addComponent("label1", label1);
		addComponent("label2", label2);
		addComponent("label3", label3);
	}

	@Override
	public void setupLayout() {
		getLayout().setAutoCreateGaps(true);
		getLayout().setAutoCreateContainerGaps(true);
		
		getLayout().setHorizontalGroup(
				getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
					.addGroup(getLayout().createSequentialGroup()
							.addComponent(returnComponent("label1"))
							.addComponent(returnComponent("label2"))
							.addComponent(returnComponent("label3")))
					.addGroup(getLayout().createParallelGroup()
							.addComponent(returnComponent("aboutTitle"))
							.addComponent(returnComponent("area")))
		);
		
		getLayout().setVerticalGroup(
				getLayout().createSequentialGroup()
						.addGroup(getLayout().createParallelGroup(GroupLayout.Alignment.CENTER)
								.addComponent(returnComponent("label1"))
								.addComponent(returnComponent("label2"))
								.addComponent(returnComponent("label3")))		
								.addComponent(returnComponent("aboutTitle"))
								.addComponent(returnComponent("area"))
		);

	}

	@Override
	public void setupListeners() {
	}

}
