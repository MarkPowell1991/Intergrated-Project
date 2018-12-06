package adminDataModel;

import java.util.ArrayList;
import utilities.IObserver;
import utilities.ISubject;

/**
 *
 * @author USER
 */
public class Venue implements ISubject {

    private int venueId;
    private Address address;
    private char hasParking;
    private char disabilityAccess;
    private int totalSeats;
    private ArrayList<IObserver> observers = new ArrayList();

    /**
     *
     * @param venueId
     * @param address
     * @param hasParking
     * @param disabilityAccess
     * @param totalSeats
     */
    public Venue(int venueId, Address address, char hasParking, char disabilityAccess, int totalSeats) {
        this.venueId = venueId;
        this.address = address;
        this.hasParking = hasParking;
        this.disabilityAccess = disabilityAccess;
        this.totalSeats = totalSeats;
    }

    /**
     *
     * @param venue
     */
    public Venue(Venue venue) {
        this.venueId = venue.venueId;
        this.address = venue.address;
        this.hasParking = venue.hasParking;
        this.disabilityAccess = venue.disabilityAccess;
        this.totalSeats = venue.totalSeats;
    }

    public Venue() {
    }

    /**
     *
     * @return
     */
    public int getVenueId() {
        return venueId;
    }

    /**
     *
     * @return
     */
    public Address getAddress() {
        return new Address(address);
    }

    /**
     *
     * @return
     */
    public char getHasParking() {
        return hasParking;
    }

    /**
     *
     * @return
     */
    public char getDisabilityAccess() {
        return disabilityAccess;
    }

    /**
     *
     * @return
     */
    public int getTotalSeats() {
        return totalSeats;
    }

    /**
     *
     * @param address
     */
    public void setAddress1(Address address) {
        this.address = address;
    }

    /**
     *
     * @param hasParking
     */
    public void setHasParking(char hasParking) {
        this.hasParking = hasParking;
    }

    /**
     *
     * @param disabilityAccess
     */
    public void setDisabilityAccess(char disabilityAccess) {
        this.disabilityAccess = disabilityAccess;
    }

    /**
     *
     * @param totalSeats
     */
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    /**
     *
     * @return
     */
    public String[] toTableData() {
        String[] data = {address.getLine1(), address.getCity(), String.valueOf(hasParking), String.valueOf(disabilityAccess), String.valueOf(totalSeats)};
        return data;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public Boolean registerObserver(IObserver o) {
        Boolean blnAdded = false;                   //Assume this method will fail
        //Validate that observer exists
        if (o != null) {
            //If observer list not initialised create it
            if (this.observers == null) {
                this.observers = new ArrayList<>();
            }
            //Add the observer to the list of registered observers
            if (!this.observers.contains(o)) {
                blnAdded = this.observers.add(o);
            }
        }
        //Return the result
        return blnAdded;
    }

    /**
     *
     * @param o
     * @return
     */
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

    /**
     *
     */
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
    public String toString() {
        return address.getLine1() + " " + address.getCity();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Venue) {
            Venue test = (Venue) obj;
            return test.getVenueId() == this.getVenueId();
        }
        return false;
    }
}
