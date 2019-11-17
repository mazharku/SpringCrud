package com.mazhar.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mazhar.controller.MazharInfo;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com\\mazhar\\xml\\main.xml");
    	MazharInfo obj = (MazharInfo) context.getBean("info");
        
        obj.insertData();
    }
}
