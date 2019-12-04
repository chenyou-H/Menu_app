import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.LinkedList;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class JDBC {
	String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=Restaurant;user=myUsername;password=myPassword";
	Connection dbConn;
	
	JDBC(){
		try {
			Class.forName(driverName);
			System.out.println("driver success");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("driver fail");
		}
		
		try {
//			Connection dbConn=DriverManager.getConnection(dbURL, userName, ps);
			dbConn=DriverManager.getConnection(dbURL);
			System.out.println("Connection success");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Connection fail");
		}
	}
	
	void printRestInfor() throws SQLException {
		Statement stm = dbConn.createStatement();
		String sql="Select * From food.restInfor;";
		ResultSet RS = stm.executeQuery(sql);
		stm.close();
	}
	
	int insertRestInfor(String restName, String restAddress, String open_date, String open_hour) throws SQLException {
		int checker=1;
		
		Statement stm = dbConn.createStatement();
		
		if(restName.contains("\'")){
			String head = restName.substring(0,restName.indexOf("\'"));
			String tail = restName.substring(restName.indexOf("\'"));
			restName = head+"\'"+tail;
		}
		
		String sql1="Select *\r\n" + 
				"from [Restaurant].[food].[restInfor]\r\n" + 
				"where restAddress = '" +restAddress+"'";
		ResultSet RS = stm.executeQuery(sql1);
	
		if(RS.next()) {
				checker=0;
		}
		
		
		String sql="INSERT INTO food.restInfor(restName,restAddress,open_date,open_hours)" + 
				"VALUES('"+ restName +"','"+restAddress+"','"+open_date+"','"+open_hour+"')";
		stm.executeUpdate(sql);
		stm.close();
		
		return checker;
	}
/*	
	int getRestID(String restAddress) throws SQLException {
		Statement stm = dbConn.createStatement();
		int restaurantID=0;
		String sql1="Select restID\r\n" + 
				"from [Restaurant].[food].[restInfor]\r\n" + 
				"where restAddress = '" +restAddress+"'";
		ResultSet RS = stm.executeQuery(sql1);
		if(RS.next()) {
			restaurantID= RS.getInt("restID");
			System.out.println("this is restID "+restaurantID);
		}
		else {
			System.out.println("something wrong in getRestID");
		}
		stm.close();				
		return restaurantID;
	}
*/	
	
	int checkRestName(String restName) throws SQLException {
		Statement stm = dbConn.createStatement();
		int checker=0;
		String sql1="Select restID\r\n" + 
				"from [Restaurant].[food].[restInfor]\r\n" + 
				"where restName = '" +restName+"'\r\n"+
				"Order  by restID ASC";
		ResultSet RS = stm.executeQuery(sql1);
		if(RS.next()==true) {
			checker =1;
		}
		else {
			checker=0;
		}
		stm.close();
		return checker;
		
	}
	
	int checkCategory(String restID, String categoryName) {
		int checker =0;
		
		return checker;
	}
	
	int getRestID(String restName) throws SQLException {
		Statement stm = dbConn.createStatement();
		int restaurantID=0;
		String sql1="Select restID\r\n" + 
				"from [Restaurant].[food].[restInfor]\r\n" + 
				"where restName = '" +restName+"'\r\n"+
				"Order  by restID ASC";
		ResultSet RS = stm.executeQuery(sql1);
		if(RS.next()) {
			restaurantID= RS.getInt("restID");
			System.out.println("this is restID "+restaurantID);
		}
		else {
			System.out.println("something wrong in getRestID");
		}
		stm.close();				
		return restaurantID;
	}

	
	String getRestOpen_Time(String restAddress) throws SQLException {
		Statement stm = dbConn.createStatement();
		String restaurantOpenTime = null;
		String sql1="Select restName, open_date,open_hours\r\n" + 
				"from [Restaurant].[food].[restInfor]\r\n" + 
				"where restAddress = '" +restAddress+"'";
		ResultSet RS = stm.executeQuery(sql1);
		if(RS.next()) {
			 restaurantOpenTime=RS.getString("restName")+"\n"+
					 RS.getString("open_date")+
					 "\n"+ 
					 RS.getString("open_hours")+
					 "\n";
		}
		else {
			System.out.println("something wrong in getRestOpen_Time");
		}
			
		stm.close();
				
		return  restaurantOpenTime;
	}
	
	
	void insertCategory(int restaurantID, String category) throws SQLException {
		Statement stm = dbConn.createStatement();
		
		if(category.contains("\'")){
			String head = category.substring(0,category.indexOf("\'"));
			String tail = category.substring(category.indexOf("\'"));
			category = head+"\'"+tail;
		}
		
		String sql2 = "INSERT INTO food.category(restID,categoryName)\r\n" + 
				"VALUES('"+ restaurantID +"','"+category+"')";
		stm.executeUpdate(sql2);
		stm.close();
	}
	
	int getCateID(String categoryName,int restID) throws SQLException {
		Statement stm = dbConn.createStatement();
		int categoryID=0;
				String sql1="Select categoryID\r\n" + 
						"from [Restaurant].[food].[category]\r\n" + 
						"where categoryName = '" +categoryName+"' AND restID = '"+restID+"';";
				ResultSet RS = stm.executeQuery(sql1);
				if(RS.next()) {
					categoryID= RS.getInt("categoryID");
					System.out.println("this is category ID "+categoryID);
				}
				else {
					System.out.println(restID+" something wrong in getCateID " + categoryID);
				}
			
				stm.close();
				return categoryID;
	}
	
	void insertFood(int cateID, String item, String description, String price, String size) throws SQLException {
		
		if(item.contains("\'")){
			String head = item.substring(0,item.indexOf("\'"));
			String tail = item.substring(item.indexOf("\'"));
			item = head+"\'"+tail;
		}
		
		Statement stm = dbConn.createStatement();
		double priceD = Double.parseDouble(price);
		String sql2 = "INSERT INTO food.item(categoryID,item,description, price, size)\r\n" + 
				"VALUES('"+ cateID +"','"+item+"','"+description+"','"+priceD+"','"+size+"');";
		stm.executeUpdate(sql2);
		stm.close();
	}
	
	DefaultListModel getRestName() throws SQLException{
	
		DefaultListModel restNameList = new DefaultListModel();
		
		Statement stm = dbConn.createStatement();
		
		String sql1="Select restName, restAddress\r\n" + 
				"from [Restaurant].[food].[restInfor]\n"+
				"order by restName";
		ResultSet RS = stm.executeQuery(sql1);
		while(RS.next()) {
			 restNameList.addElement(RS.getString("restName")+" "+RS.getString("restAddress"));	
		}	
		stm.close();
		
		return restNameList;
	}
	
	double caulateDist(int x1, int y1, int x2, int y2) {
		double ans=0;
		int sum = ((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1));
		ans=Math.sqrt(sum);
		return ans;
		
	}
	
	void bubbleSort(double arr[], String arr2[], String arr3[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[i] 
                    double temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                    
                    String temp2 = arr2[j]; 
                    arr2[j] = arr2[j+1]; 
                    arr2[j+1] = temp2; 
                    
                    temp2 = arr3[j]; 
                    arr3[j] = arr3[j+1]; 
                    arr3[j+1] = temp2; 
                    
                } 
    } 
	
	DefaultListModel getRestNameOrderByDist(String cusAddress) throws SQLException{
		
		DefaultListModel restNameList = new DefaultListModel();
		LinkedList<String> restAddressList = new LinkedList<String>();
		LinkedList<String> restNameLinkedList = new LinkedList<String>();
		
		
		int userX=Integer.parseInt(cusAddress.substring(0, cusAddress.indexOf(" ")));
		int userY=Integer.parseInt(cusAddress.substring(cusAddress.indexOf(" ")+1).trim());
		
		Statement stm = dbConn.createStatement();
		
		String sql1="Select restName, restAddress\r\n" + 
				"from [Restaurant].[food].[restInfor]\n"+
				"order by restName";
		ResultSet RS = stm.executeQuery(sql1);
		while(RS.next()) {
			restNameLinkedList.add(RS.getString("restName"));
			 restAddressList.add(RS.getString("restAddress"));	
		}	
		stm.close();
	
		
		int restSize = restAddressList.size();
		
		double dist[] = new double[restSize];
		int[]  restXArray = new int[restSize];
		int[]  restYArray = new int[restSize];
		String[] restAddressArray = new String[restSize];
		String[]  restNameArray = new String[restSize];
		for(int i=0;i<restSize;i++) {
			int restX = Integer.parseInt( restAddressList.get(i).substring(0,  restAddressList.get(i).indexOf(" ")));
			int restY = Integer.parseInt( restAddressList.get(i).substring(restAddressList.get(i).indexOf(" ")+1).trim());
			restXArray[i] = restX;
			restYArray[i] = restY;
			restAddressArray[i]=restAddressList.get(i);
			restNameArray[i] = restNameLinkedList.get(i);
		}
		
		System.out.println(" the distance is ");
		for(int i=0;i<restSize;i++) {
			dist[i]=caulateDist(userX, userY, restXArray[i],restYArray[i]);
		}
		
		bubbleSort(dist,restAddressArray, restNameArray);
		
		for(int i=0;i<restSize;i++) {
			restNameList.addElement(restNameArray[i]+" "+restAddressArray[i]);
		}
		
		return restNameList;
	}

	/*
	String displayMenu(String restAddress) throws SQLException {
		
		DecimalFormat df2 = new DecimalFormat("0.00");
		
		int restID = getRestID(restAddress);
		String menu="";
		int cateID=0;
		LinkedList<String> cateList = new LinkedList<String>();
		LinkedList<Integer> cateIDList = new LinkedList<Integer>();
		
		Statement stm = dbConn.createStatement();
		
		String sql1="Select categoryName\r\n" + 
				"from [Restaurant].[food].[category] " + 
				"where restID = " +restID;
		ResultSet RS = stm.executeQuery(sql1);
		while(RS.next()) {			
			String cate = null;
			cate=RS.getString("categoryName")+"\n";
			cateID = getCateID(RS.getString("categoryName"), restID);
			
			cateList.add(cate);
			cateIDList.add(cateID);
		}	
		
		for(int i=0;i<cateList.size();i++) {
			
			menu+=cateList.get(i);
			
			
			String sql2 = "Select *\r\n"+
					"from [Restaurant].[food].[item] "+
					"where categoryID = "+cateIDList.get(i);
			
			ResultSet RS2 = stm.executeQuery(sql2);
			while(RS2.next()) {
				String item = RS2.getString("item");
				String price = df2.format(RS2.getDouble("price")) ;
				String size = RS2.getString("size");
				String description = RS2.getString("description");
				if(size==null) { size="";}
				if(description==null || description.isEmpty()) { 
					menu+=("\t"+item+" "+price+" "+size+"\n");
				}
				else {
					menu+=("\t"+item+" "+price+" "+size+"\n\tdescription: "+description+"\n");
				}
			
			}
		}

		
		stm.close();
		
//		System.out.println(menu);
		return menu;
	}
	
	*/
	
	
	String displayMenu(String restName) throws SQLException {
		
		DecimalFormat df2 = new DecimalFormat("0.00");
		
		int restID = getRestID(restName);
		String menu="";
		int cateID=0;
		LinkedList<String> cateList = new LinkedList<String>();
		LinkedList<Integer> cateIDList = new LinkedList<Integer>();
		
		Statement stm = dbConn.createStatement();
		
		String sql1="Select categoryName\r\n" + 
				"from [Restaurant].[food].[category] " + 
				"where restID = " +restID;
		ResultSet RS = stm.executeQuery(sql1);
		while(RS.next()) {			
			String cate = null;
			cate=RS.getString("categoryName")+"\n";
			cateID = getCateID(RS.getString("categoryName"), restID);
			
			cateList.add(cate);
			cateIDList.add(cateID);
		}	
		
		for(int i=0;i<cateList.size();i++) {
			
			menu+=cateList.get(i);
			
			
			String sql2 = "Select *\r\n"+
					"from [Restaurant].[food].[item] "+
					"where categoryID = "+cateIDList.get(i);
			
			ResultSet RS2 = stm.executeQuery(sql2);
			while(RS2.next()) {
				String item = RS2.getString("item");
				String price = df2.format(RS2.getDouble("price")) ;
				String size = RS2.getString("size");
				String description = RS2.getString("description");
				if(size==null) { size="";}
				if(description==null || description.isEmpty()) { 
					menu+=("\t"+item+" "+price+" "+size+"\n");
				}
				else {
					menu+=("\t"+item+" "+price+" "+size+"\n\tdescription: "+description+"\n");
				}
			
			}
		}

		
		stm.close();
		
//		System.out.println(menu);
		return menu;
	}
	
	void deleteRestaurant(String restName, String restAddress) throws SQLException {
		
		if(restName.contains("\'")){
			String head = restName.substring(0,restName.indexOf("\'"));
			String tail = restName.substring(restName.indexOf("\'"));
			restName = head+"\'"+tail;
		}
		
		Statement stm = dbConn.createStatement();
		
		String sql1="DELETE FROM Restaurant.food.restInfor\r\n" + 
				"WHERE restName = '"+ restName+"' AND restAddress='"+restAddress+"'";
		stm.executeUpdate(sql1);
		stm.close();

	}
	
	/*
	
	DefaultListModel getMenu(String restAddress) throws SQLException{
		
		int restID = getRestID(restAddress);
		DefaultListModel menu = new DefaultListModel();
		LinkedList<String> cateList = new LinkedList<String>();
		int cateID=0;
		
		LinkedList<Integer> cateIDList = new LinkedList<Integer>();
		
		Statement stm = dbConn.createStatement();
		
		String sql1="Select categoryName\r\n" + 
				"from [Restaurant].[food].[category] " + 
				"where restID = " +restID;
		ResultSet RS = stm.executeQuery(sql1);
		while(RS.next()) {			
		
			cateID = getCateID(RS.getString("categoryName"), restID);
			cateList.add(RS.getString("categoryName"));
			cateIDList.add(cateID);
		}	
		
		for(int i=0;i<cateIDList.size();i++) {
			
			String sql2 = "Select *\r\n"+
					"from [Restaurant].[food].[item] "+
					"where categoryID = "+cateIDList.get(i);
			
			ResultSet RS2 = stm.executeQuery(sql2);
			while(RS2.next()) {
				int itemID = RS2.getInt("itemID");
				String item = RS2.getString("item");
				double price = RS2.getDouble("price");
				String size = RS2.getString("size");
				String description = RS2.getString("description");
				if(size==null) { size="";}
				if(description==null || description.isEmpty()) { 
					menu.addElement("\t"+itemID+" "+cateList.get(i)+" "+item+" "+price+" "+size+"\n");
				
				}
				else {
					menu.addElement("\t"+itemID+" "+cateList.get(i)+" " +item+" "+price+" "+size+"\n\tdescription: "+description+"\n");
					
				}
			
			}
		}
		
		
		

		
		stm.close();
		
//		System.out.println(menu);
		return menu;
	}
	*/
	
DefaultListModel getMenu(String restAddress) throws SQLException{
		
		int restID = getRestID(restAddress);
		DefaultListModel menu = new DefaultListModel();
		LinkedList<String> cateList = new LinkedList<String>();
		int cateID=0;
		
		LinkedList<Integer> cateIDList = new LinkedList<Integer>();
		
		Statement stm = dbConn.createStatement();
		
		String sql1="Select categoryName\r\n" + 
				"from [Restaurant].[food].[category] " + 
				"where restID = " +restID;
		ResultSet RS = stm.executeQuery(sql1);
		while(RS.next()) {			
		
			cateID = getCateID(RS.getString("categoryName"), restID);
			cateList.add(RS.getString("categoryName"));
			cateIDList.add(cateID);
		}	
		
		for(int i=0;i<cateIDList.size();i++) {
			
			String sql2 = "Select *\r\n"+
					"from [Restaurant].[food].[item] "+
					"where categoryID = "+cateIDList.get(i);
			
			ResultSet RS2 = stm.executeQuery(sql2);
			while(RS2.next()) {
				int itemID = RS2.getInt("itemID");
				String item = RS2.getString("item");
				double price = RS2.getDouble("price");
				String size = RS2.getString("size");
				String description = RS2.getString("description");
				if(size==null) { size="";}
				if(description==null || description.isEmpty()) { 
					menu.addElement("\t"+itemID+" "+cateList.get(i)+" "+item+" "+price+" "+size+"\n");
				
				}
				else {
					menu.addElement("\t"+itemID+" "+cateList.get(i)+" " +item+" "+price+" "+size+"\n\tdescription: "+description+"\n");
					
				}
			
			}
		}
		stm.close();
		
//		System.out.println(menu);
		return menu;
	}

//---------------------------
	
	void updateFood(String itemID, String item, String description, String price, String size) throws SQLException {
	
		if(item.contains("\'")){
			String head = item.substring(0,item.indexOf("\'"));
			String tail = item.substring(item.indexOf("\'"));
			item = head+"\'"+tail;
		}
		
		Statement stm = dbConn.createStatement();
		double priceD = Double.parseDouble(price);
		String sql2 = "UPDATE food.item\r\n" + 
				"SET item ='"+item+"',description = '"+description+"',price ='"+priceD+"',size = '"+size+"'\n"+
				"WHERE itemID = '" + itemID+"'";
		stm.executeUpdate(sql2);
		stm.close();
	}
	
	public void deleteFood(String itemID) throws SQLException {
		Statement stm = dbConn.createStatement();
		
		String sql2 = "DELETE FROM Restaurant.food.item\r\n"+
						"WHERE itemID = "+ itemID;
				
		stm.executeUpdate(sql2);
		stm.close();
	}
	
	void copyMenu(String restName, String restAddress) throws SQLException {
		
		int localRestID = getRestID(restName);
		
		LinkedList<String> categoryName= new LinkedList<String>();
		LinkedList<String> categoryID= new LinkedList<String>();
		LinkedList<Integer> targetCategoryID= new LinkedList<Integer>();
		LinkedList<String> item= new LinkedList<String>();
		LinkedList<String> description= new LinkedList<String>();
		LinkedList<String> price= new LinkedList<String>();
		LinkedList<String> size= new LinkedList<String>();
		DecimalFormat df2 = new DecimalFormat("0.00");

		int targetID = 0;
		
		
		
		Statement stm = dbConn.createStatement();
		
		String sql2 = "SELECT * FROM Restaurant.food.category\r\n"+
						"where restID ="+localRestID;
		ResultSet RS = stm.executeQuery(sql2);


		
		while(RS.next()) {			
			categoryID.add(RS.getString("categoryID"));
			categoryName.add(RS.getString("categoryName"));
		}	
		
		String sql3 = "SELECT * FROM Restaurant.food.restInfor\r\n"+
				"where restName ='"+restName+"' AND restAddress = '"+restAddress+"';";
		
		RS = stm.executeQuery(sql3);
		if(RS.next()) {
			targetID = RS.getInt("restID");
		}
		
		for(int i=0;i<categoryName.size();i++) {
			String sql4 ="INSERT INTO food.category(restID,categoryName)\r\n" + 
					"VALUES('"+ targetID +"','"+categoryName.get(i)+"')";
			stm.executeUpdate(sql4);
		}
		
		String sql5 = "SELECT * FROM Restaurant.food.category\r\n"+
				"where restID ="+targetID;
		RS = stm.executeQuery(sql5);
		
		while(RS.next()) {			
			targetCategoryID.add(RS.getInt("categoryID"));
		}	
		
		for(int i=0;i<categoryID.size();i++) {
			
			String sql6 = "Select *\r\n"+
					"from [Restaurant].[food].[item] "+
					"where categoryID = "+categoryID.get(i);
			
			ResultSet RS2 = stm.executeQuery(sql2);
			while(RS2.next()) {
				item.add(RS2.getString("item"));
				price.add(df2.format(RS2.getDouble("price"))) ;
				size.add(RS2.getString("size"));
				description.add(RS2.getString("description"));
			}
			
		}
		
		for(int i=0;i<targetCategoryID.size();i++) {
			insertFood(targetCategoryID.get(i),item.get(i),description.get(i),price.get(i),size.get(i));
		}
		
				
		
		stm.close();
		
	}

	
	
}
