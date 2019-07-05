package com.toi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toi.dao.UserDaoImpl;
import com.toi.model.User;
import com.toi.util.JavaIntegrationKit;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaymentGateway pg = new PaymentGateway();
		String requestUrl = request.getRequestURL().toString();
	    String path = requestUrl.substring(0, requestUrl.lastIndexOf("/")+1);
		try{ 
		 User user = (User) request.getSession(false).getAttribute("userdetail");
		 UserDaoImpl userdao = new UserDaoImpl();
		 String t_id = userdao.insertUser(user);
		 //System.out.println(t_id);
		 request.getSession(false).setAttribute("tid",t_id);
		 if(Integer.parseInt(t_id)>0)
		 {
			// mandatory parameters
			request.setAttribute("key","xxxxxxxx"); //enter your key
			request.setAttribute("hash_string","");
			request.setAttribute("hash","");
			request.setAttribute("txnid",t_id);
			request.setAttribute("amount","10");
			request.setAttribute("firstname",user.getUfname());
			request.setAttribute("email",user.getEmail());
			request.setAttribute("phone",user.getMobile());
			request.setAttribute("productinfo","SurSangam");
			request.setAttribute("surl",path+"PaymentSuccess");
			request.setAttribute("furl",path+"failure.jsp");
			request.setAttribute("service_provider","payu_paisa");
			// non mandatory parameters
			request.setAttribute("lastname","");
			request.setAttribute("curl",path+"failure.jsp");
			request.setAttribute("address1","");
			request.setAttribute("address2","");
			request.setAttribute("city","");
			request.setAttribute("state","");
			request.setAttribute("country","");
			request.setAttribute("zipcode","");
			request.setAttribute("udf1","");
			request.setAttribute("udf2","");
			request.setAttribute("udf3","");
			request.setAttribute("udf4","");
			request.setAttribute("udf5","");
			request.setAttribute("pg","");
			
			JavaIntegrationKit integrationKit = new JavaIntegrationKit();
		    Map<String, String> values = integrationKit.hashCalMethod(request, response);
		    //System.out.println("..."+values);
		    PrintWriter writer = response.getWriter();
		    String htmlResponse = "<html> <body>"
		                 + "          <form id=\"payuform\" action=\"" + values.get("action") + "\"  name=\"payuform\" method=POST >\n"
		                 + "          <input type=\"hidden\" name=\"key\" value=" + values.get("key").trim() + ">"
		                 + "          <input type=\"hidden\" name=\"hash\" value=" + values.get("hash").trim() + ">"
		                 + "          <input type=\"hidden\" name=\"txnid\" value=" + values.get("txnid").trim() + ">"
		                 + "          <table><tr>"
		                 + "          <td><input type=\"hidden\" name=\"amount\" value=" + values.get("amount").trim() + " /></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"firstname\" id=\"firstname\" value=" + values.get("firstname").trim() + " /></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"email\" id=\"email\" value=" + values.get("email").trim() + " /></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"phone\" value=" + values.get("phone") + " ></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"productinfo\" value=" + values.get("productinfo").trim() + " ></td>\n"
		                 + "          <td colspan=\"3\"><input type=\"hidden\" name=\"surl\"  size=\"64\" value=" + values.get("surl") + "></td>\n"
		                 + "          <td colspan=\"3\"><input type=\"hidden\" name=\"furl\" value=" + values.get("furl") + " size=\"64\" ></td>\n"
		                 + "          <td colspan=\"3\"><input type=\"hidden\" name=\"service_provider\" value=\"payu_paisa\" /></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"lastname\" id=\"lastname\" value=" + values.get("lastname") + " ></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"curl\" value=" + values.get("curl") + " ></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"address1\" value=" + values.get("address1") + " ></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"address2\" value=" + values.get("address2") + " ></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"city\" value=" + values.get("city") + "></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"state\" value=" + values.get("state") + "></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"country\" value=" + values.get("country") + " ></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"zipcode\" value=" + values.get("zipcode") + " ></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"udf1\" value=" + values.get("udf1") + "></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"udf2\" value=" + values.get("udf2") + "></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"hashString\" value=" + values.get("hashString") + "></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"udf3\" value=" + values.get("udf3") + " ></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"udf4\" value=" + values.get("udf4") + " ></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"udf5\" value=" + values.get("udf5") + " ></td>\n"
		                 + "          <td><input type=\"hidden\" name=\"pg\" value=" + values.get("pg") + " ></td>\n"
		                 + "          <td colspan=\"4\"><input type=\"hidden\" value=\"Submit\"  /></td>\n"
		                 + "          </table></form><script>"
		                 + "          document.getElementById(\"payuform\").submit(); "
		                 + "          </script></body></html>";
		                 writer.println(htmlResponse);
		              		}
		 				}catch(Exception e)
						{
						//e.printStackTrace();
						request.getRequestDispatcher("home.jsp").forward(request,response);
						}
					}
    }
