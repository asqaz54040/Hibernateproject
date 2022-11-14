package tw.samtest.action;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.samtest.model.Department;

public class DemoDepartmentBeanAction {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().configure().build();
		
		SessionFactory  factory =new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		Session session =factory.openSession();
		Transaction ts = session.beginTransaction();
		
		
		Department depart = new Department();
		depart.setDeptname("Manage");
		session.save(depart);
		
		ts.commit();
		session.close();
		factory.close();
	}

}
