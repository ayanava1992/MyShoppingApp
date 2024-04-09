<!DOCTYPE html>
<html lang="en">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<c:set var="contextroot" value="${pageContext.request.contextPath }"/>

<spring:url var="css" value="/rs/css" />
<spring:url var="js" value="/rs/js" />
<spring:url var="images" value="/rs/images" />
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>${title}</title>

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet" href="${css}/bootstrap.min.css" />

<!-- Datatable CSS -->
<link href="${css}/jquery.dataTables.css" rel="stylesheet">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="${css}/style.css" />

<script>

	window.contextroot= '${contextroot}';
</script>

</head>

<body>

<!-- header -->

	<div class="container-fluid">
	<div class="row bg-transparent py-2 px-xl-5">
		<div class="col-lg-6 d-none d-lg-block text-dark">
			<div>
				<span>WELCOME TO ON-CART!!!!!</span>
				<div class="d-inline-flex align-items-center">
					<div>
							</span> <a class="text-danger" href="">HELP</a><span
							class="text-muted px-2">|</span> <a class="text-danger" href="">SUPPORT</a>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- NAVIGATION -->

	<nav class="navbar navbar-expand-lg navbar-secondary bg-info">
	<div class="row align-items-center py-3 px-xl-5">
		<div class="col-lg-3 d-none d-lg-block">
			<a href="${flowExecutionUrl}&_event_id_home" class="text-decoration-none">
				<h2>
					<span class="text-primary font-weight-bold border px-3 mr-1">On</span>Cart
				</h2>
			</a>
		</div>
	</div>
</nav>

<br/>
<div class="container">