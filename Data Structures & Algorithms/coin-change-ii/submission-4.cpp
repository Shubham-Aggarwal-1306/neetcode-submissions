class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int> prev(amount + 1, 0);
        prev[0] = 1;

        for(int i=0;i<coins.size();i++){ 
            vector<int> curr(amount + 1, 0);
            curr[0] = 1;
            for(int j=1;j<=amount;j++){
                if(j >= coins[i]){
                    curr[j] += curr[j-coins[i]];
                }

                curr[j] += prev[j];
            }
            prev = curr;
        }

        return prev[amount];
    }
};
