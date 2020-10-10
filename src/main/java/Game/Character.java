package Game;

public class Character {
    private float health;
    private float strength;
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

    public void setHealth(float health) {
        this.health = health;
    }

    public void setStrength(float strength) {
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

    public float getHealth() {
        return health;
    }

    public float getStrength() {
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
