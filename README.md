# Menu app

(P.S if someone want to use this app, he needs to have a database, and adjust the database information in JDBC.java)

The project is written by Java. The GUI is made up of java.swing.

The database is oracle SQL Server.

The user will only have one gui page in a time, and they can always click “back” button to go back to last page.

Homepage

![alt text](./guiPic/LoginGUI.JPG "LoginGUI")

Customer Side

![alt text](./guiPic/Menu_Index_GUI.JPG "Menu_Index_GUI 1")

Display Restaurants

The user can click the button “Find near restaurants” to sort the restaurants by distance. 

After user click the button “Find near restaurant”, a small message box will appear. 
user can input their x and y address there.

![alt text](./guiPic/Menu_Index_Ex_InputAddress.JPG "Menu_Index_Ex_InputAddress")



Then the restaurant list of sorting by closest distance from user will appear.

![alt text](./guiPic/Menu_Index_Ex2.JPG "Menu_Index_Ex2")

Finally people can still sort those restaurants by name.

![alt text](./guiPic/Menu_Index_Ex3.JPG "Menu_Index_Ex3")

User can click any restaurant in the list to read its menu.

![alt text](./guiPic/MenuOutput.JPG "MenuOutput")


Manager’s Side

When enter manager’s page, it will require manager to enter username and password. After input manager information, user can click continue to go into next page.

![alt text](./guiPic/Manager_Login.JPG "Manager_Login")

In manager’s home page, the manager can choose to add new restaurant, modify restaurant’s menu and delete restaurant.

After user click new restaurant. Then they can input restaurant information.	

![alt text](./guiPic/restaurant_Infor.JPG "restaurant_Infor")

 If the restaurant’s name already exist, it will link the restaurant to the same name restaurant.

![alt text](./guiPic/dup.JPG "dup")

 If the restaurant’s address already exist, it will report a error message. And the he go back to previous page.

![alt text](./guiPic/dupRestWarning.JPG "dupRestWarning")

If the user create a totally new restaurant, it will go to category page. And user can input food’s category such as drink, soup, entree and so on  in this page. If those textfield is not enough to input all the categories, the user can still click the button “add more” to add more categories. If they are done, they can click “next” button to add food into those categories.

![alt text](./guiPic/categoryInfor.JPG "categoryInfor")

The user will get into add food page in new page. The user can click the button “add more” to store food in database and add new food. When user has no more food to add, they can click “Done” to back to manager interface.. 

![alt text](./guiPic/foodInfor.JPG "foodInfor")

The manager can click “edit restaurant” to modify a restaurant’s menu, after they click edit restaurant” button. A restaurants list will appear. 

![alt text](./guiPic/food_Infor.JPG "food_Infor")

 The user can click any restaurant in the list, and the user can update food, add new food or delete exist food.



Click “Add new food” to add food.

![alt text](./guiPic/food-.JPG "Add new food")

They can also click the food from the list to delete or update them.

![alt text](./guiPic/food_modify_buttons.JPG "food_modify_buttons")

If the user click “Update”, the user can change food information. 

If the user click “Delete” the food information will be deleted from database.

![alt text](./guiPic/modify_existingFodd.JPG "modify existing Food")

The user can click “delete” in manager’s interface to delete any restaurant. They can click any restaurant in the list to delete them

![alt text](./guiPic/food_delete.JPG "delete Food")


Done. Those things above are all the things that this project can do.
