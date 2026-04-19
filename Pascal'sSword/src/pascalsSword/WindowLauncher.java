package pascalsSword;

import javax.swing.SwingUtilities;

public class WindowLauncher {

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() { //sets it on one thread
			@Override
			public void run() {
				//Window Window = new Window();
				WindowDisplay WinodwDisplay = new WindowDisplay();
			}
		});

	}

}
