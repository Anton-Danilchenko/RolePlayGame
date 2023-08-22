public class Skeleton extends Creature{
    public Skeleton(){
        name = "Skeleton";
        hp = 18;
        strength = 3;
        agility = 3;
        crit = strength * 3;
        money = 5;
        exp = 50;
    }
    @Override
    public boolean attack(Creature creature) {
        boolean isNotEnd = true;
        System.out.println(name + " пытаеться атаковать персонажа " + creature.name + ".");
        if (agility * 20 > (int) (Math.random() * 100)){ // Проверка на попадение
            if (agility * 4 > (int) (Math.random() * 100)){ // Проверка на крит
                System.out.println("Персонаж " + name + " наносит критический удар. "
                        + creature.name + " получает " + crit + " урона.");
                creature.hp -= crit;
            }else {
                System.out.println(name + " наносит " + strength
                        + " урона персонажу " + creature.name + ".");
                creature.hp -= strength;
            }
            if (creature.hp <= 0){ // Проверка на гибель персонажа
                System.out.println(creature.name + " погибает!!!");
                isNotEnd = false;
            }
        } else {
            System.out.println(name + " промохнулся по персонажу " + creature.name + ".");
        }
        return isNotEnd;
    }
}
