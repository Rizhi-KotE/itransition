<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value="/css/font-awesome.min.css" />" />
<link rel="stylesheet" type="text/css" media="all"
	href="<c:url value="/css/jgallery.min.css?v=1.5.0" />" />
<script type="text/javascript"
	src="<c:url value="/js/jquery-2.0.3.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/jgallery.min.js?v=1.5.0" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/touchswipe.min.js" />"></script>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />">

<script type="text/javascript">
	$(function() {
		$("#gallery").jGallery({
			"transitionCols" : "1",
			"transitionRows" : "1",
			"thumbnailsPosition" : "left",
			"thumbType" : "image",
			"backgroundColor" : "FFFFFF",
			"textColor" : "000000",
			"mode" : "standard"
		});
	});
</script>
</head>
<body>
	<div class="container">
		<div class="container">
			<nav role="navigation" class="navbar navbar-default">
				<!-- Collection of nav links, forms, and other content for toggling -->
				<div id="navbarCollapse" class="collapse navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#">Transform image</a></li>
						<li><a href="#">Create slideshowm</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Sign in</a></li>
					</ul>
				</div>
			</nav>
		</div>
		<div id="gallery">
			<ul>
				<li><a href="<c:url value="/images/large/2.jpg" />"><img
						src="<c:url value="/images/thumbs/2.jpg" />" alt="Photo 2" /></a></li>
				<li><a href="<c:url value="/images/large/1.jpg" />"><img
						src="<c:url value="/images/thumbs/1.jpg" />" alt="Photo 1" /></a></li>
				<li><a href="<c:url value="/images/large/3.jpg" />"><img
						src="<c:url value="/images/thumbs/3.jpg" />" alt="Photo 3" /></a></li>
			</ul>
		</div>
	</div>
</body>
</html>