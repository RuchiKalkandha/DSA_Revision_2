public class BuyAndSellStocks {

    // brute force approach
    // for each i, we will see ki next day hm kb beche ki profit ho
    // to hm he i k lia, i+1 to end of array tk max find krenge
    // or us din khridne p kya max profit hoga vo hme mil jaega
    // age ye global max profit se jyada h to hm maxProfit ko update krdenge 
    // otherwise we will move to next i and the loop goes on
    // iski time complexity hogi O(n square) bcz of nested loops

    // Optimised approach will be
    // hm buyprice variable lenge jisme hm sbse phle din ka price store krdenge,
    // meaning hmne phle din hi stocks khrid lia the,
    // now for each i (loop chlegi)
    // agr buyprice se jyada h next price to hme profit hoga,
    // hm vo profit nikalenge or max_profit update krdenge agr vo max_profit se jyada h
    // agr buyprice se km h price[i] , mtlb is se km price available h, uspe agr hm khridenge to aage or profit hoga, pichle buyprice k mukable
    // to hm buyprice ko is price se update krdenge 
    // or ye loop aaise hi last tk continue rhega.

    public static int maxProfit(int prices[]){
        int buyPrice = prices[0];
        int max_profit = 0;
        for(int i = 0; i<prices.length;i++){
            if(buyPrice<prices[i]){
                int profit = prices[i] - buyPrice; //today's profit
                max_profit = Math.max(max_profit,profit);
            }
            else{
                buyPrice = prices[i];
            }
        }
        return max_profit;
    }
    public static void main(String args[]){
        int prices[] = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
