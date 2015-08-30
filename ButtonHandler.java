import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonHandler extends KeyAdapter {
	public ButtonHandler() {

	}

	public void keyTyped(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent key) {
		actionPerformed(key, false);
	}

	public void keyPressed(KeyEvent key) {
		actionPerformed(key, true);
	}

	public void actionPerformed(KeyEvent key, boolean Value) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_UP:
			Stuff.charater.setUp(Value);
			break;
		case KeyEvent.VK_LEFT:
			Stuff.charater.setLeft(Value);
			break;
		case KeyEvent.VK_DOWN:
			Stuff.charater.setDown(Value);
			break;
		case KeyEvent.VK_RIGHT:
			Stuff.charater.setRight(Value);
			break;
		case KeyEvent.VK_S:
			Stuff.charater.setClick(Value);
			break;
		case KeyEvent.VK_D:
			Stuff.charater.setFlag(Value);
			break;

		}
	}
}
