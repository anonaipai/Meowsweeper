import java.awt.image.BufferedImage;

public class Charater {
	private int xCoord, yCoord;
	private boolean left, right, up, down, click, flag;

	public int getX() {
		return xCoord;
	}

	public int getY() {
		return yCoord;
	}

	public void setRight(boolean d) {
		right = d;
	}

	public void setLeft(boolean d) {
		left = d;
	}

	public void setUp(boolean d) {
		up = d;
	}

	public void setDown(boolean d) {
		down = d;
	}

	public void setClick(boolean d) {
		click = d;
	}

	public void setFlag(boolean d) {
		flag = d;
	}

	public void update() {
		move();
	}

	public void move() {
		Stuff.previousTile[0] = Stuff.currentMap[yCoord / Stuff.tileSize][xCoord / Stuff.tileSize];
		Stuff.previousTile[1] = xCoord;
		Stuff.previousTile[2] = yCoord;
		if (left) {
			xCoord -= Stuff.tileSize;
		}
		if (right) {
			xCoord += Stuff.tileSize;
		}
		if (down) {
			yCoord += Stuff.tileSize;
		}
		if (up) {
			yCoord -= Stuff.tileSize;
		}
		if(click){}
		if(flag){}
		if (xCoord < 0)
			xCoord = 600;
		if (xCoord > 600)
			xCoord = 0;
		if (yCoord < 0)
			yCoord = 440;
		if (yCoord > 460)
			yCoord = 0;
		Stuff.currentTile = Stuff.currentMap[yCoord / Stuff.tileSize][xCoord / Stuff.tileSize];

	}

}
