// This work is mine unless otherwise cited. - Kai’lani Woodard

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/** Menu class contains a multitude
  * of wrapper methods to easier organize
  * methods from both the Calendar class
  * and the Planner class to give ease
  * of readability in the Main class.
  */

public class Menu {
  private Calendar calendar;
  private Planner planner;
  private Scanner sc;

  public Menu() {
    calendar = new Calendar(); // Initialize the Calendar object
    planner = new Planner(); // Initialize the Planner object
    sc = new Scanner(System.in); // Initialize the Scanner object
  }

  /** Method to throw error.
  */
  public void throwError() {
    System.out.println("\n*********************************");
    System.out.println("E*R*R*O*R: Invalid input!");
    System.out.println("*********************************");
  }

  /** Method to display the main menu.
  */
  public void displayMenu() {
    System.out.println("\n--------------------------");
    System.out.println("What would you like to do?");
    System.out.println("(D)isplay the calendar"
                      + "\n(S)ee today's events"
                      + "\n(V)iew all events"
                      + "\n(M)ore options..."
                      + "\n(Q)uit");
    System.out.println("--------------------------");
  }

  /** Method to display the secondary event menu.
  */
  public void eventMenu() {
    System.out.println("\n--------------------------");
    System.out.println("What would you like to do?");
    System.out.println("(W)rite an event"
                      + "\n(U)pdate an event"
                      + "\n(D)elete an event"
                      + "\n(G)o back..."
                      + "\n(Q)uit");
    System.out.println("-------------------------");
  }

  /** Method to prompt the user for input to display the calendar.
  */
  public void displayCalendar() {
    // Prompt user for the month they would like to view
    System.out.println("\nWhat month would you like to see? (1-12)");
    int month = sc.nextInt(); // Save user input to month variable
    // Validate user's month input
    while (month < 1 || month > 12) {
      throwError();
      System.out.println("Please enter a valid month! (1-12)");
      month = sc.nextInt();
    }

    // Prompt user for the year they would like to view it from
    System.out.println("\nFrom what year? (YYYY)");
    int year = sc.nextInt(); // Save user input to the year variable
    // Validate user's year input
    while (year < 1582 || year > 9999) {
      throwError();
      if (year < 1582) { // Fun Fact: The Gregorian Calendar was not created until 1582
        System.out.println("The Gregorian calendar wasn't invented until 1582!");
        System.out.println("Please enter a valid year! (YYYY)");
      } else if (year > 9999) { // The equation for month calculation does not exceed past four digit years
        System.out.println("Bold of you to assume that the Gregorian calendar will "
                          + "last past year 9999.");
        System.out.println("Please enter a valid year! (YYYY)");
      }
      year = sc.nextInt();
    }

    // Display the calendar to the console
    System.out.println("\n--------------------------");
    calendar.displayCalendar(month, year);
    System.out.println("\n--------------------------");

    // Add month events at the bottom of the calendar
    try {
      if (month < 10) {
        planner.displayMonthEvents("0" + Integer.toString(month), Integer.toString(year));
      } else {
        planner.displayMonthEvents(Integer.toString(month), Integer.toString(year));
      }
    } catch (IOException e) {
      System.out.println("Failed to display this month's events. Please check for the events.txt file.");
    }
  }

  /** Method to display the current events for the system's current day.
  */
  public void displayTodaysEvents() {
    DateFormat df = new SimpleDateFormat("MM/dd/YYYY");
    String today = df.format(new Date());
    System.out.println("\nToday's Events: ");
    try {
      planner.displayTodaysEvents(today);
    } catch (IOException e) {
      System.out.println("Failed to display today's events. Please check for the events.txt file.");
    }
    System.out.println("");
  }

  /** Method to display all events.
  */
  public void displayEvents() {
    System.out.println("\nAll Events: ");
    try {
      planner.displayEvents();
    } catch (IOException e) {
      System.out.println("Failed to display all events. Please check for the events.txt file.");
    }

    System.out.println("");
  }

  /** Method to prompt the user for input to write an event.
  */
  public void writeEvent() {
    // Prompt user for month of the event
    System.out.println("\nPlease enter the month for your event.");
    int month = sc.nextInt();
    // Validate user's month input
    while (month < 1 || month > 12) {
      throwError();
      System.out.println("Please enter a valid month! (1-12)");
      month = sc.nextInt();
    }

    // Prompt user for the day of the event
    System.out.println("\nPlease enter the day for your event.");
    int day = sc.nextInt();
    // Validate user's day input
    while (day < 1 || day > 28) {
      // if the month is February
      if (month == 2) {
        if (day > 29 || day < 1) {
          throwError();
          System.out.println("\nPlease enter a valid day! (1-28, unless it is a Leap Year, then 1-29");
          day = sc.nextInt();
        }
      // if the month has 30 days
      } else if (month % 2 == 0) {
        if (day > 30 || day < 1) {
          throwError();
          System.out.println("\nPlease enter a valid day! (1-30)");
          day = sc.nextInt();
        }
        break;
      // if the month has 31 days
      } else if (month % 2 != 0) {
        if (day > 31 || day < 1) {
          throwError();
          System.out.println("\nPlease enter a valid day! (1-31)");
          day = sc.nextInt();
        }
      // break the loop
      } else {
        break;
      }
    }
    System.out.println("\nPlease enter the year for your event.");
    int year = sc.nextInt();
    // Validate user's year input
    while (year < 1582 || year > 9999) {
      throwError();
      if (year < 1582) { // Fun Fact: The Gregorian Calendar was not created until 1582
        System.out.println("The Gregorian calendar wasn't invented until 1582!");
        System.out.println("Please enter a valid year that occurs after 1582! (YYYY)");
      } else if (year > 9999) { // The equation for month calculation does not exceed past four digit years
        System.out.println("Bold of you to assume that the Gregorian calendar will "
                          + "last past year 9999.");
        System.out.println("Please enter a valid year! (YYYY)");
      }
      year = sc.nextInt();
    }

    sc.nextLine(); // Clear the line, in order to proceed to the next
    System.out.println("\nPlease enter the event description.");
    String event = sc.nextLine();

    // Write event to the planner
    try {
      planner.writeEvent(Integer.toString(month), Integer.toString(day), Integer.toString(year), event);
    } catch (IOException e) {
      System.out.println("Failed to write event. Please check for the events.txt file.");
    }
  }

  /** Method to prompt the user to delete an event.
  */
  public void deleteEvent() {
    System.out.println("Please enter a keyword to find the event to delete.");
    String keyword = sc.nextLine();
    try {
      planner.deleteEvent(keyword);
    } catch (IOException e) {
      System.out.println("Failed to delete event. Please check for the events.txt file.");
    }
  }

  /** Method to prompt the user to update an event.
  */
  public void updateEvent() {
    System.out.println("Please enter a keyword to find your event to update.");
    String keyword = sc.nextLine();
    try {
      planner.updateEvent(keyword);
    } catch (IOException e) {
      System.out.println("Failed to update event. Please check for the events.txt file.");
    }
  }
}
