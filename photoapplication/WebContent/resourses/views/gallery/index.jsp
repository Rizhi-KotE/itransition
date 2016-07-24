<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="UTF-8" />
    <title>Albums</title>
     <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/resourses/css/font-awesome.min.css' />" />
    <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/resourses/css/jgallery.min.css?v=1.5.0' />" />
    <script type="text/javascript" src="<c:url value='/resourses/js/jquery-2.0.3.min.js' />"></script>
    <script type="text/javascript" src="<c:url value='/resourses/js/jgallery.min.js?v=1.5.0' />"></script>
    <script type="text/javascript" src="<c:url value='/resourses/js/touchswipe.min.js' />"></script>
</head>
<body style="width: 900px; margin: 100px auto; height: auto;">
<script type="text/javascript">
$( function() {
    $( '#gallery' ).jGallery();
} );
</script>
<div id="gallery">
    <div class="album" data-jgallery-album-title="Album 1">
        <a href="images/large/1.jpg"><img src="/resourses/images/thumbs/1.jpg" alt="Photo 1" /></a>
        <a href="images/large/2.jpg"><img src="/resourses/images/thumbs/2.jpg" alt="Photo 2" /></a>
        <a href="images/large/3.jpg"><img src="/resourses/images/thumbs/3.jpg" alt="Photo 3" /></a>
    </div>
    <div class="album" data-jgallery-album-title="Album 2">
        <a href="images/large/4.jpg"><img src="/resourses/images/thumbs/4.jpg" alt="Photo 4" /></a>
        <a href="images/large/5.jpg"><img src="/resourses/images/thumbs/5.jpg" alt="Photo 5" /></a>
        <a href="images/large/6.jpg"><img src="/resourses/images/thumbs/6.jpg" alt="Photo 6" /></a>
    </div>
</div>
</body>
</html>