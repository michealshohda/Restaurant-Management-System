import java.util.Date;

abstract class Order {

    //data feilds
    int numberOfOrder ;
    String typeOfOrder ;
    String dataOfCustomer ;  //name number and address
    int priceOfOrder ;
    Date dateOfOrder ;
    String wayOfOrder ;
    String dataOfWorker ;
    int numberOfProducts ;

    String customerName;


    //constractors
    Order(){}

    Order (String customerName){
        //this.dateOfOrder = date ;
       // this.dataOfWorker= dataOfWorker ;
        this.customerName = customerName;

    }

    //methods
    abstract int productsNumber (String product );
    abstract int ordering (String wayOfOrder , int numberOfProducts );


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
