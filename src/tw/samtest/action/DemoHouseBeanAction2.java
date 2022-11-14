package tw.samtest.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.samtest.model.HouseBean;
import tw.samtest.util.HibernateUtil;

public class DemoHouseBeanAction2 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("begin Transaction");
			session.beginTransaction();

			HouseBean hbean = new HouseBean();
			hbean.setHousename("nice house");
			session.save(hbean);
			session.getTransaction().commit();
			System.out.println("Transaction commit");

		} catch (Exception e) {
			System.out.println("session rollback");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			System.out.println("session closed");
			HibernateUtil.closeSessionFactory();
			System.out.println("Transaction closed");
		}

	}

}
