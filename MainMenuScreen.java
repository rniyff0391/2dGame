import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuScreen extends JFrame {
    private JButton startButton;
    private JButton quitButton;
    private JButton restartButton;

    public MainMenuScreen() {
        super("Game"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); 

        
        JLabel nameLabel = new JLabel("<html><body><h1>Game<html><body><h1>Game Instructions</h1><p>Dodge the balls for as long as you can!</h1><p>Press W to move up and S to move down.</p></body></html>");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel.add(nameLabel);

        // Creating a button to start the game
        startButton = new JButton("Play");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                dispose(); 
                GameEngine game = new GameEngine();
                game.start(60);
            }
        });
        panel.add(startButton);

        
        quitButton = new JButton("Quit");
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                dispose(); 
            }
        });
        panel.add(quitButton);

        // Creating a button to restart the game
        restartButton = new JButton("Restart");
        restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        restartButton.setVisible(false);
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                System.out.println("Game Restarted");
                restartButton.setVisible(false); 
            }
        });
        panel.add(restartButton);

        
        getContentPane().add(panel);

        
        

        setVisible(true); 
        setResizable(false);
    }

    public void showRestartButton() {
        restartButton.setVisible(true); 
    }

    public static void main(String[] args) {
        MainMenuScreen menu = new MainMenuScreen();
        
    }
}
