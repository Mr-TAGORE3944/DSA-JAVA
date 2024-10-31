package practise;
import java.util.*;
public class TrinagleMinPath {



    public static int find(List<List<Integer>> triangle){
        int n = triangle.size();

        for(int i = n-2 ; i >= 0 ; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                int update = min + triangle.get(i).get(j);
                triangle.get(i).set(j, update);
            }
        }

        return triangle.get(0).get(0);
    }
    


    public static void main(String[] args) {
        // Triangle solution = new Triangle();
        List<List<Integer>> triangle = List.of(
            List.of(2),
            List.of(3, 4),
            List.of(6, 5, 7),
            List.of(4, 1, 8, 3)
        );
        System.out.println(triangle);
        System.out.println(find(triangle));

        // System.out.println("Minimum path sum: " + solution.minimumTotal(triangle)); // Output: 11
    }
}
