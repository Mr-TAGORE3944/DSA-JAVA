class Solution {
public:
    int numSteps(string s) {
        if(s == "") return 0;
        long long  dec = 0;
        int ptr = s.length()-1;
        int i = 0;
        while(ptr >= 0){
            dec += (s[ptr]  - '0')* pow(2, i++);
            ptr--;
        }





        // int dec = stoi(s, nullptr , 2);
        int cnt  = 0;
        while(dec != 1){
            if(dec % 2 == 0){
                dec /= 2;
                cnt++;
            }else{
                dec++;
                cnt++;
            }
        }
        return cnt;
    }
};


// Not Optimal
