package com.mazhar.controller;

import java.sql.Connection;

import com.mazhar.database.DBConnection;

public class MazharInfo {
    private static Connection connection = DBConnection.getInitialize();
	public static void info() {
		if(connection != null) {
			System.out.println("mazhar simple spring applicarion");
		}
		
		
	}
}
