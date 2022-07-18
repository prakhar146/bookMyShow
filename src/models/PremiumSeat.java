package models;

public class PremiumSeat extends Seat {
    String identifier = "PS-";
    public PremiumSeat(String seatNumber, int price) {
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
