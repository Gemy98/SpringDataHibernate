package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springdata.hibernate.model.Client;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Client.class)
				.buildSessionFactory();		
		 Session session = factory.getCurrentSession();
		
		
		
	}

}  

/*
String url ="jdbc:mysql://localhost:3306/employee?useSSL=false"; 
String username ="root"; 
String Password = "root"; 

try {
	Connection connection = DriverManager.getConnection(
			url,username,Password);
	System.out.println("Connected");
	System.out.println(connection);

} catch (SQLException e) {
	// TODO Auto-generated catch block
	System.out.println(e.toString());
}
*/
