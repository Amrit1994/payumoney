package com.toi.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.toi.dao.UserDaoImpl;

/**
 * Servlet implementation class BindStates
 */
@WebServlet("/BindStates")
public class BindStates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BindStates() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		UserDaoImpl userdao = new UserDaoImpl();
		response.setContentType("application/json");
        OutputStream outputStream= response.getOutputStream();
        List states = userdao.getStates();
        Gson gson=new Gson();       
        outputStream.write(gson.toJson(states).getBytes());
        outputStream.flush();
        
        /* List<String> cities = userservice.getCities(stateId);
		 Gson gson = new Gson();
		 String element = gson.toJson(cities,new TypeToken<ArrayList<String>>() {}.getType());
		 JSONArray list = new JSONArray(element);
		 return String.valueOf(list);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String state  = request.getParameter("stateId");
		UserDaoImpl userdao = new UserDaoImpl();
		List cities = userdao.getCities(state);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
	    response.setHeader("Cache-control", "no-cache, no-store");
	    response.setHeader("Pragma", "no-cache");
	    response.setHeader("Expires", "-1");
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST");
	    response.setHeader("Access-Control-Allow-Headers", "Content-Type");
	    response.setHeader("Access-Control-Max-Age", "86400");
	    Gson gson = new Gson(); 
	    JsonObject myObj = new JsonObject();
	    JsonElement countryObj = gson.toJsonTree(cities);
	    myObj.add("cities", countryObj);
	    out.println(myObj.toString());
	    out.close();
	}

}
