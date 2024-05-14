
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

class Receipt {
    private long ReceiptID;
    private String time;
    private List<Item> items;
    private double subtotal;
    private double tax = 0.26 ;
    private double taxAmount;
    private double totalAmount;
    private String customerName;


    public Receipt(long ReceiptID ) {
        this.ReceiptID = ReceiptID;
        this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.items = new ArrayList<>();
        this.subtotal = 0.0;
        this.taxAmount = 0.0;
        this.totalAmount = 0.0;

    }

    public void addItemToReceipt(Menu menu, int id, int quantity) {
        Item item = menu.getMenuItem(id);
        this.items.add(item);
        subtotal += menu.getItemPrice(id);

    }


    // Method to calculate tax amount
    private void calculateTax() {
        taxAmount = subtotal * tax;
    }

    // Method to calculate total amount including tax
    private void calculateTotalAmount() {
        totalAmount = subtotal + taxAmount;
    }

    public void printReceipt() {
        calculateTax();
        calculateTotalAmount();

        System.out.println("ReceiptID:   " + ReceiptID  );
        System.out.println("Date & Time: " + time );
        System.out.println("---------------------------------");
        System.out.println("Items:    Quantity:\tPrice:");
        for (Item item : items) {
            int quantity = item.getNoOfItems();
            System.out.println(item.getName() + "\t\t" +"x"+ quantity + "\t$" + item.getPrice() );
        }
        System.out.println("---------------------------------");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Tax Rate: " + (tax * 100) + "%");
        System.out.println("Tax Amount: $" + taxAmount);
        System.out.println("---------------------------------");
        System.out.println("Total Amount: $" + totalAmount);
    }


    public long getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(long ReceiptID) {
        this.ReceiptID = ReceiptID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}