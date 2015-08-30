import java.util.Arrays;

public class MethodTester {

	public static void main(String[] args) {
		//System.out.println((int)(Math.random()*15+1));
		for(int[] lol:MethodUtils.generateMap(3,2,2,0,0)){
			System.out.print(Arrays.toString(lol));
		}
	}

}
