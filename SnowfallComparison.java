import java.util.Scanner;

public class SnowfallComparison {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        printIntro();

        String city1 = getCityName(input, 1);
        String city2 = getCityName(input, 2);

        double snow1 = getTotalSnowfallForCity(input, city1);
        double snow2 = getTotalSnowfallForCity(input, city2);

        printResults(city1, snow1, city2, snow2);
    }

    public static void printIntro() {
        System.out.println("This program will calculate the amount of");
        System.out.println("snowfall between two cities, determining");
        System.out.println("which city encountered more snow.\n");
    }

    public static String getCityName(Scanner input, int cityNumber) {
        System.out.print("What's the name of city #" + cityNumber + " > ");
        String city = input.next();
        if (city.equalsIgnoreCase("Shoreline")) {
            System.out.println("Yay! I go to school in Shoreline, WA.");
        }
        return city;
    }

    public static double getTotalSnowfallForCity(Scanner input, String city) {
        System.out.println("\nInformation for " + city + ":\n");
        System.out.print("\tHow many days did it snow for? > ");
        int days = input.nextInt();
        double total = 0;

        for (int i = 1; i <= days; i++) {
            System.out.print("\t\tHow many inches of snow on day " + i + "? > ");
            total += input.nextDouble();
        }

        System.out.printf("\t\t~~ Total snow fall = %.1f inches ~~\n", total);
        return total;
    }

    public static int convertToFeet(double inches) {
        int feet = (int) (inches / 12);
        double remainder = inches % 12;
        if (remainder >= 6) {
            feet++;
        }
        return feet;
    }

    public static void printResults(String city1, double snow1, String city2, double snow2) {
        int feet1 = convertToFeet(snow1);
        int feet2 = convertToFeet(snow2);

        System.out.println("\nResults:\n");
        System.out.printf("\t%s = %.1f in of snow (approx. %d ft)\n", city1, snow1, feet1);
        System.out.printf("\t%s = %.1f in of snow (approx. %d ft)\n", city2, snow2, feet2);

        if (snow1 > snow2) {
            System.out.println("\n" + city1 + " had more snow fall.");
        } else if (snow2 > snow1) {
            System.out.println("\n" + city2 + " had more snow fall.");
        } else {
            System.out.println("\nBoth cities had the same amount of snow fall.");
        }
    }
}
