// This work is mine unless otherwise cited. - Kai’lani Woodard

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/** Planner class contains a multitude
  * of methods that when combined together
  * help read and write user event information
  * to external files to be used over a series
  * of sessions throughout the program.
  */

public class Planner {
  private static final String FILENAME = "events.txt";

  /** Constructor.
  */
  public Planner() {

  }

  /** Method to display all events and rearrange events.txt into chronological order.
  */
  public void displayEvents() throws IOException {
    ArrayList<String> eventList = new ArrayList<>();
    Scanner fsc = new Scanner(new File(FILENAME));

    while (fsc.hasNext()) {
      eventList.add(fsc.nextLine());
    }

    Collections.sort(eventList);

    FileWriter fw = new FileWriter(FILENAME);
    BufferedWriter bw = new BufferedWriter(fw);

    for (int i = 0; i < eventList.size(); i++) {
      bw.write(eventList.get(i));
      bw.newLine();
      System.out.println(eventList.get(i));
    }

    bw.close();
    fw.close();
  }

  /** Method to display events for the given day.
  */
  public void displayTodaysEvents(String today) throws IOException {
    ArrayList<String> eventList = new ArrayList<>();
    Scanner fsc = new Scanner(new File(FILENAME));
    String line = ""; // initialize line as empty string to prevent error

    while (fsc.hasNext()) {
      line = fsc.nextLine(); // save nextLine
      if (line.substring(0, 5).equals(today.substring(0, 5))) { // compare first four characters
        eventList.add(line); // add line to list
      }
    }

    fsc.close();
    Collections.sort(eventList); // sort events chronologically

    for (int i = 0; i < eventList.size(); i++) { // cycle through list
      if (eventList.size() == 0) {
        System.out.println("\nThere are no events today!");
        break;
      }
      System.out.println(eventList.get(i)); // print each element of list
    }
  }

  /** Method to display events.
  */
  public void displayMonthEvents(String month, String year) throws IOException {
    ArrayList<String> eventList = new ArrayList<>();
    Scanner fsc = new Scanner(new File(FILENAME));

    String line = ""; // intialize line as empty to prevent error

    while (fsc.hasNext()) {
      line = fsc.nextLine(); // save nextLine
      if (line.substring(0, 2).equals(month) && line.substring(6, 10).equals(year)) { // compare if month = month
        eventList.add(line); // add line to list
      }
    }

    fsc.close();
    Collections.sort(eventList);

    for (int i = 0; i < eventList.size(); i++) { // cycle through list
      System.out.println(eventList.get(i)); // print each element of list
    }
  }

  /** Method to write events.
  */
  public void writeEvent(String month, String day, String year, String event) throws IOException {
    FileWriter fw = new FileWriter(FILENAME, true); // second parameter is true to append to file
    BufferedWriter bw = new BufferedWriter(fw);
    if (Integer.parseInt(month) < 10) {
      month = "0" + month;
    }
    if (Integer.parseInt(day) < 10) {
      day = "0" + day;
    }

    String entry = month + "/" + day + "/" + year + ": " + event; // format for events

    bw.write(entry); // write to events.txt
    bw.newLine(); // write new line

    System.out.println("\nEvent successfully added.\n"); // confirmation message
    bw.close();
    fw.close();
  }

  public void deleteEvent(String keyword) throws IOException {
    Scanner fsc = new Scanner(new File(FILENAME));
    String line;
    ArrayList<String> eventList = new ArrayList<>();

    // Sort through the events.txt file, placing each line into an ArrayList
    while (fsc.hasNext()) {
      line = fsc.nextLine();
      eventList.add(line);
    }

    fsc.close();

    ArrayList<String> options = new ArrayList<>();

    // Sort through eventList and find elements that match the keyword
    for (int i = 0; i < eventList.size(); i++) {
      // Add matching elements to another ArrayList
      if (eventList.get(i).contains(keyword))
        options.add(eventList.get(i));
    }

    Scanner prompt = new Scanner(System.in);
    String delete;

    // Prompt the user with the list of options numbered 1-?
    if (options.size() > 0) {
      for (int i = 0; i < options.size(); i++) {
        System.out.println((i+1) +  ". " + options.get(i));
      }

      System.out.println("Please enter the number that you would like to delete!");
      delete = options.get(prompt.nextInt() - 1);
      System.out.println(delete);

      // Delete selected option from eventList ArrayList
      for (int i = 0; i < eventList.size(); i++) {
        if (eventList.get(i).equals(delete))
          eventList.remove(i);
      }

      FileWriter fw = new FileWriter(FILENAME, false); // second parameter is false to overwrite to file
      BufferedWriter bw = new BufferedWriter(fw);

      // Rewrite eventList ArrayList to input.txt
      for (int i = 0; i < eventList.size(); i++) {
        bw.write(eventList.get(i));
        bw.newLine();
      }

      bw.close();
      fw.close();

      System.out.println("Event successfully deleted!");

    } else {
      System.out.println("Keyword \"" + keyword + "\" not found!");
    }
  }

  public void updateEvent(String keyword) throws IOException {
    Scanner fsc = new Scanner(new File(FILENAME));
    String line;
    ArrayList<String> eventList = new ArrayList<>();

    // Sort through the events.txt file, placing each line into an ArrayList
    while (fsc.hasNext()) {
      line = fsc.nextLine();
      eventList.add(line);
    }

    fsc.close();

    ArrayList<String> options = new ArrayList<>();

    // Sort through eventList and find elements that match the keyword
    for (int i = 0; i < eventList.size(); i++) {
      // Add matching elements to another ArrayList
      if (eventList.get(i).contains(keyword))
        options.add(eventList.get(i));
    }

    Scanner prompt = new Scanner(System.in);
    String delete;

    // Prompt the user with the list of options numbered 1-?
    if (options.size() > 0) {
      for (int i = 0; i < options.size(); i++) {
        System.out.println((i+1) +  ". " + options.get(i));
      }

      System.out.println("Please enter the number that you would like to update!");
      delete = options.get(prompt.nextInt() - 1);

      String update;

      System.out.println("What would you like to update your event to?");
      System.out.print("Month: ");
      int month = prompt.nextInt();
      if (month < 10)
        update = "0" + month + "/";
      else
        update = month + "/";
      System.out.print("\nDay: ");
      int day = prompt.nextInt();
      if (day < 10)
        update += "0" + day + "/";
      else
        update += day + "/";
      System.out.print("\nYear: ");
      int year = prompt.nextInt();
      while (year < 1000) {
        System.out.println("Invalid year, please try again!");
        year = prompt.nextInt();
      }
      update += year + ": ";
      System.out.print("\nEvent Description: " );
      prompt.nextLine();
      String event = prompt.nextLine();
      update += event;

      // Delete selected option from eventList ArrayList
      for (int i = 0; i < eventList.size(); i++) {
        if (eventList.get(i).equals(delete))
          eventList.set(i, update);
      }

      FileWriter fw = new FileWriter(FILENAME, false); // second parameter is false to overwrite to file
      BufferedWriter bw = new BufferedWriter(fw);

      Collections.sort(eventList);

      // Rewrite eventList ArrayList to input.txt
      for (int i = 0; i < eventList.size(); i++) {
        bw.write(eventList.get(i));
        bw.newLine();
      }

      bw.close();
      fw.close();

      System.out.println("Event successfully updated!");

    } else {
      System.out.println("Keyword \"" + keyword + "\" not found!");
    }
  }
}
