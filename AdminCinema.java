public class AdminCinema extends Cinema {
    // create cinema
    public static void addCinema() {
        Scanner sc = new Scanner(System.in);
        String cinemaName, cinemaCode, cinemaType;
        System.out.println("Enter cinema name: ");
        cinemaName = sc.nextLine();
        System.out.println("Enter cinema code: ");
        cinemaCode = sc.nextLine();
        System.out.println("Enter cinema type: ");
        cinemaType = sc.nextLine();
        Cinema cinema = new Cinema(cinemaName, cinemaCode, cinemaType);
        System.out.println("Cinema added successfully");
    }

    // update cinema
    public static void updateCinema() {
        Scanner sc = new Scanner(System.in);
        String cinemaName, cinemaCode, cinemaType;
        System.out.println("Enter cinema name: ");
        cinemaName = sc.nextLine();
        System.out.println("Enter cinema code: ");
        cinemaCode = sc.nextLine();
        System.out.println("Enter cinema type: ");
        cinemaType = sc.nextLine();
        Cinema cinema = new Cinema(cinemaName, cinemaCode, cinemaType);
        System.out.println("Cinema updated successfully");
    }

    // remove cinema
    public static void removeCinema() {
        Scanner sc = new Scanner(System.in);
        String cinemaName, cinemaCode, cinemaType;
        System.out.println("Enter cinema name: ");
        cinemaName = sc.nextLine();
        System.out.println("Enter cinema code: ");
        cinemaCode = sc.nextLine();
        System.out.println("Enter cinema type: ");
        cinemaType = sc.nextLine();
        Cinema cinema = new Cinema(cinemaName, cinemaCode, cinemaType);
        System.out.println("Cinema removed successfully");
    }
}
