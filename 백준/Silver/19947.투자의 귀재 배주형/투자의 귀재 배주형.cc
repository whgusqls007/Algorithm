#include <bits/stdc++.h>
using namespace std;;;;;;;;;;;;;;;;
using ll=long long;

ll dp[11];
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> dp[0] >> n;
    for(int i=1;i<=n;i++){
        dp[i]=dp[i-1]*21/20;
        if(i>2) dp[i]=max(dp[i],dp[i-3]*6/5);
        if(i>4) dp[i]=max(dp[i],dp[i-5]*27/20);
    }
    cout << dp[n];
}