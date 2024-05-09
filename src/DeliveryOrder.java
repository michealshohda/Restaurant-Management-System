import java.time.LocalDateTime;
import java.util.Date;

public class DeliveryOrder extends Order {
    private String customerAddress;
    private long customerPhone;
    private boolean isDelivered;



    public DeliveryOrder( String customerName, String customerAddress , long customerPhone) {
        super( customerName);
        this.customerAddress = customerAddress;
        this.customerPhone =customerPhone;
        this.isDelivered = false;
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
  
 
    
    @Override
    int productsNumber(String product) {
        return 0;
    }

    @Override
    int ordering(String wayOfOrder, int numberOfProducts) {
        return 0;
    }

    public long getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(long customerPhone) {
        this.customerPhone = customerPhone;
    }
    
}

