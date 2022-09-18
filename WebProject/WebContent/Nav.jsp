<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Navbar Iframe Page</title>
	<link rel="stylesheet" href="Css/Nav.css">
	<link rel="stylesheet" href="Css/Norm.css">
</head>
	<body>
		<nav>
			    <img src="Media/logo.png" id="img">
			    <ul name="nav-ul">
					<a name="link" href="Home" target="_blank">Home</a>
					<a name="link"  href="Store" target="_blank">Store</a>
					<a name="link"  href="Cart" target="_blank">Cart</a>
					<a name="profile"  href="Profile" target="_blank">
					<%
					if(request.getSession().getAttribute("fName") != null)
						out.print(request.getSession().getAttribute("fName"));
					else
						out.print("Perfil");
					%></a>
				</ul>
			</nav>
	</body>
</html>