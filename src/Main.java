import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        System.out.println("welcome to our java resturant, we serve semicolons only!");
        Application.launch();

    }

    @Override
    public void start(Stage stage) throws Exception {

        //-----------------------------------------
        //-------making the needed nodes--------------
        //-----------------------------------------

        //text needed
        Text Name = new Text("Name : ");
        Text address = new Text("address : ");
        Text order = new Text("order : ");
        Text welcome = new Text("Welcome to our resturant!");
        Text phoneNo = new Text("Phone number : ");
        Text tableNo = new Text("table Number : ");
        Text numberOfPeople = new Text("number of people : ");
        Text priceTx = new Text("total price : ");
        Text ordersCount = new Text("orders count : ");
        Text foodCount = new Text("  count ");

        welcome.setFont(new Font(20));

        // text fieldes
        TextField fnamefild = new TextField();
        TextField addressfild = new TextField();
        TextField pricefild = new TextField();
        TextField phoneNofild = new TextField();
        TextField tableNofild = new TextField();
        TextField numberOfPeoplefild = new TextField();
        TextField ordersCountfild = new TextField();
        TextField foodCountfild = new TextField();

        //edit some text fields
        pricefild.setEditable(false);

        ordersCountfild.setPrefWidth(5);
        ordersCountfild.setEditable(false);

        foodCountfild.setPrefWidth(20);
        foodCountfild.setText("0");
        foodCountfild.setEditable(false);



        // buttons
        Button placeOrderBtm = new Button("place order") ;
        Button cancelBtm = new Button("cancel") ;
        Button plusButton = new Button("+");
        Button minusButton = new Button("-");

        //radiobuttons
        RadioButton inStoreOrder_RadioButton = new RadioButton("in store order");
        RadioButton takeAwayOrder_RadioButton = new RadioButton("take away order");

        //dropdown menu
        ComboBox<String> foodComboBox = new ComboBox<>();
        foodComboBox.getItems().addAll("Burger", "Pizza", "Salad", "Sandwich");
        foodComboBox.setPromptText("Choose what to eat");

        //error alert
        Alert numberInputError = new Alert(Alert.AlertType.ERROR);
        numberInputError.setHeaderText(null);
        numberInputError.setContentText("invalid format or empty data field! Please try again.");

        //successful operation alert
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setHeaderText(null);
        successAlert.setContentText("Order has been placed successfully !");





        // make the array list to store orders
        ArrayList<Order> ordersList = new ArrayList<>();


        //dsiplay the price
        foodComboBox.setOnAction(event -> {

            String selectedItem = foodComboBox.getValue();
            //double price = getPrice(selectedItem);
            pricefild.setText( selectedItem + " EGP");
        });



        //-----------------------------------------
        //-------logical main - driver --------------
        //-----------------------------------------


        //[[[[[[[[[ if PLACE ORDER buttom is pressed ]]]]]]]]]]]]]]
        placeOrderBtm.setOnAction(event -> {

            boolean flag ;
            //and IN STORE ORDER is selected
            if(inStoreOrder_RadioButton.isSelected()){
                Order r1 = null ;
                try {
                     r1 = new Reservation(fnamefild.getText(), Integer.valueOf(tableNofild.getText()), Integer.valueOf(numberOfPeoplefild.getText()));
                    flag = true;
                }
                catch (NumberFormatException e ){
                    numberInputError.showAndWait();
                    flag = false;
                }
                if (flag) {
                    //addes new object refrence to the array list
                    ordersList.add(r1) ;
                    //update the order counter
                    ordersCountfild.setText(String.valueOf(ordersList.size()));
                    // show success messge
                    successAlert.showAndWait();


                    //clear user input
                    inStoreOrder_RadioButton.setSelected(false);
                    takeAwayOrder_RadioButton.setSelected(false);
                    fnamefild.clear();
                    addressfild.clear();
                    phoneNofild.clear();
                    numberOfPeoplefild.clear();
                    tableNofild.clear();
                    foodComboBox.setValue(null);
                    pricefild.clear();


                }

                //and TAKE AWAY is selected

            } else if (takeAwayOrder_RadioButton.isSelected()) {

                Order d1 = null ;
                  try {
                      d1 = new DeliveryOrder(fnamefild.getText(), addressfild.getText(), Long.valueOf(phoneNofild.getText()));
                      flag = true;
                  }
                  catch (NumberFormatException e ) {
                      numberInputError.showAndWait();
                      flag = false;
                  }
                if (flag) {

                    //save the object refrance in teh array list
                    ordersList.add(d1) ;

                    //update the order counter
                    ordersCountfild.setText(String.valueOf(ordersList.size()));

                    // show success messge
                    successAlert.showAndWait();
                    //clear user input
                    inStoreOrder_RadioButton.setSelected(false);
                    takeAwayOrder_RadioButton.setSelected(false);
                    fnamefild.clear();
                    addressfild.clear();
                    phoneNofild.clear();
                    numberOfPeoplefild.clear();
                    tableNofild.clear();
                    foodComboBox.setValue(null);
                    pricefild.clear();

                }
            }
        });

        //[[[[[[[[[ if CANCEL buttom is pressed ]]]]]]]]]]]]]]
        cancelBtm.setOnAction( e -> {
            //clear every thing
            inStoreOrder_RadioButton.setSelected(false);
            takeAwayOrder_RadioButton.setSelected(false);
            fnamefild.clear();
            addressfild.clear();
            phoneNofild.clear();
            numberOfPeoplefild.clear();
            tableNofild.clear();
            foodComboBox.setValue(null);
            pricefild.clear();


        });


        // if pluse buttom is pressed
        plusButton.setOnAction(e -> {
            foodCountfild.setText( String.valueOf( Integer.parseInt(foodCountfild.getText()) +1  ));
        });

        // if minus buttom is pressed
        minusButton.setOnAction(e -> {
            foodCountfild.setText( String.valueOf( Integer.parseInt(foodCountfild.getText()) - 1  ));
            if(Integer.parseInt(foodCountfild.getText())<0){foodCountfild.setText("0") ; }
        });


        //-----------------------------------------
        //-------design layout and ui--------------
        //-----------------------------------------

        //make a big vbox pane
        VBox bigVbox = new VBox();
        StackPane centered_pane = new StackPane(welcome);

        //Hbox pane for the buttoms
        HBox buttoms_Pane = new HBox();
        buttoms_Pane.getChildren().addAll(cancelBtm ,placeOrderBtm );
        //mini vbox for order counter
        VBox orderCounter_pane = new VBox(ordersCount , ordersCountfild) ;

        //make a empty pane as a space holder
        Pane empty_pane = new Pane();
        Pane empty_pane2 = new Pane();
        Pane empty_pane3 = new Pane();
        Pane empty_pane4 = new Pane();
        Pane empty_pane5 = new Pane();

        //hbox for food counter
        HBox foddCount_hbox =new HBox(minusButton , foodCountfild , plusButton);
        foddCount_hbox.setSpacing(3);

        //Hbox for the radiobuttoms and order counter
        HBox radioButtoms_pane = new HBox(inStoreOrder_RadioButton,takeAwayOrder_RadioButton ,empty_pane ,empty_pane3 ,empty_pane2 , orderCounter_pane );
        radioButtoms_pane.setSpacing(50);


        //gridpane and put elements on it
        GridPane mainPane = new GridPane();
        mainPane.add(Name, 0,0);
        mainPane.add(address, 0,1);
        mainPane.add(phoneNo, 0,2);
        mainPane.add(numberOfPeople, 0,3);
        mainPane.add(tableNo, 0,4);
        mainPane.add(fnamefild, 1,0);
        mainPane.add(addressfild, 1,1);
        mainPane.add(phoneNofild, 1,2);
        mainPane.add(numberOfPeoplefild, 1,3);
        mainPane.add(tableNofild, 1,4);
        //mainPane.add(empty_pane4, 1,6);
        //mainPane.add(empty_pane5, 2,6);
       mainPane.add(priceTx, 1,8);
        mainPane.add(pricefild, 2,8);

        mainPane.add(order, 0,5);
        mainPane.add(foodComboBox, 1,5);

        mainPane.add(foddCount_hbox,2,5);
        //mainPane.add(foodCountfild,3,5);
       // mainPane.setPadding(new Insets(50));



        //add nodes to the bigVbox
        bigVbox.getChildren().addAll(centered_pane ,radioButtoms_pane, mainPane ,buttoms_Pane);
        bigVbox.setPadding(new Insets(40));
        bigVbox.setSpacing(30);

        //only one radiobuttom is selected
        inStoreOrder_RadioButton.setOnAction(event -> {
            if (inStoreOrder_RadioButton.isSelected()) {
                takeAwayOrder_RadioButton.setSelected(false);
            }
        });

        takeAwayOrder_RadioButton.setOnAction(event -> {
            if (takeAwayOrder_RadioButton.isSelected()) {
                inStoreOrder_RadioButton.setSelected(false);
            }
        });

        //disable unneeded textfields
        //if in store is selected
         inStoreOrder_RadioButton.selectedProperty().addListener((observable, oldValue, newValue)-> {
             if(newValue) {
                 addressfild.setText("not needed");
                 addressfild.setEditable(false);
                 phoneNofild.setText("not needed");
                 phoneNofild.setEditable(false);
             }else if (!newValue){
                 addressfild.setEditable(true);
                 addressfild.setText("");
                 phoneNofild.setEditable(true);
                 phoneNofild.setText("");
             }
         });

         //if take away is selected
        takeAwayOrder_RadioButton.selectedProperty().addListener((observable, oldValue, newValue)-> {
            if(newValue) {
                numberOfPeoplefild.setText("not needed");
                tableNofild.setText("not needed");
                numberOfPeoplefild.setEditable(false);
                tableNofild.setEditable(false);
            }else if (!newValue){
                numberOfPeoplefild.setEditable(true);
                numberOfPeoplefild.setText("");
                tableNofild.setEditable(true);
                tableNofild.setText("");
            }
        });


            // set background
            Image oraginal_image = new Image("images/resphoto.jpeg") ;
            ImageView backgroundimageView = new ImageView(oraginal_image);
            backgroundimageView.setFitWidth(650);
            backgroundimageView.setFitHeight(500);
            backgroundimageView.setOpacity(0.4);
            Image modifiedImage = backgroundimageView.snapshot(null, null);
            BackgroundImage backgroundImage = new BackgroundImage(modifiedImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
            bigVbox.setBackground(new Background(backgroundImage));


        // set scene ,and put pane on scence
        Scene s1 = new Scene(bigVbox,650,500);

        //set scene and put on stage and lunch
        stage.setScene(s1);
        stage.setTitle("java resturant");
        stage.getIcons().add(new Image("images/icon.png"));
        stage.show();

    }




}
