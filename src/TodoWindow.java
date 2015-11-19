import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * Start https://youtu.be/IvZMfSR_uP4?list=PL5svY1bZDBZrHNW4_Val5LXh0_MSfxeaO
 * End https://youtu.be/nqf12rNQvkE?list=PL5svY1bZDBZrHNW4_Val5LXh0_MSfxeaO @
 * 39:26
 * 
 * @author Tom Tsiliopoulos
 * 
 */
// EXAMPLEWINDOW CLASS ++++++++++++++++++++++++++++++++++++++
public class TodoWindow extends JFrame implements ActionListener {
	// PRIVATE INSTANCE VARIABLES ++++++++++++++++++++++++++++++++++++++
	private JPanel _contentPane; // JPanel Container
	private JLabel _helloLabel; // access to _helloLabel
	private JLabel _nameLabel;
	private JTextField _nameTextField;
	private JButton _goodbyeButton;
	private JLabel _ageLabel;
	private JTextField _ageTextField;
	private JComboBox _todoComboBox;

	private Border _redLine, _blackLine;
	private JTextField textField;
	private JScrollPane _todoScrollPane;
	private JPanel _todoScrollPanel;
	private JTextField textField_1;

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
	public TodoWindow() {
		this._initialize();
		this._setupBorders();
		this._addUIComponents();

		// Register event handlers, where "this" references the entire class and
		// actionPerformed method
		this._nameTextField.addActionListener(this);
		this._goodbyeButton.addActionListener(this);
		this._ageTextField.addActionListener(this);
		this._todoComboBox.addActionListener(this);

	}

	// PRIVATE METHODS ++++++++++++++++++++++++++++++++++++++
	private void _initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		this._contentPane = new JPanel();
		this._contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(this._contentPane);
	}

	private void _setupBorders() {
		this._blackLine = BorderFactory.createLineBorder(Color.black);
		this._redLine = BorderFactory.createLineBorder(Color.red);
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
		this._nameLabel.setBounds(5, 35, 96, 30);
		this._contentPane.add(_nameLabel);

		// Name Text Field
		this._nameTextField = new JTextField();
		this._nameTextField.setBounds(100, 35, 130, 30);
		this._nameTextField.setBorder(this._blackLine);
		this._contentPane.add(_nameTextField);

		// Goodbye Button
		this._goodbyeButton = new JButton("Click Me!");
		this._goodbyeButton.setBounds(5, 221, 75, 29);
		this._contentPane.add(this._goodbyeButton);

		// Age Label
		this._ageLabel = new JLabel("Enter Age:");
		this._ageLabel.setBounds(5, 80, 96, 30);
		this._contentPane.add(this._ageLabel);

		// Age TextField
		this._ageTextField = new JTextField();
		this._ageTextField.setBounds(99, 80, 130, 29);
		this._ageTextField.setBorder(this._blackLine);
		this._contentPane.add(this._ageTextField);

		// Todo ComboBox
		this._todoComboBox = new JComboBox();
		this._todoComboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		this._todoComboBox.setSelectedIndex(0);
		this._todoComboBox.setBounds(5, 120, 64, 38);
		this._contentPane.add(this._todoComboBox);

		// Container for Todo items
		this._todoScrollPanel = new JPanel();

		// Add ScrollPane to contain our TodoPanel
		this._todoScrollPane = new JScrollPane(this._todoScrollPanel);
		this._todoScrollPane.setBounds(100, 120, 174, 130);
		this._todoScrollPane.setPreferredSize(new Dimension(8, 8));
		this._todoScrollPane.setAutoscrolls(true);

		// Define a GridBagLayout for our use
		GridBagLayout gridBagLayout = new GridBagLayout();

		// Limit the number of textFields to 10
		gridBagLayout.columnWidths = new int[] { 171, 0 };
		gridBagLayout.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30, 30, 30, 30 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };

		// set the todoPanel to the GridBagLayout defined above
		this._todoScrollPanel.setLayout(gridBagLayout);
		this._contentPane.add(this._todoScrollPane);
	}

	// THIRD METHOD OF HANDLING EVENTS, less control but easier access to
	// variables?
	// implements ActionListener interface and add methods
	// recall, all user input is accepted as ... String! add exception handling
	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == this._nameTextField) {
			this._helloLabel.setText(this._nameTextField.getText());
		}

		if (event.getSource() == this._goodbyeButton) {
			this._helloLabel.setText("goodbyeButton - clicked");
		}

		if (event.getSource() == this._ageTextField) {

			try {
				int ageDifference = 46 - Integer.parseInt(this._ageTextField.getText());
				this._helloLabel.setText(Integer.toString(ageDifference));
				this._ageTextField.setBorder(this._blackLine);

			} catch (Exception e) {
				this._helloLabel.setText("Hey, tha's just wrong");
				this._ageTextField.selectAll();
				this._ageTextField.setBorder(this._redLine);
			}
		}

		if (event.getSource() == this._todoComboBox) {
			System.out.println(this._todoComboBox.getSelectedIndex());

			/*
			 * ArrayList<JTextField> textFieldArrayList = new
			 * ArrayList<JTextField>(); for (int index = 0; index <=
			 * this._todoComboBox.getSelectedIndex(); index++) {
			 * textFieldArrayList.add(new JTextField());
			 * textFieldArrayList.get(index).setBounds(100, 80 + (index * 45),
			 * 130, 30); this._contentPane.add(textFieldArrayList.get(index));
			 * 
			 * }
			 */
		}
	}
}
