<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="forms/custom_stylesheet.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<head>
</head>
<body>
	<div class="col-sm-2 col-md-2 col-sm-push-10">
		<div max-height="10vh">
			<%@include file="forms/dropZone.jsp"%>
		</div>
		<%@include file="forms/photoGrid.jsp"%>
	</div>
</body>
</html>