import services.BookMyShow;

public class DriverClass {
    public static void main(String[] args) {
        BookMyShow bms = new BookMyShow();
        bms.printShowsByName("Jujutsu Kaisen");

        bms.bookRandomShows(10);

        bms.printShowsByName("Jujutsu Kaisen");
    }
}
