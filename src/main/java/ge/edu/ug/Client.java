package ge.edu.ug;

import strategy.concreteStrategies.CreditCardPayment;
import strategy.concreteStrategies.CryptoPayment;
import strategy.concreteStrategies.PayPalPayment;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Client {
    static ShoppingCart shoppingCart = new ShoppingCart();

    public static void handleItemEntry(Map<Integer, ShopItem> shopItems) {
        Scanner scanner = new Scanner(System.in);
        String chosenItem = "0";

        while (!chosenItem.equals("m")) {
            System.out.println("Enter m to go back to main menu");
            System.out.print("Enter item id: ");
            chosenItem = scanner.nextLine();
            int chosenItemInteger = 0;

            try {
                chosenItemInteger = Integer.parseInt(chosenItem);
            } catch (NumberFormatException e) {
                continue;
            }

            if (shopItems.containsKey(chosenItemInteger)) {
                ShopItem addedItem = shopItems.get(chosenItemInteger);
                System.out.println(
                        "You added item #"
                                + chosenItem + " "
                                + addedItem.getName() + " with the price "
                                + addedItem.getPrice() + "$"
                                + " to your shopping cart"
                );
                shoppingCart.addItem(addedItem);
            } else {
                System.out.println("Item #" + chosenItem + " does not exist in the shop.");
            }
        }
    }

    public static void handleCheckout() {
        Scanner scanner = new Scanner(System.in);
        String chosenItem = "0";

        while (!chosenItem.equals("m")) {
            System.out.println("Enter m to go back to main menu");
            System.out.println("Choose payment method:");
            System.out.println("Press 1 to pay with credit card");
            System.out.println("Press 2 to pay with crypto");
            System.out.println("Press 3 to pay with paypal");

            chosenItem = scanner.nextLine();
            int chosenItemInteger = 0;

            try {
                chosenItemInteger = Integer.parseInt(chosenItem);
            } catch (NumberFormatException e) {
                continue;
            }

            switch (chosenItemInteger) {
                case 1 -> {
                    shoppingCart.setPaymentStrategy(new CreditCardPayment());
                }

                case 2 -> {
                    shoppingCart.setPaymentStrategy(new CryptoPayment());
                }

                case 3 -> {
                    shoppingCart.setPaymentStrategy(new PayPalPayment());
                }
            }

            shoppingCart.checkout(shoppingCart.calculateTotalAmount());
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, ShopItem> shopItems = new HashMap<>();
        Random randomId = new Random();

        shopItems.put(
                randomId.nextInt(1, 100),
                new ShopItem("T-shirt", 15)
        );
        shopItems.put(
                randomId.nextInt(1, 100),
                new ShopItem("Dress", 30)
        );
        shopItems.put(
                randomId.nextInt(1, 100),
                new ShopItem("Playstation 5", 100)
        );
        shopItems.put(
                randomId.nextInt(1, 100),
                new ShopItem("Samsung s24", 3000)
        );
        shopItems.put(
                randomId.nextInt(1, 100),
                new ShopItem("Boots", 50)
        );
        shopItems.put(
                randomId.nextInt(1, 100),
                new ShopItem("Wallet", 70)
        );

        for (Map.Entry<Integer, ShopItem> itemEntry: shopItems.entrySet()) {
            int itemId = itemEntry.getKey();
            ShopItem item = itemEntry.getValue();
            System.out.println("Item #" + itemId + ": " + item.getName() + " ------------------ " + item.getPrice() + "$");
        }

        Scanner scanner = new Scanner(System.in);
        String chosenAction = "0";

        while (!chosenAction.equals("x")) {
            System.out.println();
            System.out.println("Press 1 to add items to cart");
            System.out.println("Press 2 to display items in the cart");
            System.out.println("Press 3 to checkout");
            System.out.println("Press x to exit");

            chosenAction = scanner.nextLine();

            switch (chosenAction) {
                case "1" -> {
                    handleItemEntry(shopItems);
                }

                case "3" -> {
                    handleCheckout();
                }

                default -> {

                }
            }
        }
    }
}
