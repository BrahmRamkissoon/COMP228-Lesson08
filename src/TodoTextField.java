import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextField;
// Custom TextField Class
public class TodoTextField extends JTextField {
	// 	CONSTRUCTOR +++++++++++++++++++++++++++++++++++++++
	public TodoTextField(JPanel todoPanel, int row) {

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 0, 5, 0);
		constraints.gridx = 0;
		constraints.gridy = row;
		todoPanel.add(this, constraints);
		this.setColumns(10);
	}

}
