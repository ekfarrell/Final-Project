/*
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas {

	private static final long serialVersionUID = -8255319694373975038L;
	public JFrame frame;
	public Window(int width, int height, String title, Game game){
		//Makes the new frame and sets the title to title
		JFrame frame = new JFrame(title);
		//sets the dimensions of the frame to start along with the maximum and minimum
		//so it cannot be changed
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width, height));
		
		//Makes it so the game stops running when you close the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Makes it so the frame is not resizable
		frame.setResizable(false);
		//Makes the frame start in the middle of the screen
		//remove the line to make it start in the top left corner of the screen
		frame.setLocationRelativeTo(null);
		//adding game class into the frame
		frame.add(game);
		//makes it so you can see the frame
		frame.setVisible(true);
		//runs the method in game that starts the game
		game.start();
	
	}
	JFrame getFrame(){
	   return frame;
	   }
	
	
	
	
}
*/