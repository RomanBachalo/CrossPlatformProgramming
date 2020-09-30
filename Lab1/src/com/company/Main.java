package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
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
    }
}
