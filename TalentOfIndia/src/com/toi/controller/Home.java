package com.toi.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.toi.dao.UserDaoImpl;
import com.toi.model.AuditionCity;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   UserDaoImpl userdao = new UserDaoImpl();
	   List states = userdao.getStates();
	   List acity = userdao.audCities();
	   try{
	   request.setAttribute("states",states);
	   request.setAttribute("audcities",acity);
       request.getSession().setAttribute("state", states);
       request.getSession().setAttribute("audc", acity);
	   request.getRequestDispatcher("home.jsp").forward(request,response);
	   } catch(Exception e)
	    {
		 System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
