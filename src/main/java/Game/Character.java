package Game;

public class Character {
    private int health;
    private int strength;
    private int lvl;
    private float exp;
    private float expMax;

    public Character(int health, int strength, int lvl, float exp, float expMax) {
        this.health = health;
        this.strength = strength;
        this.lvl = lvl;
        this.exp = exp;
        this.expMax = expMax;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public void setExpMax(float expMax) {
        this.expMax = expMax;
    }

    public Character() {
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getLvl() {
        return lvl;
    }

    public float getExp() {
        return exp;
    }

    public float getExpMax() {
        return expMax;
    }
}
