package ge.edu.ug.patterns.behavioral.strategy.shoppingchart;

public class FidgetSpinner implements Product{

    int price;

    public FidgetSpinner(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return 500;
    }
}
