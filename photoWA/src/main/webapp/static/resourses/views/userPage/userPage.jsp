<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en-US">
<head>
  </script>
    <link rel="stylesheet" type="text/css" media="all" href="css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" media="all" href="css/jgallery.min.css?v=1.5.0" />
    <script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
    <script type="text/javascript" src="js/jgallery.min.js?v=1.5.0"></script>
    <script type="text/javascript" src="js/touchswipe.min.js"></script>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <script type="text/javascript">
$( function(){
    $( "#gallery" ).jGallery( {
        browserHistory: true,
        "transitionCols":"1",
        "transitionRows":"1",
        "thumbnailsPosition":"left",
        "thumbType":"image",
        "backgroundColor":"FFFFFF",
        "textColor":"000000",
        "mode":"standard"
    } );
} );
</script>
</head>
<body>
<div class="container">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
              </ul>
            </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="../navbar/">Меню</a></li>
            <li><a href="../navbar-static-top/">Статическое</a></li>
            <li class="active"><a href="./">Фиксированное</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
<div id="gallery">
    <ul>
        <li><a href="images/large/2.jpg"><img src="images/thumbs/2.jpg" alt="Photo 2" /></a></li>
        <li><a href="images/large/1.jpg"><img src="images/thumbs/1.jpg" alt="Photo 1" /></a></li>
        <li><a href="images/large/3.jpg"><img src="images/thumbs/3.jpg" alt="Photo 3" /></a></li>
    </ul>
</div>
</div>
</body>
</html>