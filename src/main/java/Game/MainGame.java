package Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MainGame {
    private static final int basicExp = 10;
    private static String QUERY1 = "SELECT * FROM `Character` WHERE id=1;";

    public static void main(String[] args) {
        Character character = loadCharacter();
        Wolf wolf = new Wolf(10, 1);
        int wolfHealth = wolf.getHealth();
        int wolfStrength = wolf.getStrength();
        Scanner scanner = new Scanner(System.in);
        start();
        while (scanner.hasNextLine()) {
            switch (scanner.nextLine()) {
                case "attack":
                    int hpLost = 0;
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Wybierz obszar:");
                    System.out.println("Easy: lvl 1-10");
                    System.out.println("Normal: lvl 10-25");
                    System.out.println("Hard: lvl 25-50");
                    System.out.println("Extreme: lvl 50-100");
                    switch (scanner1.nextLine()) {
                        case "Easy":
                            System.out.println("Walczysz z wilkiem");
                            System.out.println("HP: " + wolfHealth + " Strength: " + wolfStrength);
                            for (int i = 0; i < wolfHealth; ) {
                                wolfHealth -= character.getStrength();
                                character.setHealth(character.getHealth()-wolfStrength);
                                hpLost += wolfStrength;
                                if (character.getHealth() <= 0) {
                                    System.out.println("Umarles");
                                    System.exit(0);
                                }
                            }
                            System.out.println("Gratulacje zabiles wilka i zyskujesz 10 EXP");
                            System.out.println("W trakcie walki straciles " + hpLost + " HP");
                            character.setExp(character.getExp()+10);
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
                case "info":
                    System.out.println("HP: " + character.getHealth());
                    System.out.println("Strength: " + character.getStrength());
                    System.out.println("Lvl: " + character.getLvl());
                    System.out.println(String.format("Exp: %s/%s", character.getExp(), character.getExpMax()));
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

    private static Character loadCharacter() {
        Character character = new Character();
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                character.setHealth(resultSet.getInt("health"));
                character.setStrength(resultSet.getInt("strength"));
                character.setLvl(resultSet.getInt("lvl"));
                character.setExp(resultSet.getFloat("exp"));
                character.setExpMax(resultSet.getFloat("expMax"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return character;
    }

    private static void start() {
        System.out.println("Lista wszystkich komend:");
        System.out.println("attack: Atakujesz potwora");
        System.out.println("HELP: Wyswietla liste wszystkich komend");
        System.out.println("quit: Konczy gre i zapisuje wszystkie twoje postepy");
    }
}
