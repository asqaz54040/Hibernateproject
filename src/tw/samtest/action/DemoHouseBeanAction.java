package tw.samtest.action;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.samtest.model.HouseBean;

public class DemoHouseBeanAction {

	public static void main(String[] args) {
		StandardServiceRegistry serviceRegistry =new StandardServiceRegistryBuilder().configure().build();
		
		SessionFactory  factory =new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		Session session =factory.openSession();
		Transaction ts = session.beginTransaction();
		
		
		HouseBean hBean = new HouseBean();
		hBean.setHousename("Green House");
		session.save(hBean);
		
		ts.commit();
		session.close();
		factory.close();
	}

}
