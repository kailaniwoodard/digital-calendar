# Digital Calendar and Planner

The Digital Calendar and Planner is a Java program for users to engage with a
digital calendar and planner, giving them the ability to read and write their
events alongside the calendar.

Data Abstration, CMPSC 101 Spring 2020

## Instructions
Follow the menu to interact with the program, responding with single character
answers as input. Within this program, you have the ability to display the
calendar, see the day's events, view a month's events, view all events, write
events to the calendar, update calendar events and delete calendar events.

## Note
Ensure that code is compiled and ran with the following commands within the \\src file:
```
javac -d classes *.java
cd classes
java Main
```

## Usage
```
Welcome to the Digital Calendar and Planner!

Today's date is Wed Apr 29 01:27:25 EDT 2020

          APRIL

S   M   T   W   T   F   S

            1   2   3   4

5   6   7   8   9   10  11

12  13  14  15  16  17  18

19  20  21  22  23  24  25

26  27  28  29  30

--------------------------
What would you like to do?
(D)isplay the calendar
(S)ee today's events
(V)iew all events
(M)ore options...
(Q)uit
--------------------------
D

What month would you like to see? (1-12)
4

From what year? (YYYY)
2020

--------------------------

          APRIL

S   M   T   W   T   F   S

            1   2   3   4

5   6   7   8   9   10  11

12  13  14  15  16  17  18

19  20  21  22  23  24  25

26  27  28  29  30

--------------------------
04/29/2020: CR/NC Exemptions Due
04/29/2020: CS 101 Final Project and Report Due
04/30/2020: CS 101 Final Exam

--------------------------
What would you like to do?
(D)isplay the calendar
(S)ee today's events
(V)iew all events
(M)ore options...
(Q)uit
--------------------------
S

Today's Events:
04/29/2020: CR/NC Exemptions Due
04/29/2020: CS 101 Final Project and Report Due


--------------------------
What would you like to do?
(D)isplay the calendar
(S)ee today's events
(V)iew all events
(M)ore options...
(Q)uit
--------------------------
V

All Events:
04/29/2020: CR/NC Exemptions Due
04/29/2020: CS 101 Final Project and Report Due
04/30/2020: CS 101 Final Exam
05/01/2020: FS 101 Paper Due
05/03/2020: ART 187 Unity Progress Due
08/08/2020: My Birthday


--------------------------
What would you like to do?
(D)isplay the calendar
(S)ee today's events
(V)iew all events
(M)ore options...
(Q)uit
--------------------------
M

--------------------------
What would you like to do?
(W)rite an event
(U)pdate an event
(D)elete an event
(G)o back...
(Q)uit
-------------------------
W

Please enter the month for your event.
4

Please enter the day for your event.
29

Please enter the year for your event.
2020

Please enter the event description.
Example Event

Event successfully added.


--------------------------
What would you like to do?
(W)rite an event
(U)pdate an event
(D)elete an event
(G)o back...
(Q)uit
-------------------------
U
Please enter a keyword to find your event to update.
Example
1. 04/29/2020: Example Event
Please enter the number that you would like to update!
1
What would you like to update your event to?
Month: 4

Day: 29

Year: 2020

Event Description: Example Event Edited
Event successfully updated!

--------------------------
What would you like to do?
(W)rite an event
(U)pdate an event
(D)elete an event
(G)o back...
(Q)uit
-------------------------
D
Please enter a keyword to find the event to delete.
Example
1. 04/29/2020: Example Event Edited
Please enter the number that you would like to delete!
1

Event successfully deleted!

--------------------------
What would you like to do?
(W)rite an event
(U)pdate an event
(D)elete an event
(G)o back...
(Q)uit
-------------------------
G

--------------------------
What would you like to do?
(D)isplay the calendar
(S)ee today's events
(V)iew all events
(M)ore options...
(Q)uit
--------------------------
V

All Events:
04/29/2020: CR/NC Exemptions Due
04/29/2020: CS 101 Final Project and Report Due
04/30/2020: CS 101 Final Exam
05/01/2020: FS 101 Paper Due
05/03/2020: ART 187 Unity Progress Due
08/08/2020: My Birthday


--------------------------
What would you like to do?
(D)isplay the calendar
(S)ee today's events
(V)iew all events
(M)ore options...
(Q)uit
--------------------------
Q

Thank you for using the Digital Calendar and Planner!
Goodbye!
```

## Authors

* **Kai'lani Woodard** - [kailaniwoodard](https://github.com/kailaniwoodard)

## Acknowledgments

* Credit Josh from Art of Memory Blog for the equation that the `dayOfWeek()` equation was adapted from.
* Hat tip to my Gator Girls, Kyrie Doniz and Favour Ojo for being there for me throughout this final project.
* Also kudos to my friends Harrison Seabold and Sebastian Goldberg for staying up with me, while I practically reinvented the wheel to fix my `dayOfWeek()` equation.
