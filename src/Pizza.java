

public class Pizza extends Item{
    //Data Fileds
    private String topping;

    Pizza(String topping,double price){
        super("Pizza","Italian Pizza",price);
        this.setTopping(topping);
    }
    //setters and getters
    public void setTopping(String topping){
        this.topping=topping;
    }
    public String getTopping(){
        return this.topping;
    }
    //methods
    @Override
    public void display() {
        System.out.println(this.getTopping()+" "+super.getName()+"     "+super.getPrice());
        System.out.println(super.getDiscription()+" with "+this.getTopping());
    }
}
