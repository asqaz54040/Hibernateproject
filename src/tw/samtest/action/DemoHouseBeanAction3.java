package tw.samtest.action;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.samtest.model.HouseBean;
import tw.samtest.util.HibernateUtil;

public class DemoHouseBeanAction3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		session.beginTransaction();
//
//		HouseBean temp1 = session.get(HouseBean.class, 1001);
//
//		if (temp1 != null) {
//			System.out.println(temp1.getHouseid() + ":" + temp1.getHousename());
//		} else {
//			System.out.println("no resoult");
//		}

		System.out.println("--------------------------------------------");

//		Query<HouseBean> query = session.createQuery("from HouseBean", HouseBean.class);
//		List<HouseBean> list = query.list();
//
//		Iterator<HouseBean> i1 = list.iterator();
//		
//		while (i1.hasNext()) {
//			HouseBean result =i1.next();
//			System.out.println(result.getHouseid() + ":" + result.getHousename());	
//		}
//		System.out.println("--------------------------------------------");
//		for(HouseBean house :list) {
//			System.out.println(house.getHouseid() + ":" + house.getHousename());	
//		}

		
		HouseBean del = new HouseBean();
		del.setHouseid(1001);
		session.delete(del);  //要記得打
		
		
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();

	}

}
