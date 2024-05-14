

public class Salad extends Item{
    //Data fields
    private String type;
    private String topping;
    //constructor
    Salad(String type,String topping,double price){
        super("Salad",price);
        this.setTopping(topping);
        this.setType(type);
    }
    //setters and getters
    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return this.type;
    }
    public void setTopping(String topping){
        this.topping=topping;
    }
    public String getTopping(){
        return this.topping;
    }
    //methods
    @Override
    public void display() {
        System.out.println(this.getTopping()+" "+this.getType()+" "+super.getName()+"     "+super.getPrice());
        super.setDiscription("Healthy"+" "+this.getType()+" "+super.getName());
        System.out.println(super.getDiscription()+" with "+this.getTopping());
    }

}
