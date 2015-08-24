import java.awt.Graphics2D;
import java.util.Scanner;

public class TileMap {
	Scanner mapReader;
	public void renderMap(Graphics2D g, int[][] map) {
		Stuff.currentMap = map;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				g.drawImage(MethodUtils.getImage("" + map[i][j]), j * Stuff.tileSize, i * Stuff.tileSize, null);

			}
		}
	}

	public void renderTile(Graphics2D g, int tileID, int xCoord, int yCoord) {
		g.drawImage(MethodUtils.getImage("" + tileID), xCoord, yCoord, null);
	}

	public int[][] getMap(int mapNumber) {
		for (int n = 0; n < mapNumber * 12 * 16; n++) {
			mapReader.nextInt();
		}
		int[][] tempArray = new int[12][16];
		for (int i = 0; i < tempArray.length; i++) {
			for (int j = 0; j < tempArray[0].length; j++) {
				tempArray[i][j] = mapReader.nextInt();
			}
		}
		return tempArray;
	}

}
