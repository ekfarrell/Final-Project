//Imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class Main {
    
    //sets the fps
    int fps = 60;
    //sets the width and height of the frame
    int gameWidth = 1200, gameHeight = 900;
    
    //Objects
    JFrame frame;
    InputHandler handler;
    
    //graphics for the page and graphics for the bufered image
    Graphics g2;
    Graphics g;
    //prevents the flickering
    BufferedImage i;
    
    //position of the shape
    int x = 500, y = 500;
    //radius/length of shape
    int shapeLength = 50;
    int degrees = 0;
    
    Player player1;
    
    
    //Main method runs the constructor
    public static void main(String[] args) {
        new Main();
    }
    /**
     * Main method for the constructor which runs the run method to start the game
     */
    public Main() {
        run();
        //cleanup
        System.exit(-1);
    }
    
    void init(){
        //initializes the frame
        //The string inside is the name of the frame
        frame = new JFrame("Game");
        //sets the size of the frame to a new dimension with attributes height and width
        frame.setSize(new Dimension(gameWidth,gameHeight));
        //Setting frame,setLocationRelativeTo = null makes frame in the center of your screen
        frame.setLocationRelativeTo(null);
        //Makes it so when you close the window the program stops
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the frame so you can see it
        frame.setVisible(true);
        
        //Objects
        handler = new InputHandler(frame);
        
        //Graphics stuff
        //Makes a new BufferedImage to draw on so everything can go on the frame at once
        //prevents flickering
        i = new BufferedImage(gameWidth,gameHeight,BufferedImage.TYPE_INT_RGB);
        //sets g to be the graphics of the buffered image
        g = i.getGraphics();
        //sets g2 to be the graphics of the frame
        g2 = frame.getGraphics();
       
    }
    /**
     * Runs the program in a continuous loop by running init and then using a while ture loop
     */
    void run(){
        init();
         
        //Make the game run until the window is closed
        while(true){
            //gets the current time
            long time = System.currentTimeMillis();
            
            //makes it so it keeps executing update draw, update draw,...
            update();
            draw();
            
            //this makes it so it runs at 60 fps
            time = (1000/fps) - (System.currentTimeMillis() - time);
            
            //makes sure the time is a valid time
            if(time > 0){
                try{
                    Thread.sleep(time);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                
            }
        }
    }
    
    
    /**
     * Changes the coordinates of the shape based on input
     */
    void update(){
        //if arrow key is pressed it modifies x and y respectively
        if(handler.isKeyDown(KeyEvent.VK_RIGHT))
        {
            degrees+=4;
             //player1.setVelX(2);
              
        }
        if(handler.isKeyDown(KeyEvent.VK_LEFT))
        {
            degrees-=4;
             //player1.setVelX(-2);
              
        }
        if(handler.isKeyDown(KeyEvent.VK_UP))
        {
            // y-= Math.sin(Math.toRadians((degrees+90)*-1));
           // x+= Math.cos(Math.toRadians((degrees+90)*-1));
          //player1.setVelY(-2);
           x += Math.cos(Math.toRadians((degrees-120)*-1)) *  5 + Math.sin(Math.toRadians((degrees-120)*-1)) * 5;
           y -= -Math.cos(Math.toRadians((degrees-120)*-1)) * 5 + Math.sin(Math.toRadians((degrees-120)*-1)) * 5;
           if(x<15)
                x = 15;
           if(x>gameWidth)
                x = gameWidth;
           if(y<30)
                y = 30;
           if(y>gameWidth)
                y = gameHeight;
           
           
        }
        if(handler.isKeyDown(KeyEvent.VK_DOWN))
        {
           // y+= Math.sin(Math.toRadians((degrees+90)*-1));
            // x-= Math.cos(Math.toRadians((degrees+90)*-1));
           //player1.setVelY(2);
           x -= Math.cos(Math.toRadians((degrees-120)*-1)) *  5 + Math.sin(Math.toRadians((degrees-120)*-1)) * 5;
           y += -Math.cos(Math.toRadians((degrees-120)*-1)) * 5 + Math.sin(Math.toRadians((degrees-120)*-1)) * 5;
            if(x<15)
                x = 15;
           if(x>gameWidth)
                x = gameWidth;
           if(y<30)
                y = 30;
           if(y>gameWidth)
                y = gameHeight;
        }
        if(handler.isMouseDown(1)){
            x = handler.getEvent(1).getX() - shapeLength/2;
            y = handler.getEvent(1).getY() - shapeLength/2;
        }
        if(handler.isKeyDown(KeyEvent.VK_ESCAPE))
        {
            System.exit(-1);
        }
        
    }
    /**
     * Draws the shapes onto the image
     */
    void draw(){ 
       player1 = new Player(x,y,degrees,ID.Player);
        //sets color to black and draws it to the size of the frame on the buffered image
        
        g.setColor(Color.black);
        g.fillRect(0, 0, gameWidth, gameHeight);
        Graphics2D g2d = (Graphics2D)g;
       
        player1.render(g);
       
        //things you draw after here will not be rotated
        //makes a cyan oval and draws it on the page at coordinates x and y on the buffered image
       // g.setColor(Color.cyan);
       // g.fillOval(x, y, shapeLength, shapeLength);
        
        //draws the buffered image onto the frame
        g2.drawImage(i/* this is the image that get's drawn*/, 0, 0, frame);
        
    
    }
}
