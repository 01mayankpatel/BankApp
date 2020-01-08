package com.bankapp;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class TransferFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{

		int amt=Integer.parseInt(request.getParameter("amt"));

		if(amt>0) {
			chain.doFilter(request, response);
		}
		else
		{
			((HttpServletResponse) response).sendRedirect("/BankApp6/errorAmount.html");
		}

	}
}
