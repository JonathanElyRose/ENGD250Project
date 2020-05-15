import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RotoButton extends JButton implements MouseListener {

	private Border outline1;
	private Border outline2;
	private RotoButton button;
	
	public RotoButton() {
		// TODO Auto-generated constructor stub
		
	}

	public RotoButton(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
		this.setBackground(Color.white);
		this.outline1 = BorderFactory.createLineBorder(Color.yellow, 5);
		this.outline2 = BorderFactory.createLineBorder(Color.red, 5);
		this.button = this;
		this.setBorder(outline1);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button.setBorder(outline2);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button.setBorder(outline1);
			}
		});
	}

	public RotoButton(String text) {
		super(text);
		// TODO Auto-generated constructor stub
		this.setBackground(Color.white);
		this.outline1 = BorderFactory.createLineBorder(Color.yellow, 5);
		this.outline2 = BorderFactory.createLineBorder(Color.red, 5);
		this.button = this;
		this.setBorder(outline1);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button.setBorder(outline2);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button.setBorder(outline1);
			}
		});
	}

	public RotoButton(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
		this.setBackground(Color.white);
		this.outline1 = BorderFactory.createLineBorder(Color.yellow, 5);
		this.outline2 = BorderFactory.createLineBorder(Color.red, 5);
		this.button = this;
		this.setBorder(outline1);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button.setBorder(outline2);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button.setBorder(outline1);
			}
		});
	}

	public RotoButton(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
		this.setBackground(Color.white);
		this.outline1 = BorderFactory.createLineBorder(Color.yellow, 5);
		this.outline2 = BorderFactory.createLineBorder(Color.red, 5);
		this.button = this;
		this.setBorder(outline1);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button.setBorder(outline2);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				button.setBorder(outline1);
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
