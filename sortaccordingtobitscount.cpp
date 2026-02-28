class Solution {
public:
// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/?envType=daily-question&envId=2026-02-25
    vector<int> sortByBits(vector<int>& arr) {
        // i am using the map and multi set to sort the numbers having the same
        // bit count;
        map<int, multiset<int>> map;
        for (int i = 0; i < arr.size(); i++) {
            int bits = __builtin_popcount(arr[i]);
            map[bits].insert(arr[i]);
        }
        vector<int> ans;
        for (auto p : map) {
            for (int n : p.second) {
                ans.push_back(n);
            }
        }
        return ans;
    }
};