package services;

import models.Auditorium;
import models.Seat;
import models.Show;
import models.Theatre;

import java.util.List;
import java.util.Map;

public interface TheatreService {
    Map<Auditorium, List<Show>> getShows(Theatre theatre, String show);
    boolean bookTicket(Theatre theatre, Auditorium auditorium, Show show, Seat seat);
}
