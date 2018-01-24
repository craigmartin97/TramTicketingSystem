# TramTicketingSystem
		TicketUpgradeSystem

--------------------------------------------------------------------------

What is it?
------------

The TicketUpgradeSystem is design for the user to purchase tram ticket on 
either the red, green or blue route. They then can upgrade the ticket if
they choose to


What are the key files and packages are ?
-----------------------

Package Main - 
1) TicketGUI - this file creates a new gui and all the operations are done here
2) TicketSystem - The driver class, where the main method is

Package TramUpgrade - 
1) BlueRoute - defines what a blue route ticket is and does. Defines such things as locations, times and prices
2) RedRoute - defines what a red route ticket is and does. Defines such things as locations, times and prices
3) GreenRoute - defines what a green route ticket is and does. Defines such things as locations, times and prices
4) FirstClassUpgrade - adds a code and cost individual to this upgrade
5) EntertainemnetUpgrade - adds a code and cost individual to this upgrade
6) RefreshmentUpgrade - adds a code and cost individual to this upgrade
7) WifiUpgrade - adds a code and cost individual to this upgrade
8) NewspaperUpgrade  - adds a code and cost individual to this upgrade
9) TramTicketUpgrade - 

How to work the software
------------------------


To access and work the TicketUpgradeSystem, simply open the java project
TicketUpgradeSystem.

To run the file and see it live in action press the green button. 


Once opened how do you use the software
---------------------------------------

Once you have opened the system you will be presented with a live GUI application

Press on one of the add route buttons, Red Route Ticket, Green Route Ticket or BlueRouteTicket to add
one to the GUI.

Go through the process of selecting a date, time and passenger type. Once you have done this
Your ticket will be created and added onto the coloured ticket that you have chosen.

How do I upgrade my ticket?
---------------------------

To upgrade the ticket you have created, simply press (Left Press On Mouse) the ticket and new dialog will appear.
Select which upgrade you wish to apply. The cost and upgrade code will change accordingly.

What if i want to remove an upgrade?
------------------------------------

To remove an upgrade, simply press (Right Press On Mouse) on the ticket and new dialog will appear asking which upgrade you would
like to remove. 
Please note that you must remove the last upgrade applied and continuously remove each upgrade that was last applied until you get to the 
layer that you wish to remove. 

For example, if you added the FirstClassUpgrade and then An EntertainmentUpgrade. You must remove the EntertainmentUpgrade first then the FirstClassUpgrade.


What do the TotalCost and ClearApp Buttons Do?
-----------------------------------------------

TotalCost - displays the total cost of the current items in the application including upgrades
Clear - Removes all items from the application

To View and Use Test Packages
-----------------------------

Click on test packages and select a file. Run the document to see tests run succesfully. You can also view methods to see what has been tested.
