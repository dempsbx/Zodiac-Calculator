import java.util.Scanner;

/**
 * This class prompts the user to enter a month and date and then calculates and
 * prints out the Zodiac sign if valid date is given.
 * 
 * @author Billy Dempsey
 * @version 1.0
 */
public class ZodiacCalculator {
    // Constants for month and day limits
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private static final int MIN_DAY = 1;
    private static final int MAX_DAY = 31;

    public static void main(String args[]) {
        // Create Scanner
        Scanner in = new Scanner(System.in);

        // Prompt user for month and day input and assign to variables
        System.out.println("Zodiac Sign Calculator");
        int month = getValidInput("Enter the month (1-12): ", MIN_MONTH, MAX_MONTH);
        int day = getValidInput("Enter the day of the month (1-31):", MIN_DAY, MAX_DAY);

        // Call the method to calculate Zodiac sign
        computeZodiac(month, day);

        // Close the Scanner
        in.close();
    }

    /**
     * This method computes the Zodiac sign based on month and day input.
     * 
     * @param month The month (1-12)
     * @param day   The day of the month (1-31)
     */
    public static void computeZodiac(int month, int day) {
        // Define date ranges for each Zodiac sign
        String[] zodiacSigns = { "Capricorn", "Aquarius", "Pisces", "Aries", "Taurus", "Gemini", "Cancer", "Leo",
                "Virgo", "Libra", "Scorpio", "Sagittarius", "Capricorn" };

        int[] endDays = { 19, 18, 20, 19, 20, 20, 22, 22, 22, 22, 21, 21, 31 };

        // Find the Zodiac sign
        int signIndex = month - 1;
        if (day > endDays[signIndex])
            signIndex = (signIndex + 1) % 12;

        System.out.println("The Zodiac Sign is: " + zodiacSigns[signIndex]);
    }

    /**
     * Get valid input from the user within a specified range.
     * 
     * @param prompt   The input prompt message.
     * @param minValue The minimum allowed value.
     * @param maxValue The maximum allowed value.
     * @return The valid input value.
     */
    public static int getValidInput(String prompt, int minValue, int maxValue) {
        Scanner in = new Scanner(System.in);
        int input;
        do {
            System.out.print(prompt);
            while (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print(prompt);
                in.next();
            }
            input = in.nextInt();
        } while (input < minValue || input > maxValue);
        return input;
    }
}