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
    };

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
    private static class InnerSortingClass {
        InnerSortingClass(){}
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


    public Toy() {
    }

    public Toy(String name, int price) {
        Name = name;
        Price = price;
    }

    //Function to return an instance of inner sorting class
    public InnerSortingClass GetSortingClassInstance() {
        return new InnerSortingClass();
    }

    public String GetName() {
        return Name;
    }

    public int GetPrice() {
        return Price;
    }

    public void SetPrice(int price) {
        Price = price;
    }

    public abstract String GetType();

    public String GetSubtype() {
        return Subtype.toString();
    }

    public InnerSortingClass GetAnonymousSortingClass() {
        return anonymousInnerSortingClass;
    }

    public List<Toy> SortByPriceAsc(List<Toy> toyList) {
        return anonymousInnerSortingClass.SortByPriceAsc(toyList);
    }

    public List<Toy> SortByPriceDesc(List<Toy> toyList) {
        return anonymousInnerSortingClass.SortByPriceDesc(toyList);
    }

    public List<Toy> SortByTypeAsc(List<Toy> toyList) {
        return GetSortingClassInstance().SortByTypeAsc(toyList);
    }

    public List<Toy> SortByTypeDesc(List<Toy> toyList) {
        return GetSortingClassInstance().SortByTypeDesc(toyList);
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