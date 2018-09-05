package algorithms.leetcode.depth_first_search;

import java.util.HashSet;
import java.util.List;

public class LC_841_Keys_and_Rooms {
    HashSet<Integer> enteredRooms = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        enterRoom(0, rooms);
        return enteredRooms.size() == rooms.size();
    }
    private void enterRoom(int roomId, List<List<Integer>> rooms) {
        enteredRooms.add(roomId);
        List<Integer> keysInRoom = rooms.get(roomId);
        for (int key : keysInRoom) {
            if (!enteredRooms.contains(key)) {
                enterRoom(key, rooms);
            }
        }
    }
}
