package adminDataModel;

public class Address {

    private final String line1;
    private final String line2;
    private final String city;
    private final String postCode;

    public Address() {
        this.line1 = "";
        this.line2 = "";
        this.city = "";
        this.postCode = "";
    }
    
    public Address(Address address) {
        this.line1 = address.line1;
        this.line2 = address.line2;
        this.city = address.city;
        this.postCode = address.postCode;
    }

    public Address(String line1, String line2, String city, String postCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.postCode = postCode;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    @Override
    public String toString() {
        return line1 + ", " + line2 + ", " + postCode;
    }
}
