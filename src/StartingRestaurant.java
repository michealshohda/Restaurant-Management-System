
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StartingRestaurant {
    private Scanner input;
    private String userInput;
    private String s1;
    private int orderCounter=0;
    private int noOfItems;
    private String s2;
    private Menu ourMenu1=new Menu("Menu 1");
    private Menu ourMenu2=new Menu("Menu 2");
    private ArrayList<Order> orders=new ArrayList<Order>();
    private ArrayList<Receipt> receipts=new ArrayList<Receipt>();
    private int receiptId=1010;
    public StartingRestaurant() {
        input=new Scanner(System.in);
        while(true) {
            System.out.println("Enter 'Menu' for menu or 'Order' for ordering or 'Exit' to exit console application");
            userInput=input.nextLine();
            if(userInput.equalsIgnoreCase("Menu")) {
                System.out.println("Enter 'Main menu' for default menu or 'Secret menu' for our secret items :");
                userInput=input.nextLine();
                if(userInput.equalsIgnoreCase("Main menu")) {
                    ourMenu1.displayMenu();
                    System.out.println("Enter 'return' to make order or 'add' to add item or 'sort' to sort menu by prices");
                    userInput=input.nextLine();
                    if(userInput.equalsIgnoreCase("return")) {
                        continue;
                    }
                    else if(userInput.equalsIgnoreCase("add")) {

                        double s2;
                        System.out.println("Enter the item name");
                        userInput=input.nextLine();
                        System.out.println("Enter the item description");
                        s1=input.nextLine();
                        System.out.println("Enter the item price");
                        s2=input.nextDouble();
                        input.nextLine();
                        ourMenu1.addItem(new Item(userInput,s1,s2));
                    }
                    else if(userInput.equalsIgnoreCase("sort")) {
                        ourMenu1.sortMenu();
                        ourMenu1.displayMenu();
                    }

                }
                else if(userInput.equalsIgnoreCase("Secret menu")) {
                    ourMenu2.displayMenu();
                    System.out.println("Enter 'return' to make order or 'add' to add item or 'sort' to sort menu by prices");
                    userInput=input.nextLine();
                    if(userInput.equalsIgnoreCase("return")) {
                        continue;
                    }
                    else if(userInput.equalsIgnoreCase("add")) {
                        String s1;
                        double s2;
                        System.out.println("Enter the item name");
                        userInput=input.nextLine();
                        System.out.println("Enter the item description");
                        s1=input.nextLine();
                        System.out.println("Enter the item price");
                        s2=input.nextDouble();
                        input.nextLine();
                        ourMenu2.addItem(new Item(userInput,s1,s2));
                        System.out.println("Item "+ userInput+" added succesfully");
                    }
                    else if(userInput.equalsIgnoreCase("sort")) {
                        ourMenu2.sortMenu();
                        ourMenu2.displayMenu();
                    }
                    else {
                        System.out.println("Invalid user input");
                        continue;
                    }
                }
                else {
                    System.out.println("Invalid user input");
                    continue;
                }
            }
            else if(userInput.equalsIgnoreCase("Order")) {
                long customerNumber;
                int id;
                System.out.println("Cashier name:");
                String CashierName=input.nextLine();


                System.out.println("Enter Type of Order : Reservation Or Delivery ");
                Order newOrder;
                String orderType = input.nextLine();
                if(orderType.equalsIgnoreCase("Reservation")){
                    System.out.println("Enter customer name:");
                    String customerName = input.nextLine();
                    System.out.println("Enter customer phone number:");
                    customerNumber = input.nextLong();
                    input.nextLine();
                    System.out.println("Enter table number:");
                    int tableNumber = input.nextInt();
                    System.out.println("Enter number of seats:");
                    int numberOfSeats = input.nextInt();
                    input.nextLine();

                    // Create reservation object
                    newOrder = new Reservation( LocalDateTime.now() , CashierName , customerName,  tableNumber, numberOfSeats);
                }


                else if (orderType.equalsIgnoreCase("Delivery")){
                    System.out.println("Enter customer name:");
                    String customerName = input.nextLine();
                    System.out.println("Enter customer phone number:");
                    customerNumber = input.nextLong();
                    input.nextLine(); // Consume newline left-over
                    System.out.println("Enter customer address:");
                    String customerAddress = input.nextLine();

                    // Create delivery order object
                    newOrder  = new DeliveryOrder(LocalDateTime.now(), CashierName, customerName, customerAddress , customerNumber);
                }
                else {
                    System.out.println("Invalid order type");
                    continue;
                }
                newOrder.processOrder();



                System.out.println("Choose Menu Item:");
                s2=input.nextLine();
                id=Menu.getItemId(s2);
                System.out.println("Number of Items:");
                noOfItems=input.nextInt();
                input.nextLine();
                System.out.println("Please Enter 'Confirm' to place your order");
                s2=input.nextLine();

                if(s2.equalsIgnoreCase("confirm")) {
                    orderCounter++;
                    orders.add(new Order(LocalDateTime.now(),userInput,s1,customerNumber));
                    orders.get(orderCounter-1).ordering(ourMenu1.getMenuItem(id), noOfItems, "Cash");
                    System.out.println("Your order has been placed succesfully");
                    System.out.println("enter 'print' to print your recipt ");
                    userInput=input.nextLine();
                    if(userInput.equalsIgnoreCase("print")) {
                        receipts.add(new Receipt(receiptId));
                        receiptId++;
                        receipts.get(orderCounter-1).addItemToReceipt(ourMenu1, id, noOfItems);
                        System.out.println("\n*Receipt*");
                        receipts.get(orderCounter-1).printReceipt();
                        System.out.println("\n*End*\n");
                    }

                }
                else
                    continue;

            }
            else if(userInput.equalsIgnoreCase("exit"))
                break;
        }
    }

}