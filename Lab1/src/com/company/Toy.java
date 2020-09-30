package com.company;

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

    public String GetName(){ return Name;}

    public void SetPrice(int price) {
        Price = price;
    }

    public int GetPrice() {
        return Price;
    }

    public abstract String GetType();

    public String GetSubtype()
    {
        return Subtype.toString();
    }
}

interface ToySubtypes {
}

enum CarSize implements ToySubtypes {
    Small{
        @Override
        public String toString() {
            return "Small";
        }
    },
    Medium{
        @Override
        public String toString() {
            return "Medium";
        }
    },
    Large{
        @Override
        public String toString() {
            return "Large";
        }
    }
}

enum BallType implements ToySubtypes {
    Volleyball{
        @Override
        public String toString() {
            return "Volleyball";
        }
    },
    Football{
        @Override
        public String toString() {
            return "Football";
        }
    },
    Basketball{
        @Override
        public String toString() {
            return "Basketball";
        }
    }
}

enum CubeType implements ToySubtypes {
    Digits{
        @Override
        public String toString() {
            return "Digits";
        }
    },
    Letters{
        @Override
        public String toString() {
            return "Letters";
        }
    }
}

class Car extends Toy {
    CarSize carSize;

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
    BallType ballType;

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
    CubeType cubeType;

    Cube(String name, int price, CubeType _cuebType) {
        super(name, price);
        Subtype = _cuebType;
    }

    @Override
    public String GetType() {
        return "Cube";
    }

}

