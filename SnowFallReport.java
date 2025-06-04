import java.util.Scanner;

public class SnowFallReport {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printIntro();

        String city1 = getCityName(scanner, 1);
        String city2 = getCityName(scanner, 2);

        double total1 = getTotalSnow(scanner, city1);
        double total2 = getTotalSnow(scanner, city2);

        int feet1 = convertToFeet(total1);
        int feet2 = convertToFeet(total2);

        System.out.println("Results:\n");
        System.out.println("\t" + city1 + " = " + total1 + " in of snow (approx. " + feet1 + " ft)");
        System.out.println("\t" + city2 + " = " + total2 + " in of snow (approx. " + feet2 + " ft)\n");

        if (total1 > total2) {
            System.out.println(city1 + " had more snow fall.");
        } else if (total2 > total1) {
            System.out.println(city2 + " had more snow fall.");
        } else {
            System.out.println("Both cities had the same amount of snow fall.");
        }

        scanner.close();
    }

    public static void printIntro() {
        System.out.println("This program will calculate the amount of");
        System.out.println("snowfall between two cities, determining");
        System.out.println("which city encountered more snow.\n");
    }

    public static String getCityName(Scanner scanner, int cityNumber) {
        System.out.print("What's the name of city #" + cityNumber + " > ");
        String city = scanner.next();
        if (city.equals("Shoreline")) {
            System.out.println("Yay! I go to school in Shoreline, WA.");
        }
        return city;
    }

    public static double getTotalSnow(Scanner scanner, String city) {
        System.out.println("\nInformation for " + city + ":\n");
        System.out.print("\tHow many days did it snow for? > ");
        int days = scanner.nextInt();
        double total = 0;
        if (days > 0) {
            for (int i = 1; i <= days; i++) {
                System.out.print("\t\tHow many inches of snow on day " + i + "? > ");
                total += scanner.nextDouble();
            }
        }
        System.out.println("\t~~ Total snow fall = " + total + " inches ~~\n");
        return total;
    }

    public static int convertToFeet(double inches) {
        int feet = (int) (inches / 12);
        double remainder = inches - feet * 12;
        if (remainder >= 6) {
            feet++;
        }
        return feet;
    }
}
