package adminDataModel;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import utilities.IObserver;
import utilities.ISubject;

public class Customer implements ISubject, Serializable {

    private int customerId;
    private String forename;
    private String surname;
    private LocalDate dateOfBirth;
    private String email;
    private String mobileNumber;
    private String password;
    private Address address;
    private ArrayList<IObserver> observers = null;
    private final List<Booking> bookings;

    public Customer() {
        bookings = new ArrayList();
    }

    public Customer(Customer customer) {
        this.customerId = customer.customerId;
        this.forename = customer.forename;
        this.surname = customer.surname;
        this.dateOfBirth = customer.dateOfBirth;
        this.email = customer.email;
        this.mobileNumber = customer.mobileNumber;
        this.password = customer.password;
        this.address = customer.address;
        this.bookings = customer.bookings;
    }

    public Customer(int customerId, String forename, String surname, LocalDate dateOfBirth, String email, String mobileNumber, String password, Address address) {
        this.customerId = customerId;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.address = address;
        bookings = new ArrayList();
    }
    
    public Customer(String email) {
        this.email = email;
        bookings = new ArrayList();
    }    

    public int getCustomerId() {
        return customerId;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Address getAddress() {
        return new Address(address);
    }

    public void setGivenName(String givenName) {
        this.forename = givenName;
    }

    public void setFamilyName(String familyName) {
        this.surname = familyName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setEmail(String email) {
        Random rand = new Random();
        this.customerId = rand.nextInt();
        this.email = email;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    //Potentially unsafe
    public String getPassword() {
        return password;
    }

    //Potentially unsafe
    public void setPassword(String password) {
        this.password = password;
    }

    public void editBooking(Booking booking) {
        for (Booking aBooking : bookings) {
            if (booking.getCustomer().getCustomerId() == aBooking.getCustomer().getCustomerId()
                    && booking.getShow().getShowId() == aBooking.getShow().getShowId()) {
                bookings.remove(aBooking);
                bookings.add(aBooking);
                break;
            }
        }
    }

    public List<Booking> getBooking(Booking booking) {
        List<Booking> bookingsCopy = new ArrayList();
        bookings.stream().forEach((aBooking) -> {
            bookingsCopy.add(new Booking(aBooking));
        });
        return bookingsCopy;
    }
    
    /**
     *
     * @return
     */
    public String[] toTableData() {
        String[] data = {forename + " " + surname, dateOfBirth.toString(), email, mobileNumber, address.toString(), address.getCity()};
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
    public boolean equals(Object obj) {
        if(obj instanceof Customer) {
            Customer test = (Customer) obj;
            return test.getCustomerId() == this.getCustomerId();
        }
        return false;
    }
}
