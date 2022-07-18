package services;

import models.Auditorium;
import models.Seat;
import models.Show;
import models.Theatre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheatreServiceImpl implements TheatreService {
    @Override
    public Map<Auditorium, List<Show>> getShows(Theatre theatre, String showName) {
        List<Auditorium> auditoriumList = theatre.getAuditoriumList();
        Map<Auditorium, List<Show>> availableShows = new HashMap<>();
        auditoriumList.forEach(auditorium -> {
            List<Show> shows = auditorium.getShows()
                    .stream()
                    .filter(show1 -> show1.getShowName().equals(showName))
                    .collect(Collectors.toList());
            if (!shows.isEmpty()) {
                availableShows.put(auditorium, shows);
            }
        });
        return availableShows;
    }

    @Override
    public boolean bookTicket(Theatre theatre, Auditorium auditorium, Show show, Seat seat) {
        Auditorium audiToBook = theatre.getAuditoriumList().stream()
                .filter(auditorium1 -> auditorium1.getNumber() == auditorium.getNumber()).findFirst().get();
        Show showToBook = audiToBook.getShows().stream()
                .filter(show1 -> show1.getShowName().equals(show.getShowName())).findFirst().get();

        showToBook.blockSeat(seat);

        return true;
    }
}
