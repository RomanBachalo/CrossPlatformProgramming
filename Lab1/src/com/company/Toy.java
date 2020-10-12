package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    };

    public static CarSize sub(int x) {
        switch(x) {
            case 1:
                return Small;
            case 2:
                return Medium;
            case 3:
                return Large;
        }
        return null;
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
    };

    public static BallType sub(int x) {
        switch(x) {
            case 1:
                return Volleyball;
            case 2:
                return Football;
            case 3:
                return Basketball;
        }
        return null;
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
    },
    Images {
        @Override
        public String toString() {
            return "Images";
        }
    };

    public static CubeType sub(int x) {
        switch(x) {
            case 1:
                return Digits;
            case 2:
                return Letters;
            case 3:
                return Images;
        }
        return null;
    }
}

interface ToySubtypes {}

public abstract class Toy {
    public String Name;
    protected ToySubtypes Subtype;
    private int Price;

    //Anonymous inner class for sorting toys
    public InnerSortingClass anonymousInnerSortingClass = new InnerSortingClass() {
        public List<Toy> sortByPriceAsc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::getPrice));
            return toyList;
        }

        public List<Toy> sortByPriceDesc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::getPrice).reversed());
            return toyList;
        }

        public List<Toy> sortByTypeAsc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::getType).thenComparing(Toy::getSubtype));

            return toyList;
        }

        public List<Toy> sortByTypeDesc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::getType).thenComparing(Toy::getSubtype).reversed());

            return toyList;
        }
    };

    //Inner static class used for sorting toys
    public static class InnerStaticSortingClass {
        public static List<Toy> sortByPriceAsc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::getPrice));
            return toyList;
        }

        public static List<Toy> sortByPriceDesc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::getPrice).reversed());
            return toyList;
        }

        public static List<Toy> sortByTypeAsc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::getType).thenComparing(Toy::getSubtype));

            return toyList;
        }

        public static List<Toy> sortByTypeDesc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::getType).thenComparing(Toy::getSubtype).reversed());

            return toyList;
        }
    }

    //Inner non static class used to sort toys
    private static class InnerSortingClass {
        InnerSortingClass(){}
        public List<Toy> sortByPriceAsc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::getPrice));
            return toyList;
        }

        public List<Toy> sortByPriceDesc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::getPrice).reversed());
            return toyList;
        }

        public List<Toy> sortByTypeAsc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::getType).thenComparing(Toy::getSubtype));

            return toyList;
        }

        public List<Toy> sortByTypeDesc(List<Toy> toyList) {
            Collections.sort(toyList, Comparator.comparing(Toy::getType).thenComparing(Toy::getSubtype).reversed());

            return toyList;
        }
    }


    public Toy() {
    }

    public Toy(String name, int price) {
        Name = name;
        Price = price;
    }

    //Function to return an instance of inner sorting class
    public InnerSortingClass getSortingClassInstance() {
        return new InnerSortingClass();
    }

    public String getName() {
        return Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public abstract String getType();

    public String getSubtype() {
        return Subtype.toString();
    }

    public InnerSortingClass getAnonymousSortingClass() {
        return anonymousInnerSortingClass;
    }

    public List<Toy> sortByPriceAsc(List<Toy> toyList) {
        return getAnonymousSortingClass().sortByPriceAsc(toyList);
    }

    public List<Toy> sortByPriceDesc(List<Toy> toyList) {
        return getSortingClassInstance().sortByPriceDesc(toyList);
    }

    public List<Toy> sortByTypeAsc(List<Toy> toyList) {
        return getSortingClassInstance().sortByTypeAsc(toyList);
    }

    public List<Toy> sortByTypeDesc(List<Toy> toyList) {
        return getAnonymousSortingClass().sortByTypeDesc(toyList);
    }

}

class Car extends Toy {

    Car(String name, int price, CarSize _carSize) {
        super(name, price);
        Subtype = _carSize;
    }

    @Override
    public String getType() {
        return "Car";
    }
}

class Ball extends Toy {

    Ball(String name, int price, BallType _ballType) {
        super(name, price);
        Subtype = _ballType;
    }

    @Override
    public String getType() {
        return "Ball";
    }
}

class Cube extends Toy {

    Cube(String name, int price, CubeType _cubeType) {
        super(name, price);
        Subtype = _cubeType;
    }

    @Override
    public String getType() {
        return "Cube";
    }

}