<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@page import="com.nsis.bean.UserBean" %>

</head>
<body>

 <%
  // si l'utilisateur tape l'adresse de la page Bienvenue.jsp sans s'�tre logu� auparavant, on affiche...
  if(request.getSession().getAttribute("user") == null){
   out.print("Vous n'�tes pas connect�. Cliquez <a href=\"index.html\">ici</a> pour vous authentifier");
   
  } else {
   // S'il s'est loggu�, on affiche...
   UserBean currentUser = (UserBean) request.getSession().getAttribute("user");
   out.print(String.format("Bonjour visiteur ! Tu es connect� en tant que : %s", currentUser.getLogin()));
   out.print("<br />");
   out.print(String.format("Ton mot de passe est : %s", currentUser.getPassword()));
   out.print("<p><a href=\"LogoutServlet\">D�connexion</a></p>");
  }
 %>

</body>
</html>