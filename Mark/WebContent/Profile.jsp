<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%if (request.getSession().getAttribute("stats") != null){
	boolean stats = (boolean) request.getSession().getAttribute("stats");
	if (stats == true){%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="Media/favicon.ico" type="image/x-icon">
		<link rel="stylesheet" href="Css/Norm.css">
		<link rel="stylesheet" href="Css/Profile.css">    
		<title>Mark</title>
	</head>
	<body>
		<iframe src="Nav.jsp"></iframe>
		<form class="content-box" action="ProfileServlet" method="post">
			<h1 class="content-title">User Profile</h1>
			<input class="content-input" type="text" name="fName" value="<%out.print(request.getSession().getAttribute("fName"));%>">
			<input class="content-input" type="text" name="lName" value="<%out.print(request.getSession().getAttribute("lName"));%>">
			<input class="content-input" type="date" name="birthday" value="<%out.print(request.getSession().getAttribute("bDate"));%>">
			<select class="content-input" name="sex" style="width: 85%; color: gray">
  				<option value="<%out.print(request.getSession().getAttribute("sex"));%>">
  				<%
  				if(request.getSession().getAttribute("sex").equals("M"))
  					out.print("Masculino");
  				else
  					out.print("Feminino");
  				%></option>
  				<option value="M">Masculino</option>
  				<option value="F">Feminino</option>
			</select>
			<input class="content-input" type="text" name="cpf" value="<%out.print(request.getSession().getAttribute("cpf"));%>">
			<input class="content-input" type="text" name="email" value="<%out.print(request.getSession().getAttribute("email"));%>" readonly="readonly">
			<br>
			<%
			String message = (String) request.getAttribute("message");
			if (message != null) {
				if (message == "Account Updated Successfully") {
					out.print("<span style='color: green;'> " + message + "</span>");
				} else if (message == "Account Deleted Successfully"){
					out.print("<span style='color: green;'> " + message + "</span>");
				} else {
					out.print("<span style='color: red;'> " + message + "</span>");
				}
			}
			%>
			<section class="options-box">
				<input class="options-account" style="cursor: pointer" type="submit" name="button" value="Update">
				<input class="options-account" style="cursor: pointer" type="submit" name="button" value="Delete">
			</section>
		</form>
	</body>
</html>
<%	}
	else{
	response.sendRedirect("Login");}}

else{
	response.sendRedirect("Login");}%>