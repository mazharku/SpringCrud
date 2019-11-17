package com.mazhar.application;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mazhar.controller.MazharInfo;



/**
 * @author mazhar
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com\\mazhar\\xml\\main.xml");
    	MazharInfo obj = (MazharInfo) context.getBean("info");
    	Scanner sc = new Scanner(System.in);
        System.out.println("enter name: ");
        String name= sc.nextLine();
        System.out.println("enter address: ");
        String address = sc.nextLine();
        obj.insertData(name, address);
    }
}
