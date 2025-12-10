package ge.edu.ug;

public class ShopItem {
    private String name;
    private int price;

    public ShopItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}