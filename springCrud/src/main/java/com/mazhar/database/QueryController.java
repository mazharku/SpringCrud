package com.mazhar.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.mazhar.model.PeopleModel;


@Component
public class QueryController {
	
	@Autowired
	@Qualifier("datasource")
	private DataSource datasource;
	
    public PeopleModel getPeople() {
    	PeopleModel people = null;
    	Connection con = null;
    	try {
    		con= datasource.getConnection();
    		String sql="SELECT `id`, `name`, `address` FROM `peopleinfo` WHERE id=1";
    		PreparedStatement pst=con.prepareStatement(sql);
    		ResultSet rs = pst.executeQuery();
    		
    		while(rs.next()) {
    			people = new PeopleModel(1, rs.getString("name"), rs.getString("address"));
    		}
    		return people;
    		
    	}
    	catch(Exception e) {
    		throw new RuntimeException(e);
    	}
    	
    }
	public DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
}
