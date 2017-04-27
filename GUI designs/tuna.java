import java.awt.*;
import javax.swing.*;
public class tuna extends JFrame{
	private JLabel item1;
	public tuna(){
		super("The Title Bar");
		setLayout(new FlowLayout());
		item1 = new JLabel("This is a sentence");
		item1.setToolTipText("This is gonna show up when you hover");
		add(item1);
	}
}
