package com.toi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toi.model.User;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try
		 {
		 User user = (User) request.getSession(false).getAttribute("userdetail");
		 request.setAttribute("userdetails", user);
		 List states = (List) request.getSession().getAttribute("state");
		 List audc = (List) request.getSession(false).getAttribute("audc");
		 System.out.println(audc);
		 request.setAttribute("states",states);
		 request.setAttribute("audcities",audc);
		 request.getRequestDispatcher("update.jsp").forward(request,response);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
			 request.getRequestDispatcher("home.jsp").forward(request,response);
		 }
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
	}

}
