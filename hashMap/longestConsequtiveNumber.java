package hashMap;

import java.util.HashSet;

public class longestConsequtiveNumber {
    

    public static int findlong(int[] a){
        HashSet<Integer> st = new HashSet<>();
        for(var i : a) st.add(i);
        int max = 0;
        for(var i : st){
            if(!st.contains(i-1)){
                int currNum = i;
                int steak = 1;
                while (st.contains(currNum + 1)) {
                    currNum++;
                    steak++;
                }
                max = Math.max(max,currNum );
            }
        }

        return max;
    }
}
