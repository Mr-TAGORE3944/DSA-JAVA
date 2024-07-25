package problems;
public class Trapping_Rain_Water {
    
    static int TrappedRainWater(int[] h){
        int n = h.length;
        //Calulating the left max boundery
        int[] leftMax = new int[n];
        leftMax[0] = h[0];
        for(int i = 1 ; i < n ; i++){
            leftMax[i] = Math.max(h[i], leftMax[i-1]);
        }
        //Calulating the right max boundery
        int[] rightMax = new int[n];
        rightMax[n-1] = h[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            rightMax[i] = Math.max(h[i], rightMax[i+1]);
        }
        //Cal;vulating the water level
        int TrappedWater = 0;
        for(int i = 0 ; i < n ; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            TrappedWater += waterLevel - h[i];
        }
        //Calulating the trapped water


        return TrappedWater;
    }

    public static void main(String[] args) {
        

        int[] height = {0, 1, 0,  2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(TrappedRainWater(height));
    }
}
