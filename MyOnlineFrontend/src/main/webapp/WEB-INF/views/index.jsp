<!DOCTYPE html>
<html lang="en">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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

	<%@include file="./shared/header.jsp"%>

	<!-- NAVIGATION -->

	<%@include file="./shared/nav.jsp"%>

	<!-- HOME -->
	<br/>
	<c:if test="${userclickhome== true}">
	<%@include file="home.jsp"%>
	</c:if>
	<c:if test="${userclickallproducts== true || userclickcategoryproducts== true}">
	<%@include file="productlist.jsp"%>
	</c:if>
	<c:if test="${userclicksingleproduct== true}">
	<%@include file="singleproduct.jsp"%>
	</c:if>
	<c:if test="${userclickmanageproduct== true}">
	<%@include file="manageproduct.jsp"%>
	</c:if>
	<!-- FOOTER -->

	<%@include file="./shared/footer.jsp"%>


	<!-- jQuery Plugins -->
	<script src="${js}/jquery.min.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/jquery.dataTables.js"></script>
	<script src="${js}/dataTables.bootstrap.js"></script>
	<script src="${js}/bootbox.min.js"></script>
	<script src="${js}/jquery.zoom.min.js"></script>
	<script src="${js}/main.js"></script>
	<script src="${js}/amscript.js"></script>

</body>

</html>
