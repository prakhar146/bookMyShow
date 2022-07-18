package models;

import java.util.List;

public class Auditorium {
    int number;
    List<Show> shows;

    public Auditorium(int number, List<Show> shows) {
        this.number = number;
        this.shows = shows;
    }

    public int getNumber() {
        return number;
    }

    public List<Show> getShows() {
        return shows;
    }

    //    boolean addShow(Show show) {
//        // TODO
//    }
}
