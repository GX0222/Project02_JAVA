<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    if(request.getMethod().equals("POST"))
    out.print((int)(Math.random()*(request.getParameter("max") == null || request.getParameter("max").isEmpty() ? 49 : Integer.parseInt(request.getParameter("max")))+1));
    %>
