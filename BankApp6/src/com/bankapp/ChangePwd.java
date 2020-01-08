package com.bankapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int accno=(int) session.getAttribute("accno");
		
		String npwd=request.getParameter("npwd");
		
		Model model =new Model();
		model.setAccno(accno);
		model.setPwd(npwd);
		boolean result=model.changePwd();
		
		if(result)
			response.sendRedirect("/BankAp6/successPwd.html");
		else
			response.sendRedirect("/BankApp6/errorChangePwd.html");
	}

}
