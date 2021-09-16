package com.serv1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class logindetails implements Servlet {

	ServletConfig config=null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return config.getServletName();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config=config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		System.out.println("welcome");
		System.out.println("Login details reached");
		String username=req.getParameter("un");
		String password=req.getParameter("pwd");
		System.out.println("User is : "+username);
		System.out.println("passwprd is : "+password);
		
		PrintWriter pw=res.getWriter();
		pw.println("<h1>User is :"+username+"</h1>");
		pw.println("<h1>password is : "+password+"<h1>");
	
		ServletConfig config=getServletConfig();
		System.out.println("servlet name is "+config.getServletName());
		
		String n=config.getInitParameter("user");
		String p=config.getInitParameter("passwoed");
		
		RequestDispatcher rd=null;
		if(username.equalsIgnoreCase("admin")&& password.equalsIgnoreCase("admin1234"))
		{
			 rd= req.getRequestDispatcher("success.html");
			rd.forward(req, res);
		}
		else
		{
			rd=req.getRequestDispatcher("failure.html");
			rd.forward(req, res);
		}
	}

	
}
