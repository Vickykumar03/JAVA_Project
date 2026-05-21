import java.util.Scanner;

class Item {
    String name;
    double price;
    int qty;

    Item(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    double total() {
        return price * qty;
    }
}

class Bill {
    Item[] items;

    Bill(Item[] items) {
        this.items = items;
    }

    void showBill() {
        double total = 0;

        System.out.println("\n---- BILL ----");
        System.out.println("Name\tPrice\tQty\tTotal");

        for (Item i : items) {
            double itemTotal = i.total();
            System.out.println(i.name + "\t" + i.price + "\t" + i.qty + "\t" + itemTotal);
            total += itemTotal;
        }

        double tax = total * 0.05;
        double grandTotal = total + tax;

        System.out.println("----------------");
        System.out.println("Total: " + total);
        System.out.println("Tax: " + tax);
        System.out.println("Grand Total: " + grandTotal);
    }
}

public class GroceryProject {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many items? ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nItem " + (i + 1));

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Qty: ");
            int qty = sc.nextInt();

            items[i] = new Item(name, price, qty);
        }

        Bill bill = new Bill(items);
        bill.showBill();

        sc.close();
    }
}
