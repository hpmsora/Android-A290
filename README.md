# Android-A290
<br />
<br />
Indiana University - Bloomington
<br />
<br />
CSCI-A 290
<br />
<br />
Written by **Won Yong Ha**
<br />
<br />
Exploration of topics in computing. This course introduces the basics of Android application development for common devices and will review design considerations, creation and deployment of real apps utilizing mobile device capabilities including sensors.
<br />
<br />
* Assignment 1
  * Create Hello World Project
<br />
<br />
* Assignment 2
  * Design your app with the required functionality given below.
  * Requirements:
    * Create a Multi-Activity App (Minimum two) with following requirements:
      * **Activity 1**: Welcome/Login Screen should include text boxes for user to enter first and last names, email address, and password, along with a login button and an element (view) to display the number of login attempts.
      * Prompt the user to select the background color and choose that color for the canvas (of Activity 1 & 2)
      * Ensure that user has entered email in correct format
      * Save name, email and background color in preferences and use that to update background color of activity 2
      * Disable login button after 3 unsuccessful attempts
      * Upon entering correct credentials, go to activity 2 (Calculator)
      * Load the saved preferences and display the name and email on activity2
      * **Activity 2** should also have a simple Calculator interface w/ Background color chosen from user preference in Activty1, along with one number box (user may have fractional numbers and will use the same box for both operands), and buttons for operations (+, -, /, *, ^2, ^1/2) in one row. Add another button for operation = in the row below the other buttons and make it as wide as all the other buttons combined. Use grid/Table layout for UI.
      * Display the entire operation string (For example: “5 + 7 = 12”) as user enters the operands and selects operations. Update when needed!
      * Perform the arithmetic operation after proper checks (i.e., avoid divide by zero and other common errors). Show toast warnings for errors!
    Either add another activity or include this on previous activity
      * Prompt the user to enter a date in future (check to make sure that user has done that, show warning if not and ask for new date). Using today’s date, count the number of days between today and the future date entered by user. Display the number of working days and weekend days (For simplicity, let’s use Saturday and Sunday as weekend days).
<br />
<br />
* Assignmet 3
  * Design only two apps with the required functionality (given below)
  * Requirements:
    * **App Idea 1**:<br />Design and display a simple Music playlist display application with the following:
      * Use a Grid View/ List view to display the music list.
      * Each music grid/list item should contain a picture of the music poster along with a description of the music below the music poster.
      * When the app is launched, let the main Activity have a couple of options such as Display Playlist by Genre or Singer.
      * Based on the option selected, re-direct to the appropriate activity where the grid/list view is displayed to the user containing the music poster along with its description.
    * **App Idea 2**: <br />Design a simple gallery app with following requirements:
      * Create a grid view/list view to display the gallery.
      * Each grid item should contain a small preview of the image. When the image is clicked, it should be re-directed to a new activity where the image is displayed in a better size and the description of the image is also provided such as the time/date at which the image was taken along with the dimensions etc.
      * Real time data need not be used; meaningful data can be plugged in for the purpose of creating the app.
    * **App Idea 3**:<br />Create a simple file explorer app with the following:
      * Display the list of files available in a list-view.
      * Create a list-view of files in which each list-item should have the following layout:
        * Name of the file in the first line of the list-item.
        * Date of modification along with the size of the file side by side in the second line.
      * When the item is clicked, it should be re-directed to the second activity, where the contents of the file should be displayed.
      * For the purpose of creating this app, sample data can be used and only .txt files can be considered.
<br />
<br />
* Assignmet 4
  * Design only one app with the required functionality (described below).
  * Requirements:<br />You are expected to design apps as close to the real To-do and Calendar apps as possible. Feel free to research different design/layout ideas on the web.
    * **App Idea 1**:<br />Design an app called “3 minute to do list”
      * This app will display a time-dependent list (as the name suggests)
      * Screen 1 overview: The app should be able to display all the to-do items as a list at the starting screen. It should also contain an option (‘floating button’ somewhere on the screen to add another item). The items should be contained as a list view from inside a fragment and should be clickable. Whenever the orientation is changed, the fragment should change to grid view/linear view.<br />The items are expected to have an expiry date and time which is displayed in a different format and alignment along with the item title and description. They are expected to be displayed in chronological order by their expiry date (i.e., fastest expiring one shown first)
      * Screen 2a (add a to-do item): The app should take us to a new item screen to get the required inputs from the user. It should contain a button to save and one more to discard the operation. Hitting back at this stage should save the instance context/data and restore if prompted to add the item again.
      * Screen 2b (click an item): Yes, The items should be clickable and when clicked it is supposed to display two options/buttons to whether start the activity or edit it. If user opts to exit the activity, he should be able to edit the information and save it again. If he opts to do the activity he should be taken to another screen 3. While one gets to modify the activity, one should also have a button/ an option to delete it.
      * Screen 3: It should be a plain screen with big text saying ‘Your time is running’ or something similar. (If you are ambitious you can display the count-down timer of 3 mins for extra-credit here). After 3 mins it should delete the to-do item from the list and display the rest of the list automatically. If one presses back at this point before 3 mins, the app should ask the user whether he/she has finished the task and then delete the task if they have. Leave the list unaltered if they have not.
      * While displaying the list it should check whether the time has expired or not. If it is expired, it has to change its background color.
    * **App Idea 2**:<br />Time table app [mini calendar]
      * As the name suggests, the app should display a grid layout like a calendar (as this is only a mini project, you can just display one week). The current day should be highlighted with different color. The day tile should contain the number of classes you have on any day. These tiles should be clickable. The items in the grid layout should be from within a fragment and the view is expected to be changed into a linear/list view (titled agenda) within a new fragment and have the same required functionalities.
      * Once a day tile is clicked, the user should be taken to another screen where he/she has a list view of classes/courses on that day. There should also be a floating add button on the screen to add a class/course. [The course/class should display name and time.] The list is expected to be ordered chronologically. Each course/class item should also be clickable. When clicked it should give the option of editing or deleting in a new screen with a save button. When the save button is clicked, it should save the information and revert back to the day screen again.
      * At the day screen if the back button is pressed, it should save the context and display the timetable screen so that if the day is clicked again it should have the changes unaltered. (Hint: Lifecycle functions override)
      * If ambitious, (for extra credit) the app should notify with a class title using the notification screen about current class details (throughout the duration) in any given day from the information entered.
