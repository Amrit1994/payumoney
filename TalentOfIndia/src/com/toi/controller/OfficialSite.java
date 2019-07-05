package com.toi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OfficialSite
 */
@WebServlet("/OfficialSite")
public class OfficialSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfficialSite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("page").equals("officialsitehomepage9512827347287783488374784723478"))
		     request.getRequestDispatcher("officialhome.html").forward(request,response);
		else if(request.getParameter("page").equals("officialsiteaboutpage9512827347287783488374784723478"))
	     	request.getRequestDispatcher("about.html").forward(request,response);
		else if(request.getParameter("page").equals("officialsiteeventspage9512827347287783488374784723478"))
			request.getRequestDispatcher("events.html").forward(request,response);
		else if(request.getParameter("page").equals("officialsitecontactpage9512827347287783488374784723478"))
			request.getRequestDispatcher("contact.html").forward(request,response);
		else if(request.getParameter("page").equals("officialsitefaqpage9512827347287783488374784723478"))
			request.getRequestDispatcher("faq.html").forward(request,response);
		else if(request.getParameter("page").equals("youtubedemovideo9512827347287783488374784723478"))
			request.getRequestDispatcher("youtube_demo_video.jsp").forward(request,response);
		else
		request.getRequestDispatcher("officialhome.html").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
