package com.mazhar.application;

import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mazhar.controller.MazharInfo;
import com.mazhar.database.QueryController;
import com.mazhar.model.PeopleModel;



/**
 * @author mazhar
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com\\mazhar\\xml\\main.xml");
    	QueryController dao = context.getBean("QueryController", QueryController.class);
    	List<PeopleModel> ps = dao.getAllPeople();
    	
    	//Read data from MySQL
    	
    	for(PeopleModel p : ps) {
    		System.out.println("ID : "+ p.getId() +" Name : "+p.getName() +" Address : "+p.getAddress());
    	}
    	
    	//Insert data to MYSQL
    	
    	System.out.println(dao.addPeopleInfo(new PeopleModel(1,"Spring","Spring 5.2.1 ")));
    	
    	//Delete data from MYSQL
    	System.out.println(dao.deletePeople(4));
    	
    	//Update data to MYSQL
    	
    	System.out.println(dao.updatePeopleInfo(new PeopleModel(5,"november", "november rain")));
    	
    	
    }
}
