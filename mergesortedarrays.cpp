class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int ptr1 = 0;
        int ptr2 = 0;

        vector<int> ans;


        while(ptr1 < m && ptr2 < n){
            if(nums1[ptr1] <= nums2[ptr2]){
                ans.push_back(nums1[ptr1++]);
            } else {
                ans.push_back(nums2[ptr2++]);
            }
        }


        while(ptr1 < m){
            ans.push_back(nums1[ptr1++]);
        }


        while(ptr2 < n){
            ans.push_back(nums2[ptr2++]);
        }

        for(int i = 0; i < m + n; i++){
            nums1[i] = ans[i];
        }
    }
};