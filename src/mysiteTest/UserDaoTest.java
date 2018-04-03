package mysiteTest;

import java.util.List;

import mysiteDao.UserDao;
import mysiteVo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
		 
		UserDao dao = new UserDao();
		List<UserVo> list = dao.getList();
		
		for( UserVo vo : list ){
			System.out.println( vo );
		}

	}

}
