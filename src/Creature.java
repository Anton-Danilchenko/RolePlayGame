public abstract class Creature {
    String name;
    int hp;
    int strength;
    int agility;
    int crit;
    int money;
    int exp;

    public abstract boolean attack(Creature creature);
}
