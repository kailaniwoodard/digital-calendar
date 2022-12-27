import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
  public static void main(String [] args) {
    Calendar calendar = new Calendar(); // Initialize the Calendar object

    // Greet the user to the digital calendar and program
    System.out.println("Welcome to the Digital Calendar and Planner!");

    // Tell the user the system's current date and time
    System.out.println("\nToday's date is " + new Date());
    DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); // Initialize DateFormat object

    String today = df.format(new Date()); // Save today's date in set format to pull information from

    // Display the current month based upon the system's time
    calendar.displayCalendar(Integer.parseInt(today.substring(0, 2)), Integer.parseInt(today.substring(6)));

    Menu menu = new Menu();
    Scanner sc = new Scanner(System.in);

    char action = '0'; // Initialize the action variable as S to display the menu
    char action2 = ' ';

    /** Main menu for the program.
    */
    do { // Encased within a do-while loop to ensure the menu continues to cycle until the user chooses otherwise
      // Access the main menu
      if (action == '0') {
        menu.displayMenu();
        action = Character.toUpperCase(sc.next().charAt(0));
      // Access the event writing, editing and deleting menu
      } else if (action == 'M') {
        menu.eventMenu();
        action2 = Character.toUpperCase(sc.next().charAt(0));
        // Write an event
        if (action2 == 'W') {
          menu.writeEvent();
          action = 'M';
        // Update an event
        } else if (action2 == 'U') {
          menu.updateEvent();
          action = 'M';
        // Delete an event
        } else if (action2 == 'D') {
          menu.deleteEvent();
          action = 'M';
        // Go back to the main menu
        } else if (action2 == 'G') {
          action = '0';
        // Quit
        } else if (action2 == 'Q') {
          action = 'Q';
        // Scold the user for incorrect input
        } else {
          menu.throwError();
          System.out.println("Invalid input!");
          menu.eventMenu();
          action2 = Character.toUpperCase(sc.next().charAt(0));
        }
      // Display the calendar
      } else if (action == 'D') {
        menu.displayCalendar();
        action = '0';
      // Display the day's events
      } else if (action == 'S') {
        menu.displayTodaysEvents();
        action = '0';
      // Display all events
      } else if (action == 'V') {
        menu.displayEvents();
        action = '0';
      // Quit
      } else if (action == 'Q') {
        break;
      // Scold the user for incorrect input
      } else {
        menu.throwError();
        action = '0';
      }
    } while (true);

    // Thank the user for using the program
    System.out.println("\nThank you for using the Digital Calendar and Planner!");
    System.out.println("Goodbye!"); // Say goodbye

    sc.close();
  }
}
