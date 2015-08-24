
public class Main {
	public static void main(String args[]){
		Draw drawing = new Draw();
		while(true){
			Stuff.charater.update();
			drawing.render();
			try{Thread.sleep(75);}
			catch(InterruptedException e){
				System.err.print("Wow, this text is red");
			}
		}
	}
}
