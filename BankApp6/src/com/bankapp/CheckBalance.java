package com.bankapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		int accno=(int) session.getAttribute("accno");
		
		Model model=new Model();
		model.setAccno(accno);
		boolean result=model.checkBalance();
		
		if(result)
		{
			int balance=model.getBalance();
			session.setAttribute("balance",balance);
			response.sendRedirect("/BankApp6/checkBalance.jsp");
		}
		else
		{
			response.sendRedirect("/BankApp6/errorBalance.html");
			
		}
	
	}
}
