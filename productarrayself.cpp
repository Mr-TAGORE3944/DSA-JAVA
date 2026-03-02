class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int  n = nums.size();
        vector<int> prefix(n);
        vector<int> suffix(n);
        prefix[0] = 1;
        suffix[n-1] = 1;

        for(int i = 1; i < n; i++) prefix[i] = prefix[i-1] * nums[i-1];
        for(int i = n-2; i >= 0; i--) suffix[i] = suffix[i+1] * nums[i+1];

        vector<int> ans(n);
        for(int i = 0; i < n; i++) ans[i] = prefix[i] * suffix[i];
        return ans;
    }
};


class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n , 1);
        int curr = 1;
        for(int i = 0; i < n; i++){
            ans[i] *= curr;
            curr *= nums[i]; 
        }

        curr = 1;
        for(int i = n-1; i >= 0; i--){
            ans[i] *= curr;
            curr *= nums[i];
        }

        return ans;
    }
};