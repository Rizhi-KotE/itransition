<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Snippet - Bootsnipp.com</title>
<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet">
<style></style>
<script type="text/javascript"
	src="//code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript"></script>
</head>
<body>
	<form:form modelAttribute="user" class="form-horizontal" action=""
		method="POST">
		<fieldset>
			<div id="legend">
				<legend class="">Register</legend>
			</div>

			<div class="control-group">
				<label class="control-label" for="username">User name</label>
				<div class="controls">
					<form:input type="text" id="username" name="username"
						path="username" placeholder="" class="input-xlarge" />
						<form:errors path="username" element="div class='alert alert-error'" />
				</div>
			</div>
			<div class="control-group">
				<!-- E-mail -->
				<label class="control-label" for="email">E-mail</label>
				<div class="controls">
					<form:input type="text" id="email" name="email" path="email"
						placeholder="" class="input-xlarge" />
						<form:errors path="email" element="div class='alert alert-error'" />
				</div>
			</div>

			<div class="control-group">
				<!-- Password-->
				<label class="control-label" for="password">Password</label>
				<div class="controls">
					<form:input type="password" id="password" name="password"
						path="password" placeholder="" class="input-xlarge" />
						<form:errors path="password" element="div class='alert alert-error'" />
				</div>
			</div>

			<div class="control-group">
				<!-- Password -->
				<label class="control-label" for="password_confirm">Password
					(Confirm)</label>
				<div class="controls">
					<form:input type="password" id="password_confirm"
						name="matchingPassword" placeholder="" class="input-xlarge"
						path="matchingPassword" />
						<form:errors path="matchingPassword" element="div class='alert alert-error'" />
				</div>
			</div>

			<div class="control-group">
				<!-- Button -->
				<div class="controls">
					<button type="submit" class="btn btn-success">Register</button>
				</div>
			</div>
		</fieldset>
	</form:form>

</body>
</html>
