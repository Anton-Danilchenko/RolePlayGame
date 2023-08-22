public class Character extends Creature{
    int lvl;
    int maxHp;
    public Character(String name) {
        this.name = name;
        hp = 50;
        maxHp = hp;
        strength = 5;
        agility = 4;
        crit = strength * 2;
        money = 0;
        exp = 0;
        lvl = 1;
    }

    public void heal(){ // Лечение у торговца
        if (hp + 10 > maxHp) hp = maxHp;
        else hp += 10;
        System.out.println("Персонаж выпил зелье здоровья");
    }

    public void lvlUp(){ // Повышение уровня
        if (exp >= 100) {
            lvl++;
            exp -= 100;
            System.out.println("Персонаж получил новый уровень!!!");
        }
    }
    @Override
    public boolean attack(Creature creature) {
        boolean isNotEnd = true;
        System.out.println("Персонаж " + name + " пытаеться атаковать " + creature.name + ".");
        if (agility * 20 > (int) (Math.random() * 100)){ // Проверка на попадение
            if (agility * 4 > (int) (Math.random() * 100)){ // Проверка на крит
                System.out.println("Персонаж " + name + " наносит критический удар. "
                        + creature.name + " получает " + crit + " урона.");
                creature.hp -= crit;
            }else {
                System.out.println("Персонаж " + name + " наносит " + strength
                        + " урона " + creature.name + ".");
                creature.hp -= strength;
            }
            if (creature.hp <= 0){ // Победа над монстром
                System.out.println(creature.name + " побежден!!!");
                money += creature.money;
                System.out.println("Персонаж получил " + creature.money + " золотых монет.");
                System.out.println("Персонаж получил " + creature.exp + " опыта.");
                exp += creature.exp;
                lvlUp(); // Повышение уровня
                System.out.println("Здоровье персонажа = " + hp
                        + ", количество золотых монет = " + money + ", уровень = " + lvl + ".");
                isNotEnd = false;
            }
        } else {
            System.out.println("Персонаж " + name + " промохнулся по " + creature.name + ".");
        }
        return isNotEnd;
    }
}
