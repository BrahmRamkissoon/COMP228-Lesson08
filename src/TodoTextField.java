import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextField;
// Custom TextField Class
public class TodoTextField extends JTextField {

	public TodoTextField(JPanel todoPanel) {

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.insets = new Insets(0, 0, 5, 0);
		constraints.gridx = 0;
		constraints.gridy = 0;
		todoPanel.add(this, constraints);
		this.setColumns(10);
	}

}
