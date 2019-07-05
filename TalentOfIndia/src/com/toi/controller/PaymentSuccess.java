package com.toi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import com.toi.dao.UserDaoImpl;
/**
 * Servlet implementation class PaymentSuccess
 */
@WebServlet("/PaymentSuccess")
public class PaymentSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDaoImpl user = new UserDaoImpl();
	    String txid = (String) request.getSession(false).getAttribute("tid");
	    System.out.println("Transaction id...."+txid);                            ////////////////your key////////
	    String link ="https://www.payumoney.com/sandbox/payment/op/getPaymentResponse?merchantKey=xxxxxxxxxx&merchantTransactionIds="+txid;
        URL obj = new URL(link);
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	    postConnection.setRequestMethod("POST");
	    postConnection.setRequestProperty("Content-Type", "application/json");
	    postConnection.setRequestProperty("authorization","////////////////// header////////////////////////");
	    postConnection.setDoOutput(true);
	    int responseCode = postConnection.getResponseCode();
	    System.out.println("POST Response Code :  " + responseCode);
	    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
	    BufferedReader in = new BufferedReader(new InputStreamReader(
	    postConnection.getInputStream()));
	    String inputLine;
	    StringBuffer res = new StringBuffer();
	    while ((inputLine = in .readLine()) != null) {
	          res.append(inputLine);
	    } in .close();
	    JSONParser parse = new JSONParser();
	    JSONObject jobj = null;
		try {jobj = (JSONObject)parse.parse(String.valueOf(res));}catch(ParseException e)
		{System.out.println(e);}
	     System.out.println("payment status......"+jobj.get("status"));
	     String paymentId="";
	     String paymentStatusId="";
	     if(Integer.parseInt(String.valueOf(jobj.get("status")))==0)
	     {
		 JSONArray jsonarr = (JSONArray)(jobj.get("result"));
		 JSONObject jsonobj_2 = (JSONObject)jsonarr.get(0);
		 JSONObject jsonobj_3 = (JSONObject)jsonobj_2.get("postBackParam");
		 System.out.println("if........payment id......."+jsonobj_3.get("paymentId"));
		 System.out.println("if........mihpaymentid......"+jsonobj_3.get("mihpayid"));
		 paymentId = String.valueOf(jsonobj_3.get("paymentId"));
	     paymentStatusId = String.valueOf(jsonobj_3.get("mihpayid"));
	     }
	     else
	     {
	    	 paymentId = request.getParameter("paymentId");
		     paymentStatusId = request.getParameter("mihpayid");
		     System.out.println("else....payment id......."+paymentId);
			 System.out.println("else....mihpaymentid......"+paymentStatusId);
	    	 
	     }
		 String uc = user.updateTransaction(paymentId,paymentStatusId,txid);
	     request.setAttribute("pay_id", paymentId);
	     request.setAttribute("usercode",uc);
         request.getRequestDispatcher("printform.jsp").forward(request,response);
			
	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    UserDaoImpl user = new UserDaoImpl();
		    String txid = (String) request.getSession(false).getAttribute("tid");
		    System.out.println("Transaction id...."+txid);                        ///////////your key////////////
		    String link ="https://www.payumoney.com/payment/op/getPaymentResponse?merchantKey=xxxxxxxx&merchantTransactionIds="+txid;
	        URL obj = new URL(link);
	        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		    postConnection.setRequestMethod("POST");
		    postConnection.setRequestProperty("Content-Type", "application/json");
		    postConnection.setRequestProperty("authorization","xxxxxxxxxxxx your header xxxxxxxxxxxxxxxxx");
		    postConnection.setDoOutput(true);
		    int responseCode = postConnection.getResponseCode();
		    System.out.println("POST Response Code :  " + responseCode);
		    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
		    BufferedReader in = new BufferedReader(new InputStreamReader(
		    postConnection.getInputStream()));
		    String inputLine;
		    StringBuffer res = new StringBuffer();
		    while ((inputLine = in .readLine()) != null) {
		          res.append(inputLine);
		    } in .close();
		    System.out.println(res);
		    JSONParser parse = new JSONParser();
		    JSONObject jobj = null;
			try {jobj = (JSONObject)parse.parse(String.valueOf(res));}catch(ParseException e)
			{System.out.println(e);}
		     System.out.println("payment status......"+jobj.get("status"));
		     String paymentId="";
		     String paymentStatusId="";
		     if(Integer.parseInt(String.valueOf(jobj.get("status")))==0)
		     {
			 JSONArray jsonarr = (JSONArray)(jobj.get("result"));
			 JSONObject jsonobj_2 = (JSONObject)jsonarr.get(0);
			 JSONObject jsonobj_3 = (JSONObject)jsonobj_2.get("postBackParam");
			 System.out.println("if........payment id......."+jsonobj_3.get("paymentId"));
			 System.out.println("if........mihpaymentid......"+jsonobj_3.get("mihpayid"));
			 paymentId = String.valueOf(jsonobj_3.get("paymentId"));
		     paymentStatusId = String.valueOf(jsonobj_3.get("mihpayid"));
		     }
		     else
		     {
		    	 paymentId = request.getParameter("paymentId");
			     paymentStatusId = request.getParameter("mihpayid");
			     System.out.println("else....payment id......."+paymentId);
				 System.out.println("else....mihpaymentid......"+paymentStatusId);
		    	 
		     }
			 String uc = user.updateTransaction(paymentId,paymentStatusId,txid);
		     request.setAttribute("pay_id", paymentId);
		     request.setAttribute("usercode",uc);
	         request.getRequestDispatcher("printform.jsp").forward(request,response);
	}

}
