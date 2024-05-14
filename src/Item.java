public class Item implements Comparable<Item> , Eatable{
    //Data Fields
    private String name;
    private String discreption="";
    private double price;
    private boolean availability=true;
    private int id;
    private static int counter=1;
    private int noOfItems=1;
    //Constructors
    Item(){
    }
    Item(String name,String discreption,double price){
        this.setName(name);
        this.setDiscription(discreption);
        this.setPrice(price);
        this.setId(counter);
        counter++;
    }
    Item(String name,double price){
        this.setName(name);
        this.setPrice(price);
        this.setId(counter);
        counter++;
    }
    //getters and setters
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDiscription() {
        return this.discreption;
    }
    public void setDiscription(String discription) {
        this.discreption=discription;
    }
    public boolean getAvailability() {
        return this.availability;
    }
    public void setAvailability(boolean availability) {
        this.availability=availability;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id=id;
    }
    public int getNoOfItems() {
        return this.noOfItems;
    }
    public void setNoOfItems(int noOfItems) {
        this.noOfItems=noOfItems;
    }
    //utilities
    public void display() {
        System.out.println(this.getName()+"       "+this.getPrice());
        System.out.println(this.getDiscription());
    }
    public double calculatePrice() {
        return this.getNoOfItems()*this.getPrice();
    }

    //Interface Comparable
    @Override
    public int compareTo(Item o) {
        if(o.getPrice()==this.getPrice())
            return 0;
        else if (o.getPrice()<this.getPrice())
            return 1;
        else if (o.getPrice()>this.getPrice())
            return -1;
        else
            return 0;
    }

}