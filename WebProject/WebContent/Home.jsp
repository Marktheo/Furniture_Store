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
		<link rel="stylesheet" href="Css/Home.css">    
		<title>Mark</title>
	</head>
	<body>
		<iframe src="Nav.jsp"></iframe>
		<div class="general">
				<span class="title"  style="color: white">
					MARK, ESPECIALIST IN FORNITURE & DECORATIVE ARTICLES
					<br><br><br>
					Enjoy 100% OFF on your next order. Use coupon code <strong  style="color: white">PUDIM2K22</strong>*
					<br>
					<span class="obs"  style="color: white">
						*Deliveries only in national territory.
					</span>
				</span>
				<div class="about">
					<span class="text"  style="color: white">We are a brazilian startup looking for promoting decoration diversity and forniture for the international market. Our main store is located in São Paulo, Brazil, serving the entire South America.
					Our wood is origined from national reforestation, regularly certificated by FSC.
					</span>
				</div>
				
		</div>
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