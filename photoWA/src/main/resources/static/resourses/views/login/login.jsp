<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="photoapplication.config.Constants"%>
<fmt:setBundle basename="messages" />
<fmt:message key="message.password" var="noPass" />
<fmt:message key="message.username" var="noUser" />
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Photoapplication signin</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value='<%= Constants.BOOTSTRAP_MIN_CSS%>'/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value='<%= Constants.VIEWS+"login/signin.css"%>' />"
	rel="stylesheet" />

</head>

<body>

	<div class="container">

		<form class="form-signin" action='<%= Constants.LOGIN_URL %>' method="POST">
			<c:if test="${param.error ne null }">
				<div class="alert alert-danger">Incorrect login or password</div>
			</c:if>

			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label> <input
				type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required="" autofocus="" name="username">
			<label for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required="" name="password">
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>

	</div>
</body>
</html>