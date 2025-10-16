package Lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fighter {
    private String code;
    private String name;
    private int health;
    private int attack;

    private static List<Fighter> fighters = new ArrayList<>();

    public Fighter(String code, String name, int health, int attack) {
        this.code = code;
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public void getInfo() {
        System.out.printf("%s, %s, %s, %s.%n", code, name, health, attack);
    }

    public static void getFighters() {
        if (fighters.isEmpty()) {
            System.out.println("No fighters.%n");
        } else {
            for (Fighter fighter : fighters) {
                fighter.getInfo();
            }
        }
    }

    public static void addFighter(Fighter fighter) {
        fighters.add(fighter);
        System.out.printf("%s added.%n", fighter.name);
    }

    public static void fight(Fighter fighter1, Fighter fighter2) {
        Random random = new Random();

        System.out.printf("Fight: %s vs %s.%n", fighter1, fighter2);

        Fighter attacker = random.nextBoolean() ? fighter1 : fighter2;
        Fighter defender = (attacker == fighter1) ? fighter2 : fighter1;

        while (fighter1.health > 0 && fighter2.health > 0) {
            int damage = attacker.attack;
            defender.health -= damage;

            System.out.printf("%s attacks %s for %s damage! %s health %s.%n",
                    attacker.name, defender.name, damage, defender.name, defender.health);

            Fighter temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
