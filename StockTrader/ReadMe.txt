The purpose of this program is to simulate realtime stock trading.

included is: 
data input file (simulate realtime data gahtering)
A MarketData java file for parsing the data
Output file to compare your results to
StockTrader java file

Sample input below:
1,"BUY","MARKET",100,NULL
2,"BUY","LIMIT",100,94.00
3,"SELL","MARKET",100,NULL
4,"SELL","LIMIT",100,93.00

First column is the id number based on who entered the market first
Second column is whether the person is buying or selling stock
Third column is for how the stock is to be bought or sold.
Fourth column is the number of stock being purchased or sold (this program is designed to only handle each person buying and selling 100 shares)
Fifth Column is the price to be purchased or sold

LIMIT EXPLAINED
for buying, limit is the max you're willing to pay and for selling it's the minimum you'll sell at

MARKET EXPLAINED
for buying and selling, market means that you will buy or sell at what ever price is currently being set.

The logic behind the stock trading is as follows: B=buyer S=seller M=market L=limit
BM & SM = no sale since no set price
BM & SL = sale at the price of the seller
BL & SM = sale at the price of the buyer
*BL & SL = sale, using the price of who ever enter the market first (smaller id number)

*For BL & SL, a sale is only possible if the buyer has a limit set equal to graeter than the seller.
  If the limit for the buyer is greater but the id is greater than the seller ID, the price used is that of the seller,
  If the id for the buy is smaller, that the buyer price is used
