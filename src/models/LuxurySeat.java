package models;

public class LuxurySeat extends Seat {
    String identifier = "LX-";
    public LuxurySeat(String seatNumber, int price) {
        this.number = identifier + seatNumber;
        this.price = price;
        this.isAvailable = true;
    }

    @Override
    public String getNumber() {
        return null;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }
}
