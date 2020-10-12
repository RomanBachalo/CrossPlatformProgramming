package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface Sort{
    List<Toy> sort(List<Toy> toyList);
}

public class SortManager {
    List<Toy> ToyList;

    public SortManager() {
    }

    public SortManager(List<Toy> _toyList) {
        ToyList = _toyList;
    }

    public SortManager(GameRoom gameRoom) {
        ToyList = gameRoom.getToyList();
    }

    public List<Toy> sortByPriceAsc() {
        Sort sortPriceAsc = (toyList) ->{
            Collections.sort(toyList, Comparator.comparing(Toy::getPrice));
            return toyList;
        };

        return sortPriceAsc.sort(ToyList);
    }

    public List<Toy> sortByPriceDesc() {
        Sort sortPriceDesc = (toyList) ->{
            Collections.sort(ToyList, Comparator.comparing(Toy::getPrice).reversed());
            return toyList;
        };

        return sortPriceDesc.sort(ToyList);
    }

    public List<Toy> sortByTypeAsc() {
        Sort sortTypeAsc = (toyList) ->{
            Collections.sort(ToyList, Comparator.comparing(Toy::getType).thenComparing(Toy::getName).thenComparing(Toy::getPrice));
            return toyList;
        };

        return sortTypeAsc.sort(ToyList);
    }

    public List<Toy> sortByTypeDesc() {

        Sort sortTypeDesc = (toyList) ->{
            Collections.sort(ToyList, Comparator.comparing(Toy::getType).thenComparing(Toy::getSubtype));
            return toyList;
        };

        return sortTypeDesc.sort(ToyList);
    }


}
