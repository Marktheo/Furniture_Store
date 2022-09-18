<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="Media/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="Css/Norm.css">
<link rel="stylesheet" type="text/css" href="Css/Login.css">
<title>Mark</title>
</head>
<body>
	<iframe src="Nav.jsp"></iframe>
	<main class="main-box">
		<div class="content-box">
			<h1 class="content-title">Login</h1>
			<form action="LoginServlet" method="post">
				<input class="content-input" type="text" name="email" placeholder="User">
				<input class="content-input" type="password" name="keyword" placeholder="Password">
				<section class="options-box">
					<input class="content-input login-input" type="submit" value="Continue" style="cursor: pointer">
					 <a class="create-account" href="SignUp">Create an Account</a>
				</section>
				<br>
				<%
				String message = (String) request.getAttribute("message");
				if (message != null) {
					if (message == "Account Generated Successfully") {
						out.print("<span style='color: green;'> " + message + "</span>");
					} else if(message == "Account Updated Successfully"){
						out.print("<span style='color: green;'> " + message + "</span>");
					} else if(message == "Account Deleted Successfully"){
						out.print("<span style='color: green;'> " + message + "</span>");
					}else {
						out.print("<span style='color: red;'> " + message + "</span>");
					}
				}
				%>
				<a class="update-input" href="Recover">Forgot your Password?</a>
			</form>
		</div>
	</main>
</body>
</html>