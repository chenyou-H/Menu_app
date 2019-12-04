import javax.swing.SwingUtilities;

public class runGUI {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Login();
			}
		});
	}
}
