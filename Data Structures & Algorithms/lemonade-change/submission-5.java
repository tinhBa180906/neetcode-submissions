class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] money = new int[3]; //money[0] so to tien 5$
                                  //money[1] so to tien 10$
                                  //money[2] so to tien 20$
        money[0] = 0;
        money[1] = 0;
        money[2] = 0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) money[0]++;
            else if(bills[i] == 10) {
                if(money[0] > 0) {
                    money[0] --;
                    money[1]++;
                }
                else return false;
            } 
            else if(bills[i] == 20) {
                if(money[0] >= 3 ) {
                    money[0]-=3;
                    money[2]++;
                } else if (money[0] > 0 && money[1] > 0)  {
                    money[0]--;
                    money[1]--;
                    money[2]++;
                }
                else return false;
            }
        }
        
        return true;
    }
}