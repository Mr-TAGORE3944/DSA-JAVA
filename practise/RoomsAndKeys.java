package practise;
// dont give prompt i will do it

import java.util.*;
import java.util.HashSet;
import java.util.List;

public class RoomsAndKeys {

    public static void dfs(List<List<Integer>> rooms, Set<Integer> visited, int current) {
        visited.add(current);
        for (int i : rooms.get(current)) {
            if (!visited.contains(i)) {
                dfs(rooms, visited, i);
            }
        }
    }

    public static boolean canVisit(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, visited, 0);

        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1));
        rooms.add(List.of(2));
        rooms.add(List.of(3));
        rooms.add(new ArrayList<>());

        System.out.println(canVisit(rooms));

    }
}
