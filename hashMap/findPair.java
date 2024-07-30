package hashMap;

import java.util.HashMap;

public class findPair {
    


    public static int[] findPairOfTarget(int[] a, int n){
        HashMap<Integer , Integer> mp = new HashMap<>();
        int ans[] = {-1};
        for(int i = 0 ; i < a.length ; i++){
            int target = n - a[i];
            if(mp.containsKey(target)){
                 ans = new int[]{i , mp.get(target)};
                 return ans;
            }else{
               mp.put(a[i],i); 
            }
        }

        return ans;
    }
}
