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
	
	public static String[][] loadData(String tab, String nameCol1, String nameCol2, String nameCol3){
		String[][] del = new String[3][3];
		String selectTableSQL = "SELECT " + nameCol1 + ", " + nameCol2 + ", " + nameCol3 + " from " + tab;
		try {
		    Connection dbConnection = getDBConnection();
		    Statement statement = dbConnection.createStatement();
		    // выбираем данные с БД
		    ResultSet rs = statement.executeQuery(selectTableSQL);
		    // И если что то было получено то цикл while сработает
		    int row = 0;
		    while (rs.next()) {
		    	del[row][0] = rs.getString(nameCol1);
		    	del[row][1] = rs.getString(nameCol2);
		    	del[row][2] = rs.getString(nameCol3);
			    row++;
		    }
		} catch (SQLException e) {
		    System.out.println(e.getMessage());
		}
		return del;
	}
	
	public static String[][] loadData(String tab, String nameCol1, String nameCol2){
		String[][] top = new String[10][2];
		String selectTableSQL = "SELECT " + nameCol1 + ", " + nameCol2 + " from " + tab;
		try {
		    Connection dbConnection = getDBConnection();
		    Statement statement = dbConnection.createStatement();
		    // выбираем данные с БД
		    ResultSet rs = statement.executeQuery(selectTableSQL);
		 
		    // И если что то было получено то цикл while сработает
		    int row = 0;
		    while (rs.next()) {
		        top[row][0] = rs.getString(nameCol1);
			    top[row][1] = rs.getString(nameCol2);
			    row++;
		    }
		} catch (SQLException e) {
		    System.out.println(e.getMessage());
		}
		return top;

	}
	
	public static String[] loadData (String tab, String nameCol){
		String[] comBox = new String[251];
	    int row = 0;
		String selectTableSQL = "SELECT " + nameCol + " from " + tab;
		try {
		    Connection dbConnection = getDBConnection();
		    Statement statement = dbConnection.createStatement();
		    ResultSet rs = statement.executeQuery(selectTableSQL);
		    while (rs.next()) {
		        comBox[row] = rs.getString(nameCol);
			    row++;
		    }
		} catch (SQLException e) {
		    System.out.println(e.getMessage());
		}
		return comBox;
	}
	
	public static void addData (String name, String phone, String email, String country, String organization, String fruit){
		String addDataSQL = "INSERT INTO client VALUES ('" + name + "', '" + phone + "', '" + email + "', '" + country + "', '" + organization + "', '" + fruit + "')";
		try {
			Connection dbConnection = getDBConnection();
			Statement statement;
			statement = dbConnection.createStatement();
			dbConnection = getDBConnection();
			statement.execute(addDataSQL);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	
}
