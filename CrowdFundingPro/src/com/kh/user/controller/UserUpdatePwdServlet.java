package com.kh.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.user.model.service.UserService;
import com.kh.user.model.vo.User;

/**
 * Servlet implementation class UserUpdatePwdServlet
 */
@WebServlet("/updatePwd.me")
public class UserUpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = ((User)request.getSession().getAttribute("loginUser")).getEmailId();
		String userPwd = request.getParameter("userPwd");
		String newPwd = request.getParameter("newPwd");
		
		User updateMem = new UserService().updatePwd(userId, userPwd,newPwd);
		
		RequestDispatcher view = request.getRequestDispatcher("views/User/pwdUpdateForm.jsp");
		if(updateMem != null) {
			request.setAttribute("sTag", "Y");
			request.setAttribute("msg", "성공적으로 비밀번호를 변경하였습니다.");
			request.getSession().setAttribute("loginUser", updateMem);
		}else {
			request.setAttribute("msg", "비밀번호 변경에 실패했습니다.");
		}
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
