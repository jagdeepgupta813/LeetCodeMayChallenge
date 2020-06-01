package practiceJava.leetcode.may.challenge;
/*
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 */

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanner {
	ArrayList<Pairs> stockPriceList;

	public static void main(String[] args) {
		StockSpanner s= new StockSpanner();
		
		
		  s.next(100);
		  s.next(80) ; s.next(60); s.next(70) ; s.next(60) ; 
		  s.next(101) ;
		  s.next(102); 
		  s.printStockPriceList(s.stockPriceList);
		 

			/*
			 * s.next1(100); s.next1(80) ; s.next1(60) ; s.next1(70) ; s.next1(60) ;
			 * s.next1(101) ; s.next1(102) ;
			 */
	}
	void printStockPriceList(ArrayList<Pairs> prices) {
		for(Pairs p:prices) {
			System.out.println("price "+ p.getStockPrice() + " spanner " + p.getSpanner());
		}
	}
	public StockSpanner() {
		stockPriceList=new ArrayList<Pairs>();
        
    }
    
	// as we dont need to store all the intermediate elements, so we can remove intermediate smaller prices
	//if the next element is greater than last it will add its spanner too and will check prices higher than the top 
	//otherwise the next will have spanner of 1 day, 
	
	Stack<int[]> stack = new Stack<>();
    public int next1(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        stack.push(new int[]{price, res});
        return res;
    }
    
    public int next(int price) {
        Pairs p = new Pairs();
        p.setStockPrice(price);
        int i=this.stockPriceList.size()-1;
        int count=1;
        while(i>=0) {
        	Pairs temp=this.stockPriceList.get(i);
        	if(temp.stockPrice<=p.getStockPrice()) {
        		count=count + temp.getSpanner();
        		i=i-temp.getSpanner();        		
        	}
        	else {
        		break;
        	}
        }
        p.setSpanner(count);
        this.stockPriceList.add(p);
    	return count;
    }

}

class Pairs{
	int stockPrice;
	int spanner;
	public int getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(int stockPrice) {
		this.stockPrice = stockPrice;
	}
	public int getSpanner() {
		return spanner;
	}
	public void setSpanner(int spanner) {
		this.spanner = spanner;
	}
}