import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

class Order {

    //data fields
    int numberOfOrder ;
    String typeOfOrder ;
    String dataOfCustomer ;  //name number and address
    int priceOfOrder ;
    Date dateOfOrder ;
    String wayOfOrder ;
    String dataOfWorker ;
    int numberOfProducts ;

    LocalDateTime OrderDateTime;
    ArrayList <Item> items;


    String customerName;
    long customerPhone;

    //constructors
    Order(){}
    Order (Date date,String dataOfWorker ,String customerName,long customerPhone){
        this.dateOfOrder = date ;
        this.dataOfWorker= dataOfWorker ;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }
    Order (LocalDateTime OrderDateTime,String dataOfWorker ,String customerName){
        this.OrderDateTime =OrderDateTime;
        this.dataOfWorker= dataOfWorker ;
        this.customerName = customerName;
       // this.customerPhone = customerPhone;
    }
    Order (LocalDateTime OrderDateTime,String dataOfWorker ,String customerName,long customerPhone){
        this.OrderDateTime =OrderDateTime;
        this.dataOfWorker= dataOfWorker ;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }
    Order (String customerName,long customerPhone){
        this.customerName = customerName;
        this.customerPhone = customerPhone;
    }

    //methods
    /////////*NOT USED*/////////
    //int productsNumber (String product );

    int ordering (Item firstItem, int numberOfItems ,String wayOfOrder ){
		/*items=new ArrayList();
		items.add(firstItem);*/
        firstItem.setNoOfItems(numberOfItems);
        return 0;

    }
    void processOrder(){ }


    //getters and setters

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }

    public String getTypeOfOrder() {
        return typeOfOrder;
    }

    public void setTypeOfOrder(String typeOfOrder) {
        this.typeOfOrder = typeOfOrder;
    }

    public String getDataOfCustomer() {
        return dataOfCustomer;
    }

    public void setDataOfCustomer(String dataOfCustomer) {
        this.dataOfCustomer = dataOfCustomer;
    }

    public int getPriceOfOrder() {
        return priceOfOrder;
    }

    public void setPriceOfOrder(int priceOfOrder) {
        this.priceOfOrder = priceOfOrder;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getWayOfOrder() {
        return wayOfOrder;
    }

    public void setWayOfOrder(String wayOfOrder) {
        this.wayOfOrder = wayOfOrder;
    }

    public String getDataOfWorker() {
        return dataOfWorker;
    }

    public void setDataOfWorker(String dataOfWorker) {
        this.dataOfWorker = dataOfWorker;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }
}