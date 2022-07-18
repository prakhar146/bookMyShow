package services;

import models.*;

import java.util.*;

public class BookMyShow {
    List<Theatre> theatres;
    TheatreService theatreService;
    PaymentService paymentService;

    public BookMyShow() {
        theatres = new ArrayList<>();
        theatreService = new TheatreServiceImpl();
        paymentService = new PaymentServiceImpl();
        loadTheatres();
    }

    // several filters
    public void printShowsByName(String showName) {
        Map<Theatre, Map<Auditorium, List<Show>>> availableShows = new HashMap<>();

        theatres.forEach(theatre -> {
            Map<Auditorium, List<Show>> audiMap = theatreService.getShows(theatre, showName);
            availableShows.put(theatre, audiMap);
        });

        printAvailableShows(availableShows);
    }

    public void bookRandomShows(int num) {
        Random rd = new Random();
        int N = theatres.size();
        for(int i = 0; i < num; i++) {
            int theatreNum = rd.nextInt(N - 1);
            Theatre theatre = theatres.get(theatreNum);
            List<Auditorium> audis = theatre.getAuditoriumList();
            Auditorium auditorium = audis.get(rd.nextInt(audis.size() - 1));
            Show show = auditorium.getShows().get(rd.nextInt(auditorium.getShows().size() - 1));
            int seats = rd.nextInt(4);
            System.out.println("Booking " + seats + " seats for: " + show.getShowName() + " ( " + show.getDay() + ", " + show.getTime() + ")" +
                    " Audi -> " + auditorium.getNumber() + ", Theatre -> " + theatre.getName());
            List<Seat> seatList = new ArrayList<>();
            for(int j = 1; j <= seats; j++) {
                seatList.add(new PremiumSeat(String.valueOf(j), 100));
            }
            bookTicket(theatre, auditorium, show, seatList, 1000);
        }

    }

    void printAvailableShows(Map<Theatre, Map<Auditorium, List<Show>>> availableShows) {
        for(Theatre theatre: availableShows.keySet()) {
            System.out.println("** Theatre -> " + theatre.getName() + " **");
            for (Auditorium auditorium: availableShows.get(theatre).keySet()) {
                System.out.println("-- Audi " + auditorium.getNumber() + " --");
                for (Show show:  availableShows.get(theatre).get(auditorium)) {
                    System.out.println(show);
                }
            }
            System.out.println("************");
        }
    }

    //

    boolean bookTicket(Theatre theatre, Auditorium auditorium, Show show, List<Seat> seats, int payment) {
        if(paymentService.validatePayment(seats, payment)) {
            seats.forEach(seat -> {
                theatreService.bookTicket(theatre, auditorium, show, seat);
            });
        }

        return true;
    }

    private void loadTheatres() {

        Theatre t1 = new Theatre("Ambience", new Location("Chandigarh", "Model Town"), loadAuditoriums());
        Theatre t2 = new Theatre("Elements", new Location("Jaipur", "Vaishali Nagar"), loadAuditoriums());
        Theatre t3 = new Theatre("Ser Sapata", new Location("Bhopal", "Chitrakoot"), loadAuditoriums());

        theatres.add(t1);
        theatres.add(t2);
        theatres.add(t3);
    }

    private List<Auditorium> loadAuditoriums() {
        List<Show> shows = loadShows();
        int N = shows.size();
        List<Auditorium> auditoriumList = new ArrayList<>();
        Random random = new Random();
        int audiNums = 1 + random.nextInt(4);
        for(int i = 0; i < audiNums; i++) {
            int numOfShows = 1 + random.nextInt(4);
            shows = loadShows();
            List<Show> showList = new ArrayList<>();
            for(int j = 0; j < numOfShows; j++) {
                int showNum = random.nextInt(N - 1);
                Show s = shows.get(showNum);
                showList.add(s);
            }
            Auditorium auditorium = new Auditorium(i + 1, shows);
            auditoriumList.add(auditorium);
        }

        return auditoriumList;
    }

    private List<Show> loadShows() {
        List<Show> shows = new ArrayList<>();

        Show j11 = new Show("09:00", "Jujutsu Kaisen", "Monday", seats());
        Show j12 = new Show("12:00", "Jujutsu Kaisen", "Tuesday", seats());
        Show j13 = new Show("15:00", "Jujutsu Kaisen", "Wednesday", seats());
        Show j14 = new Show("20:00", "Jujutsu Kaisen", "Thursday", seats());

        shows.add(j11);
        shows.add(j12);
        shows.add(j13);
        shows.add(j14);

        Show t11 = new Show("08:00", "Thor", "Monday", seats());
        Show t12 = new Show("13:00", "Thor", "Tuesday", seats());
        Show t13 = new Show("19:00", "Thor", "Wednesday", seats());
        Show t14 = new Show("22:00", "Thor", "Thursday", seats());

        shows.add(t11);
        shows.add(t12);
        shows.add(t13);
        shows.add(t14);

        return shows;

    }

    private List<Seat> seats() {
        List<Seat> seats = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            Seat ps = new PremiumSeat(String.valueOf(i), 100);
            Seat ls = new LuxurySeat(String.valueOf(i), 1000);
            seats.add(ps);
            seats.add(ls);
        }
        return seats;
    }
}
