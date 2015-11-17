import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

/**
 * Start https://youtu.be/IvZMfSR_uP4?list=PL5svY1bZDBZrHNW4_Val5LXh0_MSfxeaO
 * End https://youtu.be/jRE5ouam9kI?list=PL5svY1bZDBZrHNW4_Val5LXh0_MSfxeaO
 * 
 * @author Tom Tsiliopoulos
 * 
 */
// EXAMPLEWINDOW CLASS ++++++++++++++++++++++++++++++++++++++
public class ExampleWindow extends JFrame implements ActionListener {
	// PRIVATE INSTANCE VARIABLES ++++++++++++++++++++++++++++++++++++++
	private JPanel _contentPane; // JPanel Container
	private JLabel _helloLabel; // access to _helloLabel
	private JLabel _nameLabel;
	private JTextField _nameTextField;
	private JButton _goodbyeButton;


	// PUBLIC PROPERTIES ++++++++++++++++++++++++++++++++++++++
	public JLabel getHelloLabel() {
		return this._helloLabel;
	}

	public void setHelloLabel(JLabel helloLabel) {
		this._contentPane.remove(this._helloLabel);
		this._helloLabel = helloLabel;
		this._addHelloLabel();
	}

	// CONSTRUCTOR METHOD ++++++++++++++++++++++++++++++++++++++
	public ExampleWindow() {
		this._initialize();
		this._addUIComponents();
		
		// Register event handlers, where "this" references the entire class and actionPerformed method
		this._nameTextField.addActionListener(this);
		this._goodbyeButton.addActionListener(this);
		
	}

	// PRIVATE METHODS ++++++++++++++++++++++++++++++++++++++
	private void _initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		this._contentPane = new JPanel();
		this._contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this._contentPane);

	}

	private void _addHelloLabel() {
		this._helloLabel.setBounds(5, 6, 225, 23);
		this._contentPane.add(this._helloLabel);
	}

	private void _addUIComponents() {
		// Use Absolute Layout
		this._contentPane.setLayout(null);

		// Hello Label
		this._helloLabel = new JLabel("New label");
		this._addHelloLabel();

		// Name Label
		this._nameLabel = new JLabel("Enter Name:");
		this._nameLabel.setBounds(5, 41, 96, 23);
		this._nameLabel.setVerticalAlignment(SwingConstants.TOP);
		this._contentPane.add(_nameLabel);

		// Name Text Field
		this._nameTextField = new JTextField();
		this._nameTextField.setBounds(99, 35, 131, 29);
		this._contentPane.add(_nameTextField);
		
		// Goodbye Button
		this._goodbyeButton = new JButton("Click Me!");
		this._goodbyeButton.setBounds(109, 75, 121, 23);
		_contentPane.add(this._goodbyeButton);
	}
	
	
	
	// THIRD METHOD OF HANDLING EVENTS, less control but easier access to variables?
	// implements ActionListener interface and add methods
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == this._nameTextField){
		this._helloLabel.setText("nameTextField - Enter Pressed");
		}
		
		if(event.getSource() == this._goodbyeButton){
			this._helloLabel.setText("goodbyeButton - clicked");
		}
	}
}
