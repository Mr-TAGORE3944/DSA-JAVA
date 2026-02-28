class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int frnt = 0;
        int rear = nums.size() -1;
        while(frnt <= rear){
            // while(nums[rear] == val) rear--;
            while(frnt <= rear && nums[rear] == val) rear--;
            if(frnt <= rear && nums[frnt] == val){
                // swap
                int t = nums[frnt];
                nums[frnt] = nums[rear];
                nums[rear--] = t;
            }
                frnt++;
        }
        int k = 0;
        for(int i: nums){
            if(val != i) k++;
        }
        return k;
    }
};