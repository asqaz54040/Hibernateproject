package tw.samtest.model;

import java.util.List;

public interface IHouseBeanService {
	public HouseBean select(HouseBean Bean);
	public List<HouseBean> selectAll();
	public HouseBean insert(HouseBean Bean);
	public HouseBean update (int houseid,String housename);
	public boolean deleteById(int houseid);
}
