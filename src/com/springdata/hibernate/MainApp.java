package com.springdata.hibernate;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Query;


import com.mysql.cj.protocol.x.Notice.XSessionVariableChanged;
import com.springdata.hibernate.model.Client;
import com.springdata.hibernate.model.Data;
import com.springdata.hibernate.model.Info;
import com.springdata.hibernate.model.Person;
import com.springdata.hibernate.model.Student;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Info.class)
				.buildSessionFactory();		
		 Session session = factory.getCurrentSession();
		
	
		 	
	
	
	
	long z = 2 ; 
	try {
		session.beginTransaction();
	
		int id = 2 ; 
		Student student = new Student() ;
		Student student2 = new Student() ;
		student.setId(id);
		student2 = session.get(Student.class, student.getId());
		
		System.out.println(student2.getName());
		
		for(Info i : student2.getInfos()) {
			
			System.out.println(i.getPhone());
			
		}
		
		
		/*
		Student student =new Student();
		
		student.setName("Ahmed");
		
		Info info = new Info();
		
		info.setPhone("+201024556621");
		info.setStudent(student);
		Info info2 = new Info();
		info2.setStudent(student);
		
		
		
		info2.setPhone("+201557454895");
		
		//Set<Info> infoos =new HashSet<Info>() ;
		//infoos.add(info);
		//infoos.add(info2);
		//student.setInfos(infoos);
		
		
		student.getInfos().add(info);
		student.getInfos().add(info2);
		
		session.save(student);
		*/
		session.getTransaction().commit();
		
		
		System.out.println("commit Success");
		
		
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
	//	e.printStackTrace();
		System.out.println("Failed to save this client"+e);
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


/*	
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
*/


/*
//c.setFirstResult(0);
//c.setMaxResults(4);
	
//c.add(Restrictions.gt("id", (long)3)); // greater than 3
//c.add(Restrictions.lt("id", (long)3));  // less than 3 
//c.add(Restrictions.between("id", (long)2,(long)4));   //  betweeb 2 - 4 ( 2 - 3 - 4 ) 
//c.add(Restrictions.in("id", ar )); // taking id from a declared array
//c.add(Restrictions.isNotNull("address")); // all clients who don't have null address
//c.add(Restrictions.eq("fullName", "mohamed")); // getting equal name
// c.add(Restrictions.like("fullName", "a",MatchMode.START)); //searching with start a


Criterion c2 = Restrictions.eq("address", "alex");
Criterion c3 = Restrictions.eq("fullName", "ali");

LogicalExpression or = Restrictions.or(c2, c3);
c.add(or);


*/


/*Criteria c = session.createCriteria(Client.class);
//c.setProjection(Projections.min("id"));
//c.setProjection(Projections.max("id"));
//c.setProjection(Projections.avg("id"));
//c.setProjection(Projections.sum("id"));
//c.setProjection(Projections.count("address"));
//c.setProjection(Projections.countDistinct("address"));
c.setProjection(Projections.countDistinct("address"));


List<Client> client =  c.list();
System.out.println("the minimum id is : "+ client.get(0));
/*for (int i = 0 ; i< client.size();i++) {
	
	System.out.println(client.get(i).getFullName()+ "    "+ client.get(i).getAge());
}*/

//	session.getTransaction().commit();

// session.createQuery("update Client set age=100 where id = 5")
	//	.executeUpdate();	


/*	
Person p = new Person();
p.setName("Mohamed Gamal");


Data d = new Data();
d.setAge("25");
//	session.save(d);
*/

/*
Person p = new Person();
p.setId(1);

Person res = session.get(Person.class, p.getId());
System.out.println("name :"+ res.getName());
System.out.println("age :"+ res.getData().getAge());

res.setName("Ahmed");
res.getData().setAge("22");




//session.save(p);
*/