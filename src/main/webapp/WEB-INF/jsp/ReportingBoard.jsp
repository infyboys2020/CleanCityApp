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


    <form class="login" action="/reportBoard" method="post" enctype="multipart/form-data">
  <div class="login">
  <div class="login-header">
    <h1>Please fill in all the details to proceed</h1>
  </div>
  <div class="login-form">
    <h3>Name:</h3>
    <input type="text" name="name" placeholder="Name" required/><br>
    
    <h3 for="types">Type of incident:</h3>
	<select name="types" id="type">
	  <option value="garbage">Garbage</option>
	  <option value="pothole">Pothole</option>
	</select>
    
    <h3>Address:</h3>
    <input type="text" name="address" placeholder="Address" required/>
    <h3>Pin:</h3>
    <input type="text" name="pin" placeholder="Pin" required/><br>
    
    <h3>Please select exact location:</h3>
    <div id="map" style="height: 250px;width: 400px;margin-left: 50px;"></div>
    <input id="longitude" name="longitude" hidden="hidden"/>
    <input id="latitude" name="latitude" hidden="hidden"/>
    
    <h3>Contact Number:</h3>
    <input type="text" name="phone_number" placeholder="Mob" required/>
    <br>
    <h3>Photo:</h3>
    <br>
    <input class="uploadBtn" type="file" name="image" accept="image/png, image/jpeg" required/><br><br>
    <br>
    <input type="submit" value="Submit" class="login-button"/>
    <br>
  </div>
</div>

</form>


	<div id="errorMessage"></div>
	
	<script type="text/javascript" src="/js/locationSelectorMapLoader.js"></script>
</body>
</html>
