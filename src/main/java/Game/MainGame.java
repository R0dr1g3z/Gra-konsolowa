package Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class MainGame {
    private static final int basicExp = 10;
    private static String QUERY1 = "SELECT * FROM `Character` WHERE id=1;";
    private static String QUERY2 = "SELECT * FROM Monsters WHERE id=?;";
    private static String QUERY3 = "SELECT * FROM lvlSystem WHERE id=?;";

    public static void main(String[] args) {
        Character character = loadCharacter();
        Scanner scanner = new Scanner(System.in);
        start();
        while (scanner.hasNextLine()) {
            switch (scanner.nextLine()) {
                case "attack":
                    Monsters monster = loadMonster();
                    int hpLost = 0;
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Wybierz obszar:");
                    System.out.println("Easy: lvl 1-10");
                    System.out.println("Normal: lvl 10-25");
                    System.out.println("Hard: lvl 25-50");
                    System.out.println("Extreme: lvl 50-100");
                    switch (scanner1.nextLine()) {
                        case "Easy":
                            System.out.println("Polana lvl 1-3");
                            System.out.println("Las lvl 3-7");
                            System.out.println("Bagna lvl 7-10");
                            switch (scanner1.nextLine()) {
                                case "Polana":
                                    Random random = new Random();
                                    int rn = random.nextInt(2) + 1;
                                    Monsters monsters = new Monsters();
                                    int lvl = 0;
                                    float multipler = 0;
                                    try (Connection connection = DBUtil.connect()) {
                                        PreparedStatement preparedStatement = connection.prepareStatement(QUERY3);
                                        preparedStatement.setInt(1, rn);
                                        ResultSet resultSet = preparedStatement.executeQuery();
                                        while (resultSet.next()) {
                                            lvl = resultSet.getInt("lvl");
                                            multipler = resultSet.getFloat("multipler");
                                        }
                                        monster.setHealth(monster.getHealth()*multipler);
                                        monster.setStrength(monster.getStrength()*multipler);
                                    } catch (SQLException throwables) {
                                        throwables.printStackTrace();
                                    }
                                    System.out.println("Walczysz z " + monster.getName());
                                    System.out.println(String.format("HP: %s Str: %s LVL: %s",monster.getHealth(),monster.getStrength(),lvl));
                                    for (int i = 0; i < monster.getHealth(); ) {
                                        monster.setHealth(monster.getHealth() - character.getStrength());
                                        character.setHealth(character.getHealth() - monster.getStrength());
                                        hpLost += monster.getStrength();
                                        if (character.getHealth() <= 0) {
                                            System.out.println("Umarles");
                                            System.exit(0);
                                        }
                                    }
                                    System.out.println("Gratulacje zabiles " + monster.getName() + " i zyskujesz 10 EXP");
                                    System.out.println("W trakcie walki straciles " + hpLost + " HP");
                                    character.setExp(character.getExp() + 10);
                                    break;
                                case "Las":
                                    break;
                                case "Bagna":
                                    break;
                            }
                            break;
                        case "Normal":
                            System.out.println("Wybrales normal");
                            break;
                        case "Hard":
                            System.out.println("Wybrales hard");
                            break;
                        case "Extreme":

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

    private static Monsters loadMonster() {
        Random random = new Random();
        int rn = random.nextInt(4) + 1;
        Monsters monsters = new Monsters();
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY2);
            preparedStatement.setInt(1, rn);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                monsters.setName(resultSet.getString("name"));
                monsters.setHealth(resultSet.getFloat("health"));
                monsters.setStrength(resultSet.getFloat("strength"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return monsters;
    }

    private static Character loadCharacter() {
        Character character = new Character();
        try (Connection connection = DBUtil.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY1);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                character.setHealth(resultSet.getFloat("health"));
                character.setStrength(resultSet.getFloat("strength"));
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
        System.out.println("info: Informacje o twojej postaci");
        System.out.println("HELP: Wyswietla liste wszystkich komend");
        System.out.println("quit: Konczy gre i zapisuje wszystkie twoje postepy");
    }
}
