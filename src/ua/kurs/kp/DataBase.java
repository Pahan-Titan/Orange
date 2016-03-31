package ua.kurs.kp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
	
	public void DataBase() {
	}
	
	private static Connection getDBConnection() {
	    Connection dbConnection = null;
	    try {
	        Class.forName("org.postgresql.Driver");
	    } catch (ClassNotFoundException e) {
	        System.out.println(e.getMessage());
	    }
	    try {
	        dbConnection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/orange","orange_r", "orange");
	        return dbConnection;
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return dbConnection;
	}
	
	public static String[][] loadData(String tab, String nameCol1, String nameCol2){
		String[][] top_fruit = new String[10][2];
		String selectTableSQL = "SELECT " + nameCol1 + ", " + nameCol2 + " from " + tab;
		try {
		    Connection dbConnection = getDBConnection();
		    Statement statement = dbConnection.createStatement();
		    // выбираем данные с БД
		    ResultSet rs = statement.executeQuery(selectTableSQL);
		 
		    // И если что то было получено то цикл while сработает
		    int row = 0;
		    while (rs.next()) {
		        String col1 = rs.getString(nameCol1);
		        String col2 = rs.getString(nameCol2);
		        top_fruit[row][0] = col1;
			    top_fruit[row][1] = col2;
//			    System.out.println("fruit : " + top_fruit[row][0]);
//			    System.out.println("quantity_buy : " + top_fruit[row][1]);
			    row++;
		    }
		} catch (SQLException e) {
		    System.out.println(e.getMessage());
		}
		return top_fruit;

	}
	

/*	public void addData() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://hostname:port/dbname","Orange", "orange");
		connection.close();
	}*/
	
	
	
}
