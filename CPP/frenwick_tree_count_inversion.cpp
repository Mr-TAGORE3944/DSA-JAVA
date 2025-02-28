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

int n;

vector<int> bit;



int getSum(int idx){
	int ans = 0;
	while(idx > 0){
		ans += bit[idx];
		idx -= idx & (-idx);
	}
	
	return ans;
}

void update(int n , int idx , int inc){
	while(idx <= n){
		bit[idx] += inc;
		idx += idx & (-idx);
	}
}


int main(){
	
	cin >> n;
	
	vector<int> a(n+1);
	
	for(int i = 0 ; i < n ; i++){
		cin >> a[i];
	}
	
	vector<int> temp = a;
	
	sort(temp.begin() , temp.end());
	
	for(int i = 0 ; i < n ; i++){
		a[i] = lower_bound(temp.begin() , temp.end() , a[i]) - temp.begin() + 1;
	}
	
	bit = vector<int>(n+1);
	
	int inv = 0;
	
	for(int i = n-1; i >= 0 ; i--){
		inv += getSum(a[i] - 1);
		update(n , a[i] , 1);
	}
	
	cout << inv << "\n";
	
	
	return 0;
}