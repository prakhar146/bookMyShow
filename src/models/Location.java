package models;

public class Location {
    private String city;
    private String area;

    public Location(String city, String area) {
        this.city = city;
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public String getArea() {
        return area;
    }
}
