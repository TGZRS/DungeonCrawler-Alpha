import java.util.Scanner;

public class GameLogic {

    public static Scanner scanner = new Scanner(System.in);

    public static void chest() {
        if (Math.random() > 0.8) {
            short playerAttackIncrease = (short)(Math.random() * 15 * Config.difficultyMultiplier);
            byte playerHealthIncrease = (byte)(Math.random() * 25 * Config.difficultyMultiplier);
            Config.playerAttack += playerAttackIncrease;
            Config.maxPlayerHealth += playerHealthIncrease;
            Config.playerHealth += playerHealthIncrease;
            System.out.println("You found a rare reward!\n" + "it increased your attack by " + playerAttackIncrease + " and your health by " + playerHealthIncrease);
        }

        byte goldReceivedChest = (byte) (Math.random() * 100);
        Config.playerGold += goldReceivedChest;
        System.out.println("You found a Chest!\n" + "You now have " + Config.playerGold + " gold\n");
    }

    public static void randomEvent() {
        if (Config.roomInstanceCount % 10 == 0){
           bossEncounter();
        }
        else if (Config.roomInstanceCount % 5 == 0) {
            shopEncounter();
        }
        else {
            byte randomNumber = (byte) Math.ceil((Math.random() * 2));
            switch (randomNumber) {
                case 1:
                    chest();
                    break;
                case 2:
                    monsterEncounter();
                    break;
            }
        }
    }

    public static void monsterEncounter() {
        String playerInput;
        short monsterHealth = (short)(5 * Config.difficultyMultiplier + Math.random() * 10);
        short monsterDamage = (short)(Config.difficultyMultiplier + Math.random() * 10);
        short playerDamageDone;
        short goldReceived;

        label:
        while (monsterHealth > 0) {
            System.out.print("\nYou encounter a Monster with " + monsterHealth + " health\n" + "\nDo you attack? ");
            playerInput = scanner.next();
            playerInput = playerInput.toLowerCase();
            playerInput = playerInput.strip();

            switch (playerInput) {
                case "y":
                    playerDamageDone = (short) (Math.random() * Config.playerAttack * 2);
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
                        System.out.println("You died with " + Config.playerGold + " gold");
                        System.out.println("Your attack was: " + Config.playerAttack);
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
            goldReceived = (byte)(Math.random() * 100);
            System.out.println("You beat the monster! Your reward is: " + goldReceived + " gold\n");
            Config.playerGold += goldReceived;
        }

    }


    public static void bossEncounter() {
        String playerInput;
        short bossHealth = (short)(Math.round((float)(Config.roomInstanceCount/10)) * 50);
        short bossDamage = (short)(Math.random() * 15 * Math.round((double)(Config.roomInstanceCount/10)));
        short playerDamageDone;
        short goldReceived;


        while (bossHealth > 0) {
            System.out.print("\nYou encounter a boss with " + bossHealth + " health\n" + "\nDo you attack? ");
            playerInput = scanner.next();
            playerInput = playerInput.toLowerCase();
            playerInput = playerInput.strip();

            switch (playerInput) {
                case "y":
                    playerDamageDone = (short) (Math.random() * Config.playerAttack * 2);
                    bossHealth -= playerDamageDone;
                    if (bossHealth > 0) {
                        Config.playerHealth -= bossDamage;
                    }
                    if (Config.playerHealth < 0) {
                        Config.playerHealth = 0;
                    }
                    System.out.println("\nYou did " + playerDamageDone + " damage" + " and now have " + Config.playerHealth + " Health");
                    if (Config.playerHealth <= 0) {
                        System.out.println("Game Over! (You died)");
                        System.out.println("You died with " + Config.playerGold + " gold");
                        System.out.println("Your attack was: " + Config.playerAttack);
                        System.exit(0);
                    }
                    break;
                case "n":
                    System.out.println("You couldn't escape...");
                case "s":
                    System.out.println("\n" + Config.playerName + " stats: \n\n" + "Gold: " + Config.playerGold + "\nAttack: " + Config.playerAttack + "\nHealth: " + Config.playerHealth + "\n\n");
                    break;
            }
        }

        if (bossHealth <= 0) {
            goldReceived = (short)(Math.random() * 400);
            System.out.println("You beat the Boss! Your reward is: " + goldReceived + " gold\n");
            Config.playerGold += goldReceived;
        }

    }
        public static void shopEncounter() {
            while (true) {
                System.out.println("\nYou find a shop!\nWould you like to buy anything?\n\nFor sale:\n" +
                        "1: Heal Potion (100 Gold) \n2: Attack Potion (100 Gold) \n3: exit\n");
                String playerBuyChoice = scanner.next();
                playerBuyChoice = playerBuyChoice.strip();

                if (playerBuyChoice.equals("1")) {
                    if (Config.playerGold >= 100) {
                        Config.playerHealth += 25;

                        if (Config.playerHealth > Config.maxPlayerHealth) {
                            Config.playerHealth = Config.maxPlayerHealth;
                            Config.playerGold -= 100;
                            System.out.println("You pay 100 gold and drink the potion!");
                            System.out.println("Your Health is " + Config.playerHealth + " and your gold is " + Config.playerGold);
                            continue;
                        }
                        else {
                            Config.playerGold -= 100;
                            System.out.println("You pay 100 gold and drink the potion!");
                            System.out.println("Your Health is " + Config.playerHealth + " and your gold is " + Config.playerGold);
                            continue;
                        }
                    }
                    else {
                        System.out.println("You don't have enough gold. You need " + (100 - Config.playerGold) + " more\n");
                    }
                    break;
                }
                else if (playerBuyChoice.equals("2")) {
                    if (Config.playerGold >= 100) {
                        Config.playerAttack += 10;
                        Config.playerGold -= 100;
                        System.out.println("You pay 100 gold and drink the potion!\nYour attack is now " + Config.playerAttack + " and your gold is now " + Config.playerGold);
                        continue;
                    }
                    else {
                        System.out.println("You don't have enough gold. You need " + (100 - Config.playerGold) + " more\n");
                    }
                    break;
                }
                else if (playerBuyChoice.equals("3")) {
                    System.out.println("You choose not to buy anything and leave");
                    break;
                }
                else {
                    System.out.println("Invalid choice! Please select 1, 2, or 3.\n");
                }
            }
        }
    }
