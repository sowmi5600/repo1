package com.serv1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Sample implements Servlet{

	 ServletConfig config=null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("destroy executed");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("servlet configu execute");
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		System.out.println("servlet ifo executed");
		return "this is servlet information";
		
	}

	@Override
	public void init(ServletConfig conf) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init method executed");
		this.config=conf;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("request reached");
		System.out.println(getServletInfo());
		ServletConfig config=getServletConfig();
		System.out.println(config);
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.forward(req, res);
	}

	
}
