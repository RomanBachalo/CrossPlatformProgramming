package com.company;

enum ChildAgeGroup {
    Junior,
    Middle,
    Senior
}

public class Child {
    public String Name;
    public int Age;

    public Child() {
    }

    public Child(String name, int age) {
        Name = name;
        Age = age;
    }
}