package practise;

public class candy {



    public static int find(int[] ratings){
        int n = ratings.length;
        int[] candies = new int[n];

        // all students should get 1 candy each
        for(int i = 0 ;i < n ; i++){
            candies[i] = 1;
        }

        // go to left to right and find the rating according to that 
        for(int i = 1 ; i < n ; i++){
            if (ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        // now go to right to left then you can get the solution for the given array

        for(int i = n-2 ; i >= 0 ; i--){
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1] +1);
            }
        }

        int total =0;

        for(int i : candies){
            total += i;
        }

        return total;
    }
    



    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println(find(ratings));

    }
}
