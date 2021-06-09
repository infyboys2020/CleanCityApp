<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
<meta http-equiv="Content-type" content="text/html;charset=UTF-8">

<title>Clean City</title>
<link rel="stylesheet" type="text/css" href="https://js.api.here.com/v3/3.1/mapsjs-ui.css" />
<script type="text/javascript" src='/js/test-credentials.js'></script>    
<script type="text/javascript" src="https://js.api.here.com/v3/3.1/mapsjs-core.js"></script>
<script type="text/javascript" src="https://js.api.here.com/v3/3.1/mapsjs-service.js"></script>
<script type="text/javascript" src="https://js.api.here.com/v3/3.1/mapsjs-ui.js"></script>
<script type="text/javascript" src="https://js.api.here.com/v3/3.1/mapsjs-mapevents.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/base.css">
<script src="/js/garbageReport.js"></script>
	

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
<body id="markers-on-the-map">


	<div class="page-header">
		<h1>CleanCity Navigator</h1>
	</div>


    <form class="login" action = "/user/reportBoard" method="get" enctype="multipart/form-data">
  <div class="login">
  
  <div class="login-form">
    <input type="submit" value="Reporting Board" formAction="/user/reportBoard" class="login-button"/>
    <br>
    <input type="submit" value="Ticket Board" formAction="/user/ticketBoard" class="login-button"/>
    <br>
    <input type="submit" value="Admin Board" formAction="/admin/fetch" class="login-button"/>
    <br>
  </div>
</div>

</form>


	<div id="errorMessage"></div>
	
	<script type="text/javascript" src="/js/locationSelectorMapLoader.js"></script>
</body>
</html>
