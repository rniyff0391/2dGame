import java.awt.Graphics;
import java.awt.Color;

public class Ball 
{
    //instance variables
    private int xCoord;
    private int yCoord;
    private int diameter;
    private int vX;
    private int vY;
    private Color color;
    private Player basket1;
    
    private int score;

    //Constructor
    public Ball(int x, int y, int diam, int speed, Color col)
    {
        score = 0;
        xCoord = x;
        yCoord = y;
        diameter = diam;
        this.vX = speed;
        this.vY = 4;
        color = col;
       basket1 = new Player(100, 200, 25, 25, Color.CYAN);
    }
    //toString method just incase
    public String toString()
    { 
        return "the location of the Ball is " + xCoord + yCoord;
    }
    
    //Accessor(Getters)/Mutator(Setter) Methods
    public int getX()
    {
        return xCoord;
    }
    public int getY()
    {
        return yCoord;
    }
    public int getDiam()
    {
        return diameter;
    }
    public int getCenterX()
    {
        return xCoord + diameter/2;
    }
    public int getCenterY()
    {
        return yCoord + diameter/2;
    }
    public void setX(int x)
    {
        xCoord = x;
    }
    public void setY(int y)
    {
        yCoord = y;
    }
    public void setVx(int vx)
    {
        vX = vx;
    }
    
    //stop method for collision of evilBall
    public void stop()
    {
        vX = 0;
    }
    //getScore() method
    public int getScore()
    {
        return score;
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
    //detect collision method
    public boolean detectCollision(Player basket1)
    {
        boolean detected = false;

        int radius = diameter/2;

        int nextX;
        int nextY;
        nextX = xCoord + vX;
        nextY = yCoord + vY;

        int centerX = nextX + diameter/2;
        int centerY = nextY + diameter/2;

        for(int i = basket1.getX(); i <= basket1.getX() + basket1.getWidth(); i++)
        {
            for(int j = basket1.getY(); j <= basket1.getY() + basket1.getHeight(); j++)
            {
                if(distance(i, j, centerX, centerY) <= radius)
                {
                    detected = true;
                }
            }
        }
        return detected;
    }
    //Act method
    public void act(int w, int h, Player b1)
    {
        xCoord -=vX; 
        //this if resets the balls back to the right of the window once they leave it, or once they go past the left side of the window
        if (xCoord <- diameter) 
        {
            score++;
            xCoord = w + diameter;  
            yCoord = (int) (Math.random() * h); //once wrapped around, it will generate a new y position for the ball  
        } 
    }
    //draw method
    public void drawSelf(Graphics g)
    {
        g.setColor(color);
        g.fillOval(xCoord, yCoord, diameter, diameter);
    }
}
