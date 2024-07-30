package hashMap;

import java.util.HashMap;

public class Largest_SubArray_with_0_Sum {
    public static int findLargest(int[] a){
        HashMap<Integer , Integer> mp = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int pefSum = 0;
        mp.put(0, -1);
        for(int i = 0 ; i < a.length ; i++){
            pefSum += a[i];
            if(mp.containsKey(pefSum)){
                max = max < (i - mp.get(pefSum))? (i - mp.get(pefSum)) : max;
                
            }else{
                mp.put(pefSum, i);
            }
        }

        return max;
    }
}
