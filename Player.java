import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

}
