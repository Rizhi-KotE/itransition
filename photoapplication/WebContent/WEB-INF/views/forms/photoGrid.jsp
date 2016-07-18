<!DOCTYPE html>
<html>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			url: "../photo/min",
			type: "GET",
			success: function(data){
				var image = new Image;
				image.src = data;
				$("<li class='span4'><a href='' class='thumbnail'></a></li>")
				.append(image)
				.appendTo("#gridPane")
			},
			
		data: "author=a"})})
</script>

<div id="gridPane"></div>
<input type="button" id="button">
</body>
</html>