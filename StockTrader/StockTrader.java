import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class StockTrader{

    public static void main(String args[]) throws FileNotFoundException{

        List<MarketData> market = new ArrayList<>(); //stores all data from file
        List<MarketData> buyers = new ArrayList<>(); //stores buyer data from market data
        List<MarketData> sellers = new ArrayList<>(); //stores seller data from
        MarketData buyTemp; // store the current buyer data

        int sale = 0; //used for declaring if a sale has been made
        int buyId = 0; //if sale, store buyers id
        int sellId = 0; //if sale, store sellers id
        int saleShares =0; //if sale, store number of shares
        double salePrice =0; //if sale, store sale price


        //SECTION FILE START: use if available file, comment out section FILE
        fileManager("inputData.csv",market);


        //SECTION HARD-CODE START: UNCOMMENT if you'd like to use hardcoded data instead

//        market.add(new MarketData(1,"BUY","MARKET",100,102.23));
//        market.add(new MarketData(2,"BUY","LIMIT",100,94.00));
//        market.add(new MarketData(3,"SELL","MARKET",100,0.0));
//        market.add(new MarketData(4,"SELL","LIMIT",100,93.00));

        //SECTION HARD-CODE END

        //Distribute market list into buyers and sellers list
        for(MarketData m : market){
            if(m.getDirection().equalsIgnoreCase("BUY")){
                buyers.add(m);
            }
            else {
                sellers.add(m);
            }
        }

        //Each buyer goes in order of ascedning id# and attempts a sale going through seller list until
        // sale is made or goes through entire sell list. Once sale made, seller removed from sellers list

        //LOGIC IS AS FOLLOWS: B=buyer S=seller M=market L=limit
        // BM & SM = no sale
        // BM & SL = sale
        // BL & SM = sale
        // BL & SL = sale, using the price of smaller id

        for(int i =0; i < buyers.size();i++){
            if(sellers.size()>0) {
                buyTemp = buyers.get(i);
                for (MarketData sellTemp : sellers) {

                    sale=determineSale(buyTemp,sellTemp);

                    if (sale != 0) {
                        buyId=buyTemp.getId();
                        sellId=sellTemp.getId();
                        saleShares=buyTemp.getShares();
                        salePrice =getPrice(buyTemp,sellTemp,sale);

                        System.out.println(buyId+ "," + sellId + "," + saleShares + "," + salePrice);

                        sellers.remove(sellers.indexOf(sellTemp));
                        break;
                    }
                }
            }
            else{
                break;
            }
        }
    }




    //Reads in and parses file into market data list
    public static void fileManager(String fileName,List market) throws FileNotFoundException{
        String preParse= new String(); //store line from file
        String[] postParse = new String[5]; //parse that line into a string array

        //Temp variables to store into market list
        int tempId =0;
        String tempDirection = new String();
        String tempType = new String();
        int tempShare=0;
        double tempPrice=0.00;


        Scanner sc = new Scanner(new File(fileName));
        preParse = sc.nextLine(); //removes title row

        //Used to parse file into market list
        while(sc.hasNext()){
            preParse = sc.nextLine();
            postParse = preParse.split(",");
            for (int i =0; i < postParse.length;i++) {
                switch (i) {
                    case 0 : tempId = Integer.parseInt(postParse[0]);
                        break;
                    case 1 : tempDirection = postParse[1];
                        break;
                    case 2 : tempType = postParse[2];
                        break;
                    case 3 : tempShare = Integer.parseInt(postParse[3]);
                        break;
                    case 4 : if(tempType.equalsIgnoreCase("LIMIT")){
                        tempPrice = Double.parseDouble(postParse[4]);
                    }
                    else{//store zero in place of NULL
                        tempPrice = 0d;
                    }
                        break;
                    default:
                        break;
                }
            }
            market.add(new MarketData(tempId,tempDirection,tempType,tempShare,tempPrice));
        }
        sc.close();
    }

    public static int determineSale(MarketData buyTemp, MarketData sellTemp){
        int saleType = 0;

        if (buyTemp.getType().equalsIgnoreCase("MARKET") && sellTemp.getType().equalsIgnoreCase("MARKET")) {
            saleType = 0;
        } else if (buyTemp.getType().equalsIgnoreCase("LIMIT") && sellTemp.getType().equalsIgnoreCase("MARKET")) {
            saleType = 1;
        } else if (buyTemp.getType().equalsIgnoreCase("MARKET") && sellTemp.getType().equalsIgnoreCase("LIMIT")) {
            saleType = 2;
        } else if (buyTemp.getType().equalsIgnoreCase("LIMIT") && sellTemp.getType().equalsIgnoreCase("LIMIT")) {
            if (buyTemp.getPrice() < sellTemp.getPrice()) {
                saleType = 0;
            }
            else if (buyTemp.getPrice() >= sellTemp.getPrice()) {
                if(buyTemp.getId() < sellTemp.getId()){
                    saleType=1;
                }
                else if(buyTemp.getId() > sellTemp.getId()){
                    saleType=2;
                }
            }
        }
        return saleType;
    }

    public static double getPrice(MarketData buy, MarketData sell, int sale){
        double price = 0;
        if (sale==1){
            price= buy.getPrice();
        }
        else if(sale==2){
            price= sell.getPrice();
        }
        return price;
    }
}