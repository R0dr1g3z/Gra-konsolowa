package Game;

public class Wolf {
    private int health;
    private int strength;

    public Wolf(int health, int strength) {
        this.health = health;
        this.strength = strength;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
