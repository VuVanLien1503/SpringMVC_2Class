package manager.service;

import manager.model.Room;
import manager.my_interface.ICrud;
import manager.my_interface.ISearch;


import java.util.ArrayList;
import java.util.List;

public class RoomService implements ICrud<Room>, ISearch<Room> {
    List<Room> listRoom;

    public RoomService() {
        listRoom = new ArrayList<>();
        listRoom.add(new Room(1, "room001"));
        listRoom.add(new Room(2, "room002"));
        listRoom.add(new Room(3, "room003"));
    }

    public List<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(List<Room> listRoom) {
        this.listRoom = listRoom;
    }

    @Override
    public List<Room> findAll() {
        return listRoom;
    }

    @Override
    public void save(Room room) {

    }

    @Override
    public void update(int index, Room room) {

    }

    @Override
    public void delete(Room room) {

    }

    @Override
    public Room findById(int id) {
        Room room = null;
        for (Room r :
                listRoom) {
            if (r.getId() == id) {
                room = r;
            }
        }
        return room;
    }

    @Override
    public List<Room> findByName(String value) {
        return null;
    }
}
