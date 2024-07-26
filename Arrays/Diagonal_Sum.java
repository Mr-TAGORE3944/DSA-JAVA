

public class Diagonal_Sum {
    

    static void DiagonalSum(int[][] a){
        int dsum = 0;
        int adsum = 0;
        
        for(int i = 0 ; i < a.length ; i++){
            dsum += a[i][i];
            // if(i != a.length -1 -i){
            //     adsum += a[i][a.length -1 -i];
            // }
            adsum += a[i][a.length -1 -i];
        }


        System.out.println(dsum  + " " + adsum);
    }
    public static void main(String[] args) {
        int[][] a= {{1,2,3} 
                  , {4,5,6} 
                   ,{2,8,9}};

        DiagonalSum(a);
    }
}
