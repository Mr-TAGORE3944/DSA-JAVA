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



int query(int idx){
	int ans = 0;
	while(idx > 0){
		ans += bit[idx];
		idx -= idx & (-idx);
	}
	return ans;
}
void update(int idx , int val){
	while(idx <= n){
		bit[idx] += val;
		idx += idx & (-idx);
	}
}

int main(){
	cin >> n;
	bit = vector<int>(n+1);
	vector<int> a(n+1);
	
	for(int i = 1 ; i <= n ; i++){
		cin>>a[i];
		update(i , a[i]);
	}
	int q;cin>>q;
	
	while(q--){
		int c; cin >>c;
		
		if(c == 1){
			int l,r;cin>>l>>r;
			int ans = query(r) - query(l-1);
			cout << ans << "\n";
		}else if( c == 2){
			int idx,val;cin >> idx >> val;
			update(idx , -a[idx]);
			a[idx] = val;
			update(idx , val);
		}
	}
	return 0;
}