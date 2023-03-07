package servletStudy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletStudy.dao.MemberDAO;
import servletStudy.vo.MemberVO;

/**
 * Servlet implementation class MemberListController
 */
@WebServlet("/member/list.do")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberListController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberDAO memberDAO = new MemberDAO();
		List<MemberVO> memberList = memberDAO.list();
		
		request.setAttribute("memberList", memberList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/member/list.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
