package adminDataModel;

import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import utilities.IObserver;
import utilities.ISubject;

public class Show implements ISubject, Serializable {

    private int showId;
    private Event event;
    private Venue venue;
    private LocalDateTime startTime;
    private double childConcesion;
    private double studentConcession;    
    private List<Priceband> priceBands;
    private ArrayList<IObserver> observers = null;

    public Show() {
        priceBands = new ArrayList();
    }

    public Show(Event e, Venue v, LocalDateTime sd) {
        showId = (new Random()).nextInt();
        event = e;
        venue = v;
        startTime = sd;
    }

    public Show(int showId, LocalDateTime startTime, double childConcesion, 
            double studentConcession, Venue venue) {
        this.showId = showId;
        this.startTime = startTime;
        this.childConcesion = childConcesion;
        this.studentConcession = studentConcession;
        this.priceBands = new ArrayList();
    }

    public Show(int showId, LocalDateTime startTime, double childConcesion, 
            double studentConcession, Venue venue, List<Priceband> priceBands) {
        this.showId = showId;
        this.startTime = startTime;
        this.childConcesion = childConcesion;
        this.studentConcession = studentConcession;
        this.venue = venue;
        this.priceBands = new ArrayList();
    }

    public Show(Show aShow) {
        this.showId = aShow.showId;
        this.startTime = aShow.startTime;
        this.childConcesion = aShow.childConcesion;
        this.studentConcession = aShow.studentConcession;
        this.venue = aShow.venue;
        this.priceBands = aShow.priceBands;
    }

    public int getShowId() {
        return showId;
    }

    public Event getEvent() {
        return new Event(event);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public double getChildConcesion() {
        return childConcesion;
    }

    public double getStudentConcession() {
        return studentConcession;
    }

    public Venue getVenue() {
        return new Venue(venue);
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setChildConcesion(double childConcesion) {
        this.childConcesion = childConcesion;
    }

    public void setStudentConcession(double studentConcession) {
        this.studentConcession = studentConcession;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setPriceBands(List<Priceband> priceBands) {
        this.priceBands = priceBands;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
    
    public void addPriceBand(Priceband priceBand) {
        priceBands.add(priceBand);
    }

    public List<Priceband> getPriceBands() {
        List<Priceband> aPriceBands = priceBands;
        return aPriceBands;
    }

    public String[] toTableData() {
        String[] result = {"" + startTime.getDayOfMonth() + " " + startTime.getMonth() + " " 
                + startTime.getYear(), "" + startTime.getHour() + ":" 
                + (startTime.getMinute() == 0 ? "00" : startTime.getMinute()), event.toString(), 
                venue.toString(), String.valueOf(childConcesion), String.valueOf(studentConcession),
                Arrays.toString(priceBands.toArray())}; //Array of price band into string
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
        //Return the result
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
            for (IObserver currentObserver : this.observers) {
                //Call update on this observer
                currentObserver.update();
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Show) {
            Show test = (Show) obj;
            return test.getShowId() == this.getShowId();
        }
        return false;
    }
}
