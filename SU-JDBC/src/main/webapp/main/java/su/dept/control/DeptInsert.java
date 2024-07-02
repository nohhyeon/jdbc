package su.dept.control;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.apache.commons.logging.*;
import su.dept.dao.DeptDAO;
import su.dept.dto.DeptDTO;

@WebServlet("/DeptInsert")
public class DeptInsert extends HttpServlet {
	private static Log log = LogFactory.getLog(DeptInsert.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./dept/dept_insert.jsp");
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
		ArrayList<DeptDTO> arrayList = new ArrayList<DeptDTO>();
//가변 배열에 추가한 전체 데이터를 반환하여 arrayList 인스턴스로 할당하고 할당하지 않으면 null 값이 반환된다.
		arrayList = deptDao.deptSelectAll();
		log.info(arrayList);
		request.getSession().setAttribute("arrayList", arrayList);
// 입력한 정보를 DeptDTO 클래스의 인스턴스에 저장한다.
		deptDTO.setDeptno(deptno);
		deptDTO.setDname(dname);
		deptDTO.setLoc(loc);
//입력된 데이터를 반환하여 deptDTO 인스턴스로 할당하고 할당하지 않으면 null 값이 반환된다.
		deptDTO = deptDao.deptInsert(deptDTO);
		log.info(deptDTO);
		response.sendRedirect("./dept/dept_insert_view.jsp?deptno=" + deptno);
	}
}