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
      * If ambitious, (for extra credit) the app should notify with a class title using the notification screen about current class details (throughout the duration) in any given day from the information entered
<br />
<br />
* Assignmet 5
  * Complete one of the previous projects and resubmit the completed/corrected version
  * Assignment 2 Resubmission
<br />
<br />
* Assignment 6
  * **Step Tracker App**
  * The project is a step tracker application where the user is being tracker using the step counter sensor. User will trigger tracking either by using a gesture. The user will be tracked until the user turns off the tracking which is again done by using a gesture. Thus, the steps taken by the user are being tracked and presented.
  * Here is a list of features to be implemented:
    * The project should make use of map view. The map view in the application will have a marker/pointer for the current user location.
    * When the user double-taps or tilts or flings on the screen – use gesture detector - start tracking the user’s steps by using step counter sensor. Keep tracking the user until the user stops.
    * The user stops his/her tracking by using double-tap or tilt or fling gesture.
    * Once done, the path the user has taken to walk should be displayed in the map view along with how many steps.
    * Along with the double-tap or tilt or fling feature – if you add one more feature which detects the shake event of the phone and starts tracking after a shake and keeps tracking until the user again shakes the phone or other gesture.
<br />
<br />
* Assignment 7 - Final Project
  * **Hike Planner App**
  * The project is a hike planning and fitness assistant where users can plan where to walk based on current location in a map and keep track of the temperature difference as well as get notified of to-do tasks at each location. [Simply speaking, this app is basically a temperature difference tracker and TO-DO logger app based on map view and GPS.]
  * Here is a list of features to be implemented:
    * Display a map view in the application which shows the user’s current location.
    * When the user clicks on the map – the location should be marked. The user can click on any number of places on the map. All those places should be marked and saved. (numbers can be used if the place names are not available)
    * When the user now clicks on the marked place in the map, then a fragment should be displayed showing the EditText where the user needs to create his TO-DO list of tasks.
    * When the user is done entering TO-DO list and clicks save – all the items entered should be saved for that particular location. Similarly, each of those individual places selected will have their own notes created by the user and saved.
    * Now, you need to use the GPS sensor and keep track of where the user moves – if the user visits the location he had previously selected in the map by touching a place – then the notes saved in that particular location should be shown to the user and the user should be notified – a simple toast would do, and the note should be opened and shown to the user. (For extra credit, make the app to run in the background at this point and resume once the user clicks on app again. Please specify in a report.txt file if you have implemented this functionality)
    * Also, when the user visits the location – the temperature sensor should be used to record the temperature at the location.
    * When the user visits each new location – the temperatures noted in previous location should be passed between places and the temperature difference should be shown. [This difference should be shown only when the user visits places which he clicked before on the map]
    * Finally after the user reaches each place in his plan, he should be given an option to view summary of the hike so far. There should be a summary page which shows the list of places the user selected in the map – and the list of places the user has visited so far along with the list of places the user has picked and hasn’t visited so far. Along with these details – the temperature which was noted using temperature sensor and saved in SharedPreference or a file should be shown in the summary.
    * This data should be present even after closing and reopening the app. (Hint: save and reload the details using a file in the internal storage). Given below are some pictures to help you get started.
