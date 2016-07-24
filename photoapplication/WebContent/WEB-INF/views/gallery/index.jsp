<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
/*
 * Bootstrap Image Gallery Demo
 * https://github.com/blueimp/Bootstrap-Image-Gallery
 *
 * Copyright 2013, Sebastian Tschan
 * https://blueimp.net
 *
 * Licensed under the MIT license:
 * http://www.opensource.org/licenses/MIT
 */
-->
<html lang="en">
<head>
<!--[if IE]>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<![endif]-->
<meta charset="utf-8">
<title>Bootstrap Image Gallery</title>
<meta name="description"
	content="Bootstrap Image Gallery is an extension to blueimp Gallery, a touch-enabled, responsive and customizable image and video gallery. It displays images and videos in the modal dialog of the Bootstrap framework, features swipe, mouse and keyboard navigation, transition effects, fullscreen support and on-demand content loading and can be extended to display additional content types.">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
<link rel="stylesheet"
	href="<c:url value='/resourses/css/bootstrap-image-gallery.css'/>">
<link href="<c:url value='/resourses/css/demo.css'/>" rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-fixed-top .navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="https://github.com/blueimp/Bootstrap-Image-Gallery">Bootstrap
					Image Gallery</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a
						href="https://github.com/blueimp/Bootstrap-Image-Gallery/tags">Download</a></li>
					<li><a
						href="https://github.com/blueimp/Bootstrap-Image-Gallery">Source
							Code</a></li>
					<li><a
						href="https://github.com/blueimp/Bootstrap-Image-Gallery/blob/master/README.md">Documentation</a></li>
					<li><a href="https://blueimp.net">&copy; Sebastian Tschan</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container">
		<form class="form-inline">
			<div class="form-group">
				<button id="image-gallery-button" type="button"
					class="btn btn-primary btn-lg">
					<i class="glyphicon glyphicon-picture"></i> Launch Image Gallery
				</button>
			</div>
			<div class="btn-group" data-toggle="buttons">
				<label class="btn btn-success btn-lg"> <i
					class="glyphicon glyphicon-leaf"></i> <input
					id="borderless-checkbox" type="checkbox"> Borderless
				</label> <label class="btn btn-primary btn-lg"> <i
					class="glyphicon glyphicon-fullscreen"></i> <input
					id="fullscreen-checkbox" type="checkbox"> Fullscreen
				</label>
			</div>
		</form>
		<br>
		<!-- The container for the list of example images -->
		<div id="links"></div>
		<br>
	</div>
	<!-- The Bootstrap Image Gallery lightbox, should be a child element of the document body -->
	<div id="blueimp-gallery" class="blueimp-gallery">
		<!-- The container for the modal slides -->
		<div class="slides"></div>
		<!-- Controls for the borderless lightbox -->
		<h3 class="title"></h3>
		<a class="prev">‹</a> <a class="next">›</a> <a class="close">×</a>
		<a class="play-pause"></a>
		<ol class="indicator"></ol>
		<!-- The modal dialog, which will be used to wrap the lightbox content -->
		<div class="modal fade">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" aria-hidden="true">&times;</button>
						<h4 class="modal-title"></h4>
					</div>
					<div class="modal-body next"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default pull-left prev">
							<i class="glyphicon glyphicon-chevron-left"></i> Previous
						</button>
						<button type="button" class="btn btn-primary next">
							Next <i class="glyphicon glyphicon-chevron-right"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">></script>
	<!-- Bootstrap JS is not required, but included for the responsive demo navigation and button states -->
	<script
		src="https://netdna.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="https://blueimp.github.io/Gallery/js/jquery.blueimp-gallery.min.js"></script>
	<script src="<c:url value='/resourses/js/bootstrap-image-gallery.js'/>"></script>
	<script src="<c:url value='/resourses/js/demo.js'/>"></script>
</body>
</html>
