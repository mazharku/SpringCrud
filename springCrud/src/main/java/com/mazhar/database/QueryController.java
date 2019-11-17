package com.mazhar.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * create table with 3 field id, name and address
 * **/

public class QueryController {
    private Connection con = DBConnection.getInitialize();
	
	public boolean insertPeople(String name, String address) {
		try {
			
			String sql="INSERT INTO `peopleinfo`(`name`, `address`) VALUES (?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, address);
			
			return pst.execute();
			
		}
		catch(Exception e) {
			System.out.println("error return with "+ e);
			return false;
		}
		
		
	}
}
