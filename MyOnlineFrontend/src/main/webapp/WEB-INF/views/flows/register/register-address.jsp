<%@include file="../shared/header.jsp"%>
	
	<div class="row">

		<div class="offset-md-3 col-md-6">

			<div class="card">

				<div class="card-heading bg-primary text-white">
					<h4>REGISTER- ADDRESS</h4>
				</div>

				<div class="card-body">

					<sf:form method="POST" modelAttribute="billing"
						class="form-horizontal" id="billingForm">


						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="address_line1">ADDRESS
								LINE-1: </label>
							<div class="col-md-8">
								<sf:input type="text" path="address_line1" class="form-control"
									placeholder="Enter Address Line-1" />
								<sf:errors path="address_line1" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="address_line2">ADDRESS
								LINE-2: </label>
							<div class="col-md-8">
								<sf:input type="text" path="address_line2" class="form-control"
									placeholder="Enter Address Line-2" />
								<sf:errors path="address_line2" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="city">CITY: </label>
							<div class="col-md-8">
								<sf:input type="text" path="city" class="form-control"
									placeholder="Enter City Name" />
								<sf:errors path="city" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="postalCode">PIN
								CODE: </label>
							<div class="col-md-8">
								<sf:input type="text" path="postalCode" class="form-control"
									placeholder="XXXXXX" />
								<sf:errors path="postalCode" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="state">STATE: </label>
							<div class="col-md-8">
								<sf:input type="text" path="state" class="form-control"
									placeholder="Enter State Name" />
								<sf:errors path="state" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group row">
							<label class="col-md-4 col-form-label" for="country">COUNTRY: </label>
							<div class="col-md-8">
								<sf:input type="text" path="country" class="form-control"
									placeholder="Enter Country Name" />
								<sf:errors path="country" cssClass="help-block" element="em" />
							</div>
						</div>

						<br />
						<div class="form-group row">
							<div class="offset-md-4 col-md-8">
								<button type="submit" name="_eventId_confirm"
									class="btn btn-primary">
									NEXT- CONFIRM<span class="glyphicon glyphicon-chevron-right"></span>
								</button>
							</div>
						</div>


					</sf:form>


				</div>


			</div>


		</div>


	</div>
	<%@include file="../shared/footer.jsp"%>
	