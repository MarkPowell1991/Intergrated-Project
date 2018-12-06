package adminDataModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import utilities.IObserver;
import utilities.ISubject;

public class Event implements ISubject, Serializable {

    private Integer eventId;
    private String name;
    private String description;
    private EventType type;
    private Genre genre;
    private String ageRequirement;
    private final List<Show> shows;
    private Integer duration;
    private boolean refundable;
    private double basePrice;
    private ArrayList<IObserver> observers = null;

    public Event() {
        shows = new ArrayList();
    }

    public Event(Event event) {
        this.eventId = event.eventId;
        this.name = event.name;
        this.description = event.description;
        this.type = event.type;
        this.genre = event.genre;
        this.ageRequirement = event.ageRequirement;
        this.duration = event.duration;
        this.refundable = event.refundable;
        this.shows = event.shows;
        this.basePrice = event.basePrice;
    }

    public Event(Integer eventId, String name, String description, EventType type, Genre genre,
            String ageRequirement, Integer duration, boolean refundable, double basePrice) {
        this.eventId = eventId;
        this.name = name;
        this.description = description;
        this.type = type;
        this.genre = genre;
        this.ageRequirement = ageRequirement;
        this.duration = duration;
        this.refundable = refundable;
        this.basePrice = basePrice;
        this.shows = new ArrayList();
    }

    public Integer getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyObservers();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyObservers();
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
        notifyObservers();
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
        notifyObservers();
    }

    public String getAgeRequirement() {
        return ageRequirement;
    }

    public void setAgeRequirement(String ageRequirement) {
        this.ageRequirement = ageRequirement;
        notifyObservers();
    }

    public Integer getDuration() {
        return duration;
    }

    public void setduration(Integer duration) {
        this.duration = duration;
        notifyObservers();
    }

    public Boolean getRefundable() {
        return refundable;
    }

    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
        notifyObservers();
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public void editShow(Show show) {
        for (Show aShow : shows) {
            if (show.getShowId() == aShow.getShowId()) {
                shows.remove(aShow);
                shows.add(show);
                break;
            }
        }
    }

    public List<Show> getShows() {
        List<Show> showsCopy = new ArrayList();
        shows.stream().forEach((aShow) -> {
            showsCopy.add(new Show(aShow));
        });
        return showsCopy;
    }

    @Override
    public String toString() {
        return name;
    }

    public String[] toTableData() {
        String[] data = {name, type.toString(), genre.toString(), ageRequirement, description, "" + basePrice, refundable ? "Y" : "N"};
        return data;
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
        if(obj instanceof Event) {
            Event test = (Event) obj;
            return this.getEventId() == test.getEventId();
        }
        //return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        return false;
    }
}
