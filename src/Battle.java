public class Battle extends Thread{
    boolean isNotEnd = true;
    public void run(Creature character, Creature creature) throws InterruptedException {
        while (isNotEnd){
            if (isNotEnd){
                isNotEnd = character.attack(creature);
                sleep(1000);
            }
            if (isNotEnd){
                isNotEnd = creature.attack(character);
                sleep(1000);
            }
        }
    }
}
