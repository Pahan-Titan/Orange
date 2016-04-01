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
		String[][] top = new String[10][2];
		String selectTableSQL = "SELECT " + nameCol1 + ", " + nameCol2 + " from " + tab;
		try {
		    Connection dbConnection = getDBConnection();
		    Statement statement = dbConnection.createStatement();
		    // �������� ������ � ��
		    ResultSet rs = statement.executeQuery(selectTableSQL);
		 
		    // � ���� ��� �� ���� �������� �� ���� while ���������
		    int row = 0;
		    while (rs.next()) {
		        top[row][0] = rs.getString(nameCol1);
			    top[row][1] = rs.getString(nameCol2);
//			    System.out.println("fruit : " + top_fruit[row][0]);
//			    System.out.println("quantity_buy : " + top_fruit[row][1]);
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
	
	public static void addData (String name, String phone, String email, String fruit, String quantity_buy, String organization, String country, int addres){
		String addDataSQL = "INSERT INTO client VALUES ('" + name + "', '" + phone + "', '" + email + "', '" + country + "', '" + fruit + "', '" + organization + "', " + addres + ", '" + quantity_buy + "')";
		try {
			Connection dbConnection = getDBConnection();
			Statement statement;
			statement = dbConnection.createStatement();
			dbConnection = getDBConnection();
			statement.execute(addDataSQL);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		System.out.println(addDataSQL);
	}
	
	
	
}
