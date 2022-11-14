package tw.samtest.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class IHouseBeanDao implements IHouseBeanService {
	private Session session;
	
	public IHouseBeanDao(Session session) {
		this.session=session;
	}
	
	public HouseBean select(HouseBean Bean) {
		return session.get(HouseBean.class, Bean.getHouseid());
	}
	
	public List<HouseBean> selectAll() {
    	Query<HouseBean> query = session.createQuery("from HouseBean", HouseBean.class);
    	return query.list();
    }
	
	public HouseBean insert(HouseBean Bean) {
		HouseBean result = session.get(HouseBean.class, Bean.getHouseid());
		
		if(result == null) {  //注意這裡要null 沒有才新增
			session.save(Bean);
			return Bean;
		}
		return null;
	}
	
	public HouseBean update (int houseid,String housename) {
		HouseBean result = session.get(HouseBean.class, houseid);
		if(result != null) {
			result.setHousename(housename);
		}
		return result;
	}
	
	public boolean deleteById(int houseid) {
		HouseBean result = session.get(HouseBean.class, houseid);
		if(result != null) {
			session.delete(result);
			return true;
		}
		return false;
	}
	
}
