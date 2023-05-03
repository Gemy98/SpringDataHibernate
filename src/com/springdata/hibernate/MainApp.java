package com.springdata.hibernate;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;


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
		Client c = new Client();
		session.beginTransaction();
		
		
		Query q1 = session.createQuery("select Max(id) from Client ");// the maximum id
		Query q2 = session.createQuery("select min(id) from Client ");// the minimum id 
		Query q3 = session.createQuery("select sum(id) from Client ");// add all values to a variable and show it 
		Query q4= session.createQuery("select avg(age) from Client "); // sum of values divided by how many value
		Query q5= session.createQuery("select count(id) from Client "); // how many values ( no count for empty column )
		Query q6= session.createQuery("select count(distinct address) from Client "); // how many values ( no count for empty column and repeated value )


		
		
		
		
		System.out.println(q1.list().get(0));
		System.out.println(q2.list().get(0));
		System.out.println(q3.list().get(0));
		System.out.println(q4.list().get(0));
		System.out.println(q5.list().get(0));
		System.out.println(q6.list().get(0));

				
		session.getTransaction().commit();
		
		// session.createQuery("update Client set age=100 where id = 5")
			//	.executeUpdate();	
		
		
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

/*Client c = new Client();
c.setId((long)2);
session.delete(c);
	
session.getTransaction().commit();

System.out.println("commit Success");
*/
/* Query q = session.createQuery("from Client where id = ?1 or fullName =:V1");
q.setInteger(1, 3);
q.setString("V1","ahmed");
q.setFirstResult(0);
q.setMaxResults(4);

List<Client>  l = q.list()  ;

// .list();


for (int i = 0 ; i < l.size();i++) {
System.out.println(l.get(i).getFullName());
}	*/