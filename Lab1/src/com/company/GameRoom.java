package com.company;

import java.util.List;

public class GameRoom {
    private List<Child> childList;
    private List<Toy> toyList;

    public GameRoom() {
    }

    public GameRoom(List<Child> _childList, List<Toy> _toyList) {
        childList = _childList;
        toyList = _toyList;
    }

    public List<Child> GetChildList() {
        return childList;
    }

    public List<Toy> GetToyList() {
        return toyList;
    }

    public void AddChild(Child child) {
        childList.add(child);
    }

    public void AddToy(Toy toy) {
        toyList.add(toy);
    }

    public void RemoveChild(int index) {
        childList.remove(index);
    }

    public void RemoveToy(int index) {
        toyList.remove(index);
    }

}
