//needed import statements
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player 
{
    //instance variables
    private int xCoord; //this represents the x-coordinate of the platform
    private int yCoord; //this represents the x-coordinate of the platform
    private int vX; //this represents the velocity of the platform moving left and right
    private int vY;
    private int WIDTH; //this represents the width of the platform, basically how long it will be
    private int HEIGHT; //this represents the height of the platform, how long/tall it will be
    private Color color; //this will be the color of the platform

    //Constructor
    public Player(int xCoor, int yCoor, int w, int h, Color col)
    {
        xCoord = xCoor;
        yCoord = yCoor;
        WIDTH = w;
        HEIGHT = h;
        color = col;
    }

    //Accessor(Getters)/Mutator(Setter) Methods 
    //Accessor(Getters)
    public int getX()
    {
        return xCoord;
    }
    public int getY()
    {
        return yCoord;
    }
    public int getVx()
    {
        return vX;
    }
    public int getVy()
    {
        return vY;
    }
    public int getWidth()
    {
        return WIDTH;
    }
    public int getHeight()
    {
        return HEIGHT;
    }
    //Setters(Mutators)
    public void setX(int x)
    {
        xCoord = x;
    }
    public void setY(int y)
    {
        yCoord = y;
    }
    public void setWidth(int w)
    {
        WIDTH = w;
    }
    public void setHeight(int h)
    {
        HEIGHT = h;
    }
    public void setVx(int vx)
    {
        vX = vx;
    }
    public void setVy(int vy)
    {
        vY = vy;
    }

    //Movement methods
    //Making the basket move left and right
    public void moveUp()
    {
        vY = -10;
        if(yCoord < 0)
        {
            yCoord = 0;
        }
    }
    public void moveDown()
    {
        vY = 10;
    }
    public void stop()
    {
        vY = 0;
    }

    //distance method
    public double distance(int x1, int y1, int x2, int y2)
    {
        double xDiff = x2-x1;
        double yDiff = y2-y1;
        double powX = Math.pow(xDiff,2);
        double powY = Math.pow(yDiff,2);
        double distance = Math.sqrt(powX + powY);
        
        return distance;
    }
    
    public void act(int w, int h)
    {
        int nextY = yCoord + vY;
        if(nextY + HEIGHT > h)//>0 means that the player hit the ceiling
        {
            vY = 0;
        }
        if(nextY < 0)//<0 means that the player hit the floor
        {
            vY = 0;
        }
        yCoord += vY;

    }

    public void drawSelf(Graphics g)
    {
        g.setColor(color);
        g.fillRect(xCoord, yCoord, WIDTH, HEIGHT);
    } 
}
