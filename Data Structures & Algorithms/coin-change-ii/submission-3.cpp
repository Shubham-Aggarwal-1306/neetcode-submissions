class Solution {
public:
    int change(int amount, vector<int>& coins) {
        vector<int> secondDp(amount + 1, 0);
        secondDp[0] = 1;

        for(int i=coins.size()-1;i>=0;i--){ 
            vector<int> firstDp(amount + 1, 0);
            firstDp[0] = 1;
            for(int j=1;j<=amount;j++){
                if(j >= coins[i]){
                    firstDp[j] += firstDp[j-coins[i]];
                }

                firstDp[j] += secondDp[j];
            }
            secondDp = firstDp;
        }

        return secondDp[amount];
    }
};
