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
		<link rel="stylesheet" href="Css/Cart.css">    
		<title>Mark</title>
	</head>
	<body>
		<iframe src="Nav.jsp"></iframe>
		<form class="cart-box" action="CartController" method="post">
			<h2>Products in Your Cart</h2>
			<br>
			<div class="cart-content">
				<section class="cart-left">
					<div class="cart-text">
						<span>Made in <strong>Brazil</strong></span>
						<span>Import Duties are Included*</span>
					</div>
					<hr class="cart-hr">
					<br>
					<div class="cart-product">
						<input class="cart-description" type="text" value="<%
						if(request.getSession().getAttribute("product") != null){
								out.print(request.getSession().getAttribute("product"));
							} else {
								out.print("No Products in Your Cart");
							}
						%>" readonly="readonly">
						<span>R$ 499,90</span>
						<span><strong>Quantity:</strong> Unique</span>
						<input type="submit" style="cursor: pointer" class="cart-del" name="button" value="Delete">
					</div>
					<br>
					<hr class="cart-hr">
					<br>
					<div class="cart-code">
						<span>Enter the Discount Code in the Field Below</span>
						<input class="cart-btn" type="text" name="code" value="" placeholder="PUDIM2K22">
					</div>
				</section>
				
				<section class="cart-right">
					<h3>Resume</h3>
					<br>
					<div class="cart-subtotal">
						<span><strong>Subtotal</strong></span>
						<span>R$ 499,90</span>
					</div>
					<div class="cart-delivery">
						<span><strong>Delivery</strong></span>
						<span>R$ 99,90</span>
					</div>
					<hr class="cart-hr">
					<br>
					<div class="cart-total">
						<span><strong>Delivery</strong></span>
						<span>R$ 599,90</span>
					</div>
					<input class="cart-btn" style="cursor: pointer" type="submit" name="button" value="Finish">
					<br>
					<%
					String message = (String) request.getAttribute("message");
					if (message != null) {
						if (message == "Successfull Purchase") {
							out.print("<span style='color: green;'> " + message + "</span>");
						}else {
							out.print("<span style='color: red;'> " + message + "</span>");
						}
					}
					%>
				</section>
				
			</div>
			
		</form>
		<footer>
			@2021 Marcos Vinícius Theodoro - Todos os direitos reservados.
		</footer>
	</body>
</html>
<%	}
	else{
	response.sendRedirect("Login");}}

else{
	response.sendRedirect("Login");}%>