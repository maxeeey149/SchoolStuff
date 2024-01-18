package com.Maxeeey.PostgreSQL;

import java.sql.Connection;
import java.sql.SQLException;

import org.postgresql.ds.PGSimpleDataSource;

import org.postgresql.ds.PGSimpleDataSource;

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
}
