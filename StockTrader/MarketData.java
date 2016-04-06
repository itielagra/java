public class MarketData {

    private int id=0;
    private String direction = new String();
    private String type = new String();
    private int shares=0;
    private double price = 0.00;

    public String getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getShares() {
        return shares;
    }

    public double getPrice() {
        return price;
    }

    MarketData(int id, String direction, String type, int shares,double price){
        this.id = id;
        this.direction = direction;
        this.type = type;
        this.shares = shares;
        this.price = price;
    }
}
