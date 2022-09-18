<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="Media/favicon.ico" type="image/x-icon">
		<link rel="stylesheet" href="Css/Norm.css">
		<link rel="stylesheet" href="Css/SignUp.css">    
		<title>Mark</title>
	</head>
	<body>
		<iframe src="Nav.jsp"></iframe>
		<div class="content-box">
			<h1 class="content-title">Register</h1>
			<form action="SignUpServlet" method="post">
				<input class="content-input" type="text" name="fName" placeholder="First Name">
				<input class="content-input" type="text" name="lName" placeholder="Last Name">
				<input class="content-input" type="date" name="birthday" placeholder="Birthday">
				<select class="content-input"name="sex" style="width: 85%; color: gray">
  					<option value="" selected>Sexo</option>
  					<option value="M">Masculino</option>
  					<option value="F">Feminino</option>
				</select>
				<input class="content-input" type="text" name="cpf" placeholder="CPF">
				<input class="content-input" type="text" name="email" placeholder="User">
				<input class="content-input" type="password" name="keyword" placeholder="Password" >
				<input class="content-input" type="submit" value="Create your Account" style="width: 30%; cursor: pointer"><br>
				<%	String message = (String) request.getAttribute("message");
				if (message != null) {
					if(message != "Account Generated Successfully"){
						out.print("<span style='color: red;'> " + message + "</span>");
					}
				}%>
			</form>
			<a class="login-input" href="Login">Already Have an Account?</a>
		</div>
	</body>
</html>