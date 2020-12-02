<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="upload" enctype="multipart/form-data" method="post">

		选择要读取的Excel文件： 
		<br /> <br /> 
		<input type="file" name="file" /> 
		<br /> <br /> 
		<input type="submit" name="提交" /> <br />
	</form>
</body>
</html>