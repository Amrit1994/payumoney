package com.toi.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toi.util.SendMail;

/**
 * Servlet implementation class ContactUs
 */
@WebServlet("/ContactUs")
public class ContactUs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		out = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String sub = request.getParameter("sub");
		String msg = request.getParameter("msg");
		String mobile = request.getParameter("mobile");
		SendMail sm = new SendMail();
		String subj="Query From Talent of India";
		String msgCp="";
		String subCp="Reply From Talent of India Team";
		sm.mailToContactAdmin("noreply@talentofindia.co.in","Talent@2019","mailtalentofindia@gmail.com",subj,name,email,sub,msg,mobile);
		sm.mailToContactWebsiteForm("xxxxxxxxxxxx","xxxxxx",email,subCp,msgCp);
		alert("Data submitted successfully");
		response.sendRedirect("Home");  
	    }
	
		void alert(String message)
		{
			 out.println("<script type=\"text/javascript\">");
			 out.println("alert('"+message+"')");
			 out.println("</script>");
		}

}
