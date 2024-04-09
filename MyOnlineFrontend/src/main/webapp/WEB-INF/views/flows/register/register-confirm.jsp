<%@include file="../shared/header.jsp"%>
<div class="row">

		<div class="col-md-6">

			<div class="card">

				<div class="card-heading bg-dark">
					<h2 class="text-light text-center">PERSONAL DETAILS</h2>
				</div>

				<div class="card-body">
					<table class="table">
						<tbody>
							<tr>
								<th>USER NAME: </th>
								<td>${r_m.user.firstName}
									${r_m.user.lastName}</td>
							</tr>
							<tr>
								<th>EMAIL-ID: </th>
								<td>${r_m.user.email}</td>
							</tr>
							<tr>
								<th>PHONE NUMBER: </th>
								<td>${r_m.user.phone}</td>
							</tr>
							<tr>
								<th>ROLE OF THE USER: </th>
								<td>${r_m.user.role}</td>
							</tr>
						</tbody>
					</table>
					<p class="text-center">
						<a href="${flowExecutionUrl}&_eventId_personal"
							class="btn btn-lg btn-warning">Edit</a>
					</p>
				</div>


			</div>

		</div>



		<div class="col-md-6">

			<div class="card">

				<div class="card-heading bg-dark">
					<h2 class="text-light text-center">Billing Details</h2>
				</div>

				<div class="card-body">

					<table class="table">
						<tbody>
							<tr>
								<th>ADDRESS: </th>
								<td>${r_m.billing.address_line1},
									${r_m.billing.address_line2}</td>
							</tr>
							<tr>
								<th>CITY: </th>
								<td>${r_m.billing.city}-
									${r_m.billing.postalCode}</td>
							</tr>
							<tr>
								<th>STATE: </th>
								<td>${r_m.billing.state}</td>
							</tr>
							<tr>
								<th>COUNTRY: </th>
								<td>${r_m.billing.country}</td>
							</tr>
						</tbody>
					</table>
					<p class="text-center">
						<a href="${flowExecutionUrl}&_eventId_billing"
							class="btn btn-lg btn-warning">Edit</a>
					</p>

				</div>

			</div>

		</div>
	</div>
	<br/>
	<div class="row">

		<div class="offset-md-5 col-md-2">

			<div class="text-center">

				<a href="${flowExecutionUrl}&_eventId_success"
					class="btn btn-lg btn-success">Confirm</a>

			</div>

		</div>

	</div>
<%@include file="../shared/footer.jsp"%>