package Game;

import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        Wolf wolf = new Wolf(10, 1);
        Character character = new Character(30, 3);
        int wolfHealth = wolf.getHealth();
        int wolfStrength = wolf.getStrength();
        int characterHealth = character.getHealth();
        int characterStrength = character.getStrength();
        Scanner scanner = new Scanner(System.in);
        start();
        while (scanner.hasNextLine()) {
            switch (scanner.nextLine()) {
                case "attack":
                    int hpLost = 0;
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Wybierz obszar:");
                    System.out.println("Easy: zalecany 1 lvl");
                    System.out.println("Normal: zalecany 10 lvl");
                    System.out.println("Hard: zalecany 25 lvl");
                    System.out.println("Extreme: zalecany 50 lvl");
                    switch (scanner1.nextLine()) {
                        case "Easy":
                            System.out.println("Walczysz z wilkiem");
                            System.out.println("HP: " + wolfHealth + " Strength: " + wolfStrength);
                            for (int i = 0; i < wolfHealth; ) {
                                wolfHealth -= characterStrength;
                                characterHealth -= wolfStrength;
                                hpLost += wolfStrength;
                                if (characterHealth <= 0) {
                                    System.out.println("Umarles");
                                    System.exit(0);
                                }
                            }
                            System.out.println("Gratulacje zabiles wilka i zyskujesz 10 EXP");
                            System.out.println("W trakcie walki straciles " + hpLost + " HP");
                            break;
                        case "Normal":
                            System.out.println("Wybrales normal");
                            break;
                        case "Hard":
                            System.out.println("Wybrales hard");
                            break;
                        case "Extreme":
                            System.out.println("Wybrales extreme");
                            break;
                    }
                    break;
                case "HELP":
                    System.out.println("Lista komend");
                    break;
                case "quit":
                    System.out.println("Twoje postepy zostaly zapisane");
                    System.exit(0);
            }
        }
    }

    private static void start() {
        System.out.println("Lista wszystkich komend:");
        System.out.println("attack: Atakujesz potwora");
        System.out.println("HELP: Wyswietla liste wszystkich komend");
        System.out.println("quit: Konczy gre i zapisuje wszystkie twoje postepy");
    }
}
