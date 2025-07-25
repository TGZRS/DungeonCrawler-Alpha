import java.util.Scanner;


public class Main {

    public static int playerGold = 0;
    public static byte playerAttack = 10;
    public static byte playerHealth = 100;
    public static Scanner scanner = new Scanner(System.in);
    public static String playerName;

    public static void main(String[] args) {
        byte roomInstanceCount = 1;
        boolean enterRoomBool = false;
        String playerInput;

        System.out.print("Enter Player Name: ");
        playerName = scanner.next();
        System.out.println(playerName + " stats: \n" + "Gold: " + playerGold + "\nAttack: " + playerAttack + "\nHealth: " + playerHealth + "\n\n");
        System.out.println("Controls: \ny = yes \nn = no \ns = show stats \nh = heal \n");

        while (playerHealth > 0) {

            System.out.print("Enter Room " + roomInstanceCount + "? \n");
            playerInput = scanner.next();
            playerInput = playerInput.toLowerCase();

            if (playerInput.equals("y")) {
                randomEvent();
                roomInstanceCount++;
            } else if (playerInput.equals("n")) {
                System.out.print("Your final gold count is: " + playerGold + "\n");
                System.exit(0);
            } else if (playerInput.equals("s")) {
                System.out.println(playerName + " stats: \n" + "Gold: " + playerGold + "\nAttack: " + playerAttack + "\nHealth: " + playerHealth + "\n\n");
            } else if (playerInput.equals("h")) {
                if (playerGold >= 100) {
                    playerHealth += 10;
                    if (playerHealth > 100) ;
                    playerHealth = 100;
                    playerGold -= 100;
                    System.out.println("You have been healed at the cost of 100 gold");
                    System.out.println("Your Health is " + playerHealth + " and your gold is " + playerGold);
                }
                else {
                    System.out.println("You don't have enough gold. You need " + (100 - playerGold) + " more\n");
                    continue;
                }
            }
        }
        System.out.println("Game Over! (You died)");
        System.out.println("Your final gold count is: " + playerGold);
    }
    public static void encounter() {
        String playerInput;
        byte monsterHealth = (byte)(Math.random() * 50);
        byte monsterDamage = (byte)(Math.random() * 10);
        byte playerDamageDone;
        int goldRecieved;

        while (monsterHealth > 0) {
            System.out.print("\nYou encounter a Monster with " + monsterHealth + " health\n" + "\nDo you attack? ");
            playerInput = scanner.next();
            playerInput = playerInput.toLowerCase();

            if (playerInput.equals("y")) {
                playerDamageDone = (byte)(Math.random() * playerAttack * 2);;
                monsterHealth -= playerDamageDone;
                playerHealth -= monsterDamage;
                if (playerHealth < 0) {
                    playerHealth = 0;
                }
                System.out.println("\nYou did " + playerDamageDone + " damage" + " and now have " + playerHealth + " Health");
                if (playerHealth <= 0) {
                    System.out.println("Game Over! (You died)");
                    System.out.println("Your final gold count is: " + playerGold + " gold");
                    System.exit(0);
                }
            }
            else if (playerInput.equals("n")) {
                System.out.println("You ran away...\n");
                break;
            }
            else if (playerInput.equals("s")) {
                System.out.println("\n" + playerName + " stats: \n\n" + "Gold: " + playerGold + "\nAttack: " + playerAttack + "\nHealth: " + playerHealth + "\n\n");
            }
        }

        if (monsterHealth <= 0) {
            goldRecieved = (byte)(Math.random() * 200);
            System.out.println("You beat the monster! Your reward is: " + goldRecieved + " gold\n");
            playerGold += goldRecieved;
        }

    }

    public static void randomEvent() {
        byte randomNumber = (byte) Math.ceil((Math.random() * 3));
        switch (randomNumber) {
            case 1:
                chest();
                break;
            case 2,3:
                encounter();
                break;
        }
    }

    public static void chest() {
        byte goldRecievedChest = (byte)(Math.random() * 100);
        playerGold += goldRecievedChest;
        System.out.println("You now have " + playerGold + " gold\n");
    }

}

