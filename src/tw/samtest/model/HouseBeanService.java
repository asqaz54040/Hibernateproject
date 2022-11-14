package tw.samtest.model;

import java.util.List;

import org.hibernate.Session;

public class HouseBeanService implements IHouseBeanService {

	private HouseBeanDao hDao;

	public HouseBeanService(Session session) {
		hDao = new HouseBeanDao(session);
	}

	@Override
	public HouseBean select(HouseBean Bean) {
		return hDao.select(Bean);
	}

	@Override
	public List<HouseBean> selectAll() {
		return hDao.selectAll();
		
	}

	@Override
	public HouseBean insert(HouseBean Bean) {
		return hDao.insert(Bean);
	}

	@Override
	public HouseBean update(int houseid, String housename) {
		return hDao.update(houseid, housename);

	}

	@Override
	public boolean deleteById(int houseid) {
		return hDao.deleteById(houseid);
	}

}
