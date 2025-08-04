
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //MainWindow.window();

        String playerInput;

        System.out.print("Enter Player Name: ");
        Config.playerName = scanner.next();
        System.out.println(Config.playerName + " stats: \n" + "Gold: " + Config.playerGold + "\nAttack: " + Config.playerAttack + "\nHealth: " + Config.playerHealth + "\nRelease Version: " + Config.releaseVersion + "\n\n");
        System.out.println("Controls: \ny = yes \nn = no \ns = show stats\n");

        while (Config.playerHealth > 0) {

            System.out.print("Enter Room " + Config.roomInstanceCount + "? \n");
            playerInput = scanner.next();
            playerInput = playerInput.toLowerCase();

            switch (playerInput) {
                case "y" -> {
                    GameLogic.randomEvent();
                    Config.roomInstanceCount++;
                }
                case "n" -> {
                    System.out.print("You leave the catacombs... \n" + "You exited with " + Config.playerGold + " gold");
                    System.out.println("Your attack was: " + Config.playerAttack);
                    System.exit(0);
                }
                case "s" ->
                        System.out.println(Config.playerName + " stats: \n" + "Gold: " + Config.playerGold + "\nAttack: " + Config.playerAttack + "\nHealth: " + Config.playerHealth + "\n\n");
            }
        }
        System.out.println("Game Over! (You died)");
        System.out.println("You died with " + Config.playerGold + " gold");
        System.out.println("Your attack was: " + Config.playerAttack);
        System.exit(0);
    }




    }
