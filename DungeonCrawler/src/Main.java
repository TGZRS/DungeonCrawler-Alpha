
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        short roomInstanceCount = 1;
        String playerInput;

        System.out.print("Enter Player Name: ");
        Config.playerName = scanner.next();
        System.out.println(Config.playerName + " stats: \n" + "Gold: " + Config.playerGold + "\nAttack: " + Config.playerAttack + "\nHealth: " + Config.playerHealth + "\n\n");
        System.out.println("Controls: \ny = yes \nn = no \ns = show stats \nh = heal \n");

        while (Config.playerHealth > 0) {

            System.out.print("Enter Room " + roomInstanceCount + "? \n");
            playerInput = scanner.next();
            playerInput = playerInput.toLowerCase();

            switch (playerInput) {
                case "y" -> {
                    GameLogic.randomEvent();
                    roomInstanceCount++;
                }
                case "n" -> {
                    System.out.print("Your final gold count is: " + Config.playerGold + "\n");
                    System.exit(0);
                }
                case "s" ->
                        System.out.println(Config.playerName + " stats: \n" + "Gold: " + Config.playerGold + "\nAttack: " + Config.playerAttack + "\nHealth: " + Config.playerHealth + "\n\n");
                case "h" -> {
                    if (Config.playerGold >= 100) {
                        Config.playerHealth += 10;

                        if (Config.playerHealth > Config.maxPLayerHealth) {
                            Config.playerHealth = Config.maxPLayerHealth;
                            Config.playerGold -= 100;
                            System.out.println("You have been healed at the cost of 100 gold");
                            System.out.println("Your Health is " + Config.playerHealth + " and your gold is " + Config.playerGold);
                        }
                        else{
                            Config.playerGold -= 100;
                            System.out.println("You have been healed at the cost of 100 gold");
                            System.out.println("Your Health is " + Config.playerHealth + " and your gold is " + Config.playerGold);
                        }

                    }
                    else {
                        System.out.println("You don't have enough gold. You need " + (100 - Config.playerGold) + " more\n");
                }
            }
            }
        }
        System.out.println("Game Over! (You died)");
        System.out.println("Your final gold count is: " + Config.playerGold);
    }





}
