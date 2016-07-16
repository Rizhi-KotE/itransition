<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="upload" method="POST" enctype="multipart/form-data">
		File to upload: 
		<input type="file" name="file"><br />
		Name: 
		<input type="text" name="name"><br />
		<input type="submit" value="Upload"> 
		Press here to upload the file!
	</form>
</body>
<body>
	<form action="sayHello" method="POST">
		Name: 
		<input type="text" name="name">
		<input type="submit" value="Say hello">
	</form>
</body>
</html>