package com.toi.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.toi.dao.UserDaoImpl;
import com.toi.model.User;

/**
 * Servlet implementation class UserRegistrationController
 */
@WebServlet("/UserRegistrationController")
public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	User user;
    UserDaoImpl userDao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationController() {
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
	@SuppressWarnings({ "unused", "null", "deprecation" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		user = new User();
	    PrintWriter out = response.getWriter();
        final String IMAGE_RESOURCE_PATH = "/uploads/";
        String rootPath = getServletContext().getRealPath(IMAGE_RESOURCE_PATH);
        File directory = new File(rootPath);
        if(!directory.exists()) {
            directory.mkdirs();
        }
        MultipartRequest m = null;
        try{
	    m=new MultipartRequest(request,rootPath,1024 * 1024 * 1024);
        }
        catch(Exception e)
        {
         System.out.println(e);	
         request.getRequestDispatcher("home.jsp").forward(request,response);
        }
	    String ufname = m.getParameter("ufname");
		String mname = m.getParameter("umname");
		String lname = m.getParameter("ulname");
		String ffname = m.getParameter("ffname");
		String fmname = m.getParameter("fmname");
		String flname = m.getParameter("flname");
		String mfname = m.getParameter("mfname");
		String mmname = m.getParameter("mmname");
		String mlname = m.getParameter("mlname");
		String userCode = m.getParameter("usercode");
		String email = m.getParameter("email");
	    String category = m.getParameter("cat");
	    String gender = m.getParameter("gender");
	    String address = m.getParameter("address");
	    String picture = m.getParameter("picture");
	    String document = m.getParameter("document");
	    String sig = m.getParameter("sig");
	    String mobile = m.getParameter("phone");
	    String state = m.getParameter("state");
	    String audcity = m.getParameter("audcity");
	    String city = m.getParameter("city");
	    int pincode = Integer.parseInt(m.getParameter("pincode"));
		String dob = m.getParameter("bday");
		int year = Integer.parseInt(dob.split("-")[0]);
		//System.out.println("......................."+year);
		if(year>2005)
		{
			 System.out.println("Your age is not valid");
			 out.println("<script type=\"text/javascript\">");
			 out.println("alert('Your age is not valid')");
			 out.println("</script>");
			 response.sendRedirect("Home");
			 return;
		}
        Date dobb = null;
		try{
		dobb=new SimpleDateFormat("yyyy-MM-dd").parse(dob);
		}catch(Exception e){System.out.println(e);}
		//System.out.println("...."+dobb);
		
		//System.out.println(ufname+".."+mname+".."+lname+".."+ffname+".."+fmname+".."+flname+".."+mfname+".."+mmname+".."+mlname+".."+email+".."+mobile+""
		//+category+".."+gender+".."+address+".."+picture+".."+document+".."+sig+".."+state+".."+city+".."+pincode);
		
		String images[] = new String[3];
		int i=0;
		Enumeration files = m.getFileNames();       
		while (files.hasMoreElements()) { 
			   String name =(String)files.nextElement();
			   images[i] = m.getFilesystemName(name);
		       i++;
		} 
		String requestUrl = request.getRequestURL().toString();
		try{
		if(images[2]!=null)
        picture = requestUrl.substring(0, requestUrl.lastIndexOf("/") + 1) + "uploads/" +images[2];
		}catch(NullPointerException n){picture = m.getParameter("picture");}
		
		try{
		if(images[1]!=null)
	    document = requestUrl.substring(0, requestUrl.lastIndexOf("/") + 1) + "uploads/" +images[1];
		}catch(NullPointerException n){document =  m.getParameter("document");}
		
		try{
		if(images[0]!=null)	
		sig = requestUrl.substring(0, requestUrl.lastIndexOf("/") + 1) + "uploads/" +images[0];
		}catch(NullPointerException n){sig = m.getParameter("sig");}
		
		// not used yet....... usercode is updated by store procedure
		userCode = "";//String.valueOf("TOI/SUR/"+ufname.substring(0,3)+"/"+dobb.getYear()+"/"+mobile);
		//System.out.println(userCode);
        try{
        user.setUserCode(userCode);
        user.setUfname(ufname.replaceAll("\\s+", ""));
		user.setUmname(mname.replaceAll("\\s+", ""));
		user.setUlname(lname.replaceAll("\\s+", ""));
		user.setFfname(ffname.replaceAll("\\s+", ""));
		user.setFmname(fmname.replaceAll("\\s+", ""));
		user.setFlname(flname.replaceAll("\\s+", ""));
		user.setMfname(mfname.replaceAll("\\s+", ""));
		user.setMmname(mmname.replaceAll("\\s+", ""));
		user.setMlname(mlname.replaceAll("\\s+", ""));
		user.setEmail(email);
		user.setMobile(Long.parseLong(mobile));
		user.setCategory(category);
		user.setGender(gender);
		user.setDob(dobb);
		user.setAddress(address);
		user.setState(state);
		user.setAudCity(audcity);
		user.setCity(city);
		user.setPincode(pincode);
		user.setPicture(picture);
		user.setDocument(document);
		user.setSignature(sig);
        }
        catch(NullPointerException e)
        {
          System.out.println(e);
		  request.getRequestDispatcher("home.jsp").forward(request,response);	
        }
        
		 try{
		 request.setAttribute("userdetails", user);
		 request.getSession().setAttribute("userdetail", user);
		 request.getRequestDispatcher("viewUserDetails.jsp").forward(request,response);
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
			// e.printStackTrace();
			 request.getRequestDispatcher("home.jsp").forward(request,response);
		 }
		
	   }

}
