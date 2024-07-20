package problems;

public class L_48_chocolate_distribution {

    static boolean isDivision(int[] a , int studenst , int maxChocolates){
        int n = a.length;
        int noStudents = 1;
        int choco = 0;
        for(int i = 0 ; i < a.length ; i++){
            if(a[i] > maxChocolates) return false;
            if(choco + a[i] <= maxChocolates){
                choco += a[i];
            } else {
                noStudents++;
                choco = a[i];
            }
        }

        if(noStudents > studenst) return false;
        return true;

    }
    

    static int distributeChocolate(int[] a , int students ){
        if(a.length < students) return -1;
        int st = 1 , end = (int) 1e9;
        int ans = 0;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if(isDivision(a , students , mid)){
                ans = mid;
                end = mid -1;
            } else {
                st = mid +1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {5,3,1,4,2};
        System.out.println(distributeChocolate(a, 3));
    }
}
