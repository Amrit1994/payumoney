package com.toi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.InvalidPaymentOrderException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.model.PaymentOrderFilter;
import com.instamojo.wrapper.response.CreatePaymentOrderResponse;
import com.instamojo.wrapper.response.PaymentOrderDetailsResponse;
import com.instamojo.wrapper.response.PaymentOrderListResponse;
import com.toi.dao.UserDaoImpl;
import com.toi.model.User;
////////////////////////////////// instamojo paymeny gateway integration //////////////////////////////////////////
public class PaymentGateway {

	public void buy(User user,int regId,HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("called....");
		String requestUrl = request.getRequestURL().toString();
	    String path = requestUrl.substring(0, requestUrl.lastIndexOf("/")+1);
		UserDaoImpl udi = new UserDaoImpl();
		List l = new ArrayList();
		double amount=10;
		// I am making product details and putting into the database for creation of Transaction ID
		String t_id = udi.insertTransDetails(regId);
		/***** Create a new payment order *******/
		PaymentOrder order = new PaymentOrder();
		order.setName(user.getUfname());
		order.setEmail(user.getEmail());
		order.setPhone(String.valueOf(user.getMobile()));
		order.setCurrency("INR");
		order.setAmount(amount);
		order.setDescription("Talent of India: SUR-SANGAM");
		order.setRedirectUrl(path+"PaymentSuccess");
		order.setWebhookUrl("http://www.google.com/");
		order.setTransactionId(t_id);
		
		Instamojo api = null;
		try {
			// gets the reference to the instamojo api
			//INSTAMOJO_TEST_API_ENDPOINT var3
			//INSTAMOJO_LIVE_API_ENDPOINT = "https://api.instamojo.com/v2/";
			
			//INSTAMOJO_TEST_AUTH_ENDPOINT var4
			//INSTAMOJO_LIVE_AUTH_ENDPOINT = "https://www.instamojo.com/oauth2/token/";
			
			//String var1 = "test_R4B9atZddfxic2P6dW0bP7Sm9COL97G4wjE";
			//String var2 = "test_ETTfJAJdoLQlCYyALZJNZqP0mnNPtnDBip5T0h3fuNCiKHPpwIT8aFE26kXib370q7VzgF5QmoQ9m2tR9FLdr0agY0wD9TQJrCRFqC1q2tYqS6v3ZAg7LNHfh0O";
			String var1="test_ZKsaU496Daeu4bsRYrDkZBGOgPCvhIcdryM";
			String var2="test_OjYWbOwriMRj3aY64y77u1ahPjof6bkoPF028DdzQCLtsxVVRhzIUbgKCdmjBlusDH0b7Ew40DbfquoKcguz02NdjLTl1buF2rmgy1pIWfy5CeyS4ZmMLhkk34R";
			String var3 = "https://test.instamojo.com/v2/";
			String var4 = "https://test.instamojo.com/oauth2/token/";
			api = InstamojoImpl.getApi(var1,var2,var3,var4);
			
		} catch (ConnectionException e) {
			//LOGGER.log(Level.SEVERE, e.toString(), e);
			System.out.println("after 4 cheza"+e.toString());
		}

		boolean isOrderValid = order.validate();
		String paymentOrderId = "";
		if (isOrderValid) {
			try {
				CreatePaymentOrderResponse createPaymentOrderResponse = api.createNewPaymentOrder(order);
			    paymentOrderId = createPaymentOrderResponse.getPaymentOrder().getId();
		        System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,"+createPaymentOrderResponse.getPaymentOptions().getPaymentUrl());
				response.sendRedirect(createPaymentOrderResponse.getPaymentOptions().getPaymentUrl());
			    // print the status of the payment order.
				System.out.println("response..."+createPaymentOrderResponse.getPaymentOrder().getStatus());
			} catch (InvalidPaymentOrderException e) {
			    //LOGGER.log(Level.SEVERE, e.toString(), e);
			    System.out.println(e);
			    if (order.isTransactionIdInvalid()) {
			        System.out.println("Transaction id is invalid. This is mostly due to duplicate  transaction id.");
			    }
			    if (order.isCurrencyInvalid()) {
			        System.out.println("Currency is invalid.");
			    }
			} catch (ConnectionException e) {
				System.out.println("create order redp...."+e);
			    //LOGGER.log(Level.SEVERE, e.toString(), e);
		    }
		} else {
			// inform validation errors to the user.
			if (order.isTransactionIdInvalid()) {
			    System.out.println("Transaction id is invalid.");
			}
			if (order.isAmountInvalid()) {
			  System.out.println("Amount can not be less than 9.00.");
			}
			if (order.isCurrencyInvalid()) {
			  System.out.println("Please provide the currency.");
			}
			if (order.isDescriptionInvalid()) {
			  System.out.println("Description can not be greater than 255 characters.");
		        }
			if (order.isEmailInvalid()) {
			  System.out.println("Please provide valid Email Address.");
			}
			if (order.isNameInvalid()) {
			  System.out.println("Name can not be greater than 100 characters.");
			}
			if (order.isPhoneInvalid()) {
			  System.out.println("Phone is invalid.");
			}
			if (order.isRedirectUrlInvalid()) {
			  System.out.println("Please provide valid Redirect url.");
			}
			
			if (order.isWebhookInvalid()) {
		      System.out.println("Provide a valid webhook url");
		    }
		}
		
		/*
		 * Get details of payment order when order id is given
		 */

		try {
			 PaymentOrderDetailsResponse paymentOrderDetailsResponse = api.getPaymentOrderDetails(paymentOrderId);

			if (paymentOrderDetailsResponse.getId() != null) {
				// print the status of the payment order.
				System.out.println("status...."+paymentOrderDetailsResponse.getStatus());
			} else {
				System.out.println("Please enter valid order id.");
			}
		} catch (ConnectionException e) {
			System.out.println(e);
			//LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		
	
		/*
		 * Get details of payment order when transaction id is given
		 */

		try {
			PaymentOrderDetailsResponse paymentOrderDetailsResponse = api.getPaymentOrderDetailsByTransactionId(t_id);

			if (paymentOrderDetailsResponse.getId() != null) {
				// print the status of the payment order.
				System.out.println("Payment order detiasl..."+paymentOrderDetailsResponse.getStatus());
			} else {
				System.out.println("Please enter valid transaction id.");
			}
		} catch (ConnectionException e) {
			System.out.println(e);
			//LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		
		
		
		/*
		 * Get list of all payment orders
		 */

		try {
			PaymentOrderFilter paymentOrderFilter = new PaymentOrderFilter();
			PaymentOrderListResponse paymentOrderListResponse = api.getPaymentOrderList(paymentOrderFilter);
			// Loop over all of the payment orders and print status of each
			// payment order.
			for (PaymentOrder paymentOrder : paymentOrderListResponse.getPaymentOrders()) {
				System.out.println("Result = " + paymentOrder.getStatus());
			}
			System.out.println(paymentOrderListResponse.getPaymentOrders());
		} catch (ConnectionException e) {
			System.out.println(e);
			//LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		
		/*
		 Create a new refund **************************************
	
		Refund refund = new Refund();
		refund.setPaymentId("0005");
		refund.setStatus("refunded");
		refund.setType("RFD");
		refund.setBody("This is a test refund.");
		refund.setRefundAmount(9D);
		refund.setTotalAmount(10D);

		boolean isRefundValid = refund.validate();

		if (isRefundValid) {
			try {
				CreateRefundResponse createRefundResponse = api.createNewRefund(refund);
				// print the status of the refund.
				System.out.println(createRefundResponse.getRefund().getStatus());
			} catch (InvalidRefundException e) {
				//LOGGER.log(Level.SEVERE, e.toString(), e);

				if (refund.isTypeInvalid()) {
					System.out.println("type is invalid.");
				}
			} catch (ConnectionException e) {
				//LOGGER.log(Level.SEVERE, e.toString(), e);
				System.out.println(e);
			}
		} else {
			// inform validation errors to the user.
			if (refund.isPaymentIdInvalid()) {
				System.out.println("Payment id is invalid.");
			}
			if (refund.isTypeInvalid()) {
				System.out.println("Type is invalid.");
			}
			if (refund.isBodyInvalid()) {
				System.out.println("Body is invalid.");
			}
			if (refund.isRefundAmountInvalid()) {
				System.out.println("Refund amount is invalid.");
			}
		}
*/
	}
}
