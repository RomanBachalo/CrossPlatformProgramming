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

                default:
                    exit = true;
                    break;
            }
        }
        
/*
        Toy c1 = new Cube("Cube1", 100, CubeType.Digits);
        Toy c6 = new Ball("Ball2", 110, BallType.Football);
        Toy c2 = new Cube("Cube3", 120, CubeType.Letters);
        Toy c4 = new Cube("Cube4", 110, CubeType.Letters);
        Toy c7 = new Ball("Ball3", 110, BallType.Volleyball);
        Toy c3 = new Cube("Cube2", 130, CubeType.Digits);
        Toy c5 = new Ball("Ball1", 110, BallType.Basketball);
        List<Toy> toys = new LinkedList<Toy>();
        toys.add(c1);
        toys.add(c2);
        toys.add(c3);
        toys.add(c4);
        toys.add(c5);
        toys.add(c6);
        toys.add(c7);
        toys.add(c7);
        List<Child> children = new LinkedList<Child>();
        children.add(new Child("Ivan", 43));
        GameRoom gameRoom = new GameRoom(children, toys);

        //SortManager sortManager = new SortManager(gameRoom);
        //toys = sortManager.SortByTypeDesc();

        toys = Toy.InnerStaticSortingClass.SortByPriceAsc(toys);

        Toy[] t = new Toy[toys.size()];
        toys.toArray(t);

        for (int i = 0; i < t.length; i = i + 1) {
            System.out.println(t[i].Name + " " + t[i].GetSubtype() + " " + t[i].GetPrice());
        }

 */
    }
}