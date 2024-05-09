import java.time.LocalDateTime;

public class Reservation extends Order {
    private int tableNumber;
    private int numberofSeats;
    private boolean isOccupied;
    private ReservationStatus status;

    Reservation(LocalDateTime OrderDateTime, String dataOfWorker ,String customerName,long customerPhone, int tableNumber, int numberofSeats) {
        super( OrderDateTime, dataOfWorker , customerName, customerPhone);
        this.tableNumber = tableNumber;
        this.numberofSeats = numberofSeats;
        this.isOccupied = false;
        this.status = ReservationStatus.PENDING;
    }
    
    
    public void reserveTable(String customerName, String phoneNumber) throws TableOccupiedException {
        if (isOccupied) {
           throw new TableOccupiedException("Table " + tableNumber + " is already occupied.");
        } else {
            status = ReservationStatus.CONFIRMED ;
            isOccupied = true ;
            System.out.println("Table " + tableNumber + " has been occupied by " + customerName);
        }
    }
    
    public void cancelReservation(String customerName, int tableNumber) throws TableNotOccupiedException {
        if ((!isOccupied) && status == ReservationStatus.PENDING) {
            status = ReservationStatus.CANCELLED;
            isOccupied = false;
            System.out.println("Reservation cancelled for table " + tableNumber);
        } else {
           throw new TableNotOccupiedException("Table " + tableNumber + " is not occupied.");
        }
    }
    
        class TableOccupiedException extends Exception {
            public TableOccupiedException(String message) {   
                super(message);
            }
        }
        class TableNotOccupiedException extends Exception {
            public TableNotOccupiedException(String message) {
                super(message);
            }
       }
        
        enum ReservationStatus {
            PENDING, CONFIRMED, CANCELLED
        }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getNumberofSeats() {
        return numberofSeats;
    }

    public void setNumberofSeats(int numberofSeats) {
        this.numberofSeats = numberofSeats;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

   