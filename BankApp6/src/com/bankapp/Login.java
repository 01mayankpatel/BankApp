package com.bankapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String custid=request.getParameter("custid");
		String pwd =request.getParameter("pwd");
		
		Model model=new Model();
		model.setCustid(custid);
		model.setPwd(pwd);
		
		boolean result=model.login();
		if(result)
		{
			int accno=model.getAccno();
			HttpSession session=request.getSession(true);
			session.setAttribute("accno", accno);
			response.sendRedirect("/BankApp6/home.jsp");
		}
		else {
			response.sendRedirect("/BankApp6/errorLogin.html");
		}
	}

}
