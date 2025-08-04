import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.Set;


public class MainWindow {
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static byte movementPerTick = 10;
    public static short playerLocationX = 1250;
    public static short playerLocationY = 520;
    public static short playerHeight = 50;
    public static short playerWidth = 50;

    // Set to track currently pressed keys
    private static Set<Integer> pressedKeys = new HashSet<>();

    public static void window() {
        String loadPlayerImagePath = "C:\\Users\\Sasha Mattison\\Documents\\RTRT.Engine\\PlayerSprite.png";
        String loadMapImagePath = "C:\\Users\\Sasha Mattison\\Documents\\DungeonCrawler-main\\DungeonCrawler\\pixil-frame-0.png";
        JFrame frame = new JFrame();
        frame.setLayout(null);

        ImageIcon playerSprite = new ImageIcon(loadPlayerImagePath);
        ImageIcon mapSprite = new ImageIcon(loadMapImagePath);
        JLabel playerSpriteDraw = new JLabel(playerSprite);
        JLabel mapSpriteDraw = new JLabel(mapSprite);
        playerSpriteDraw.setBounds(playerLocationX, playerLocationY, playerWidth, playerHeight);
        mapSpriteDraw.setBounds(0, 0, mapSprite.getIconWidth(), mapSprite.getIconHeight());
        frame.add(playerSpriteDraw);

        // Basic window setup
        frame.setSize(screenSize);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Mirror.Engine.0");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.requestFocusInWindow();


        // Add KeyListener for input
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                pressedKeys.add(e.getKeyCode());
                updatePlayerPosition(playerSpriteDraw, playerSprite);
            }

            public void keyReleased(KeyEvent e) {
                pressedKeys.remove(e.getKeyCode());
                updatePlayerPosition(playerSpriteDraw, playerSprite);
            }
        });

        frame.setVisible(true);
    }

    private static void updatePlayerPosition(JLabel playerSpriteDraw, ImageIcon playerSprite) {
        // Calculate movement vector based on pressed keys
        int deltaX = 0;
        int deltaY = 0;

        // Check horizontal movement (A and D can cancel each other out)
        if (pressedKeys.contains(KeyEvent.VK_D)) {
            deltaX += 1;
        }
        if (pressedKeys.contains(KeyEvent.VK_A)) {
            deltaX -= 1;
        }

        // Check vertical movement (W and S can cancel each other out)
        if (pressedKeys.contains(KeyEvent.VK_W)) {
            deltaY -= 1;
        }
        if (pressedKeys.contains(KeyEvent.VK_S)) {
            deltaY += 1;
        }

        // If moving diagonally, normalize the movement to maintain consistent speed
        if (deltaX != 0 && deltaY != 0) {
            // For diagonal movement, divide by sqrt(2) to maintain the same speed
            double normalizedMovement = movementPerTick / Math.sqrt(2);
            playerLocationX += (int)(deltaX * normalizedMovement);
            playerLocationY += (int)(deltaY * normalizedMovement);
        } else {
            // For cardinal directions, use full movement speed
            playerLocationX += deltaX * movementPerTick;
            playerLocationY += deltaY * movementPerTick;
        }

        // Update the sprite position
        if (playerLocationX>900) {
            playerSpriteDraw.setBounds(playerLocationX, playerLocationY,
                    playerWidth, playerHeight);
        }
        else {
            playerLocationX=900;
        }

        if (playerLocationX<1780) {
            playerSpriteDraw.setBounds(playerLocationX, playerLocationY,
                    playerWidth, playerHeight);
        }
        else {
            playerLocationX=1780;
        }

        if (playerLocationY>=0) {
            playerSpriteDraw.setBounds(playerLocationX, playerLocationY,
                    playerWidth, playerHeight);
        }
        else {
            playerLocationY=0;
        }

        if (playerLocationY<=1040) {
            playerSpriteDraw.setBounds(playerLocationX, playerLocationY,
                    playerWidth, playerHeight);
        }
        else {
            playerLocationY=1040;
        }

        // Debug output
        if (deltaX != 0 || deltaY != 0) {
            System.out.println("Movement: deltaX=" + deltaX + ", deltaY=" + deltaY +
                    ", Position: (" + playerLocationX + ", " + playerLocationY + ")");
        }
    }
}