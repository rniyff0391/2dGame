import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;

public class GameEngine extends JComponent implements KeyListener, MouseListener, MouseMotionListener
{
    //instance variables
    private int WIDTH;
    private int HEIGHT;
    private Player player;
    private ArrayList<Ball> eBalls;
    
    private boolean gameOver;

    public GameEngine()
    {
        gameOver = false;
        WIDTH = 900; //x
        HEIGHT = 500; //y
        player = new Player(75, 200, 25,25, Color.CYAN);
       eBalls = new ArrayList<Ball>();
        int y = (int) (Math.random() * 500); //?????
        Random rand = new Random();
        int yy = rand.nextInt(500);
        
        for(int i = 0; i < 5; i++)
        {                                                                                     
            eBalls.add(new Ball(10000, (int)(Math.random() * 480), 25,(int)(Math.random() *6) + 25,  new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)))); //why doesnt it work with y but works when in the loop
            //tried making it so that if 2 or more balls spawn in the same y-position, they change but it doesnt seem to work
            if(eBalls.get(i).getY() == (int) (Math.random() * 480))
            {
              eBalls.get(i).setY((int)(Math.random() * 400));
            }
        }
        
        
        //Setting up the GUI
        JFrame gui = new JFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Dodge Ball Rampage");
        gui.setPreferredSize(new Dimension(WIDTH + 5, HEIGHT + 30));
        gui.setResizable(true);
        gui.getContentPane().add(this);
        
        gui.pack();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
       
    }
    
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        if(key == 87)
        {
            player.moveUp();
        }
        if(key == 83)
        {
            player.moveDown();
        }
    }

    
    
    public void keyTyped(KeyEvent e) 
    {
    }
    
    
    public void paintComponent(Graphics g)
    {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 900, 500);

        player.drawSelf(g);


        for(Ball eB : eBalls)
        {
           eB.drawSelf(g);
        }
          g.setFont(new Font("Futura Bold", Font.PLAIN, 20));
          g.setColor(Color.WHITE);
          g.drawString("Score: " + eBalls.get(1).getScore(), 0, 20);
        
        if(gameOver == true)
        {
            //basket.stop();
            g.setFont(new Font("BOLD", Font.BOLD, 75));
            g.setColor(Color.RED);
            g.drawString("Game Over!", 250, 250);   
        }  
    }
    
    public void loop()
    {          
        if(gameOver == false)
        { 
            for(Ball dtc : eBalls)
            {
                if(dtc.detectCollision(player) == true)
            {
                gameOver = true;
                player.stop();
                //stopping every ball in the arraylist
                for(Ball stopped : eBalls)
                {
                    stopped.stop();
                }
            }
            }
            
            player.act(WIDTH, HEIGHT);

            for(Ball evil : eBalls)
            {
                evil.act(WIDTH, HEIGHT, player);
            }
            
        }
        repaint();
    }
    public void mousePressed(MouseEvent e)
    {
    }
    public void mouseReleased(MouseEvent e)
    {
    }
    public void mouseClicked(MouseEvent e)
    {
    }
    public void mouseDragged(MouseEvent e)
    {
    }
    public void start(final int ticks){
        Thread gameThread = new Thread(){
            public void run(){
                while(true)
                {   
                    loop();
                    try{
                        Thread.sleep(1000 / ticks);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };	
        gameThread.start();
    }
    
