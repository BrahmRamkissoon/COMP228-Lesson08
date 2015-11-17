import javax.swing.JLabel;

// DRIVER CLASS +++++++++++++++++++++++++++++++++++
public class Program {

	// MAIN STATIC METHOD ++++++++++++++++++++++++++
	public static void main(String[] args) {
		try {
			// EXAMPLE WINDOWS LIVES AND DIES HERE +++
			ExampleWindow frame = new ExampleWindow();
			frame.setVisible(true);
			
			// example to setvalue of a label part 1/2
			JLabel myLabel = new JLabel("GoodBye!!!");
			
			// get reference to object frame and its property and set text value
			frame.getHelloLabel().setText("Hello World");
			// example to setvalue of a lable part 2/2
			frame.setHelloLabel(myLabel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
