import javax.swing.*;
class Ref2{
	Ref2(){
		JFrame jfrm=new JFrame("A Simple Swing Application");
		jfrm.setSize(275, 100);
		jfrm.setVisible(true);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel jlab=new JLabel("Swing means powerful GUIs");
		jfrm.add(jlab);
	}
}

public class Ref1{
	public static void main(String args[]){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new Ref2();
			}
		});
	}
}
