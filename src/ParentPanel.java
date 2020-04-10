/*
 * @author Jonathan Ely.
 */

import java.util.HashMap;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class ParentPanel extends JPanel{
	private GroupLayout layout = new GroupLayout(this);
	private JFrame frame;
	private HashMap<String, JComponent> componentMap = new HashMap<String, JComponent>();
	private int panelScale = 50;
	
	public ParentPanel(JFrame frame) {
		this.setLayout(layout);
		this.frame = frame;
		setupComponents();
		setupLayout();
	}
	
	public GroupLayout getLayout() {
		return this.layout;
	}
	
	public void addComponent(String string, JComponent component) {
		this.componentMap.put(string, component);
	}
	
	public JComponent returnComponent(String string) {
		if(this.componentMap.containsKey(string)) {
			return this.componentMap.get(string);
		}
		else {
			return null;
		}
	}
	
	public int getPanelScale() {
		return panelScale;
	}
	
	public void setPanelScale(int scale) {
		this.panelScale = scale;
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
	
	public abstract void setupComponents();
	
	public abstract void setupLayout();
}
