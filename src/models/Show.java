package models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Show implements Cloneable {
    private String time;
    private String showName;
    private String day;
    private List<Seat> seats;

    public Show(String time, String showName, String day, List<Seat> seats) {
        this.time = time;
        this.showName = showName;
        this.day = day;
        this.seats = seats;
    }

    public String getTime() {
        return time;
    }

    public String getShowName() {
        return showName;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public String getDay() {
        return day;
    }

    public boolean blockSeat(Seat seat) {
        Seat toBlock = seats.stream().filter(seat1 -> seat.number.equals(seat1.number)).findFirst().get();
        toBlock.setAvailable(false);
        return true;
    }

    @Override
    public String toString() {

        return "[" + showName + ", time -> " + day + ", " + time + " -- seats " + availableSeats().size() + " / " + seats.size() + "]";
    }

    private List<Seat> availableSeats() {
        return seats.stream().filter(seat -> seat.isAvailable).collect(Collectors.toList());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
