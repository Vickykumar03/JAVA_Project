import java.util.*;

class Item{
    String itemName;
    int price;
    int qnty;

    Item(String itemName,int price,int qnty){
        this.itemName = itemName;
        this.price = price;
        this.qnty = qnty;
    }
}

class Bill {
    Item item[]; 

    Bill(Item[] item){
        this.item = item;
    }
    void showBill(){
        StringBuilder receipt = new StringBuilder();

        receipt.append("------ Grocery Bill ------\n");

        receipt.append("Item\tPrice\tQty\tTotal\n");

        int Total = 0;
        for(Item i:item){
            int subTotal = i.price*i.qnty;

            Total +=subTotal;
            receipt.append(i.itemName +"\t"+i.price+"\t"+i.qnty+"\t"+subTotal+"\n");
            
        }
        float tax = (float)(Total*0.05);
        receipt.append("\nTotal: "+Total+"\nTax(5%): "+tax+"\nGrand Total: "+(tax+Total));

        System.out.println(receipt.toString());
    }

}
public class GroceryProject{
    public static void main(String[] ar){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Item item[] = new Item[n];

        for(int i=0;i<n;i++){

            String name = sc.next();
            int price = sc.nextInt();
            int qnty = sc.nextInt();
            item[i] = new Item(name,price,qnty);
        }
        Bill a = new Bill(item);


        a.showBill();

    }
}