package tech;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	
	public static void main(String[] args)
	{
		Main obj = new Main();
		obj.onCreate();
		//obj.onRetrieve();
		obj.onRetrieveAll(3);
	//	obj.onUpdate();
	//	obj.onDelete();
	}
	
	
	public void onCreate()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SameName");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		System.out.println("Calling onCreate method");
		
		Employee e1= new Employee();
		e1.setEname("Aman");
		e1.setCity("Delhi");
		
		em.persist(e1);
		em.getTransaction().commit();
		
		
		Employee e2= new Employee();
		em.getTransaction().begin();
		e2.setEname("Raman");
		e2.setCity("Pune");
		em.persist(e2);
		em.getTransaction().commit();

		
		
		Employee e3= new Employee();
		em.getTransaction().begin();
		e3.setEname("Gagan");
		e3.setCity("Banglore");
		em.persist(e3);
		em.getTransaction().commit();
	

	}
	
	/*public void onRetrieve()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SameName");
		EntityManager em = emf.createEntityManager();
		
		Employee emp= new Employee();
		emp = em.find(Employee.class, 5);
		System.out.println(emp);
	}*/
	
	
	public List<Employee> onRetrieveAll(Integer id)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SameName");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		 List<Employee> list = em.createQuery("SELECT FROM Employee p").getResultList();
		    
		 	em.getTransaction().commit();
		    em.close();
		    emf.close();
		
		    for (Employee emp : list) 
		    {
		    	System.out.println("List of Employees::" + emp.getEid() + "," + emp.getEname() + "," + emp.getEcity());
		    }
		
	return list;
	}
	
/*	public void onUpdate()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SameName");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		System.out.println("----------- onUpdate method calling-------------");
		Employee emp = new Employee();
		
		emp.setEname("Aalok");
		System.out.println("Employee after updation :- " + emp);
	
		em.persist(emp);
		em.getTransaction().commit();
	}
	
	/*public void onDelete()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SameName");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Calling onDelete method");
		Employee e1= new Employee();
		e1.setEid(1);
		e1.setEname("Aman");
		e1.setCity("Delhi");
	
		em.getTransaction().begin();
		em.persist(e1);
		em.getTransaction().commit();
	
	}*/
}
