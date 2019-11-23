package com.mazhar.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mazhar.model.PeopleModel;


@Component
public class QueryController {
	
	@Autowired
	private DataSource datasource;
    private Connection con = null;
	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	
	 public List<PeopleModel> getAllPeople() {
	    	List<PeopleModel> people = new LinkedList<PeopleModel>();
	    
	    	try {
	    		con= datasource.getConnection();
	    		String sql="SELECT * FROM `peopleinfo`";
	    		PreparedStatement pst=con.prepareStatement(sql);
	    		ResultSet rs = pst.executeQuery();
	    		
	    		while(rs.next()) {
	    			people.add(new PeopleModel(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
	    		}
	    		return people;
	    		
	    	}
	    	catch(Exception e) {
	    		throw new RuntimeException(e);
	    	}
	    	
	}
	 public String  addPeopleInfo(PeopleModel people) {
		 String name = people.getName();
		 String add = people.getAddress();
		 try {
			con = datasource.getConnection();
			String sql="INSERT INTO `peopleinfo`(`name`, `address`) VALUES (?,?)";
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, add);
			pst.execute();
			return "Insert Succssfull";
		} catch (SQLException e) {
			
			return "fail to insert due to "+e;
		}
		 
	 }
	 
	 public String updatePeopleInfo(PeopleModel people) {
		 try {
			con = datasource.getConnection();
			String sql="UPDATE `peopleinfo` SET `name`=?,`address`=? WHERE id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, people.getName());
			pst.setString(2, people.getAddress());
			pst.setInt(3, people.getId());
			pst.executeUpdate();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return ""+e;
		}
		 
	 }
	 
	 public String deletePeople(int id) {
		 try {
			con= datasource.getConnection();
			String sql ="DELETE FROM `peopleinfo` WHERE id=?";
			PreparedStatement pst= con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeLargeUpdate();
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return ""+e;
		}
	 }
}
