class Solution {
    int helper(int i,int amount,vector<int>& coins,vector<vector<int>> &dp){
        if(amount == 0){
            return 1;
        }

        if(i == coins.size()){
            return 0;
        }

        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int ways = 0;
        if(coins[i] <= amount){
            ways += helper(i,amount-coins[i],coins,dp);
        }

        ways += helper(i+1,amount,coins,dp);

        return dp[i][amount]=ways;
    }
public:
    int change(int amount, vector<int>& coins) {
        vector<vector<int>> dp(coins.size(),vector<int>(amount+1,-1));
        return helper(0,amount,coins,dp);
    }
};
