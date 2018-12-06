package adminDataModel;

import java.util.ArrayList;
import java.util.List;

public class Priceband {

    private String name;
    private Integer seats;
    private Double price;

    public Priceband(String name, Integer seats, Double price) {
        this.name = name;
        this.seats = seats;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "" + name + "," + seats + "," + price + ';';
    }

    public static List<Priceband> toPricebandList(String pEncode) {
        List<Priceband> pricebandList = new ArrayList();
        String pBand[];
        for (String pB : pEncode.split(";")) {
            pBand = pB.split(",");
            pricebandList.add(new Priceband(pBand[0], Integer.parseInt(pBand[1]), Double.parseDouble(pBand[2])));
        }
        return pricebandList;
    }
}
