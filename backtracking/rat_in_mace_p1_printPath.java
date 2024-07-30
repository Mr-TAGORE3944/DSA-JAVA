package backtracking;

public class rat_in_mace_p1_printPath {
    

    
    public static void mace(int sr , int sc , int er , int ec , String s){
        if(sr > er || sc > ec) return;
        if(sr == er && sc == ec){
            System.out.print(s + "  ");
            return;
        };
        mace(sr+1, sc, er, ec , s+"D");
        mace(sr, sc+1, er, ec , s+"R");
    }


    public static void main(String[] args) {
        

        int rows = 5;
        int cols = 5;
        mace(1, 1, rows, cols , "");
     
    }
}
