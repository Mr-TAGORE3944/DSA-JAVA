package backtracking;

public class rat_in_mace_p1_printPath_dead_blocks {
    

        public static void mace(int sr , int sc , int er , int ec , String s , int[][] maze){
        if(sr > er || sc > ec) return;
        if(sr == er && sc == ec){
            System.out.print(s + "  ");
            return;
        };
        if(maze[sr][sc] == 0) return;
        mace(sr+1, sc, er, ec , s+"D" , maze);
        mace(sr, sc+1, er, ec , s+"R" , maze);
    }


    public static void main(String[] args) {
        

        int rows = 6;
        int cols = 4;
        int[][] maze = {{1,0,1,1,1,1},
                        {1,1,1,1,0,1},
                        {0,1,1,1,1,1},
                        {0,0,1,0,1,1}};
        mace(1, 1, rows, cols , "" , maze);
     
    }
}
