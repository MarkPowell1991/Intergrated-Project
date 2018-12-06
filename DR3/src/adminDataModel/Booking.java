package adminDataModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import utilities.IObserver;
import utilities.ISubject;

public class Booking implements ISubject, Serializable {

    private long bookingId;
    private Customer customer;
    private Show show;
    private double totalPrice;
    private int numberOfTickets;
    private BookingStatus bookingStatus;
    private ArrayList<IObserver> observers = null;

    public Booking() {
    }

    public Booking(Booking booking) {
        this.bookingId = booking.bookingId;
        this.customer = booking.customer;
        this.show = booking.show;
        this.totalPrice = booking.totalPrice;
        this.numberOfTickets = booking.numberOfTickets;
        this.bookingStatus = booking.bookingStatus;
    }

    //DOES NOT HANDLE PRICE BANDS YET
    public Booking(Customer customer, Show show, BookingStatus bookingStatus, double totalPrice, int numberOfTickets) {
        Random rand = new Random();
        this.bookingId = rand.nextInt();
        this.bookingStatus = bookingStatus;
        this.customer = customer;
        this.show = show;
        this.totalPrice = totalPrice;
        this.numberOfTickets = numberOfTickets;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public long getBookingId() {
        return bookingId;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Show getShow() {
        return show;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public String[] toTableData() {
        String[] result = {"" + show.getStartTime().getDayOfMonth() + " " + show.getStartTime().getMonth() + " "
            + show.getStartTime().getYear() + "  " + show.getStartTime().getHour() + ":"
            + (show.getStartTime().getMinute() == 0 ? "00" : show.getStartTime().getMinute()), ""
            + customer.getEmail(), show.getEvent().getName(), show.getVenue().toString(), ""
            + numberOfTickets, "£" + String.format("%.2f", totalPrice)};
        return result;
    }

    @Override
    public Boolean registerObserver(IObserver o) {
        Boolean blnAdded = false;                   //Assume this method will fail
        //Validate that observer exists
        if (o != null) {
            //If observer list not initialised create it
            if (this.observers == null) {
                this.observers = new ArrayList<>();
            }
            //Add the observer to the list of registered observers if not already registered
            if (!this.observers.contains(o)) {
                blnAdded = this.observers.add(o);
            }
        }
        return blnAdded;
    }

    @Override
    public Boolean removeObserver(IObserver o) {
        Boolean blnRemoved = false;
        //Validate we have something to remove
        if (o != null) {
            if (this.observers != null && this.observers.size() > 0) {
                blnRemoved = this.observers.remove(o);
            }
        }
        return blnRemoved;
    }

    @Override
    public void notifyObservers() {
        //Ensure we have a valid list of observers
        if (this.observers != null && this.observers.size() > 0) {
            //Start foreach loop
            this.observers.stream().forEach((currentObserver) -> {
                //Call update on this observer
                currentObserver.update();
            });
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Booking) {
            Booking test = (Booking) obj;
            return test.getBookingId() == this.getBookingId();
        }
        return false;
    }
}
