package su.dept.control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import su.dept.dao.DeptDAO;
import su.dept.dto.DeptDTO;

@WebServlet("/DeptUpdate")
public class DeptUpdate extends HttpServlet {
	private static Log log = LogFactory.getLog(DeptUpdate.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./dept/dept_update.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		log.info(deptno);
		String dname = request.getParameter("dname");
		log.info(dname);
		String loc = request.getParameter("loc");
		log.info(loc);
		DeptDAO deptDao = new DeptDAO();
		DeptDTO deptDTO = new DeptDTO();
// 입력한 정보를 DeptDTO 클래스의 인스턴스에 저장한다.
		deptDTO.setDeptno(deptno);
		deptDTO.setDname(dname);
		deptDTO.setLoc(loc);
		log.info(deptDTO);
//수정한 데이터를 반환하여 deptDTO 인스턴스로 할당하고 할당하지 않으면 null 값이 반환된다.
		deptDTO = deptDao.deptUpdate(deptDTO);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./dept/dept_update_view.jsp");
		dispatcher.forward(request, response);
	}
}