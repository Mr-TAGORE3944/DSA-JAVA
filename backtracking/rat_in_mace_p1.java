package backtracking;
public class rat_in_mace_p1 {
    


    public static int mace(int sr , int sc , int er , int ec){
        if(sr > er || sc > ec) return 0;
        if(sr == er && sc == ec) return 1;
        int downWards = mace(sr+1, sc, er, ec);
        int rightWards = mace(sr, sc+1, er, ec);
        int totalways = downWards + rightWards;
        return totalways;
    }


    public static void main(String[] args) {
        

        int rows = 3;
        int cols = 3;
        int directions = mace(1, 1, rows, cols);
        System.out.println(directions);
    }
}
