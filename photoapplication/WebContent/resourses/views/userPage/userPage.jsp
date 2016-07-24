<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<%@ page import="photoapplication.config.Constants"%>
<link rel="icon"
	href="<c:url value='<%=Constants.VIEWS + "favicon.ico"%>' /> " />

<link
	href="<c:url value='<%=Constants.VIEWS + "userPage/cover.css"%>'/>"
	rel="stylesheet">
<title>user page</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value='<%=Constants.BOOTSTRAP_MIN_CSS%>' />"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/resourses/css/font-awesome.min.css' />" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value='/resourses/css/jgallery.min.css?v=1.5.0' />" />
<script type="text/javascript"
	src="<c:url value='/resourses/js/jquery-2.0.3.min.js' />"></script>
<script type="text/javascript"
	src="<c:url value='/resourses/js/jgallery.js?v=1.5.0' />"></script>
<script type="text/javascript"
	src="<c:url value='/resourses/js/touchswipe.min.js' />"></script>
</head>

<body>

	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">Cover</h3>
						<nav>
							<ul class="nav masthead-nav nav nav-tabs pull-right">
								<li class="active"><a href="#">Home</a></li>
								<li><a href="#">Features</a></li>
								<li><a href="#">Contact</a></li>
							</ul>
						</nav>
					</div>
				</div>

			</div>

		</div>

	</div>


	<div class="inner cover">
		<%@ include file='/resourses/jgallery/dist/slider.html'%>
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="<c:url value='<%=Constants.BOOTSTRAP_MIN_JS%>'/>"></script>
</body>
</html>
