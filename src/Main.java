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

        welcome.setFont(new Font(20));



        // text fieldes
        TextField fnamefild = new TextField();
        TextField addressfild = new TextField();
        TextField pricefild = new TextField();
        TextField phoneNofild = new TextField();
        TextField tableNofild = new TextField();
        TextField numberOfPeoplefild = new TextField();

        //edit some text fields
        pricefild.setEditable(false);


        // buttons
        Button placeOrderBtm = new Button("place order") ;
        Button cancelBtm = new Button("cancel") ;

        //radiobuttons
        RadioButton inStoreOrder_RadioButton = new RadioButton("in store order");
        RadioButton takeAwayOrder_RadioButton = new RadioButton("take away order");
        CheckBox ch1 = new CheckBox();

        //dropdown menu
        ComboBox<String> foodComboBox = new ComboBox<>();
        foodComboBox.getItems().addAll("Burger", "Pizza", "Salad", "Sandwich");
        foodComboBox.setPromptText("Choose what to eat");




        //dsiplay the price
        foodComboBox.setOnAction(event -> {

            String selectedItem = foodComboBox.getValue();
            //double price = getPrice(selectedItem);
            pricefild.setText( selectedItem + " EGP");
        });

        //-----------------------------------------
        //-------logical main - driver --------------
        //-----------------------------------------
        placeOrderBtm.setOnAction(e -> {

            if(inStoreOrder_RadioButton.isSelected()){
                Reservation r1 = new Reservation(fnamefild.getText(),Integer.valueOf(tableNofild.getText()) ,Integer.valueOf( numberOfPeoplefild.getText() ) );
                System.out.println("in store order");


            } else if (takeAwayOrder_RadioButton.isSelected()) {
                DeliveryOrder d1 = new DeliveryOrder(fnamefild.getText() , addressfild.getText() , Long.valueOf( phoneNofild.getText() )) ;
                System.out.println("in take away order");


            }
        });

        cancelBtm.setOnAction( e -> {
            //clear every thing
            inStoreOrder_RadioButton.setSelected(false);
            takeAwayOrder_RadioButton.setSelected(false);
            fnamefild.clear();
            addressfild.clear();
            phoneNofild.clear();
            numberOfPeoplefild.clear();
            tableNofild.clear();
            //foodComboBox.cancelEdit();
            foodComboBox.setValue(null);
            pricefild.clear();


        });












        //-----------------------------------------
        //-------design layout and ui--------------
        //-----------------------------------------

        //make a big vbox pane
        VBox bigVbox = new VBox();
        StackPane centered_pane = new StackPane(welcome);


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
        //mainPane.add(placeOrderBtm, 2,6);
        //mainPane.add(cancelBtm, 1,6);

        mainPane.add(priceTx, 1,6);
        mainPane.add(pricefild, 2,6);

        mainPane.add(order, 0,5);
        mainPane.add(foodComboBox, 1,5);
       // mainPane.setPadding(new Insets(50));


        //stack pane for the buttoms
        HBox buttoms_Pane = new HBox();
        buttoms_Pane.getChildren().addAll(cancelBtm ,placeOrderBtm );




        //add nodes to the bigVbox
        bigVbox.getChildren().addAll(centered_pane ,inStoreOrder_RadioButton,takeAwayOrder_RadioButton, mainPane ,buttoms_Pane);
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
            backgroundimageView.setFitWidth(525);
            backgroundimageView.setFitHeight(500);
            backgroundimageView.setOpacity(0.4);

            Image modifiedImage = backgroundimageView.snapshot(null, null);

            BackgroundImage backgroundImage = new BackgroundImage(modifiedImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


            bigVbox.setBackground(new Background(backgroundImage));



        // set scene ,and put pane on scence
        Scene s1 = new Scene(bigVbox,525,500);



        //set scene and put on stage and lunch
        stage.setScene(s1);
        stage.setTitle("java resturant");
        stage.getIcons().add(new Image("images/icon.png"));
        stage.show();

    }



}
