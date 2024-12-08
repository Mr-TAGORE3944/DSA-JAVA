import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class KeysAndRooms {

    // Method to check if all rooms can be visited
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>(); // Set to track visited rooms
        dfs(rooms, 0, visited); // Start DFS from room 0
        return visited.size() == rooms.size(); // Check if all rooms were visited
    }

    // DFS helper method to visit rooms
    private void dfs(List<List<Integer>> rooms, int currentRoom, Set<Integer> visited) {
        visited.add(currentRoom); // Mark the current room as visited

        // Explore all keys in the current room
        for (int key : rooms.get(currentRoom)) {
            if (!visited.contains(key)) { // If the room hasn't been visited, enter it
                dfs(rooms, key, visited);
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        KeysAndRooms solution = new KeysAndRooms();

        // Example rooms setup
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1)); // Room 0 has a key to room 1
        rooms.add(List.of(2)); // Room 1 has a key to room 2
        rooms.add(List.of(3)); // Room 2 has a key to room 3
        rooms.add(new ArrayList<>()); // Room 3 has no keys

        // Check if all rooms can be visited
        boolean result = solution.canVisitAllRooms(rooms);
        System.out.println(result); // Output: true
    }
}
