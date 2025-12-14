package ge.edu.ug.patterns.behavioral.strategy.shoppingchart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingChart {

    private List<Product> items = new ArrayList<>();

    public void addItem(Product item){
        items.add(item);
    }

    public int getTotalAmount(){
        return this.items.stream().map(Product::getPrice).reduce(Integer::sum).orElse(0);
    }

    public void checkout(PaymentStrategy strategy){
        strategy.pay(getTotalAmount());
    }
}
