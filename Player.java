import java.awt.*;
import java.util.*;

public class Player extends GameObject{

    Random r = new Random();
    int[] xArray;
    int[] yArray;
    int velX;
    int velY;
    private InputHandler handler;
    
    public Player(int x, int y, int degrees, ID id) {
        super(x,y,degrees,id);
        xArray = new int[] {x,x+15,x,x-15,x};
        yArray = new int[] {y-15,y+10,y,y+10,y-15};
        
    }
    
    public void tick(){
        x+= velX;
        y+= velY;
    }
    
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillPolygon(xArray, yArray,5);
    }
    
    public void rotate(int degrees){
        int newx = (int)Math.cos(degrees+90)*15;
        int newy = (int)Math.sin(degrees+90)*15;
        
        for(int i = 0; i < this.xArray.length; i++){
           //this.xArray[i] 
        }
    }

}
