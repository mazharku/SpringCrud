package com.mazhar.application;

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
    	PeopleModel ps = dao.getPeople();
    	System.out.println("results "+ ps.getAddress());
    	
    }
}
