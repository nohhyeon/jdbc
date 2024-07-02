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

@WebServlet("/DeptDelete")
public class DeptDelete extends HttpServlet {
	private static Log log = LogFactory.getLog(DeptDelete.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("./dept/dept_delete.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		log.info(deptno);
		DeptDAO deptDao = new DeptDAO();
		DeptDTO deptDTO = new DeptDTO();
		log.info(deptDTO);
// 입력한 정보를 DeptDTO 클래스의 인스턴스에 저장한다.
		deptDTO.setDeptno(deptno);
//삭제한 데이터를 반환하여 deptDTO 인스턴스로 할당하고 할당하지 않으면 null 값이 반환된다.
		deptDTO = deptDao.deptDelete(deptno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./dept/dept_delete_view.jsp");
		dispatcher.forward(request, response);
	}
}
