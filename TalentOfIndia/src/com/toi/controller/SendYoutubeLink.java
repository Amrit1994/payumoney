package com.toi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toi.dao.UserDaoImpl;
import com.toi.model.Youtube;
import com.toi.util.SendMail;


/**
 * Servlet implementation class SendYoutubeLink
 */
@WebServlet("/SendYoutubeLink")
public class SendYoutubeLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendYoutubeLink() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   UserDaoImpl userdao = new UserDaoImpl();
		   List states = userdao.getStates();
		   try{
		   request.setAttribute("states",states);
		   request.getRequestDispatcher("youtube.jsp").forward(request,response);
		   } catch(Exception e)
		    {
			 System.out.println(e);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
			String ufname = request.getParameter("ufname");
			String email = request.getParameter("email");
		    String address = request.getParameter("address");
		    String mobile = request.getParameter("phone");
		    String dob = request.getParameter("bday");
		    String state = request.getParameter("state");
		    String city = request.getParameter("city");
		    String pincode = request.getParameter("pincode");
		    String vlink = request.getParameter("vlink");
		    Youtube yt = new Youtube();
		    yt.setName(ufname);
		    yt.setEmail(email);
		    yt.setAddress(address);
		    yt.setMobile(mobile);
		    yt.setDob(dob);
		    yt.setState(state);
		    yt.setCity(city);
		    yt.setPincode(pincode);
		    yt.setVideolink(vlink);
		    SendMail sm = new SendMail();
			String msg="";
			String sub="Query From Talent of India";
			String msgCp="";
			String subCp="Reply From Talent of India Team";
			sm.data("xxxxxxxxxxxxxxx","xxxxxxxxxxxxxx","xxxxxxxxxxxxxxxxxxxxx",sub,msg,yt);
			sm.mailToContactPerson("xxxxxxxxxxx","xxxxxxxxxx",email,subCp,msgCp);
			alert("Data submitted successfully");
			//request.getRequestDispatcher("home.jsp").include(request,response);
			response.sendRedirect("Home");  
	}
	
	void alert(String message)
	{
		 out.println("<script type=\"text/javascript\">");
		 out.println("alert('"+message+"')");
		 out.println("</script>");
	}

}
