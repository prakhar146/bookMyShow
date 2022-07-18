package models;

import java.util.List;
import java.util.stream.Collectors;

public class Theatre {
    private String name;
    private Location location;
    private List<Auditorium> auditoriumList;

    public Theatre(String name, Location location, List<Auditorium> auditoriumList) {
        this.name = name;
        this.location = location;
        this.auditoriumList = auditoriumList;
    }

    boolean addAuditorium(Auditorium auditorium) {
        auditoriumList.add(auditorium);
        return true;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public List<Auditorium> getAuditoriumList() {
        return auditoriumList;
    }
//    boolean updateAuditorium(Auditorium auditorium) {
//        Auditorium auditoriumToChange = auditoriumList.stream()
//                .filter(audi -> audi.number == auditorium.number)
//                .collect(Collectors.toList())
//                .stream().findFirst().get();
//        auditoriumToChange = auditorium;
//
//    }
}
