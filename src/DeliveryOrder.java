
import java.time.LocalDateTime;

public class DeliveryOrder extends Order {
    private String customerAddress;
    private boolean isDelivered;


    public DeliveryOrder( String customerName, String customerAddress , long customerPhone) {

        this.customerAddress = customerAddress;
        this.customerPhone =customerPhone;
        this.isDelivered = false;
    }
    DeliveryOrder(LocalDateTime OrderDateTime, String dataOfWorker ,String customerName,String customerAddress ,long customerPhone) {
        super( OrderDateTime, dataOfWorker , customerName, customerPhone);
        this.customerAddress = customerAddress;
        this.isDelivered = false;
    }


    @Override
    public String getTypeOfOrder() {
        return "Delivery";
    }

    @Override
    void processOrder() {
        try {
            markAsDelivered();
        } catch (DeliveryAlreadyCompletedException e) {
            e.printStackTrace();
        }
    }



    public void markAsDelivered() throws DeliveryAlreadyCompletedException {
        if (isDelivered) {
            throw new DeliveryAlreadyCompletedException("Order of Mr./Mrs. : " + customerName + " has already been delivered.");
        } else {
            isDelivered = true;
            System.out.println("Order of Mr./Mrs. : " + customerName + " has been delivered.");
        }
    }








    class DeliveryAlreadyCompletedException extends Exception {
        public DeliveryAlreadyCompletedException(String message) {
            super(message);
        }
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public boolean isIsDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    @Override
    public String toString() {
        return "Delivery{" + "customerAddress=" + customerAddress + ", isDelivered=" + isDelivered + '}';
    }




}