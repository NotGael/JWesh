package org.jwesh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jwesh.action.Action;
import org.jwesh.action.ActionManager;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		String url = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		System.out.println("method : " + method);
		System.out.println("requestURI : " + url);
		System.out.println("contextPath : " + contextPath);
		
		Action action = ActionManager.getInstance().getAction(method + "|" + url);
		if (action != null) {
			action.execute(request,  response);
		} else {
			response.sendError(404);
		}
		
	}

}
