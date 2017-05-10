/*import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Game extends Canvas implements Runnable {
    
    
    //auto generated serialversionId
    private static final long serialVersionUID = -8618401325038452386L;
    //sets the height and the width of the frame we are creating
    private final int WIDTH = 1000;
    //makes the Height a 12 by 9 aspect ratios but can change for other ratios
    private final int HEIGHT = WIDTH / 12 * 9;
    
    private Thread thread;
    //Is used for the game loop
    private boolean isRunning = false;
    private Handler handler;
    private Random r;
    private InputHandler controls = new InputHandler(this);
    int x = 300;
    int y = 300;
    Player player1 = new Player(x,y,ID.Player);
    public Game(){
        new Window(WIDTH, HEIGHT, "ASTEROIDS", this);
        handler = new Handler();
        r = new Random();
        handler.addObject(player1);
        
    }
    
    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        //turns the boolean to true so the game loop can run
        isRunning = true;
    }
    
    public synchronized void stop(){
        try{
            thread.join();
            isRunning = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(isRunning){
            long now = System.nanoTime();
            delta += (now-lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(isRunning)
                render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    
    private void tick(){
        if(controls.isKeyDown(KeyEvent.VK_RIGHT))
		{
			x+= player1.setVelX(5);
		}
		if(controls.isKeyDown(KeyEvent.VK_LEFT))
		{
			x-= player1.setVelX(5);
		}
		if(controls.isKeyDown(KeyEvent.VK_UP))
		{
			y-= player1.setVelX(5);
		}
		if(controls.isKeyDown(KeyEvent.VK_DOWN))
		{
			y+= player1.setVelY(5);
		}
        handler.tick();
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        handler.render(g);
        
        g.dispose();
        bs.show();
    }
    
    public static void main(String[] args) {
        new Game();
    }
    
}
*/