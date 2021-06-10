<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<meta http-equiv="Content-type" content="text/html;charset=UTF-8">

<title>Clean City</title>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/base.css">
	

<style type="text/css">

input{
	width: 90%;
    height: 60px;
    margin-bottom: 40px;
}
.login-form{
	padding-bottom:0% !important;
}

</style>
</head>
<body>

	<div class="page-header">
		<h1 style="color: snow;">CleanCity Navigator</h1>
	</div>

    <form class="login" action = "/user/reportBoard" method="get" enctype="multipart/form-data">
  <div class="login">
  
  <div class="login-form">
    <input type="submit" value="Register a complaint" formAction="/user/reportBoard" class="login-button"/>
    <br>
    <input type="submit" value="Check Ticket Status" formAction="/user/ticketBoard" class="login-button"/>
    <br>
    <input type="submit" value="Complaints Dashboard" formAction="/user/reportDashboard" class="login-button"/>
    <br>
    <input type="submit" value="Complaints Management(For Admins)" formAction="/admin/fetch" class="login-button" 
    	style="background-color: #f9f9b5;"/>
    <br>
  </div>
</div>

</form>


</body>
</html>
