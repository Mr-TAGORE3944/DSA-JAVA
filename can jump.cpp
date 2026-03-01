class Solution {
public:
    bool canJump(vector<int>& nums) {
        int goal = nums.size()-1;
        bool ok = false;

        for(int i = nums.size()-2; i >= 0; i--){
            if(i + nums[i] >= goal){
                goal = i;
                // return true;
            }
        }
        return goal == 0;
    }
};