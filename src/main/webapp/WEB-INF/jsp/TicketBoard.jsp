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
#map {
	/* width: 50%;
    	float:right; */
	height: 450px;
	background: grey;
}

#panel {
	width: 100%;
	height: 400px;
}

body {
	margin-left: 3% !important;
}
</style>
</head>
<body id="markers-on-the-map">


	<div class="page-header">
		<h1>CleanCity Reporting Board</h1>
	</div>


    <form class="login" action="/user/ticketBoard" method="post" >
  <div class="login">
  <div class="login-header">
    <h2>Please fill in all the details to proceed</h2>
  </div>
  <div class="login-form">
      <h3>Ticket ID:</h3>
    <input type="text" name="ticketId" id="ticketId" placeholder="Ticket ID" required/><br>
    <br>
    <input type="submit" value="Search" class="login-button"/>
    <br>
  
  </div>
</div>

</form>




	<div id="errorMessage"></div>

</body>
</html>
