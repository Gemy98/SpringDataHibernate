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
		
	
		 	
	
	
	
	long z = 2 ; 
	try {
		
		session.beginTransaction();
		Client c = new Client();
		c.setId((long)2);
		session.delete(c);
			
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

/*	 
	Client client1 = new Client("Gemy",25,"Elmansoura");
	Client client2  = new Client("Gemy",25,"Elmansoura");
	Client client3 = new Client("Gemy",25,"Elmansoura");
	*/

/*Client client = session.get(Client.class, z);
		

		session.getTransaction().commit();
		
		System.out.println("commit Success");
		
		System.out.println(client.getFullName()+ "\n" +client.getAge()+"\n"+client.getAddress());
		*/


/*session.beginTransaction();
		Client c = new Client("ahmed",30,"tanta");
		c.setId((long)2);
		session.update(c);
			
		session.getTransaction().commit();
		
		System.out.println("commit Success");
		*/
