package com.mazhar.controller;

import java.sql.Connection;

import com.mazhar.database.DBConnection;
import com.mazhar.database.QueryController;

public class MazharInfo {
    private static Connection connection = DBConnection.getInitialize();
    QueryController control = new QueryController();
	public static void info() {
		if(connection != null) {
			System.out.println("mazhar simple spring applicarion");
		}
		
		
	}
	
	public void insertData(String name, String add) {
		System.out.println(" query execution result retuns "+control.insertPeople(name, add));
	}
}
