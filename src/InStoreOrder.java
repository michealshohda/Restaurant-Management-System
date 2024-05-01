import java.util.Date;

public class InStoreOrder extends Order {

    //extra data fields
    int tableNumber ;
    int numberOfPersons;

    //constractor
    InStoreOrder(){
        super();
    }

    @Override
    int productsNumber(String product) {
        return 0;
    }

    @Override
    int ordering(String wayOfOrder, int numberOfProducts) {
        return 0;
    }
}
