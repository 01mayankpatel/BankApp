<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Trans are:</h1>
<br/>
<h2>Credited Amount:</h2>
<br/>
<%
ArrayList<Integer> al=(ArrayList<Integer>)session.getAttribute("al");

for(int i=1;i<al.size();i++)
{
	if(al.get(i)>0)
	{
		out.println(al.get(i));
	}
}
%>
<br/>
<h2>Debited Amount:</h2>
<br/>
<%
for(int i=1;i<al.size();i++)
{
	if(al.get(i)<0)
	{
		out.println(al.get(i));
	}
}
%>



</body>
</html>