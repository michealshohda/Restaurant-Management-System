

import java.util.ArrayList;
import java.util.Collections;

public class Menu {
    //Data Fields
    private ArrayList <Item> items;
    private int noOfItems;
    //Constructors
    Menu(){
        this.items=new ArrayList <Item> ();
        this.noOfItems=0;
    }
    Menu(String menuNumber){
        if(menuNumber=="Menu 1") {
            this.items=new ArrayList <Item> ();
            addItem(new Burger("Beef","double",180));	//ID=1
            addItem(new Pizza("Pepperoni",220));		//ID=2
            addItem(new Salad("Ceaser","Chicken",90));	//ID=3
            addItem(new Sandwich("Fajita","Baguette",140));//ID=4
            this.noOfItems=4;
        }
        else if(menuNumber=="Menu 2") {
            this.items=new ArrayList <Item> ();
            addItem(new Burger("Chicken","single",120));	//ID=1
            addItem(new Pizza("Mix Cheese",200));		//ID=2
            addItem(new Salad("Fatoush","Pomegranate",90));	//ID=3
            addItem(new Sandwich("Shrimp","Brioche",290));//ID=4
            this.noOfItems=4;
        }
    }
    //Methods
    public void addItem(Item item){	//adding items to the menu
        this.items.add(item);
        this.noOfItems++;
    }

    public void displayMenu() {
        for(int i=0;i<noOfItems;i++) {
            if(items.get(i).getAvailability()==true) {
                items.get(i).display();System.out.println(items.get(i).getId());
                System.out.println("*****************************");
            }
            else if(items.get(i).getAvailability()==false) {
                System.out.println("  **  NOT AVAILABLE  **");
                items.get(i).display();System.out.println(items.get(i).getId());
                System.out.println("*****************************");
            }
        }
    }
    public void setMenuItemAvailability(int id,boolean available){
        for(int i=0;i<noOfItems;i++) {
            if(id==items.get(i).getId())
                items.get(i).setAvailability(available);
        }
    }
    public Item getMenuItem(int id) {
        for(int i=0;i<noOfItems;i++) {
            if(id==items.get(i).getId())
                return items.get(i);
        }
        return new Item("Not valid",0);
    }
    public double getItemPrice(int id) {
        return getMenuItem(id).calculatePrice();
    }
    //generic sort method
    public void sortMenu() {
        Collections.sort(items);
    }
    //utilities
    public static int getItemId(String item) {
        if(item.equalsIgnoreCase("burger"))
            return 1;
        else if(item.equalsIgnoreCase("pizza"))
            return 2;
        else if(item.equalsIgnoreCase("salad"))
            return 3;
        else if(item.equalsIgnoreCase("sandwich"))
            return 4;
        else
            return 0;
    }

}