interface Eatable {
    public void display();

}



public class Burger extends Item{
    //Data Fileds
    private String burgerType;
    private String noOfPatties;
    //constructor
    Burger(String burgerType,String noOfPatties,double price){
        super("Burger","Juicy Burger",price);
        this.setBurgerType(burgerType);
        this.setNoOfPatties(noOfPatties);
    }
    //Setters and getters
    public void setBurgerType(String burgerType){
        this.burgerType=burgerType;
    }
    public String getBurgerType(){
        return this.burgerType;
    }
    public void setNoOfPatties(String noOfPatties){
        this.noOfPatties=noOfPatties;
    }
    public String getNoOfPatties(){
        return this.noOfPatties;
    }
    //methods
    @Override
    public void display() {
        System.out.println(this.getBurgerType()+" "+super.getName()+"     "+super.getPrice());
        System.out.println(this.getNoOfPatties()+" "+this.getBurgerType()+" "+super.getDiscription());
    }
}