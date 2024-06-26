<div class="row">

	<%@include file="./shared/sidenav.jsp"%>

	<div class="col-md-9">

		<div class="row">
			<div class="row">
				<c:if test="${userclickallproducts == true}" var="data">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${contextroot}/home">Home</a></li>
						<li class="breadcrumb-item active">All Products</li>
						<script>
						window.categoryId = '';
					</script>
					</ol>
					
				</c:if>
				<c:if test="${userclickcategoryproducts == true}" var="data">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${contextroot}/home">Home</a></li>
						<li class="breadcrumb-item"><a
							href="${contextroot}/product/show/all/active/products">Product</a></li>
						<li class="breadcrumb-item active">${category.categoryName}</li>
					</ol>
					<script>
						window.categoryId = '${category.id}';
					</script>
				</c:if>
			</div>
		</div>
		<div class="col-sm-12">
			<table class="table" id="producttable">
				<thead>
					<tr>
						<th></th>
						<th>Product Code</th>
						<th>Product Name</th>
						<th>Brand Name</th>
						<th>Quantity</th>
						<th>Price</th>
						<th></th>
						<th></th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th></th>
						<th>Product Code</th>
						<th>Product Name</th>
						<th>Brand Name</th>
						<th>Quantity</th>
						<th>Price</th>
						<th></th>
						<th></th>
					</tr>
				</tfoot>

			</table>
		</div>
	</div>
</div>