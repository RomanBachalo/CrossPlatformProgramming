package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;

        GameRoom gameRoom = new GameRoom(new LinkedList<Child>(), new LinkedList<Toy>());

        while (!exit) {
            System.out.println("1. Print game room list");
            System.out.println("2. Add child");
            System.out.println("3. Remove child");
            System.out.println("4. Add toy");
            System.out.println("5. Remove toy");
            System.out.println("6. Sort toys");
            System.out.println("0. Exit");

            Scanner myInput = new Scanner(System.in);
            int option = (int) myInput.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Children:");
                    Child[] c = new Child[gameRoom.GetChildList().size()];
                    gameRoom.GetChildList().toArray(c);

                    for (int i = 0; i < c.length; i += 1) {
                        System.out.println((i + 1) + ". " + c[i].Name + ", " + c[i].Age + " year(s)");
                    }

                    System.out.println("Toys:");
                    Toy[] t = new Toy[gameRoom.GetToyList().size()];
                    gameRoom.GetToyList().toArray(t);

                    for (int i = 0; i < t.length; i += 1) {
                        System.out.println((i + 1) + ". " + t[i].Name + " - " + t[i].GetType() + "(" + t[i].GetSubtype() + "), " + t[i].GetPrice() + "$");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter child`s name");
                    String name = (String) myInput.next();

                    System.out.println("Enter child`s age");
                    int age = (int) myInput.nextInt();

                    gameRoom.AddChild(new Child(name, age));
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Enter child number");
                    int childIndex = (int) myInput.nextInt();

                    gameRoom.RemoveChild(childIndex);
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
                            gameRoom.AddToy(new Car(toyName, price, CarSize.sub(subtype)));
                            break;
                        case 2:
                            gameRoom.AddToy(new Ball(toyName, price, BallType.sub(subtype)));
                            break;
                        case 3:
                            gameRoom.AddToy(new Cube(toyName, price, CubeType.sub(subtype)));
                            break;
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Enter toy number");
                    int toyIndex = (int) myInput.nextInt();

                    gameRoom.RemoveToy(toyIndex);
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Choose sorting method:");
                    System.out.println("1. Sort ascending by price");
                    System.out.println("2. Sort descending by price");
                    System.out.println("3. Sort ascending by type");
                    System.out.println("4. Sort descending by type");

                    int sortMethod = (int) myInput.nextInt();

                    switch (sortMethod)
                    {
                        case 1:
                            SortManager sortManager = new SortManager(gameRoom);
                            gameRoom.SetToyList(sortManager.SortByPriceAsc());
                            System.out.println("Done");
                            System.out.println();
                            break;
                        case 2:
                            gameRoom.SetToyList(Toy.InnerStaticSortingClass.SortByPriceDesc(gameRoom.GetToyList()));
                            System.out.println("Done");
                            System.out.println();
                            break;
                        case 3:
                            Toy[] toy1 = new Toy[gameRoom.GetToyList().size()];
                            gameRoom.GetToyList().toArray(toy1);
                            gameRoom.SetToyList(((Toy) toy1[0]).SortByTypeAsc(gameRoom.GetToyList()));
                            System.out.println("Done");
                            System.out.println();
                            break;
                        case 4:
                            Toy[] toy2 = new Toy[gameRoom.GetToyList().size()];
                            gameRoom.GetToyList().toArray(toy2);
                            gameRoom.SetToyList(((Toy) toy2[0]).SortByTypeDesc(gameRoom.GetToyList()));
                            System.out.println("Done");
                            System.out.println();
                            break;
                    }
                default:
                    exit = true;
                    break;
            }
        }
    }
}