import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        boolean isAlive = true;
        boolean isShopping = true;
        boolean isFights = true;
        boolean inShop = true;
        Scanner scanner = new Scanner(System.in);
        //Создание персонажа :
        System.out.println("Здраствуйте, Вы запустили RolePlayGame.");
        System.out.print("Введите имя персонажа: ");
        String name = scanner.next();
        Character character = new Character(name);
        System.out.println("Персонаж с именем  " + name + " появился в мире.");

        while (isAlive){
            System.out.println("Куда Вы хотите пойти?");
            System.out.println("1. К торговцу.");
            System.out.println("2. В темный лес.");
            System.out.println("3. На выход");
            System.out.print("Введите номер пункта : ");
            String act = scanner.next();
            switch (act){
                //1. Поход к торговцу :
                case "1":{
                    System.out.println("Торговец предлогает купить зелье здоровья.");
                    System.out.println("Зелье стоит 10 золотых монет и востанавливает 10 здоровья.");
                    while (isShopping){
                        System.out.println("Хотите купить зелье?");
                        System.out.println("1. Да.");
                        System.out.println("2. Нет.");
                        System.out.print("Дейстаие : ");
                        String shopping = scanner.next();
                        switch (shopping){
                            // Покупка зелья :
                            case "1": {
                                while (inShop) { // Реализация повторной покупки зелья
                                    if (character.money >= 10) {
                                        character.money -= 10;
                                        character.heal();
                                        System.out.println("1. Купить ещё одно зелье.");
                                        System.out.println("2. Вернуться в город.");
                                        System.out.print("Дейстаие : ");
                                        String actionInShop = scanner.next();
                                        switch (actionInShop){
                                            case "1":{
                                                inShop = true;
                                                break;
                                            }
                                            case "2":{
                                                inShop = false;
                                                break;
                                            }
                                            default:
                                                System.out.println("Не верно выбран номер команды.");
                                                break;
                                        }
                                    } else {
                                        System.out.println("Недостаточно золотых монет!!!");
                                        System.out.println("Торговец прогоняет персонажа из своей лавки!!!");
                                        inShop = false;
                                        isShopping = false;
                                    }
                                } break;
                            }
                            // Отказ покупать зелье :
                            case "2":{
                                System.out.println("Персонаж покидает лавку.");
                                isShopping = false;
                                break;
                            }
                            //Обработка неправильно введенной команды :
                            default: {
                                System.out.println("Не верно выбран номер команды.");
                                break;
                            }
                        }
                    }
                    break;
                }
                //2. Поход в лес :
                case "2":{
                    while (isFights){
                        Skeleton skeleton = new Skeleton();
                        Goblin goblin = new Goblin();
                        Battle battle = new Battle();
                        // Сражение с рандомным монстром :
                        if (Math.random() > 0.5) {
                            System.out.println("На вашем пути появился " + goblin.name + ".");
                            battle.run(character, goblin);
                        }
                        else {
                            System.out.println("На вашем пути появился " + skeleton.name + ".");
                            battle.run(character, skeleton);
                        }
                        // Проверка жив ли персонаж :
                        if (character.hp <= 0 ){
                            isFights = false;
                            isAlive = false;
                            System.out.println("Персонаж погиб.");
                            System.out.println("Игра окончена.");
                        }
                        // Реализация повторного боя
                        System.out.println("1. Продолжить поход по лесу.");
                        System.out.println("2. Ввернуться в город.");
                        System.out.print("Дейстаие : ");
                        String actionInForest = scanner.next();
                        switch (actionInForest){
                            case "1":{
                                isFights = true;
                                break;
                            }
                            case "2":{
                                isFights = false;
                                break;
                            }
                        }
                    }break;
                }

                //3. Выход из игры :
                case "3":{
                    isAlive = false;
                    System.out.println("До встречи");
                    break;
                }
                //Обработка неправильно введенной команды :
                default: {
                    System.out.println("Не верно выбран номер команды");
                    break;
                }
            }
        }
    }
}
