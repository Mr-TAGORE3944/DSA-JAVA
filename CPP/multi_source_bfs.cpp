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

int rr[] = {0 , 0 , 1 , -1};
int cc[] = {1 , -1 , 0 , 0};

int multi_source_bfs(int n , vector<pair<int,int>> police){
	queue<pair<int,int>> q;
	int dp[n+1][n+1] , vis[n+1][n+1];
	memset(dp , INT_MAX , sizeof(dp));
	memset(vis , 0 , sizeof(vis));
	
	
	for(auto &[x,y] : police){
		dp[x][y] = 0;
		q.push({x , y});
	}
	
	while(!q.empty()){
		pair<int,int> node = q.front(); q.pop();
		
		for(int i = 0 ; i < 4 ; i++){
			int dx = x + rr[i] , dy = y + cc[i];
			if(dp[dx][dy] > dp[x][y] + 1){
				dp[dx][dy] = dp[x][y] + 1;
				q.push({dx , dy});
			}
		}
	}
}