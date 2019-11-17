package com.mazhar.database;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QueryController {
    private Connection con = DBConnection.getInitialize();
	
	public void insertPeople() {
		try {
			
			String sql="INSERT INTO `peopleinfo`(`name`, `address`) VALUES (?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "mazhar");
			pst.setString(2, "jhenaidah");
			
			pst.execute();
			
		}
		catch(Exception e) {
			System.out.println("error return with "+ e);
		}
		
		
	}
}
