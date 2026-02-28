class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n = nums.size();
        if(n <= 2) return n;
        int k = 2;
        for(int i = 2; i < n; i++){
            if(nums[i] != nums[k-2]){
                nums[k++] = nums[i]; 
            }
        }
        return k;

    }
};

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        unordered_map<int,int> map;
        int k = 0;
        for(int i = 0; i < nums.size(); i++){
            map[nums[i]]++;
            if(map[nums[i]] <= 2){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
};