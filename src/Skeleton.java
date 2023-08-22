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
        System.out.println(name + " ��������� ��������� ��������� " + creature.name + ".");
        if (agility * 20 > (int) (Math.random() * 100)){ // �������� �� ���������
            if (agility * 4 > (int) (Math.random() * 100)){ // �������� �� ����
                System.out.println("�������� " + name + " ������� ����������� ����. "
                        + creature.name + " �������� " + crit + " �����.");
                creature.hp -= crit;
            }else {
                System.out.println(name + " ������� " + strength
                        + " ����� ��������� " + creature.name + ".");
                creature.hp -= strength;
            }
            if (creature.hp <= 0){ // �������� �� ������ ���������
                System.out.println(creature.name + " ��������!!!");
                isNotEnd = false;
            }
        } else {
            System.out.println(name + " ����������� �� ��������� " + creature.name + ".");
        }
        return isNotEnd;
    }
}
