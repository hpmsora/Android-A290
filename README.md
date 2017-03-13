# Android-A290<br />

Indiana University - Bloomington<br />

CSCI-A 290<br />

Written by **Won Yong Ha**<br />

Exploration of topics in computing. This course introduces the basics of Android application development for common devices and will review design considerations, creation and deployment of real apps utilizing mobile device capabilities including sensors.<br />

* Assignment 1<br />
  * Create Hello World Project<br />
* Assignment 2<br />
  * Design your app with the required functionality given below.<br />
  * Requirements:<br />
    * Create a Multi-Activity App (Minimum two) with following requirements:<br />
      * **Activity 1**: Welcome/Login Screen should include text boxes for user to enter first and last names, email address, and password, along with a login button and an element (view) to display the number of login attempts.<br />
      * Prompt the user to select the background color and choose that color for the canvas (of Activity 1 & 2)<br />
      * Ensure that user has entered email in correct format<br />
      * Save name, email and background color in preferences and use that to update background color of activity 2<br />
      * Disable login button after 3 unsuccessful attempts<br />
      * Upon entering correct credentials, go to activity 2 (Calculator)<br />
      * Load the saved preferences and display the name and email on activity2<br />
      * **Activity 2** should also have a simple Calculator interface w/ Background color chosen from user preference in Activty1, along with one number box (user may have fractional numbers and will use the same box for both operands), and buttons for operations (+, -, /, *, ^2, ^1/2) in one row. Add another button for operation = in the row below the other buttons and make it as wide as all the other buttons combined. Use grid/Table layout for UI.<br />
      * Display the entire operation string (For example: “5 + 7 = 12”) as user enters the operands and selects operations. Update when needed!<br />
      * Perform the arithmetic operation after proper checks (i.e., avoid divide by zero and other common errors). Show toast warnings for errors!<br /><br />
    Either add another activity or include this on previous activity<br />
      * Prompt the user to enter a date in future (check to make sure that user has done that, show warning if not and ask for new date). Using today’s date, count the number of days between today and the future date entered by user. Display the number of working days and weekend days (For simplicity, let’s use Saturday and Sunday as weekend days).
* Assignmet 3<br />
  * Design only two apps with the required functionality (given below)
  * Requirements:<br />
    * App Idea 1:<br />Design and display a simple Music playlist display application with the following:
      * Use a Grid View/ List view to display the music list.
      * Each music grid/list item should contain a picture of the music poster along with a description of the music below the music poster.
      * When the app is launched, let the main Activity have a couple of options such as Display Playlist by Genre or Singer.
      * Based on the option selected, re-direct to the appropriate activity where the grid/list view is displayed to the user containing the music poster along with its description.
    * App Idea 2: <br />Design a simple gallery app with following requirements:
      * Create a grid view/list view to display the gallery.
      * Each grid item should contain a small preview of the image. When the image is clicked, it should be re-directed to a new activity where the image is displayed in a better size and the description of the image is also provided such as the time/date at which the image was taken along with the dimensions etc.
      * Real time data need not be used; meaningful data can be plugged in for the purpose of creating the app.
    * App Idea 3:<br />Create a simple file explorer app with the following:
      * Display the list of files available in a list-view.
      * Create a list-view of files in which each list-item should have the following layout:
        * Name of the file in the first line of the list-item.
        * Date of modification along with the size of the file side by side in the second line.
      * When the item is clicked, it should be re-directed to the second activity, where the contents of the file should be displayed.
      * For the purpose of creating this app, sample data can be used and only .txt files can be
considered.
