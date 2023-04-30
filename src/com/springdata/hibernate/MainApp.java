package com.springdata.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.protocol.x.Notice.XSessionVariableChanged;
import com.springdata.hibernate.model.Client;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Client.class)
				.buildSessionFactory();		
		 Session session = factory.getCurrentSession();
		
		 
	Client client = new Client();
	//client.setId((long)1);
	client.setAge(20);
	client.setAddress("Cairo");
	client.setFullName("MohamedGamal");
	
	
	try {
		session.beginTransaction();
		session.save(client);
		session.getTransaction().commit();
		
		System.out.println("commit Success");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
	//	e.printStackTrace();
		System.out.println("Failed to save this client");
	}
	finally {
		session.close();
	}
		
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
