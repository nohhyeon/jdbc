package su.dept.control;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/DeptSelect")
public class DeptSelect extends HttpServlet {
	private static Log log = LogFactory.getLog(DeptSelect.class);
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeptDAO deptDao = new DeptDAO();
		DeptDTO deptDTO = new DeptDTO();
		log.info(deptDTO);
		ArrayList<DeptDTO> arrayList = new ArrayList<DeptDTO>();
//가변 배열에 추가한 전체 데이터를 반환하여 arrayList 인스턴스로 할당하고 할당하지 않으면 null 값이 반환된다.
		arrayList = deptDao.deptSelectAll();
		log.info(arrayList);
		request.setAttribute("arrayList", arrayList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./dept/dept_select_view.jsp");
		dispatcher.forward(request, response);
	}
}
