import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Draw {
	Image charater;

	JFrame frame;
	Canvas canvas;
	BufferStrategy bufferStrategy;

	private int WIDTH = 640;
	private int HEIGTH = 480;

	public Draw() {

		charater = MethodUtils.getImage("charater");
		frame = new JFrame("MineSweeper");
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setPreferredSize(new Dimension(WIDTH, HEIGTH));
		panel.setLayout(null);

		canvas = new Canvas();
		canvas.setBounds(0, 0, WIDTH, HEIGTH);
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
		
		try {
			Stuff.currentMap = MethodUtils.getMap(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MethodUtils.renderMap((Graphics2D) bufferStrategy.getDrawGraphics(), Stuff.currentMap);

	}
	void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		render(g);
		g.dispose();
		bufferStrategy.show();
	}


	protected void render(Graphics2D g) {
		MethodUtils.renderTile(g, Stuff.previousTile[0], Stuff.previousTile[1], Stuff.previousTile[2]);
		g.drawImage(charater, Stuff.charater.getX(), Stuff.charater.getY(), null);

	}
}
