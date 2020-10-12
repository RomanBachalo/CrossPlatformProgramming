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

    public List<Child> getChildList() {
        return childList;
    }

    public List<Toy> getToyList() {
        return toyList;
    }

    public void setToyList(List<Toy> _toyList) {
        toyList = _toyList;
    }

    public void addChild(Child child) {
        childList.add(child);
    }

    public void addToy(Toy toy) {
        toyList.add(toy);
    }

    public void removeChild(int index) {
        childList.remove(index);
    }

    public void removeToy(int index) {
        toyList.remove(index);
    }

}
