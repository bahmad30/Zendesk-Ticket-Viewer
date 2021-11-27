#Zendesk Ticket Viewer

---

A simple CLI application that allows users to view and page through tickets 
using the Zendesk API. This application was made with Java and Maven, and tested with JUnit.


##Installation

---
To run this application you must have a compatible JDK installed.

To use this application, first clone (or download) this repository
to your working directory.

```
git clone https://github.com/bahmad30/Zendesk-Ticket-Viewer.git
```
Then open this project using your IDE (IntelliJ, Eclipse, VSCode, etc.)

##Usage

---

You must create environment variables ENV_EMAIL, ENV_SUBDOMAIN, and ENV_TOKEN,
which should hold your Zendesk email, subdomain, and API token respectively:

```
ENV_EMAIL={email@example.com}
ENV_SUBDOMAIN={yoursubdomain}
ENV_TOKEN={yourAPItoken}
```

Alternativey, you can directly edit the API_URL and API_AUTH fields in Viewer.java.

To run this application, navigate to Main.java (located under src/main/java/com/company)
and run the main method using your IDE's run feature. This will launch the application in
the command line, where you can use your keyboard to:
* View a list of tickets previews
* View details of a specific ticket
* Page through 25 tickets at a time (if more than 25 tickets)

##Testing

---

To run the tests for this application, navigate to the test
classes (located under /test/java/com/company). Here, you can run DisplayTest.java
and ViewerTest.java using you IDE's run/test feature.

##Features & Screenshots

---

The user is greeted with a main menu:
![Alt text](/screenshots/main_menu.png?raw=true)

The user can view a list of ticket previews:
![Alt text](/screenshots/ticket_page.png?raw=true)

The user can also page through these ticket previews, or view an individual ticket's details:
![Alt text](/screenshots/single_ticket.png?raw=true)
