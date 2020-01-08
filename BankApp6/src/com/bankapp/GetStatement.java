package com.bankapp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetStatement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		int accno=(int) session.getAttribute("accno");
		
		Model model=new Model();
		model.setAccno(accno);
		model.getStatement();
		ArrayList<Integer> al=model.getAl();
		if(al.isEmpty())
		{
			response.sendRedirect("/BankApp6/failStatement.html");
		}
		else
		{
			session.setAttribute("al", al);
			response.sendRedirect("/BankApp6/successStatement.jsp");
		}
	}

}
