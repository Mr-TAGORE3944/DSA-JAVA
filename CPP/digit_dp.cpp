#include <bits/stdc++.h>
using namespace std;

/* clang-format off */

/* TYPES  */
#define ll long long
#define pii pair<int, int>
#define pll pair<long long, long long>
#define vi vector<int>
#define vll vector<long long>
#define mii map<int, int>
#define si set<int>
#define sc set<char>


 int L ,R;

vector<int> nums;


int dp[10][2][10][10]; // for memoiatation for optimal solution




int go(int i , bool flag , int first , int last){
	if(i == nums.size()){
		return (first == last); // return 0 or 1
	}
	
	int &mem = dp[i][flag][first][last];
	
	if(mem != -1) return mem;
	
	int res = 0;
	
	if(flag){
		// start from 0  to 10 for all single digits
		
		for(int dig = 0 ; dig < 10 ; dig++){
			int new_dig = first;
			if(first == 0){
				new_dig = dig;
			}
			int new_ld = dig;
			res += go(i + 1 , true , new_dig  , new_ld);
		}
	}else{
		// now for out of bound elements then we want to go from 0 to nums[i] number
		
		for(int dig = 0 ; dig < nums[i] ; dig++){
			int new_fd = first;
			if(first == 0){
				new_fd = dig;
			}
			int new_ld = dig;
			if(dig < nums[i]){
			res += go(i+1 , true , new_fd , new_ld);
		}else{
			res += go(i+1 , false , new_fd , new_ld);
		}
		}
		
		
		
	}
	mem = res;
	return res;
}



int f(int x){
	nums.clear();
	while(x > 0){
		nums.push_back(x % 10);
		x /= 10;
	}
	
	sort(nums.begin() , nums.end());
	memset(dp , -1 , sizeof(dp));
	
	return go(0 , false , 0 , 0);
}



int main(){
	L = 8 , R = 24;
	
	int ans = f(R) - f(L-1);
	cout << ans << "\n";
	return 0;
}