package Game;

public class Monsters {
    private String name;
    private float health;
    private float strength;

    public Monsters(String name, float health, float strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    public Monsters() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getStrength() {
        return strength;
    }

    public void setStrength(float strength) {
        this.strength = strength;
    }
}
