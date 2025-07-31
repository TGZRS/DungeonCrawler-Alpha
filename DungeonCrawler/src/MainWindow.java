// This part is under construction!


/*

import javax.swing.*;
import java.awt.*;

public class MainWindow {

    public static double releaseVersion = 0.0;

    public static void main(String[] args) {
        //Variables
        //---------------------------------------------//


        //---------------------------------------------//

        //Initialize Window
        //---------------------------------------------//
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Dungeon Crawler Main Release " + releaseVersion);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setBackground(Color.BLACK);
        frame.getContentPane().setBackground(Color.BLACK);

        //---------------------------------------------//

        //Adding Labels, TextFields, and Buttons
        //---------------------------------------------//
        JLabel playerGoldLabel = new JLabel();
        playerGoldLabel.setBounds(25, -30, 100, 100);
        playerGoldLabel.setForeground(Color.WHITE);
        playerGoldLabel.setText("Enter your name: ");
        playerGoldLabel.setVisible(true);
        frame.add(playerGoldLabel);

        JTextField textField = new JTextField();
        textField.setBounds(25, 30, 100, 150); // x, y, width, height
        textField.setBackground(Color.DARK_GRAY);
        textField.setForeground(Color.WHITE);
        frame.add(textField);

        JButton printPlayerName = new JButton("Submit");
        printPlayerName.setBounds(25, 200, 120, 30);
        printPlayerName.setBackground(Color.DARK_GRAY);
        printPlayerName.setForeground(Color.WHITE);
        printPlayerName.addActionListener(e -> {

            Config.playerName = textField.getText().strip();
            System.out.println(Config.playerName); //DEBUG

            JLabel playerStatsName = new JLabel();
            playerStatsName.setText(Config.playerName + " Stats Are:");
            playerStatsName.setBounds(150, 0, 200, 50);
            playerStatsName.setForeground(Color.WHITE);
            frame.add(playerStatsName);

            JLabel playerStatsAttack = new JLabel();
            playerStatsAttack.setText("Attack: " + Config.playerAttack);
            playerStatsAttack.setBounds(150, 20, 200, 50);
            playerStatsAttack.setForeground(Color.WHITE);
            frame.add(playerStatsAttack);

            JLabel playerStatsHealth = new JLabel();
            playerStatsHealth.setText("Health: " + Config.playerHealth);
            playerStatsHealth.setBounds(150, 40, 200, 50);
            playerStatsHealth.setForeground(Color.WHITE);
            frame.add(playerStatsHealth);

            //frame.remove(printPlayerName);
            frame.revalidate();
            frame.repaint();
                });

        frame.add(printPlayerName);

        //---------------------------------------------//


        //---------------------------------------------//
        frame.setVisible(true);
    }

}


 */