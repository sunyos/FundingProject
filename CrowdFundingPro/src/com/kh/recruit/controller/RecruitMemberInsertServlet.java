package com.kh.recruit.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.common.model.vo.Attachment;
import com.kh.recruit.model.service.RecruitService;
import com.kh.recruit.model.vo.RecruitMember;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class RecruitMemberApplyServlet
 */
@WebServlet("/recruitMemberInsert.do")
public class RecruitMemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruitMemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10 * 1024 * 1024;
			
			String resources = request.getSession().getServletContext().getRealPath("/resources");
			String savePath = resources + "\\upfiles\\";
			System.out.println("savePath : " + savePath);
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// rid, title 처리
			
			int rid = Integer.parseInt(multiRequest.getParameter("recruitId"));
			
			String title = multiRequest.getParameter("recruitName");
			
			// 회원 등록 처리
			
			String name = multiRequest.getParameter("recruitMemberName");
			String phone = multiRequest.getParameter("recruitMemberPhone");
			String email = multiRequest.getParameter("recruitMemberEmail");
			String education = multiRequest.getParameter("recruitMemberEducation");
			String career = multiRequest.getParameter("recruitMemberCareer");
			
			if (multiRequest.getParameter("recruitId") == null || multiRequest.getParameter("recruitId").equals("") ||
				title == null || title.equals("") || 
				name == null || name.equals("") || 
				phone == null || phone.equals("") || 
				email == null || email.equals("") || 
				education == null || education.equals("") || 
				career == null || career.equals("")) {
				// 지원서 등록 실패
				request.getSession().setAttribute("msg", "지원서 등록 실패");
				response.sendRedirect(request.getContextPath() + "/recruitContentList.do?rid=" + rid);
			}
			
			RecruitMember rm = new RecruitMember(name, phone, education, career, email);

			// 파일 업로드 처리
			
			Attachment at = null;
			
			// null이 아니면 첨부한거
			if (multiRequest.getOriginalFileName("recruitPortfolio") != null) {
				String originName = multiRequest.getOriginalFileName("recruitPortfolio");
				String changeName = multiRequest.getFilesystemName("recruitPortfolio");
				
				at = new Attachment();
				
				at.setFilePath(savePath);
				at.setOriginName(originName);
				at.setChangeName(changeName);
			}
					
			int result = new RecruitService().insertRecruitMember(rm, at, title);
			
			if (result > 0) {
				request.getSession().setAttribute("msg", "지원서 등록 성공");
				response.sendRedirect(request.getContextPath() + "/recruitContentList.do?rid=" + rid);
			} else {
				if (at != null) {
					File failedFile = new File(savePath + at.getChangeName());
					failedFile.delete();
					
					// 에러 페이지 처리
					request.getSession().setAttribute("msg", "지원서 등록 실패");
					response.sendRedirect("views/common/errorPage.jsp");
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}