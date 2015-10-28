package ServletAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class DatabaseCollection {
	
	String url = "jdbc:oracle:thin:system/password@localhost"; 
	Properties props = new Properties();
	
	//make sure to have the following steps done
	//1 copy ojdbc6.jar to webcontent/web-inf/lib
	//2 add ojdbc6.jar to build path - libraries / add external jar
	//3 Class.forName ("oracle.jdbc.driver.OracleDriver")
	static{
	    try {
	        Class.forName ("oracle.jdbc.driver.OracleDriver");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}
	
	public DatabaseCollection() {
		props.setProperty("user", "testuserdb");
        props.setProperty("password", "password");
	}
	
	public ArrayList<DemoCustomer> getCustomerName(int id){
		ArrayList<DemoCustomer> demoCus = new ArrayList<DemoCustomer>(); 
		
		try{
			Connection conn = DriverManager.getConnection(url,props);
			
			String sql ="select cust_first_name, cust_last_name from demo_customers where customer_id = ?";
	
	        //creating PreparedStatement object to execute query
	        PreparedStatement preStatement = conn.prepareStatement(sql);
	        preStatement.setInt(1, id);
	    
	        ResultSet result = preStatement.executeQuery();
	      
	        while(result.next()){
	        	DemoCustomer cus = new DemoCustomer();
	        	cus.setFirstName(result.getString(1));
	        	cus.setLastName(result.getString(2));
	            demoCus.add(cus);
	        }
	        
	        conn.close();
		}catch(Exception e){
			demoCus = null;
			e.printStackTrace();
		}
		
		return demoCus;
		
	}

}
