import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonHandler extends KeyAdapter {
	public ButtonHandler() {

	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent key) {
		actionPerformed(key);
	}

	public void keyPressed(KeyEvent key) {
		actionPerformed(key);
	}

	public void actionPerformed(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_UP:
			Stuff.charater.setUp(false);
			break;
		case KeyEvent.VK_LEFT:
			Stuff.charater.setLeft(false);
			break;
		case KeyEvent.VK_DOWN:
			Stuff.charater.setDown(false);
			break;
		case KeyEvent.VK_RIGHT:
			Stuff.charater.setRight(false);
			break;
		case KeyEvent.VK_S:
			Stuff.charater.setClick(false);
			break;
		case KeyEvent.VK_D:
			Stuff.charater.setFlag(false);
			break;

		}
	}
}
