import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Draw{
	Image charater;
	
	JFrame frame;
	Canvas canvas;
	BufferStrategy bufferStrategy;
	
	private int WIDTH = 640;
	private int HEIGTH = 480;
	public Draw(){
		
		charater = MethodUtils.getImage("charater");
		frame = new JFrame("MineSweeper");
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(new Dimension(WIDTH,HEIGTH));
		panel.setLayout(null);
		
		canvas = new Canvas();
		canvas.setBounds(0,0,WIDTH, HEIGTH);
		canvas.setIgnoreRepaint(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		
		panel.add(canvas);
		canvas.createBufferStrategy(2);
		bufferStrategy = canvas.getBufferStrategy();
		
		canvas.requestFocus();
		canvas.setBackground(Color.WHITE);
		canvas.addKeyListener(new ButtonHandler());		
	}
	public void render() {
		// TODO Auto-generated method stub
		
	}
}
