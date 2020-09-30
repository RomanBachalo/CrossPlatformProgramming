package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortManager {
    List<Toy> ToyList;

    public SortManager() {
    }

    public SortManager(List<Toy> _toyList) {
        ToyList = _toyList;
    }

    public SortManager(GameRoom gameRoom) {
        ToyList = gameRoom.GetToyList();
    }

    public List<Toy> SortByPriceAsc() {
        Collections.sort(ToyList, Comparator.comparing(Toy::GetPrice));
        return ToyList;
    }

    public List<Toy> SortByPriceDesc() {
        Collections.sort(ToyList, Comparator.comparing(Toy::GetPrice).reversed());
        return ToyList;
    }

    public List<Toy> SortByTypeAsc() {
        Collections.sort(ToyList, Comparator.comparing(Toy::GetType).thenComparing(Toy::GetName).thenComparing(Toy::GetPrice));
        return ToyList;
    }

    public List<Toy> SortByTypeDesc() {
        Collections.sort(ToyList, Comparator.comparing(Toy::GetType).thenComparing(Toy::GetSubtype));
        return ToyList;
    }


}
