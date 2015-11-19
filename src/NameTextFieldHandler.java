import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class NameTextFieldHandler implements ActionListener {
	private TodoWindow _callingWindow;
	
	// let's try passing a reference to ExampleWindow class to modify a component
	public NameTextFieldHandler(TodoWindow callingWindow){
		this._callingWindow = callingWindow;
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		this._callingWindow.getHelloLabel().setText("You Pressed Enter");
		
	}

}
