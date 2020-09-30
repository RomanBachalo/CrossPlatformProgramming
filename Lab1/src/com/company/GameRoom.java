package com.company;

import java.util.List;

public class GameRoom {
    List<Child> childList;
    List<Toy> toyList;
    GameRoomType gameRoomType;

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

enum GameRoomType {
    Junior,
    Middle,
    Senior
}