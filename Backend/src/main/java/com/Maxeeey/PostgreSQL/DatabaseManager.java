package com.Maxeeey.PostgreSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Maxeeey.TODOListElements.NormalTODOListElement;

public class DatabaseManager {
	public String checkConnectionPossible() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "gammelfleisch1";
		
		try {
			Class.forName("org.postgresql.Driver");
			java.sql.Connection con = java.sql.DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Es gibt Probleme beim Verbindungsaufbau mit der Datenbank");
			e.printStackTrace();
			return "Verbindung zur Datenbank konnte NICHT hergestellt werden";
		}
		catch(ClassNotFoundException e) {
			System.out.println("DriverKlasse konnte nicht gefunden werden");
			e.printStackTrace();
			return "Driver-Class couldn't be loaded";
		}
		return "Verbindung mit der Datenbank konnte hergestellt werden";
	}
	
	
	/*
	 * this function returns Connection Element to Database
	 */
	public Connection getConnectionToDatabase() {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "gammelfleisch1";
		
		try {
			Class.forName("org.postgresql.Driver");
			java.sql.Connection con = java.sql.DriverManager.getConnection(url, username, password);
			return con;
		} catch (SQLException e) {
			System.out.println("Es gibt Probleme beim Verbindungsaufbau mit der Datenbank");
			e.printStackTrace();
			return null;
		}
		catch(ClassNotFoundException e) {
			System.out.println("DriverKlasse konnte nicht gefunden werden");
			e.printStackTrace();
			return null;
		}
	}
	
	//executes a query and gives a List of Elements of that.
	public List<NormalTODOListElement> executeQueryAndListIt(String queryCommand) {
		Connection dataBaseConnection = this.getConnectionToDatabase();
		Statement stmt;
		List<NormalTODOListElement> listWithToDosNEW = new ArrayList<>();
		
		try {
			stmt = dataBaseConnection.createStatement();
			stmt.execute(queryCommand);
			ResultSet rs = stmt.getResultSet();
			if(rs == null) {
				return null;
			}
			while (rs.next()) {
				NormalTODOListElement newCreatedTODOTask = 
					new NormalTODOListElement(rs.getString("name"), rs.getInt("id"), rs.getBoolean("isdone"));
				listWithToDosNEW.add(newCreatedTODOTask);
			}
			stmt.close();
			dataBaseConnection.close();
		} catch (SQLException e) {
			System.out.println("Es gab Probleme beim Erstellen des SQL-Statements");
			e.printStackTrace();
		}
		return listWithToDosNEW;
	}
	
	/*
	 * This method returns the max value for ID. If it fails, it returns -1
	 */
	public int executeQueryToGetMaxInt(String queryCommand) {
		Connection dataBaseConnection = this.getConnectionToDatabase();
		Statement stmt;
		try {
			stmt = dataBaseConnection.createStatement();
			stmt.execute(queryCommand);
			ResultSet rs = stmt.getResultSet();
			if(!rs.next()) {//move cursor to the first row
				return -1;
			} 
			int resultOfQuery = rs.getInt("max");
			stmt.close();
			return resultOfQuery;
		} catch (SQLException e) {
			System.out.println("Es gab Probleme beim Erstellen des SQL-Statements");
			e.printStackTrace();
		}
		return -1;
	}
}
