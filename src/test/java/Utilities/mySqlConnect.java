package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

//import com.mysql.cj.jdbc.Driver;
//import com.mysql.jdbc.Driver;

public class mySqlConnect {
	
	 //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
    private static String dbUrl = "jdbc:mysql://localhost:3306/nopcommerce";					

	//Database Username		
	private static String username = "nopcommerce";	
    
	//Database Password		
	private static String password = "root";				

	//Query to Execute		
	private static String query = "select * from config;";
	
	public static Object[][] getMySqlData() throws SQLException, ClassNotFoundException {
	
	//(Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();  
	//Class<?> d = Class.forName("com.mysql.cj.jdbc.Driver");
	Class.forName("com.mysql.cj.jdbc.Driver");
		//Create Connection to DB		
	Connection con = DriverManager.getConnection(dbUrl,username,password);

		//Create Statement Object		
    Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);					

		// Execute the SQL Query. Store results in ResultSet		
	ResultSet rs= stmt.executeQuery(query);
	rs.last();
	int rows = rs.getRow();

	ResultSetMetaData rsMetaData = (ResultSetMetaData) rs.getMetaData();
	int columns = rsMetaData.getColumnCount();
	
	Object[][] data = new Object[rows][columns];
	
    System.out.println("Table contains "+rows+" rows"+columns+" columns");
    int i = 0;
    
    rs.beforeFirst();
    // While Loop to iterate through all data and print results		
	while (rs.next()){
        		String baseURL = rs.getString(2);								        
                String browser = rs.getString(3);
                String un = rs.getString(4);
                String pwd = rs.getString(5);	
                System. out.println(baseURL+";  "+browser+"; "+un+";  "+pwd);
                data[i][0]= baseURL;
                data[i][1]= browser;
                data[i][2]= un;
                data[i][3]= pwd;
                i = i+1;
        }		
		 // closing DB Connection		
	con.close();	
	return data;
	}
}
