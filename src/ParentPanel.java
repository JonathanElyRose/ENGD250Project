import java.awt.Color;
import java.util.HashMap;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * Provides a framework and associated getter and setter methods for all JPanels within the program. It gives access to the MainFrame
 * instance of the program, an instance of GroupLayout, which can be used for directing the layout of JComponents within the JPanel, and a
 * HashMap of String keys linked to JComponent entries, which allows JPanels a place to store and access their JComponents from.
 * 
 * @author Jonathan Ely, Emmi Schwitters.
 */
public abstract class ParentPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private GroupLayout layout = new GroupLayout(this);
	private MainFrame frame;
	private HashMap<String, JComponent> componentMap = new HashMap<String, JComponent>();
	private int panelScale = 50;
	
	public ParentPanel(MainFrame frame) {
		this.setLayout(layout);
		this.frame = frame;
		setupComponents();
		setupListeners();
		setupLayout();
		
		this.setBackground(Color.gray);
	}
	
	/**
	 * Getter method for ParentPanel's GroupLayout instance (layout)
	 * 
	 * @return GroupLayout layout
	 */
	public GroupLayout getLayout() {
		return this.layout;
	}
	
	/**
	 * Adds a new JComponent to the JPanel's HashMap<String, JComponent> componentMap. This HashMap is used to keep track of a Panel's JComponents.
	 * 
	 * @param string - ID String (usually the name of the local JComponent variable where this function is called)
	 * @param icon - JComponent instance (JButton, JTextField, etc.)
	 */
	public void addComponent(String string, JComponent icon) {
		this.componentMap.put(string, icon);
	}
	
	/**
	 * A getter method which returns a component from the HashMap componentMap based upon a String ID. If the String is not a key for the HashMap,
	 * the method returns null and prints a warning message. This warning is not fatal to the program, and some JPanels already trigger it.
	 * 
	 * @param string - An ID for a JComponent stored in the HashMap componentMap
	 * @return JComponent
	 */
	public JComponent returnComponent(String string) {
		if(this.componentMap.containsKey(string)) {
			return this.componentMap.get(string);
		}
		else {
			System.out.println("Warning in ParentPanel: Component '" + string + "' does not exist within componentMap of " + Thread.currentThread().getStackTrace()[2].getClassName());
			return null;
		}
	}
	
	/**
	 * Getter method for ParentPanel's integer panelScale. This value is intended to provide uniform scaling across all JComponents in a panel
	 * 
	 * @return int panelScale - integer value of panelScale. Suggested to be between 20 to 100.
	 */
	public int getPanelScale() {
		return panelScale;
	}
	
	/**
	 * Setter method for ParentPanel's integer panelScale. This value is intended to provide uniform scaling across all JComponents in a panel
	 * 
	 * @param int scale - integer value suggested to be between 20 to 100.
	 */
	public void setPanelScale(int scale) {
		this.panelScale = scale;
	}
	
	/**
	 * Getter method for the MainFrame instance used by all ParentPanel children, which allows access to methods for swapping between panels
	 * actively shown in the program window.
	 * 
	 * @return MainFrame frame
	 */
	public MainFrame getFrame() {
		return this.frame;
	}
	
	/**
	 * An abstract method used across all children of ParentPanel, intended for the declaration and initialization of all the JComponents in the
	 * JPanel. This method should use the addComponent method of ParentPanel to add the initialized JComponents to the HashMap componentMap,
	 * with corresponding String IDs to be used as the keys.
	 */
	public abstract void setupComponents();
	
	/**
	 * An abstract method used across all children of ParentPanel, intended for the assignment of JComponents to GroupLayout's horizontal and
	 * vertical groups. This method should use the returnComponent method of ParentPanel to obtain JComponents. setupLayout should also be
	 * used to define any gaps or spacing within the layout.
	 */
	public abstract void setupLayout();
	
	/**
	 * An abstract method used across all children of ParentPanel, intended for assigning ActionListeners to the JPanel's JComponents. JButtons
	 * intended for swapping JPanels in and out of visibility within the program frame will likely find MainFrame's methods to be useful. This
	 * instance can be obtained using ParentPanel's getFrame(). This method should use the returnComponent method of ParentPanel to obtain 
	 * JComponents.
	 */
	public abstract void setupListeners();
}
