<div class="container">

	<!-- BreadCrumb -->

	<div class="row">

		<div class="col-xs-12">

			<ol class="breadcrumb-item">

				<li class="breadcrumb-item"><a href="${contextroot}/home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="${contextroot}/product/show/all/active/products">PRODUCTS</a></li>
				<li class="breadcrumb-item-active">${product.name}</li>
			</ol>
		</div>
	</div>

	<div class="row">

		<div class="col-xs-12 col-sm-4">

			<div class="thumbnail">

				<img src="${images}/${product.code}.jpg" class="img img-responsive" />

			</div>
		</div>

		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr>

			<p>${product.description }</p>
			<hr>

			<h4>
				Price: <strong> &#8377; ${product.unit_price} /-</strong>
			</h4>

			<c:choose>

				<c:when test="${product.quantity < 1}">

					<h6>
						Qty. Available: <span style="color: red">OUT OF STOCK!</span>
					</h6>

				</c:when>
				<c:otherwise>

					<h6>Qty. Available: ${product.quantity}</h6>

				</c:otherwise>

			</c:choose>

			<hr />

			<c:choose>

				<c:when test="${product.quantity < 1}">

					<a href="javascript:void(0)" class="btn btn-success disabled"><strike>
							<span class="glyphicon glyphicon-shopping-cart"></span> ADD TO
							CART
					</strike></a>

				</c:when>
				<c:otherwise>

					<a href="#" class="btn btn-success"> <span
						class="glyphicon glyphicon-shopping-cart"></span> ADD TO CART 
					</a>




				</c:otherwise>

			</c:choose>
			<a href="${contextroot}/product/show/all/active/products"
				class="btn btn-primary">BACK</a>


		</div>

	</div>
</div>