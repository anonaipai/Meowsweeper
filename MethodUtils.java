import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class MethodUtils {
	public static BufferedImage getImage(String s) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("\\src\\img" + s + ".png"));
		} catch (IOException e) {

		}
		return img;
	}

	public static int picValue(int xCoord, int yCoord) {
		return -1;
	}

	public static boolean[][] generateMap(int mines, int width, int height) {
		boolean[][] meowfield = new boolean[height][width];
		int[] RNGesus = new int[mines];
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
			meowfield[RNGesus[i] %width][RNGesus[i]/height] = true;
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
