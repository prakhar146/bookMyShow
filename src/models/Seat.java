package models;


public abstract class Seat {
    protected String number;
    protected int price;
    protected boolean isAvailable;

    abstract public String getNumber();

    abstract public int getPrice();

    abstract public void setPrice(int price);

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}