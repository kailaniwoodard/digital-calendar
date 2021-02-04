// This work is mine unless otherwise cited. - Kai’lani Woodard

/** Calendar class contains a multitude
  * of methods that when combined together
  * help calculate the correct layout and
  * display the calendar to the terminal.
  */

public class Calendar {
  private static final String[] MONTHS = {"JANUARY", "FEBRUARY", "MARCH", "APRIL",
                                        "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER",
                                        "OCTOBER", "NOVEMBER", "DECEMBER"};
  private static final char[] WEEK = {'S', 'M', 'T', 'W', 'T', 'F', 'S'};
  private static final int[] DAY = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  private static final int[] MONTH_CODE = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
  private static final int[] CENTURIES = {1700, 1800, 1900, 2000, 2100, 2200, 2300};
  private static final int[] CENTURY_CODE = {4, 2, 0, 6, 4, 2, 0};
  private static final int WIDTH = 25;

  /** Constructor.
  */
  public Calendar() {

  }

  public static int calculateYearCode(int year) {
    int YY = year % 100; // Calculate last two digits of the year
    return (YY + (YY / 4)) % 7;
  }

  /** Method to determine the day of the week a given date is.
  */
  public static int dayOfWeek(int m, int d, int c, int y) { // month, day, century, year
    int yc = (y + (y / 4)) % 7;
    int mc = MONTH_CODE[m-1];
    String centuryString = Integer.toString(c);
    String yearString = centuryString + y;
    centuryString += 0;
    centuryString += 0;
    int year = Integer.parseInt(yearString);
    int century = Integer.parseInt(centuryString);
    int cc = 0;
    for (int i = 0; i < CENTURIES.length; i++) {
      if (century == CENTURIES[i]) {
        cc = CENTURY_CODE[i];
        break;
      }
    }

    int lyc = 0;

    if (isLeapYear(year)) {
      lyc = 1;
      if (m == 1 || m == 2) {
        return (yc + mc + cc + d - lyc) % 7;
      } else {
        return (yc + mc + cc + d - 0) % 7;
      }
    }
    return (yc + mc + cc + d - lyc) % 7;
    /* Equation adapted from Josh from Art of Memory Blog:
    * https://artofmemory.com/blog/how-to-calculate-the-day-of-the-week-4203.html
    */
  }

  /** Method to determine whether the given year is a leap year.
  */
  public static boolean isLeapYear(int year) {
    // Determine if year is divisble by 4
    if (year % 4 == 0) {
      // Determine if year is a century year
      if (year % 100 == 0) {
        // Determine if given century year is a leap year (only if divisble by 400)
        if (year % 400 == 0)
          return true;
        else
          return false;
      // If only condition satisfied is year % 4 == 0
      } else
        return true;
    // No conditions are satisfied
    } else
      return false;
  }

  /** Method to center a month's title in the calendar's display.
  */
  public void centerMonth(String month) {
    // Calculate number of spaces printed left and right of the title
    int buffer = (WIDTH - month.length()) / 2;
    System.out.println(""); // Create new line

    for (int i = 0; i < (WIDTH - month.length() + 1); i++) {
      // If title has not been printed yet
      if (buffer > i) {
        System.out.print(" ");
      // If title must be printed
      } else if (i == buffer) {
        System.out.print(month);
      // If title has been printed
      } else if (buffer < i) {
        System.out.print(" ");
      }
    }
    System.out.println("\n"); // Separate with a new line
  }

  /** Method to construct and display a month.
  */
  public void displayCalendar(int month, int year) {
    // Print month title
    centerMonth(MONTHS[month - 1]);
    // Print days of the week
    for (int i = 0; i < WEEK.length; i++) {
      System.out.print(WEEK[i] + "   ");
    }

    System.out.println("\n"); // Establish new line

    // Format date to be suitable as parameters for dayOfWeek()
    int m = month; // Variable to be used as month parameter in dayOfWeek()

    int c = year / 100; // Variable of the first two digits of year
    int y = year % 100; // Variable of last two digits of year

    // Create a variable that tracks how many spaces in a week are filled
    int count = dayOfWeek(m, 8, c, y); // Use 8 as variable because 1 breaks

    // Print blank spaces before first day of the month
    for (int i = 0; i < count; i++) {
      System.out.print("    "); // Print 4 blank spaces per day
    }

    // Save amount of days to integer variable
    int days = DAY[month - 1];

    // Conditional statement regarding printing a month with a leap year
    if (month == 1) {
      if (isLeapYear(year)) {
        // If given January is a leap year, set days = 29
        days = 29;
      }
    }
    // Print numbered days into the calendar
    for (int i = 0; i < days; i++) {
      // Change spacing when numbered day becomes double digit
      if ((i+1) >= 10) {
        if (count == 7) { // When count = 7, week is fully printed
          System.out.println("\n");
          System.out.print((i+1) + "  ");
          // Reset counter to 1, indicating 1 day has been added
          count = 1;
        } else {
          System.out.print((i+1) + "  ");
          // Increment count by 1 to indicated a day has been printed in the week
          count++;
        }
      // If numbered day is still a single digit
      } else if (count == 7) { // When count = 7, week is fully printed
        System.out.println("\n");
        System.out.print((i+1) + "   ");
        // Reset counter to 1, indicating 1 day has been added
        count = 1;
      } else {
        System.out.print((i+1) + "   ");
        count++;
      }
    }
    // Print new line to buffer calendar from prompt text
    System.out.println("");
  }
}
