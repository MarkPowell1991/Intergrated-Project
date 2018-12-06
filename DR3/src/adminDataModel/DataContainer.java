/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminDataModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Objects;
import utilities.IObserver;
import utilities.ISubject;

public class DataContainer implements ISubject, IObserver, Serializable {

    private static DataContainer instance;

    private ArrayList<Customer> peopleList = new ArrayList();
    private ArrayList<Venue> venueList = new ArrayList();
    private ArrayList<Event> eventList = new ArrayList();
    private ArrayList<Show> showList = new ArrayList();
    private ArrayList<Booking> bookingList = new ArrayList();
    private ArrayList<IObserver> observers = null;

    private DataContainer() {
    }

    public static DataContainer getInstance() {
        if (instance == null) {
            instance = new DataContainer();
            createTestData();
        }
        return instance;
    }

    public static void disposeInstance() {
        instance = null;
    }

    public static void createTestData() {
        Customer testCustomer;
        Venue venue;
        Event event;
        Booking booking;
        LocalDateTime dt;

        testCustomer = new Customer(1, "Mark", "Powell", LocalDate.of(1993, Month.MARCH, 24), "blapblap@hotmail.co.uk", "07973671120", "password", new Address("5 High Way", "7th Street", "Plymouth", "PL1 5DP"));
        instance.addNewCustomer(testCustomer);
        testCustomer = new Customer(2, "Rishabh", "Daga", LocalDate.of(1996, Month.APRIL, 12), "idiot@hotmail.co.uk", "07973671120", "password", new Address("6 High Way", "4th Street", "Plymouth", "PL1 5DP"));
        instance.addNewCustomer(testCustomer);

        venue = new Venue(1, new Address("O2 Arena", "East Side", "London", "TL5 1DN"), 'Y', 'N', 250);
        instance.addNewVenue(venue);
        venue = new Venue(2, new Address("O3 Arena", "East Side", "London", "TL6 2DN"), 'N', 'Y', 500);
        instance.addNewVenue(venue);

        event = new Event(1, "Lion King", "Lions and Wolfs", EventType.Movie, Genre.Drama, "U", 44, false, 4);
        Boolean addNewEvent = instance.addNewEvent(event);
        event = new Event(2, "Tiger King", "Tigers and Wolfs", EventType.Movie, Genre.Romantic, "U", 64, true, 8);
        instance.addNewEvent(event);

        dt = LocalDateTime.of(2016, 4, 20, 19, 13);
        instance.showList.add(new Show(instance.eventList.get(0), instance.venueList.get(0), dt));
        dt = LocalDateTime.of(2016, 4, 21, 15, 00);
        instance.showList.add(new Show(instance.eventList.get(0), instance.venueList.get(1), dt));
        dt = LocalDateTime.of(2016, 4, 21, 17, 00);
        instance.showList.add(new Show(instance.eventList.get(0), instance.venueList.get(1), dt));
        dt = LocalDateTime.of(2016, 4, 23, 9, 45);
        instance.showList.add(new Show(instance.eventList.get(1), instance.venueList.get(0), dt));
        dt = LocalDateTime.of(2016, 4, 24, 11, 00);
        instance.showList.add(new Show(instance.eventList.get(1), instance.venueList.get(0), dt));
        dt = LocalDateTime.of(2016, 4, 25, 13, 30);
        instance.showList.add(new Show(instance.eventList.get(1), instance.venueList.get(1), dt));

    }

    public Boolean addNewCustomer(Customer objNewItem) {
        Boolean blnResult = false;
        if (null != objNewItem) {
            if (!this.peopleList.contains(objNewItem)) {
                blnResult = this.peopleList.add(objNewItem);
                if (blnResult) {
                    objNewItem.registerObserver(this);
                    this.notifyObservers();
                }
            }
        }
        return blnResult;
    }

    public Boolean addNewVenue(Venue objNewItem) {
        Boolean blnResult = false;
        if (null != objNewItem) {
            if (!this.venueList.contains(objNewItem)) {
                blnResult = this.venueList.add(objNewItem);
                if (blnResult) {
                    objNewItem.registerObserver(this);
                    this.notifyObservers();
                }
            }
        }
        return blnResult;
    }

    public Boolean addNewEvent(Event objNewItem) {
        Boolean blnResult = false;
        if (null != objNewItem) {
            if (!this.eventList.contains(objNewItem)) {
                blnResult = this.eventList.add(objNewItem);
                if (blnResult) {
                    objNewItem.registerObserver(this);
                    this.notifyObservers();
                }
            }
        }
        return blnResult;
    }

    public Boolean addNewShow(Show objNewItem) {
        Boolean blnResult = false;
        if (null != objNewItem) {
            if (!this.showList.contains(objNewItem)) {
                blnResult = this.showList.add(objNewItem);
                if (blnResult) {
                    objNewItem.registerObserver(this);
                    this.notifyObservers();
                }
            }
        }
        return blnResult;
    }

    public Boolean addNewBooking(Booking objNewItem) {
        Boolean blnResult = false;
        if (null != objNewItem) {
            if (/*!this.bookingList.contains(objNewItem)*/true) {
                blnResult = this.bookingList.add(objNewItem);
                if (blnResult) {
                    objNewItem.registerObserver(this);
                    this.notifyObservers();
                }
            }
        }
        return blnResult;
    }

    public Boolean updateCustomer(Customer c) {
        for (Customer curr : peopleList) {
            if (c.getCustomerId() == curr.getCustomerId()) {
                peopleList.remove(curr);
                peopleList.add(c);
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    public Boolean updateEvent(Event e) {
        for (Event curr : eventList) {
            if (Objects.equals(e.getEventId(), curr.getEventId())) {
                eventList.remove(curr);
                eventList.add(e);
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    public Boolean updateVenue(Venue v) {
        for (Venue curr : venueList) {
            if (v.getVenueId() == curr.getVenueId()) {
                venueList.remove(curr);
                venueList.add(v);
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    public Boolean updateShow(Show s) {
        for (Show curr : showList) {
            if (s.getShowId() == curr.getShowId()) {
                showList.remove(curr);
                showList.add(s);
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    public Boolean updateBooking(Booking b) {
        for (Booking curr : bookingList) {
            if (b.getBookingId() == curr.getBookingId()) {
                bookingList.remove(curr);
                bookingList.add(b);
                notifyObservers();
                return true;
            }
        }
        return false;
    }

    public Boolean removeCustomerAt(Integer index) {
        Boolean blnResult = false;
        if (index < peopleList.size() && index >= 0) {
            peopleList.remove(peopleList.get(index));
            blnResult = true;
        }
        if (blnResult) {
            this.notifyObservers();
        }
        return blnResult;
    }

    public Boolean removeVenueAt(Integer index) {
        Boolean blnResult = false;
        if (index < venueList.size() && index >= 0) {
            venueList.remove(venueList.get(index));
            blnResult = true;
        }
        if (blnResult) {
            this.notifyObservers();
        }
        return blnResult;
    }

    public Boolean removeEventAt(Integer index) {
        Boolean blnResult = false;
        if (index < eventList.size() && index >= 0) {
            eventList.remove(eventList.get(index));
            blnResult = true;
        }
        if (blnResult) {
            this.notifyObservers();
        }
        return blnResult;
    }

    public Boolean removeShowAt(Integer index) {
        Boolean blnResult = false;
        if (index < showList.size() && index >= 0) {
            showList.remove(showList.get(index));
            blnResult = true;
        }
        if (blnResult) {
            this.notifyObservers();
        }
        return blnResult;
    }

    public Boolean removeBookingAt(Integer index) {
        Boolean blnResult = false;
        if (index < bookingList.size() && index >= 0) {
            bookingList.remove(bookingList.get(index));
            blnResult = true;
        }
        if (blnResult) {
            this.notifyObservers();
        }
        return blnResult;
    }

    public ArrayList<Customer> getPeopleList() {
        ArrayList<Customer> arlResult = new ArrayList<>();
        this.peopleList.stream().forEach((currItem) -> {
            arlResult.add(currItem);
        });
        return arlResult;
    }

    public Customer getByEmail(String email) {
        for (Customer curr : getPeopleList()) {
            if (curr.getEmail().equals(email)) {
                return curr;
            }
        }
        return null;
    }

    public ArrayList<Venue> getVenueList() {
        ArrayList<Venue> arlResult = new ArrayList<>();
        this.venueList.stream().forEach((currItem) -> {
            arlResult.add(currItem);
        });
        return arlResult;
    }

    public ArrayList<Event> getEventList() {
        ArrayList<Event> arlResult = new ArrayList<>();
        this.eventList.stream().forEach((currItem) -> {
            arlResult.add(currItem);
        });
        return arlResult;
    }

    public ArrayList<Show> getShowList() {
        ArrayList<Show> arlResult = new ArrayList<>();
        this.showList.stream().forEach((currItem) -> {
            arlResult.add(currItem);
        });
        return arlResult;
    }

    public ArrayList<Booking> getBookingList() {
        ArrayList<Booking> arlResult = new ArrayList<>();
        this.bookingList.stream().forEach((currItem) -> {
            arlResult.add(currItem);
        });
        return arlResult;
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
            //Add the observer to the list of registered observers
            if (!this.observers.contains(o)) {
                blnAdded = this.observers.add(o);
            }
            //Make sure all stock items are observed by the warehouse
            if (blnAdded) {
                this.peopleList.stream().forEach((currItem) -> {
                    currItem.registerObserver(this);
                });
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
    public void update() {
        this.notifyObservers();
    }
}
