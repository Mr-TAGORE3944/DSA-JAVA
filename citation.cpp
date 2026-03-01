class Solution {
public:
    int hIndex(vector<int>& citations) {
        int n = citations.size();
        vector<int> citationsPapers(n + 1, 0);

        for(auto c: citations){
            citationsPapers[min(c, n)]++;
        }

        int cum = 0;
        for(int h = n; h >= 0; h--){
            cum += citationsPapers[h];
            if(cum >= h) return h;
        }
        return 0;
    }
};