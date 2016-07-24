<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="robots" content="noindex">

<title>Simple User Profile - Bootsnipp.com</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<style type="text/css">
.user-row {
	margin-bottom: 14px;
}

.user-row:last-child {
	margin-bottom: 0;
}

.dropdown-user {
	margin: 13px 0;
	padding: 5px;
	height: 100%;
}

.dropdown-user:hover {
	cursor: pointer;
}

.table-user-information>tbody>tr {
	border-top: 1px solid rgb(221, 221, 221);
}

.table-user-information>tbody>tr:first-child {
	border-top: 0;
}

.table-user-information>tbody>tr>td {
	border-top: 0;
}

.toppad {
	margin-top: 20px;
}
</style>
<script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	window.alert = function() {
	};
	var defaultCSS = document.getElementById('bootstrap-css');
	function changeCSS(css) {
		if (css)
			$('head > link')
					.filter(':first')
					.replaceWith(
							'<link rel="stylesheet" href="'+ css +'" type="text/css" />');
		else
			$('head > link').filter(':first').replaceWith(defaultCSS);
	}
	$(document).ready(function() {
		var iframe_height = parseInt($('html').height());
		window.parent.postMessage(iframe_height, 'http://bootsnipp.com');
	});
</script>
</head>
<body>
	<%@ page import="java.lang.System" %>
	<%@ page import="photoapplication.database.entity.ImageUser" %>
	<% System.out.println(request); %>
	<% System.out.println(request.getAttribute("model")); %>
	<% System.out.println(request.getAttribute("user")); %>
	
	<div class="container">
		<div class="row">
			<div class="col-md-5  toppad  pull-right col-md-offset-3 ">
				<a href="edit.html">Edit Profile</a> <a href="edit.html">Logout</a>
				<br>
				<p class=" text-info">May 05,2014,03:00 pm</p>
			</div>
			<div
				class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">


				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Sheena Kristin A.Eschor</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-3 col-lg-3 " align="center">
								<img alt="User Pic"
									src="http://babyinfoforyou.com/wp-content/uploads/2014/10/avatar-300x300.png"
									class="img-circle img-responsive">
							</div>

							<!--<div class="col-xs-10 col-sm-10 hidden-md hidden-lg"> <br>
                  <dl>
                    <dt>DEPARTMENT:</dt>
                    <dd>Administrator</dd>
                    <dt>HIRE DATE</dt>
                    <dd>11/12/2013</dd>
                    <dt>DATE OF BIRTH</dt>
                       <dd>11/12/2013</dd>
                    <dt>GENDER</dt>
                    <dd>Male</dd>
                  </dl>
                </div>-->
							<div class=" col-md-9 col-lg-9 ">
								<table class="table table-user-information">
									<tbody>
										<tr>
											<td>Department:</td>
											<td>Programming</td>
										</tr>
										<tr>
											<td>Hire date:</td>
											<td>06/23/2013</td>
										</tr>
										<tr>
											<td>Date of Birth</td>
											<td>01/24/1988</td>
										</tr>

										<tr>
										</tr>
										<tr>
											<td>Gender</td>
											<td>Male</td>
										</tr>
										<tr>
											<td>Home Address</td>
											<td>Metro Manila,Philippines</td>
										</tr>
										<tr>
											<td>Email</td>
											<td><a href="mailto:info@support.com"></a></td>
										</tr>
										<tr>
											<td>Phone Number</td>
											<td>123-4567-890(Landline)<br> <br>555-4567-890(Mobile)
											</td>

										</tr>

									</tbody>
								</table>

								<a href="#" class="btn btn-primary">My Sales Performance</a> <a
									href="#" class="btn btn-primary">Team Sales Performance</a>
							</div>
						</div>
					</div>
					<div class="panel-footer">
						<a data-original-title="Broadcast Message" data-toggle="tooltip"
							type="button" class="btn btn-sm btn-primary"><i
							class="glyphicon glyphicon-envelope"></i></a> <span
							class="pull-right"> <a href="edit.html"
							data-original-title="Edit this user" data-toggle="tooltip"
							type="button" class="btn btn-sm btn-warning"><i
								class="glyphicon glyphicon-edit"></i></a> <a
							data-original-title="Remove this user" data-toggle="tooltip"
							type="button" class="btn btn-sm btn-danger"><i
								class="glyphicon glyphicon-remove"></i></a>
						</span>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var panels = $('.user-infos');
							var panelsButton = $('.dropdown-user');
							panels.hide();

							//Click dropdown
							panelsButton
									.click(function() {
										//get data-for attribute
										var dataFor = $(this).attr('data-for');
										var idFor = $(dataFor);

										//current button
										var currentButton = $(this);
										idFor
												.slideToggle(
														400,
														function() {
															//Completed slidetoggle
															if (idFor
																	.is(':visible')) {
																currentButton
																		.html('<i class="glyphicon glyphicon-chevron-up text-muted"></i>');
															} else {
																currentButton
																		.html('<i class="glyphicon glyphicon-chevron-down text-muted"></i>');
															}
														})
									});

							$('[data-toggle="tooltip"]').tooltip();

							$('button').click(function(e) {
								e.preventDefault();
								alert("This is a demo.\n :-)");
							});
						});
	</script>


</body>
</html>