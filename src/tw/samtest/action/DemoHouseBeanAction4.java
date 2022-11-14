package tw.samtest.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.samtest.model.HouseBean;
import tw.samtest.model.HouseBeanDao;
import tw.samtest.model.HouseBeanService;
import tw.samtest.util.HibernateUtil;

public class DemoHouseBeanAction4 {

	public static void main(String[] args) {

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("begin Transaction");
			session.beginTransaction();

			HouseBeanDao hDao = new HouseBeanDao(session);
//			HouseBean insertBean = new HouseBean();
//
//			insertBean.setHousename("Great House");
//			hDao.insert(insertBean);

			List<HouseBean> resultAll = hDao.selectAll();

			for (HouseBean hBean : resultAll) {
				System.out.println(hBean.getHouseid() + ":" + hBean.getHousename());
			}
			System.out.println("service分隔線--------------------------------------------");
			HouseBeanService hService = new HouseBeanService(session);
			List<HouseBean> resultAll2 = hService.selectAll();

			for (HouseBean hBean : resultAll2) {
				System.out.println(hBean.getHouseid() + ":" + hBean.getHousename());
			}

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
