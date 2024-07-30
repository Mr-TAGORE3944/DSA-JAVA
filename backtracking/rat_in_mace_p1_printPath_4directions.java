package backtracking;

public class rat_in_mace_p1_printPath_4directions {

    static int cnt = 0;
        public static void mace(int sr , int sc , int er , int ec , String s , boolean[][] isVisited){
            if(sr < 0 || sc < 0) return;
            if(sr > er || sc > ec) return;
            if(isVisited[sr][sc] == true) return;
        if(sr == er && sc == ec){
            cnt++;
            System.out.println(s);
            return;
        };
        isVisited[sr][sc] = true;
        //Down
        mace(sr+1, sc, er, ec , s+"D" , isVisited);
        //Right
        mace(sr, sc+1, er, ec , s+"R" , isVisited);
        // left
        mace(sr, sc -1, er, ec, s + "L" , isVisited);
        // up
        mace(sr -1, sc, er, ec, s + "U" , isVisited);
        isVisited[sr][sc] = false;

    }


    public static void main(String[] args) {
        
        int rows = 4;
        int cols = 4;
        boolean[][] isVisited = new boolean[rows][cols];
        mace(0, 0, rows-1, cols-1 , "",isVisited);
        System.out.println(cnt);
     
    }
}
