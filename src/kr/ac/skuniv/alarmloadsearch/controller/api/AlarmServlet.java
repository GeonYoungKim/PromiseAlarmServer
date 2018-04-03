package kr.ac.skuniv.alarmloadsearch.controller.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alarmloadsearchDao.AlarmDao;
import alarmloadsearchVo.AlarmVo;
import kr.ac.skuniv.mysite.dto.JsonResult;
import mysiteDao.UserDao;
import mysiteVo.UserVo;
import net.sf.json.JSONObject;



/**
 * Servlet implementation class AlarmServlet
 */
@WebServlet("/api/alarm")
public class AlarmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String actionName = request.getParameter( "a" );
		 
		if("alarminsert".equals(actionName)){
			String sd=request.getParameter("sd");
			String ed=request.getParameter("ed");
			String pd=request.getParameter("pd");
			String pt=request.getParameter("pt");
			String st=request.getParameter("st");
			String way=request.getParameter("way");
			AlarmDao dao=new AlarmDao();
			AlarmVo vo=new AlarmVo();
			vo.setStartDeparture(sd);
			vo.setEndDeparture(ed);
			vo.setPromiseDay(pd);
			vo.setPromiseTime(pt);
			vo.setStartTime(st);
			vo.setWay(way);			
			dao.insert(vo);
		}else if("list".equals(actionName)){
			AlarmDao dao=new AlarmDao();
			List<AlarmVo> list=dao.getList();
			
			JSONObject jsonObject=JSONObject.fromObject(JsonResult.success(list));
			response.setContentType("application/json; charset=utf-8"); 	//Ÿ���� ������ ���� text/html�� ����!!!!
			response.getWriter().print(jsonObject.toString()); 	//jsonObject�� ��Ʈ������ ��ȯ�Ͽ� ��.
			
		}else if("alarmdelete".equals(actionName)){
			String strno=request.getParameter("no");
			int no=Integer.parseInt(strno);
			
			AlarmDao dao=new AlarmDao();
			AlarmVo vo=new AlarmVo();
			vo.setNo(no);
			dao.delete(vo);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
