<div class="col-md-3">
	<a
		class="d-flex align-items-center justify-content-between bg-success"
		style="height: 65px; margin: 1px; padding: 30px;">
		<h5 class="m-0">Categories</h5>
	</a>

	<nav
		class="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0"
		id="navbar-vertical"></nav>
	<div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
		<div class="nav-link" data-toggle="dropdown px-1">
			<c:forEach items="${categorylist}" var="category">
				<a href="" class="nav-item nav-link">${category.categoryName}</a>
			</c:forEach>
		</div>
	</div>
</div>