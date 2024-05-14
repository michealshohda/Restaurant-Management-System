

public class Sandwich extends Item{
    private String filling;
    private String typeOfBread;
    Sandwich(String filling,String typeOfBread,double price){
        super("Sandwich",price);
        this.setFilling(filling);
        this.setTypeOfBread(typeOfBread);
    }
    //setters and getters
    public void setFilling(String filling){
        this.filling=filling;
    }
    public String getFilling(){
        return this.filling;
    }
    public void setTypeOfBread(String typeOfBread){
        this.typeOfBread=typeOfBread;
    }
    public String getTypeOfBread(){
        return this.typeOfBread;
    }
    //methods
    @Override
    public void display() {
        System.out.println(this.getFilling()+" "+super.getName()+"     "+super.getPrice());
        super.setDiscription(this.getFilling()+" "+super.getName()+" in our special "+this.getTypeOfBread()+" Bread");
        System.out.println(super.getDiscription());
    }
}