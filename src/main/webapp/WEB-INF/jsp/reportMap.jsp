<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    
    <title>Clean City Report</title>
    <link rel="stylesheet" type="text/css" href="https://js.api.here.com/v3/3.1/mapsjs-ui.css" />
    <script type="text/javascript" src='/js/test-credentials.js'></script>    
    <script type="text/javascript" src="https://js.api.here.com/v3/3.1/mapsjs-core.js"></script>
    <script type="text/javascript" src="https://js.api.here.com/v3/3.1/mapsjs-service.js"></script>
    <script type="text/javascript" src="https://js.api.here.com/v3/3.1/mapsjs-ui.js"></script>
    <script type="text/javascript" src="https://js.api.here.com/v3/3.1/mapsjs-mapevents.js"></script>
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<script src="/js/reportPopulatorScript.js"></script>
	
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
	body{
		margin-left: 3%!important;
	}
    </style>
  </head>
  <body id="markers-on-the-map">
  	<div id = "message" hidden= "hidden">${message}</div>
  	
    <div class="page-header">
        <h2>Clean City Report</h2>
    </div>
    
    <form class="form-horizontal" id="searchForm">
	    <input type="button" class="btn btn-primary" value="Search" onclick="submitForm()">
	</form>
	
	<div id ="errorMessage"></div>
    <div id="map"></div>

    <script type="text/javascript" src="/js/reportMapLoader.js"></script>
  </body>
</html>
