#include"bits/stdc++.h"
using namespace std;
const int N=210;
typedef long long ll;
#define int ll
int dp[N][1820][2];
const int mod=1e9+7;
bool p[1820];
bool isprime(int x){
	for(int i=2;i*i<=x;i++){
		if(x%i==0)return 0;
	}
	return 1;
}
int calc(string  s){
	memset(dp,0,sizeof dp);

	dp[0][0][0]=1;	
	int n=s.length();

	for(int i=0;i<n;i++){
		for(int sum=0;sum<=1800;sum++){
			for(int tight=0;tight<2;tight++){

				//if already smaller
				if(tight){
					for(int dig=0;dig<=9;dig++){
						dp[i+1][sum+dig][1]=(dp[i+1][sum+dig][1]+dp[i][sum][tight])%mod;
					}
				}
				else{

					int lim=s[i]-'0';

					for(int dig=0;dig<=lim;dig++){
						if(dig<lim){
							dp[i+1][sum+dig][1]=(dp[i+1][sum+dig][1]+dp[i][sum][tight])%mod;
						}
						else{
							dp[i+1][sum+dig][tight]=(dp[i+1][sum+dig][tight]+dp[i][sum][tight])%mod;
						}
					}
				}

			}
		}
	}

	int ans=0;
	for(int i=0;i<=1800;i++){
		if(p[i])ans=(ans+dp[n][i][0]+dp[n][i][1])%mod;
	}
	return ans;


}
int ok(string s){
	int sum=0;
	for(auto i:s)sum+=(i-'0');
	return p[sum];
}
void solve(){
	string l,r;
	cin>>l>>r;
	cout<<(calc(r)-calc(l)+ok(l)+mod)%mod<<"\n";

}
int32_t main(){

	for(int i=2;i<=1800;i++){
		p[i]=isprime(i);
	}
	int t;
	cin>>t;
	while(t--)solve();
}
