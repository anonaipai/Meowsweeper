import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class MethodUtils {
	
	public static void renderMap(Graphics2D g, int[][] map) {
		Stuff.currentMap = map;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				g.drawImage(MethodUtils.getImage("" + map[i][j]), j * Stuff.tileSize, i * Stuff.tileSize, null);

			}
		}
	}

	public static void renderTile(Graphics2D g, int tileID, int xCoord, int yCoord) {
		g.drawImage(MethodUtils.getImage("" + tileID), xCoord, yCoord, null);
	}

	public static int[][] getMap(int mapNumber) throws IOException {
		Scanner mapReader = new Scanner(new File("maps"));
		for (int n = 0; n < mapNumber * 12 * 16; n++) {
			mapReader.nextInt();
		}
		int[][] tempArray = new int[12][16];
		for (int i = 0; i < tempArray.length; i++) {
			for (int j = 0; j < tempArray[0].length; j++) {
				tempArray[i][j] = mapReader.nextInt();
			}
		}
		mapReader.close();
		return tempArray;
	}
	public static BufferedImage getImage(String s) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("src\\img\\" + s + ".png"));
		} catch (IOException e) {
			System.out.println("The file at src\\img\\"+s+".png");
		}
		return img;
	}

	public static int picValue(int xCoord, int yCoord) {
		return -1;
	}
	//fills in the mines
	public static int[][] generateMap(int mines, int width, int height, int fcX, int fcY) {
		if(mines>width*height-1){
			return null;
		}
		int[][] meowfield = new int[height][width];
		meowfield[fcY][fcX] = (int)Math.random()*10;
		int[] RNGesus = new int[mines];
		for(int i=0; i<meowfield.length;i++){	
			Arrays.fill(meowfield[i], -1);
		}
		Arrays.fill(RNGesus, -1);
		for (int i = 0; i < mines; i++) {
			int ranNum = (int) (Math.random() * width * height);
			System.out.println(ranNum);
			if (!contains(RNGesus, ranNum)) {
				RNGesus[i] = ranNum;
			} else {
				i--;
			}
		}
		System.out.println(Arrays.toString(RNGesus));
		for (int i = 0; i < RNGesus.length; i++) {
			meowfield[RNGesus[i] %width][RNGesus[i]/height] = 10;
		}
		return meowfield;
	}

	private static boolean contains(int[] list, int key) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == key) {
				return true;
			}
		}
		return false;
	}

}
