import java.util.Scanner;

public class GameLogic {

    public static Scanner scanner = new Scanner(System.in);

    public static void chest() {
        if (Math.random() > 0.8) {
            short playerAttackIncrease = (short)(Math.random() * 15);
            byte playerHealthIncrease = (byte)(Math.random() * 25);
            Config.playerAttack += playerAttackIncrease;
            Config.playerHealth += playerHealthIncrease;
            Config.maxPLayerHealth += playerHealthIncrease;
            System.out.println("You found a rare reward!\n" + "it increased your attack by " + playerAttackIncrease + " and your health by " + playerHealthIncrease);
        }

        byte goldReceivedChest = (byte) (Math.random() * 100);
        Config.playerGold += goldReceivedChest;
        System.out.println("You found a Chest!\n" + "You now have " + Config.playerGold + " gold\n");
    }

    public static void randomEvent() {
        byte randomNumber = (byte) Math.ceil((Math.random() * 2));
        switch (randomNumber) {
            case 1:
                chest();
                break;
            case 2:
                encounter();
                break;
        }
    }

    public static void encounter() {
        String playerInput;
        byte monsterHealth = (byte)(Math.random() * 50);
        byte monsterDamage = (byte)(Math.random() * 10);
        byte playerDamageDone;
        short goldReceived;

        label:
        while (monsterHealth > 0) {
            System.out.print("\nYou encounter a Monster with " + monsterHealth + " health\n" + "\nDo you attack? ");
            playerInput = scanner.next();
            playerInput = playerInput.toLowerCase();
            playerInput = playerInput.strip();

            switch (playerInput) {
                case "y":
                    playerDamageDone = (byte) (Math.random() * Config.playerAttack * 2);
                    monsterHealth -= playerDamageDone;
                    if (monsterHealth > 0) {
                        Config.playerHealth -= monsterDamage;
                    }
                    if (Config.playerHealth < 0) {
                        Config.playerHealth = 0;
                    }
                    System.out.println("\nYou did " + playerDamageDone + " damage" + " and now have " + Config.playerHealth + " Health");
                    if (Config.playerHealth <= 0) {
                        System.out.println("Game Over! (You died)");
                        System.out.println("Your final gold count is: " + Config.playerGold + " gold");
                        System.exit(0);
                    }
                    break;
                case "n":
                    System.out.println("You ran away...\n");
                    break label;
                case "s":
                    System.out.println("\n" + Config.playerName + " stats: \n\n" + "Gold: " + Config.playerGold + "\nAttack: " + Config.playerAttack + "\nHealth: " + Config.playerHealth + "\n\n");
                    break;
            }
        }

        if (monsterHealth <= 0) {
            goldReceived = (short)(Math.random() * 200);
            System.out.println("You beat the monster! Your reward is: " + goldReceived + " gold\n");
            Config.playerGold += goldReceived;
        }

    }

}
