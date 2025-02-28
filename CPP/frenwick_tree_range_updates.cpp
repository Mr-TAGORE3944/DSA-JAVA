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


// update function
void update(int idx , int inc , int bit[] , int n){
	while(idx <= n){
		bit[idx] += inc;
		idx += idx & (-idx);
	}
}

int query(int idx , int bit[] , int n){
	int ans =0;
	while(idx > 0){
		ans += bit[idx];
		idx -= idx & (-idx);
	}
	
	return ans;
}

int main(){
	
	int t; cin >>t;
	while(t--){
		int n; cin>>n;
		int bit[n+10] = {0};
		// queries 
		int q; cin >> q;
		
		while(q--){
			int l,r,inc;
			cin >> l >> r >> inc;
			// make it one based index for easy inplementation
			l++;r++;
			update(l , inc , bit , n); // for adding the inc from 0 to l with positive inc
			update(r+1 , -inc , bit , n); // for adding the inc from r+1 to n with negative -inc
		}
		
		cin >> q;
		while(q--){
			int w; cin >> w;
			w++;
			cout << query(w , bit , n) << "\n";
		}
	}
	
	
	
	
	return 0;
}