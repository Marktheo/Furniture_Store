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
		<link rel="stylesheet" href="Css/Store.css">    
		<title>Mark</title>
	</head>
	<body>
		<iframe src="Nav.jsp"></iframe>
		<form class="store-box" action="StoreServlet" method="post">
			<div class="store-column">
				<section class="store-title">
					<span>Wooden Padded Brown Chair</span>
					<span>Wooden Table with Drawer</span>
				</section>
				<div class="store-line">
					<img class="store-img" alt="Chair" src="Media/Chair.jpg">
					<img class="store-img" alt="Table" src="Media/Table.jpg">
				</div>
				<section class="store-section">
					<input class="store-btn" style="cursor: pointer" type="submit" name="button" value="Add to Cart - Chair">
					<input class="store-btn" style="cursor: pointer" type="submit" name="button" value="Add to Cart - Table">
				</section>
			</div>
			
			<div class="store-column">
				<section class="store-title">
					<span>Wooden Portable Bench</span>
					<span>Aluminum Yellow Chandeliers</span>
				</section>
				<div class="store-line">
					<img class="store-img" alt="Sit" src="Media/Sit.jpg">
					<img class="store-img" alt="Lamps" src="Media/Lamps.jpg">
				</div>
				<section class="store-section">
					<input class="store-btn" style="cursor: pointer" type="submit" name="button" value="Add to Cart - Bench">
					<input class="store-btn" style="cursor: pointer" type="submit" name="button" value="Add to Cart - Chandeliers">
				</section>
			</div>
			
			<div class="store-column">
				<section class="store-title">
					<span>Wooden Padded Cyan Sofa</span>
					<span>Wooden Decorated Cabinet</span>
				</section>
				<div class="store-line">
					<img class="store-img" alt="Sofa" src="Media/Sofa.jpg">
					<img class="store-img" alt="Cabinet" src="Media/Cabinet.jpg">
				</div>
				<section class="store-section">
					<input class="store-btn" style="cursor: pointer" type="submit" name="button" value="Add to Cart - Sofa">
					<input class="store-btn" style="cursor: pointer" type="submit" name="button" value="Add to Cart - Cabinet">
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