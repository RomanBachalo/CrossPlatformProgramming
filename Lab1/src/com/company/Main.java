package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;

        List<Child> cList = new LinkedList<Child>();
        List<Toy> tList = new LinkedList<Toy>();

        cList.add(new Child("Evan", 5));
        cList.add(new Child("Ron", 4));
        cList.add(new Child("Jade", 4));
        cList.add(new Child("Nat", 3));

        tList.add(new Ball("Ball_1", 20, BallType.Football));
        tList.add(new Car("Car_1", 20, CarSize.Small));
        tList.add(new Cube("Cube_1", 40, CubeType.Digits));
        tList.add(new Ball("Ball_3", 30, BallType.Basketball));
        tList.add(new Car("Car_3", 40, CarSize.Medium));
        tList.add(new Cube("Cube_3", 30, CubeType.Images));
        tList.add(new Ball("Ball_2", 35, BallType.Volleyball));
        tList.add(new Car("Car_2", 15, CarSize.Large));
        tList.add(new Cube("Cube_2", 25, CubeType.Letters));

        GameRoom gameRoom = new GameRoom(cList, tList);

        while (!exit) {
            System.out.print("1.Print game room list    ");
            System.out.print("2.Add child   ");
            System.out.print("3.Remove child    ");
            System.out.print("4.Add toy   ");
            System.out.print("5.Remove toy  ");
            System.out.print("6.Sort toys   ");
            System.out.println("0.Exit    ");

            Scanner myInput = new Scanner(System.in);
            int option = (int) myInput.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Children:");
                    Child[] c = new Child[gameRoom.getChildList().size()];
                    gameRoom.getChildList().toArray(c);

                    for (int i = 0; i < c.length; i += 1) {
                        System.out.println((i + 1) + ". " + c[i].Name + ", " + c[i].Age + " year(s)");
                    }

                    System.out.println("Toys:");
                    int sum = 0;
                    Toy[] t = new Toy[gameRoom.getToyList().size()];
                    gameRoom.getToyList().toArray(t);

                    for (int i = 0; i < t.length; i += 1) {
                        sum += t[i].getPrice();
                        System.out.println((i + 1) + ". " + t[i].Name + " - " + t[i].getType() + "(" + t[i].getSubtype() + "), " + t[i].getPrice() + "$");
                    }
                    System.out.println();
                    System.out.println("Total price: " + sum + "$");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter child`s name");
                    String name = (String) myInput.next();

                    System.out.println("Enter child`s age");
                    int age = (int) myInput.nextInt();

                    gameRoom.addChild(new Child(name, age));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter child number");
                    int childIndex = (int) myInput.nextInt();

                    gameRoom.removeChild(childIndex);
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Choose toy:");
                    System.out.println("1. Car");
                    System.out.println("2. Ball");
                    System.out.println("3. Cube");
                    int type = (int) myInput.nextInt();

                    System.out.println("Choose toy subtype: 1, 2, 3");
                    int subtype = (int) myInput.nextInt();

                    System.out.println("Enter toy`s name");
                    String toyName = (String) myInput.next();

                    System.out.println("Enter toy`s price");
                    int price = (int) myInput.nextInt();

                    switch (type)
                    {
                        case 1:
                            gameRoom.addToy(new Car(toyName, price, CarSize.sub(subtype)));
                            break;
                        case 2:
                            gameRoom.addToy(new Ball(toyName, price, BallType.sub(subtype)));
                            break;
                        case 3:
                            gameRoom.addToy(new Cube(toyName, price, CubeType.sub(subtype)));
                            break;
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Enter toy number");
                    int toyIndex = (int) myInput.nextInt();

                    gameRoom.removeToy(toyIndex);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Choose sorting method:");
                    System.out.println("1. Sort ascending by price (SortManager)");
                    System.out.println("2. Sort descending by price (Inner Static Class)");
                    System.out.println("3. Sort ascending by type (Inner Class)");
                    System.out.println("4. Sort descending by type (Anonymous Inner Class)");

                    int sortMethod = (int) myInput.nextInt();

                    switch (sortMethod)
                    {
                        case 1:
                            SortManager sortManager = new SortManager(gameRoom);
                            gameRoom.setToyList(sortManager.sortByPriceAsc());
                            System.out.println("Done");
                            System.out.println();
                            continue;
                        case 2:
                            gameRoom.setToyList(Toy.InnerStaticSortingClass.sortByPriceDesc(gameRoom.getToyList()));
                            System.out.println("Done");
                            System.out.println();
                            continue;
                        case 3:
                            Toy[] toy1 = new Toy[gameRoom.getToyList().size()];
                            gameRoom.getToyList().toArray(toy1);
                            gameRoom.setToyList(((Toy) toy1[0]).sortByTypeAsc(gameRoom.getToyList()));
                            System.out.println("Done");
                            System.out.println();
                            continue;
                        case 4:
                            Toy[] toy2 = new Toy[gameRoom.getToyList().size()];
                            gameRoom.getToyList().toArray(toy2);
                            gameRoom.setToyList(((Toy) toy2[0]).sortByTypeDesc(gameRoom.getToyList()));
                            System.out.println("Done");
                            System.out.println();
                            continue;
                    }
                    break;
                default:
                    exit = true;
                    break;
            }
        }
    }
}