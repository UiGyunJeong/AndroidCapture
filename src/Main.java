import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				Gui gui = new Gui();
				gui.setVisible(true);
				
			}
		};
		SwingUtilities.invokeLater(r);
	}

}
