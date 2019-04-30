package CoffeMachineSimulator;
import java.util.Scanner;
public class CoffeeMachineSimulator {

    enum Status{
        action,coffe,water,milk,beans,cups;
    }
    int water;
    int milk;
    int beans;
    int cups;
    int money;
    Status status;

    CoffeeMachineSimulator()
    {
        water = 400;
        milk = 540;
        beans = 120;
        cups = 9;
        money = 550;
        status = Status.action;
    }


    void doSmth(String a)
    {
        switch (status)
        {
            case action:
                switch (a) {
                    case "remaining":
                        System.out.println("The coffee machine has:");
                        System.out.println(water + " of water");
                        System.out.println(milk + " of milk");
                        System.out.println(beans + " of coffee beans");
                        System.out.println(cups + " of disposable cups");
                        System.out.println(money + " of money\n");
                        System.out.print("Write action (buy, fill, take, remaining, exit): ");
                        break;

                    case "buy":
                        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                        status = Status.coffe;
                        break;

                    case "fill":
                        System.out.print("Write how many ml of water do you want to add: ");
                        status = Status.water;
                        break;
                    case "take":
                        System.out.println("I gave you $" + money);
                        money = 0;
                        System.out.print("Write action (buy, fill, take, remaining, exit): ");
                        break;
                }
                break;

            case coffe:
                switch (a) {
                    case "1":
                        if (water >= 250){
                            if (beans >= 16) {
                                --cups;
                                water -= 250;
                                beans -= 16;
                                money += 4;
                                System.out.println("I have enough resources, making you a coffee!");
                            }
                            else {
                                System.out.println("Sorry, not enough beans!");
                            }
                        }else {
                            System.out.println("Sorry, not enough water!");
                        }

                        break;
                    case "2":
                        if (water >= 350) {
                            if (milk >= 75) {
                                if (beans >= 20) {
                                    --cups;
                                    water -= 350;
                                    milk -= 75;
                                    beans -= 20;
                                    money += 7;
                                    System.out.println("I have enough resources, making you a coffee!");
                                }
                                else {
                                    System.out.println("Sorry, not enough beans!");
                                }
                            }else {
                                System.out.println("Sorry, not enough milk!");
                            }
                        }else {
                            System.out.println("Sorry, not enough water!");
                        }
                        break;

                    case "3":
                        if (water >= 200) {
                            if (milk >= 100) {
                                if (beans >= 12) {
                                    --cups;
                                    water -= 200;
                                    milk -= 100;
                                    beans -= 12;
                                    money += 6;
                                    System.out.println("I have enough resources, making you a coffee!");
                                }
                                else {
                                    System.out.println("Sorry, not enough beans!");
                                }
                            }else {
                                System.out.println("Sorry, not enough milk!");
                            }
                        }else {
                            System.out.println("Sorry, not enough water!");
                        }
                        break;
                }
                System.out.print("Write action (buy, fill, take, remaining, exit): ");
                status = Status.action;
                break;

            case water:
                water += Integer.parseInt(a);
                System.out.print("Write how many ml of milk do you want to add: ");
                status = Status.milk;
                break;

            case milk:
                milk += Integer.parseInt(a);
                System.out.print("Write how many grams of coffee beans do you want to add: ");
                status = Status.beans;
                break;

            case beans:
                beans += Integer.parseInt(a);
                System.out.print("Write how many disposable cups of coffee do you want to add: ");
                status = Status.cups;
                break;

            case cups:
                cups += Integer.parseInt(a);
                System.out.print("Write action (buy, fill, take, remaining, exit): ");
                status = Status.action;
                break;
        }
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        CoffeeMachineSimulator coffeeMachine = new CoffeeMachineSimulator();

        System.out.print("Write action (buy, fill, take, remaining, exit): ");
        String action = scn.nextLine();
        while (!action.equals("exit")) {
            coffeeMachine.doSmth(action);
            action = scn.nextLine();
        }
    }

}
