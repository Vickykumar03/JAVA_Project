import java.util.Scanner;

class Item {

    private String name;
    private double price;
    private int qty;

    Item(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public double getTotal() {
        return price * qty;
    }
}


class Bill {

    private Item[] items;

    Bill(Item[] items) {
        this.items = items;
    }

    public void generateReceipt() {

        double total = 0;

        StringBuilder sb = new StringBuilder();

        sb.append("\n====== Grocery Bill ======\n");
        sb.append("----------------------------------\n");
        sb.append("Item\tPrice\tQty\tTotal\n");
        sb.append("----------------------------------\n");

        for (Item i : items) {

            double itemTotal = i.getTotal();

            sb.append(i.getName())
              .append("\t")
              .append(i.getPrice())
              .append("\t")
              .append(i.getQty())
              .append("\t")
              .append(itemTotal)
              .append("\n");

            total += itemTotal;
        }

        double tax = total * 0.05;

        double grandTotal = total + tax;

        sb.append("----------------------------------\n");
        sb.append("Total: ").append(total).append("\n");
        sb.append("Tax (5%): ").append(tax).append("\n");
        sb.append("Grand Total: ").append(grandTotal).append("\n");

        System.out.println(sb);
    }
}


public class GroceryProject {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] arr = new Item[n];

        for (int i = 0; i < n; i++) {

            sc.nextLine();

            System.out.println("\nEnter details of Item " + (i + 1));

            System.out.print("Item Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int qty = sc.nextInt();

            arr[i] = new Item(name, price, qty);
        }

        Bill b = new Bill(arr);

        b.generateReceipt();

        sc.close();
    }
}