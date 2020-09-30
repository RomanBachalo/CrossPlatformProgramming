package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Toy {
    public String Name;
    private int Price;
    protected ToySubtypes Subtype;

    public Toy() {
    }

    public Toy(String name, int price) {
        Name = name;
        Price = price;
    }

    public String GetName() {
        return Name;
    }

    public void SetPrice(int price) {
        Price = price;
    }

    public int GetPrice() {
        return Price;
    }

    public abstract String GetType();

    public String GetSubtype() {
        return Subtype.toString();
    }

    //Inner static class used for sorting toys
    public static class InnerStaticSortingClass {
        public static List<Toy> SortByPriceAsc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::GetPrice));
            return toyList;
        }

        public static List<Toy> SortByPriceDesc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::GetPrice).reversed());
            return toyList;
        }

        public static List<Toy> SortByTypeAsc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::GetType).thenComparing(Toy::GetSubtype));

            return toyList;
        }

        public static List<Toy> SortByTypeDesc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::GetType).thenComparing(Toy::GetSubtype).reversed());

            return toyList;
        }
    }

    //Inner non static class used to sort toys
    private class InnerSortingClass {
        public InnerSortingClass() {
        }

        public List<Toy> SortByPriceAsc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::GetPrice));
            return toyList;
        }

        public List<Toy> SortByPriceDesc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::GetPrice).reversed());
            return toyList;
        }

        public List<Toy> SortByTypeAsc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::GetType).thenComparing(Toy::GetSubtype));

            return toyList;
        }

        public List<Toy> SortByTypeDesc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::GetType).thenComparing(Toy::GetSubtype).reversed());

            return toyList;
        }
    }

    //Function to return an instance of inner sorting class
    public InnerSortingClass GetSortingClassInstance() {
        return new InnerSortingClass();
    }
}

interface ToySubtypes {
}

enum CarSize implements ToySubtypes {
    Small {
        @Override
        public String toString() {
            return "Small";
        }
    },
    Medium {
        @Override
        public String toString() {
            return "Medium";
        }
    },
    Large {
        @Override
        public String toString() {
            return "Large";
        }
    }
}

enum BallType implements ToySubtypes {
    Volleyball {
        @Override
        public String toString() {
            return "Volleyball";
        }
    },
    Football {
        @Override
        public String toString() {
            return "Football";
        }
    },
    Basketball {
        @Override
        public String toString() {
            return "Basketball";
        }
    }
}

enum CubeType implements ToySubtypes {
    Digits {
        @Override
        public String toString() {
            return "Digits";
        }
    },
    Letters {
        @Override
        public String toString() {
            return "Letters";
        }
    }
}

class Car extends Toy {

    Car(String name, int price, CarSize _carSize) {
        super(name, price);
        Subtype = _carSize;
    }

    @Override
    public String GetType() {
        return "Car";
    }
}

class Ball extends Toy {

    Ball(String name, int price, BallType _ballType) {
        super(name, price);
        Subtype = _ballType;
    }

    @Override
    public String GetType() {
        return "Ball";
    }
}

class Cube extends Toy {

    Cube(String name, int price, CubeType _cubeType) {
        super(name, price);
        Subtype = _cubeType;
    }

    @Override
    public String GetType() {
        return "Cube";
    }

}

